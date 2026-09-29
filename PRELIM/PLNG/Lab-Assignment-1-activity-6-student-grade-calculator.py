def numberInputs(printOut, choice_type):
    while True:
        try:
            value = choice_type(input(printOut))
            if value <= 100 and value >= 0:
                return value
            print("\n[ Invalid range! Please enter a score between 0 and 100. ]\n")
        except ValueError:
            print("\n[ Invalid input! Please enter a valid choice number. ]\n")


while True:
    JavaScore = numberInputs("Input:\nJava Score: ", int)
    CScore = numberInputs("Input:\nC Score: ", int)
    DBScore = numberInputs("Input:\nDatabase Handling Score: ", int)

    score = (JavaScore + CScore + DBScore) / 3
    gradeLetter = ""
    gradeMin, gradeMax = 0, 0

    if score >= 90:
        gradeLetter = "A"
        gradeMin, gradeMax = 90, 100
    elif score >= 80:
        gradeLetter = "B"
        gradeMin, gradeMax = 80, 89
    elif score >= 75:
        gradeLetter = "C"
        gradeMin, gradeMax = 75, 79
    else:
        gradeLetter = "F"
        gradeMin, gradeMax = 0, 74

    print(f"\nAverage: {score:.2f}")

    if gradeLetter == "F":
        print(f"Grade: {gradeLetter} because the average 74 and below")
    else:
        print(f"Grade: {gradeLetter} because the average is between {gradeMin} and {gradeMax}")

    print("\nDo you want to continue: (YES / NO)")
    exitChoice = input()
    if exitChoice.strip().lower() == "no":
        print("Program terminated.\nThank you!")
        break

    print("\n")
