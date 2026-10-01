import os
import re
import sys

class Student:
    _no_of_students = 0

    def __init__(self, student_no=None, student_name=None, date_of_birth=None, tariff_points=None):
        if student_no is None and student_name is None and date_of_birth is None and tariff_points is None:
            self._student_no = "not known"
            self._student_name = "not known"
            self._date_of_birth = "01/01/1995"
            self._tariff_points = 20
        else:
            self.student_no = student_no
            self.student_name = student_name
            self.date_of_birth = date_of_birth
            self.tariff_points = tariff_points

        Student._no_of_students += 1

    @classmethod
    def get_no_of_students(cls):
        return cls._no_of_students

    @property
    def student_no(self):
        return self._student_no

    @student_no.setter
    def student_no(self, value):
        if value is None or not str(value).strip():
            raise ValueError("Student number cant be empty.")
        self._student_no = value

    @property
    def student_name(self):
        return self._student_name

    @student_name.setter
    def student_name(self, value):
        if value is None or not str(value).strip():
            raise ValueError("Student name cant be empty.")
        self._student_name = value

    @property
    def date_of_birth(self):
        return self._date_of_birth

    @date_of_birth.setter
    def date_of_birth(self, value):
        if value is None or not str(value).strip():
            raise ValueError("Date of birth cant no value.")
        self._date_of_birth = value

    @property
    def tariff_points(self):
        return self._tariff_points

    @tariff_points.setter
    def tariff_points(self, value):
        if value < 20 or value > 280:
            raise ValueError("Tariff points must be between 20 and 280.")
        self._tariff_points = value

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
    student1 = Student()
    student2 = Student("ST10234", "Alice Smith", "2002/5/14", 180)

    print(f"Student 1 Name: {student1.student_name}") 
    print(f"Student 1 Points: {student1.tariff_points}")
    
    print(f"Student 2 Name: {student2.student_name}")
    print(f"Student 2 Points: {student2.tariff_points}")

    print(f"Total Students Created: {Student.get_no_of_students()}")

def act_seven():
    file_path = "data.txt"
    try:
        print("--- Reading Data from File ---")
        print("E No.\tE Name\t\tMobile")
        print("---------------------------------")
        
        with open(file_path, 'r') as file:
            for line in file:
                data = re.split(r'[,\t]', line.strip('\n'))
                
                if len(data) == 3:
                    e_number = data[0].strip()
                    e_name = data[1].strip()
                    mobile = data[2].strip()
                    print(f"{e_number}\t{e_name}\t\t{mobile}")
                    
    except FileNotFoundError:
        print("Could not find the file.")
        print(f"The location at {os.path.abspath(file_path)} may not exist")

def main():
    print("=== SELECT A PROGRAM ===")
    print("1. Positive/Negative Stats & Minimum Value")
    print("2. Remove Duplicates & Find 2nd Smallest/Largest")
    print("3. Delete a element in an array from specific position")
    print("4. Even elements and odd elements in array")
    print("5. A and Stars")
    print("6. Student Tariff Points System")
    print("7. Tab separated data on text")
    
    try:
        choice = int(input("Enter your choice (1, 2, 3, 4, 5, 6, or 7): "))
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
            case 7:
                act_seven()
            case _:
                print("Invalid choice! Please restart and enter a number between 1 and 7.")
                
    except ValueError:
        print("\nInvalid input! Please enter a valid integer choice.")

main()
