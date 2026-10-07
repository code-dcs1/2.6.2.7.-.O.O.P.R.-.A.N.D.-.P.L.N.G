import sys

def act_one():
    lists = [0] * 10
    calc = [0, 0, 0, 0]
    
    for i in range(10):
        try:
            sys.stdout.write(f"Enter the no.{i+1} number: ")
            sys.stdout.flush()
            lists[i] = int(sys.stdin.readline().strip())
        except (ValueError, IndexError):
            print("Input error, defaulting to default 0")
            lists[i] = 0

    for i in range(10):
        if lists[i] >= 0:
            calc[0] += lists[i]
        if lists[i] < 0:
            calc[1] += 1

    avg = calc[0] / 10 if calc[0] > 0 else 0.0
    
    print(f"\nThe sum of positive numbers is {calc[0]} and the average of them is {avg} they are the numbers ")
    for i in range(10):
        if lists[i] >= 0:
            print(lists[i], end=" ")

    print(f"\nThe total amount of negative numbers is {calc[1]} and they are the numbers ")
    for i in range(10):
        if lists[i] < 0:
            print(lists[i], end=" ")

    n = len(lists)
    for i in range(n - 1):
        swapped = False
        for j in range(n - i - 1):
            if lists[j] > lists[j + 1]:
                lists[j], lists[j + 1] = lists[j + 1], lists[j]
                swapped = True
        if not swapped:
            break
            
    print(f"\nMinimum Value in the array is: {lists[0]}")


def act_two():
    numbers = [0] * 8

    print("Enter 8 integer numbers:")
    for i in range(8):
        while True:
            try:
                numbers[i] = int(input(f"Element {i + 1}: "))
                break
            except ValueError:
                print("Invalid input. Please enter an integer.")

    u_num = []
    for num in numbers:
        if num not in u_num:
            u_num.append(num)
    
    print(f"\nOriginal Array: {numbers}")
    print(f"Array after removing duplicates: {u_num}")

    if len(u_num) < 2:
        print("\nThe numbers here are less than 2 unique numbers.")
    else:
        u_num.sort()
        s_small = u_num[1]
        s_large = u_num[len(u_num) - 2]

        print(f"Second smallest element: {s_small}")
        print(f"Second largest element: {s_large}")

def act_three():
    arr = [0] * 5
    
    print("Enter Data in Array: ")
    input_data = []
    while len(input_data) < 5:
        input_data.extend(input.split())
    
    for i in range(5):
        arr[i] = int(input_data[i])
        
    print("Stored Data in Array: ", end="")
    for i in range(len(arr)):
        print(f"{arr[i]} ", end="")
    print()
    
    try:
        pos = int(input("Enter position of Element to Delete: "))
    except ValueError:
        print("Invalid position")
        return
        
    if pos < 0 or pos >= len(arr):
        print("Invalid position")
    else:
        for i in range(pos, len(arr) - 1):
            arr[i] = arr[i + 1]

        print("New data in Array: ", end="")
        for i in range(len(arr) - 1):
            print(f"{arr[i]} ", end="")
        print()


def act_four():
    arr_size = 10
    
    while True:
        try:
            size_input = sys.stdin.readline().strip()
            print(f"Enter the size of the array: {size_input}")
            arr_size = int(size_input)
            break
        except ValueError:
            print("Input error, defaulting to default 10")
            break

    lists = [0] * arr_size
    print(f"Enter {arr_size} elements into the array")
    
    elements_read = 0
    while elements_read < arr_size:
        line_tokens = sys.stdin.readline().split()
        if not line_tokens and elements_read < arr_size:
            continue
            
        for token in line_tokens:
            if elements_read >= arr_size:
                break
            try:
                lists[elements_read] = int(token)
            except ValueError:
                print("0")
                lists[elements_read] = 0
            elements_read += 1

    print("Even elements: ", end="")
    for i in range(arr_size):
        if lists[i] % 2 == 0:
            print(f"{lists[i]} ", end="")
            
    print("\nOdd elements: ")
    for i in range(arr_size):
        if lists[i] % 2 == 1:
            print(f"{lists[i]} ", end="")
    print()


def act_five():
    for i in range(4):
        print("*", end="")
        for j in range(i + 1):
            if j < i:
                print("A*", end="")
        print()


def act_six():
    basic_salary = float(input("Enter the basic salary: "))
    hra = float(input("Enter the HRA: "))
    ta = float(input("Enter the TA: "))
    others = float(input("Enter the Others: "))

    da = 0.12 * basic_salary    
    # Tax cuts
    pf = 0.14 * basic_salary
    it = 0.15 * basic_salary
    net_salary = basic_salary + da + hra + ta + others - (pf + it)

    print(f"Net Salary: ${net_salary:,.2f}")

def main():
    while True:
        print("\n=== SELECT A PROGRAM ===")
        print("1. Positive/Negative Stats & Minimum Value")
        print("2. Remove Duplicates & Find 2nd Smallest/Largest")
        print("3. Delete a element in an array from specific position")
        print("4. Even elements and odd elements in array")
        print("5. A and Stars")
        print("6. Calculate Net Salary")
        
        try:
            choice = int(input("Enter your choice (1, 2, 3, 4, 5, or 6): "))
            print()

            match choice:
                case 1:
                    act_one()
                case 2:
                    act_two()
                case 3:
                    act_three()
                case 4:
                    act_four()
                case 5:
                    act_five()
                case 6:
                    act_six()
                case _:
                    print("Invalid choice! Please restart and enter a number between 1 and 6.")
                    
        except ValueError:
            print("\nInvalid input! Please enter a valid integer choice.")

        choice = input("\nWould you like to continue (Y/N): ")
        if choice == "N" or choice == "n":
            print("Exiting the program... ")
            break
        

main()
