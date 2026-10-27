from datetime import date as _date

def read_int(prompt):
    while True:
        try:
            return int(input(prompt).strip())
        except ValueError:
            print("Invalid input. Please enter a whole number.")

def read_text(prompt):
    while True:
        text = input(prompt).strip()
        if text:
            return text
        print("This field cannot be empty.")

class Date:
    def __init__(self, year, month, day):
        self.year = year
        self.month = month
        self.day = day

    def __str__(self):
        return f"{self.year}-{self.month}-{self.day}"

def read_date(label):
    while True:
        print(label)
        year = read_int("  Year: ")
        month = read_int("  Month: ")
        day = read_int("  Day: ")
        try:
            _date(year, month, day)
            return Date(year, month, day)
        except ValueError:
            print("Invalid date. Please try again.")

class Patient:
    def __init__(self):
        self.name = None
        self.admission_date = None
        self.disease = None
        self.discharge_date = None

    def input_data(self):
        self.name = read_text("Name of the patient: ")
        self.admission_date = read_date("Date of admission:")
        self.disease = read_text("Disease: ")
        self.discharge_date = read_date("Date of discharge:")

    def display(self):
        print("--------------------------------")
        print(f"Name: {self.name}")
        print(f"Date of admission: {self.admission_date}")
        print(f"Disease: {self.disease}")
        print(f"Date of discharge: {self.discharge_date}")

class PatientWithAge(Patient):
    def __init__(self):
        super().__init__()
        self._age = 0

    def get_age(self):
        return self._age

    def input_data(self):
        super().input_data()
        while True:
            self._age = read_int("Age: ")
            if 0 <= self._age <= 150:
                break
            print("Age must be between 0 and 150.")

    def display(self):
        super().display()
        print(f"Age: {self._age}")

def main():
    patients = []
    running = True

    print("OUTPUT IN ACTIVITY 2")
    while running:
        print()
        print("1. Insert New Patient")
        print("2. Display all Patient")
        print("3. Display pediatric patient")
        print("4. Exit")
        choice = read_int("Choice: ")

        if choice == 1:
            p = PatientWithAge()
            p.input_data()
            patients.append(p)
            print("Patient added.")

        elif choice == 2:
            if not patients:
                print("No patients in the database.")
            for pt in patients:
                pt.display()

        elif choice == 3:
            found = False
            for pt in patients:
                if pt.get_age() < 12:
                    pt.display()
                    found = True
            if not found:
                print("No pediatric patients found.")

        elif choice == 4:
            running = False

        else:
            print("Invalid choice. Enter 1 to 4.")

    print("Goodbye!")

main()
