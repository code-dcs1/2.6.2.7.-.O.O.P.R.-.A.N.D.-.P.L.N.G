def regular_input(prompt, guidelines):
    """Keep asking until the user enters a valid integer."""
    while True:
        try:
            return int(input(prompt))
        except ValueError:
            print(f"Input error, try to follow the guidelines for the input\n[ {guidelines} ]\n")

def read_non_negative(prompt, guidelines="The input should be a number"):
    """Keep asking until the user enters an integer that is 0 or more."""
    while True:
        value = regular_input(prompt, guidelines)
        if value < 0:
            print("The amount should be not less than 0\n")
        else:
            return value

def main():
    print("Welcome!")
    balance = read_non_negative("Enter your initial balance: ")

    running = True
    while running:
        print("\n--------------------------------------------------")
        print("Select an option:")
        print("1. Withdraw Amount")
        print("2. Deposit Amount")
        print("3. Exit")
        print("--------------------------------------------------")
        choice = regular_input("Enter your choice (1-3): ", "The input should be a number")

        if choice == 1:
            print("How much amount you want to withdraw from your account?")
            withdraw_amount = read_non_negative("Amount: ")
            if withdraw_amount > balance:
                print("Transaction failed: Insufficient funds!")
            else:
                balance -= withdraw_amount
                print(f"Your new balance is: {balance}")

        elif choice == 2:
            print("How much amount you want to deposit in your account?")
            deposit_amount = read_non_negative("Amount: ")
            balance += deposit_amount
            print(f"Your new balance is: {balance}")

        elif choice == 3:
            print("Thank you for using the system!")
            running = False

        else:
            print("Invalid option! Please select 1, 2, or 3.")

main()
