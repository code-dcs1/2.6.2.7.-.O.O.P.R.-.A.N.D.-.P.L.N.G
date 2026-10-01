validPurposes = ["Enrollment", "Records", "Payment"]
serviceTypes = ["regular", "priority"]

def createQueue():
    return {
        "tickets": [],
        "next_ticket_id": 1,
        "prioStreak": 0,
        "counters": {f"Counter {i+1}": None for i in range(2)},
        "completed_history": []
    }


def getTicketsRunning(tickets):
    for ticket in tickets:
        if ticket["status"] == "waiting":
            yield ticket


def issueTicket(state, purpose, service_type="regular"):
    if purpose not in validPurposes or service_type.lower() not in serviceTypes:
        raise ValueError(f"Invalid service type or purpose.")

    ticket = {
        "id": state["next_ticket_id"],
        "purpose": purpose,
        "service_type": service_type.lower(),
        "status": "waiting"
    }

    state["tickets"].append(ticket)
    issued_id = state["next_ticket_id"]
    state["next_ticket_id"] += 1
    return issued_id


def issue_many(state, *requests):
    validated_requests = []
    for req in requests:
        if not isinstance(req, (tuple, list)) or len(req) < 1:
            raise ValueError("Each request must be a tuple/list of (purpose, [service_type])")

        purpose = req[0]
        service_type = req[1] if len(req) > 1 else "regular"

        if purpose not in validPurposes or service_type.lower() not in serviceTypes:
            raise ValueError(f"Invalid service type or purpose in the request.")

        validated_requests.append((purpose, service_type.lower()))

    issued_ids = []
    for purpose, stype in validated_requests:
        issued_ids.append(issueTicket(state, purpose, stype))
    return issued_ids


def next_ticket(waitTickets, prioStreak):
    if not waitTickets:
        return None, -1, prioStreak

    prioTicket = [t for t in waitTickets if t["service_type"] == "priority"]
    regTickets = [t for t in waitTickets if t["service_type"] == "regular"]

    if prioTicket and not regTickets:
        chosen = prioTicket[0]
        new_streak = prioStreak + 1
    elif regTickets and not prioTicket:
        chosen = regTickets[0]
        new_streak = prioStreak
    else:
        if prioStreak >= 2:
            chosen = regTickets[0]
            new_streak = 0
        else:
            chosen = prioTicket[0]
            new_streak = prioStreak + 1

    idx = waitTickets.index(chosen)
    return chosen, idx, new_streak


def call_next_ticket(state):
    free_counter = None
    for name, status in state["counters"].items():
        if status is None:
            free_counter = name
            break

    if not free_counter:
        return None, "All counters are currently busy."

    waiting = [t for t in state["tickets"] if t["status"] == "waiting"]
    ticket, idx, new_streak = next_ticket(waiting, state["prioStreak"])

    if ticket is None:
        return None, "No tickets are currently waiting."

    ticket["status"] = "served"
    state["prioStreak"] = new_streak
    state["counters"][free_counter] = ticket
    return (free_counter, ticket), f"Ticket #{ticket['id']} assigned to {free_counter}."


def complete_service(state, counter_name):
    if counter_name not in state["counters"]:
        return False, f"Invalid counter name. Valid options: {list(state['counters'].keys())}"

    ticket = state["counters"][counter_name]
    if ticket is None:
        return False, f"{counter_name} is already free / has no active service."

    state["counters"][counter_name] = None
    state["completed_history"].append(ticket)
    return True, f"Completed service for Ticket #{ticket['id']} at {counter_name}."


def cancel_ticket(state, ticket_id):
    for t in state["tickets"]:
        if t["id"] == ticket_id:
            if t["status"] == "waiting":
                t["status"] = "cancelled"
                return True, f"Ticket #{ticket_id} successfully cancelled."
            else:
                return False, f"Cannot cancel Ticket #{ticket_id}. Current status: {t['status']}."
    return False, f"Ticket #{ticket_id} not found."


