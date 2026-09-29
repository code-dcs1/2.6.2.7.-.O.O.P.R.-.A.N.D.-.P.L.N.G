choice = int(input("Choose a number between 1 - 100: "))
if (choice <= 100 and choice >= 1) and choice % 5 == 0:
    print("The number you entered is valid")
else:
    print("You entered an invalid input")