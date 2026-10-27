"""Part A - Campus service waiting list (singly linked list).

Run normally for the interactive menu, or `python <file> demo` to run the
required demonstration and test cases automatically.
"""
import sys


class CustomerNode:
    def __init__(self, name):
        self.name = name
        self.next = None


class WaitingList:
    def __init__(self):
        self.head = None
        self.tail = None

    def add_customer(self, name):
        node = CustomerNode(name)
        if self.head is None: # empty list: node is both head and tail
            self.head = self.tail = node
        else:
            self.tail.next = node
            self.tail = node
        print(f"Added: {name}")

    def serve_customer(self):
        if self.head is None:
            print("No customers are waiting.")
            return None
        node = self.head
        self.head = node.next
        if self.head is None: # list became empty
            self.tail = None
        node.next = None
        print(f"Served: {node.name}")
        return node.name

    def cancel_customer(self, name):
        prev = None
        cur = self.head
        while cur is not None and cur.name != name:
            prev = cur
            cur = cur.next
        if cur is None:
            print(f"Customer '{name}' not found.")
            return False
        if prev is None: # removing the head
            self.head = cur.next
        else:
            prev.next = cur.next
        if cur is self.tail: # removing the tail
            self.tail = prev
        cur.next = None
        print(f"Cancelled: {name}")
        return True

    def display_waiting(self):
        parts = []
        cur = self.head
        while cur is not None:
            parts.append(cur.name)
            cur = cur.next
        parts.append("None")
        print("Waiting: " + " -> ".join(parts))

    def count_customers(self):
        count = 0
        cur = self.head
        while cur is not None:
            count += 1
            cur = cur.next
        return count


def menu():
    wl = WaitingList()
    while True:
        print("\n1 Add customer | 2 Serve customer | 3 Cancel customer | "
              "4 Display waiting list | 5 Count customers | 0 Exit")
        choice = input("Choose: ").strip()
        if choice == "1":
            name = input("Customer name: ").strip()
            if name:
                wl.add_customer(name)
            else:
                print("Name cannot be empty.")
        elif choice == "2":
            wl.serve_customer()
        elif choice == "3":
            name = input("Name to cancel: ").strip()
            wl.cancel_customer(name)
        elif choice == "4":
            wl.display_waiting()
        elif choice == "5":
            print(f"Customers waiting: {wl.count_customers()}")
        elif choice == "0":
            print("Goodbye!")
            break
        else:
            print("Invalid option. Please enter 0-5.")


def demo():
    print("=== Required demonstration ===")
    wl = WaitingList()
    for n in ("Ana", "Ben", "Carla"):
        wl.add_customer(n)
    wl.display_waiting()
    wl.serve_customer()
    wl.cancel_customer("Carla")
    wl.add_customer("Daniel")
    wl.display_waiting()
    print(f"Customers waiting: {wl.count_customers()}")

    print("\n=== Test: empty list ===")
    e = WaitingList()
    e.serve_customer()
    e.cancel_customer("X")
    e.display_waiting()
    print("Count:", e.count_customers())

    print("\n=== Test: add one, serve it ===")
    e.add_customer("Solo")
    e.serve_customer()
    print("head is None:", e.head is None, "| tail is None:", e.tail is None)

    print("\n=== Test: cancel head / middle / tail / missing ===")
    t = WaitingList()
    for n in ("A", "B", "C", "D", "E"):
        t.add_customer(n)
    t.cancel_customer("A"); t.display_waiting() # head
    t.cancel_customer("C"); t.display_waiting() # middle
    t.cancel_customer("E"); t.display_waiting() # tail
    print("tail is D:", t.tail.name == "D", "| tail.next is None:", t.tail.next is None)
    t.cancel_customer("Zed") # missing

    print("\n=== Test: duplicates ===")
    d = WaitingList()
    for n in ("Sam", "Lee", "Sam"):
        d.add_customer(n)
    d.cancel_customer("Sam")
    d.display_waiting()


if __name__ == "__main__":
    if len(sys.argv) > 1 and sys.argv[1] == "demo":
        demo()
    else:
        menu()
