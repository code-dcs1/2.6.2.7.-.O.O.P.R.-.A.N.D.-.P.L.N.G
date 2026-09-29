def numberInputs(printOut, choice_type):
    while True:
        try:
            return choice_type(input(printOut))
        except ValueError:
            print(
                "\n\n\n\n\n[ Invalid input! Please enter a valid choice number. ]\n")


while True:
    choice, num1, num2 = 0, 0.0, 0.0
    while True:
        choice = numberInputs(
        "Arithmetic Operations:\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Modulus\n6. Increment\n7. Decrement\n Your choice: ", int)
        if 1 <= choice <= 7:
            break
        print("\n[ Invalid choice! Please select an operation from 1 to 7. ]\n")

    if (choice >= 1 and choice <= 7):
        num1 = numberInputs("\nEnter first number: ", float)
        if (choice != 6 and choice != 7):
            num2 = numberInputs("\nEnter second number: ", float)

        if choice == 1:
            print(f"Addition: x + y = {num1 + num2}")
        elif choice == 2:
            print(f"Subtraction: x - y = {num1 - num2}")
        elif choice == 3:
            print(f"Multiplication: x * y = {num1 * num2}")
        elif choice == 4:
            if num2 != 0:
                print(f"Division: x / y = {num1 / num2}")
            else:
                print("Error: Division by zero")
        elif choice == 5:
            try:
                print(f"Modulus: x % y = {num1 % num2}")
            except ZeroDivisionError:
                print("Error: Division by zero")
        elif choice == 6:
            num1 = num1 + 1
            print(f"Increment: x + 1 = {num1}")
        elif choice == 7:
            num1 = num1 - 1
            print(f"Decrement: x - 1 = {num1}")
    else:
        print("Invalid input")

    print("Do you want to continue: (YES / NO)")
    exitChoice = input()
    if exitChoice.strip().lower() == "no":
        print("Program terminated.\nThank you!")
        break

    print("\n")
