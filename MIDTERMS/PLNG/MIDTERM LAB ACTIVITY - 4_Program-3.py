import math

def read_salary(prompt):
    while True:
        try:
            value = float(input(prompt).strip())
            if math.isfinite(value) and value > 0:
                return value
            print("Salary must be greater than zero.")
        except ValueError:
            print("Invalid input. Please enter a number.")

def read_text(prompt):
    while True:
        text = input(prompt).strip()
        if text:
            return text
        print("This field cannot be empty.")

class Professor:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary

class Dean(Professor):
    def __init__(self, name, salary, department):
        super().__init__(name, salary)
        self.department = department

    def _details(self):
        return (f"Name: {self.name}\n"
                f"Department: {self.department}\n"
                f"Salary: {int(self.salary)}")

    def __str__(self):
        return "Status\nRank: Dean\n" + self._details()

class Executive(Dean):
    def __str__(self):
        return "Status\nRank: Executive\n" + self._details()

def main():
    print("OUTPUT IN ACTIVITY 3")

    print("Enter the Dean's details:")
    name = read_text("  Name: ")
    salary = read_salary("  Salary: ")
    department = read_text("  Department: ")
    dean = Dean(name, salary, department)

    print("Enter the Executive's details:")
    name = read_text("  Name: ")
    salary = read_salary("  Salary: ")
    department = read_text("  Department: ")
    executive = Executive(name, salary, department)

    print()
    print(dean)
    print("--------------------------------")
    print(executive)

main()