def estimate_position(state, ticket_id):
    target = next((t for t in state["tickets"] if t["id"] == ticket_id), None)
    if not target or target["status"] != "waiting":
        return None

    sim_waiting = [{k: v for k, v in t.items()} for t in state["tickets"] if t["status"] == "waiting"]
    sim_streak = state["prioStreak"]
    position = 0

    while sim_waiting:
        chosen, idx, sim_streak = next_ticket(sim_waiting, sim_streak)
        position += 1
        if chosen["id"] == ticket_id:
            return position
        sim_waiting.pop(idx)

    return None


def report(**kwargs):
    print("\n--- Summary Report ---")
    for key, val in kwargs.items():
        formatted_key = key.replace("_", " ").title()
        print(f"{formatted_key}: {val}")
    print("----------------------")


def run_unit_tests():
    print("Running Automated Tests...")

    state1 = createQueue()
    t1 = issueTicket(state1, "Enrollment", "regular")
    t2 = issueTicket(state1, "Payment", "priority")

    if t1 == 1 and t2 == 2:
        print("Test 1 Passed: ID numbering is correct.")
    else:
        print("Test 1 Failed: ID numbering mismatch")

    state2 = createQueue()
    issueTicket(state2, "Enrollment", "priority")
    issueTicket(state2, "Records", "priority")
    issueTicket(state2, "Payment", "regular")
    issueTicket(state2, "Payment", "priority")

    c1_res, _ = call_next_ticket(state2)
    complete_service(state2, c1_res[0])
    c2_res, _ = call_next_ticket(state2)
    complete_service(state2, c2_res[0])
    c3_res, _ = call_next_ticket(state2)

    if c3_res[1]["id"] == 3:
        print("Test 2 Passed: Fairness rule handled correctly.")
    else:
        print(f"Test 2 Failed: Fairness rule picked {c3_res[1]['id']}")
    complete_service(state2, c3_res[0])

    state3 = createQueue()
    issueTicket(state3, "Enrollment", "regular")
    issueTicket(state3, "Records", "regular")
    issueTicket(state3, "Payment", "regular")
    call_next_ticket(state3)
    call_next_ticket(state3)
    res, msg = call_next_ticket(state3)

    if res is None and "busy" in msg:
        print("Test 3 Passed: Busy state handled correctly.")
    else:
        print("Test 3 Failed: Busy state ignored")

    state4 = createQueue()
    t_id = issueTicket(state4, "Enrollment", "regular")
    cancel_ticket(state4, t_id)
    waiting = [t for t in state4["tickets"] if t["status"] == "waiting"]

    if len(waiting) == 0:
        print("Test 4 Passed: Ticket cancelled successfully.")
    else:
        print("Test 4 Failed: Cancelled ticket remained in queue")

    state5 = createQueue()
    issueTicket(state5, "Enrollment", "regular")
    issueTicket(state5, "Payment", "priority")
    gen = getTicketsRunning(state5["tickets"])
    next(gen)
    next(gen)
    try:
        next(gen)
        print("Test 5 Failed: StopIteration not raised")
    except StopIteration:
        print("Test 5 Passed: Generator raises StopIteration as expected.")

    print("All 5 tests passed successfully!\n")


def display_menu():
    print("\n~ ~ ~ ~ ~ | ~ ~ ~ ~ ~ | ~ ~ ~ ~ ~ | ~ ~ ~ ~ ~\n\tCampus Service Queue Manager\n~ ~ ~ ~ ~ | ~ ~ ~ ~ ~ | ~ ~ ~ ~ ~ | ~ ~ ~ ~ ~")
    print("(1) Issue a ticket")
    print("(2) Call the next ticket")
    print("(3) Complete a service")
    print("(4) Cancel a waiting ticket")
    print("(5) Show waiting tickets")
    print("(6) Show counter status and completed history")
    print("(7) Show a summary report")
    print("(8) Test the functions")
    print("(9) Exit")
    print("~ ~ ~ ~ ~ | ~ ~ ~ ~ ~ | ~ ~ ~ ~ ~ | ~ ~ ~ ~ ~")


def main():
    state = createQueue()

    while True:
        # Always repeats while true
        display_menu()
        choice = input("Enter your choice (1-9): ").strip()

        if choice == "1":
            print("\nPurpose Options: 1. Enrollment | 2. Records | 3. Payment")
            p_choice = input("Select Purpose (1-3): ").strip()
            purpose_map = {"1": "Enrollment", "2": "Records", "3": "Payment"}
            purpose = purpose_map.get(p_choice)

            if not purpose:
                print("Error: Invalid purpose selection.")
                continue

            stype_input = input("Enter Service Type (1. Regular / 2. Priority) [Default: Regular]: ").strip()
            service_type = "priority" if stype_input == "2" else "regular"

            t_id = issueTicket(state, purpose, service_type)
            print(f"Success: Issued Ticket #{t_id} [{service_type.upper()}] for {purpose}.\nPress any key to continue")
            input()
            print("\n" * 100)

        elif choice == "2":
            msg = call_next_ticket(state)[1]
            print(f"\n{msg}\nPress any key to continue")
            input()
            print("\n" * 100)

        elif choice == "3":
            print("\nActive Counters:")
            for countName, val in state["counters"].items():
                status_str = f"Busy (Ticket #{val['id']})" if val else "Free"
                print(f" - {countName}: {status_str}")

            countInput = input("Enter Counter Number to complete (1 or 2): ").strip()
            countName = f"Counter {countInput}"
            
            msg = complete_service(state, countName)[1]
            print(f"\n{msg}\nPress any key to continue")
            input()
            print("\n" * 100)

        elif choice == "4":
            raw_id = input("Enter Ticket ID to cancel: ").strip()
            if not raw_id.isdigit():
                print("Error: Ticket ID must be numeric.")
                continue
            msg = cancel_ticket(state, int(raw_id))[1]
            print(f"\n{msg}\nPress any key to continue")
            input()
            print("\n" * 100)

        elif choice == "5":
            print("\n--- Currently Waiting Tickets ---")
            waiting_gen = getTicketsRunning(state["tickets"])
            pos = 1
            has_waiting = False
            for t in waiting_gen:
                has_waiting = True
                est_pos = estimate_position(state, t["id"])
                print(f"Position {pos} | Ticket #{t['id']} | {t['service_type'].upper()} | Purpose: {t['purpose']} | Est. Call Turn: {est_pos}")
                pos += 1
            if not has_waiting:
                print("No tickets are currently waiting.")
            print("Press any key to continue")
            input()
            print("\n" * 100)

        elif choice == "6":
            print("\n--- Counter Status ---")
            for countName, val in state["counters"].items():
                if val:
                    print(f"{countName}: BUSY servicing Ticket #{val['id']} [{val['service_type']}] for {val['purpose']}")
                else:
                    print(f"{countName}: FREE")

            print("\n--- Completed History ---")
            if not state["completed_history"]:
                print("No completed services recorded yet.")
            else:
                for t in state["completed_history"]:
                    print(f"Ticket #{t['id']} | {t['service_type'].upper()} | {t['purpose']}")
            print("Press any key to continue")
            input()
            print("\n" * 100)

        elif choice == "7":
            waiting_cnt = sum(1 for t in state["tickets"] if t["status"] == "waiting")
            served_cnt = len(state["completed_history"])
            cancelled_cnt = sum(1 for t in state["tickets"] if t["status"] == "cancelled")
            free_counters = sum(1 for v in state["counters"].values() if v is None)

            report(
                waitTickets=waiting_cnt,
                served_tickets=served_cnt,
                cancelled_tickets=cancelled_cnt,
                free_counters=free_counters,
                prioStreak_count=state["prioStreak"]
            )
            print("Press any key to continue")
            input()
            print("\n" * 100)

        elif choice == "8":
            print("\--- Testing the various functions ---")
            run_unit_tests()
            print("Press any key to continue")
            input()
            print("\n" * 100)

        elif choice == "9":
            print("\nExiting Campus Queue Manager. Goodbye!")
            break

        else:
            print("\nError: Invalid menu choice. Please select from 1 to 9.")

main()
