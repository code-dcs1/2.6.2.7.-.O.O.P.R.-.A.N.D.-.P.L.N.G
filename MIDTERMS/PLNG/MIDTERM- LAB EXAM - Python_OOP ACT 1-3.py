class Book:
    def __init__(self,title,author,price):
        self.title = title
        self.author = author
        self.price = price
    
    def __str__(self):
        return f"Book: {self.title} | Author: {self.author}\nPrice: PHP {self.price:.2f}"

class Ebook(Book):
    def __init__(self,title,author,price,filesize):
        super().__init__(title,author,price)
        self.filesize = filesize

    def __str__(self):
        return f"E{super().__str__()} | File size: {self.filesize} MB"

import math

class Student:
    def __init__(self,name,student_id,tuition_fee):
        self.name = name
        self.student_id = student_id
        self.tuition_fee = tuition_fee
    
    def validateTuition(self, tuition_fee):
        try:
            tf_numeric = float(tuition_fee)
            if tf_numeric < 0:
                raise ValueError
            return tf_numeric
        except ValueError:
            return 0

    def __str__(self):
        newTuition = self.validateTuition(self.tuition_fee)
        return f"Name: {self.name} | Student ID: {self.student_id}\nTuition fee: PHP {newTuition:.2f}"

class ScholarStudent(Student):
    def __init__(self,name,student_id,tuition_fee,scholarship_percentage):
        super().__init__(name,student_id,tuition_fee)
        self.scholarship_percentage = scholarship_percentage

    def calculate_payable_fee(self,name,student_id,tuition_fee,scholarship_percentage):
        try:
            sp = float(self.scholarship_percentage)
            if sp < 0:
                raise ValueError
            if sp > 100:
                scholarship_percentage = 100

            newTuition = tuition_fee - (tuition_fee * scholarship_percentage / 100)
            return newTuition
        except ValueError:
            return f"{tuition_fee}.0"

    def __str__(self):
        if isinstance(self.scholarship_percentage, (int, float)):
            return f"{super().__str__()}\nScholarship: {(self.scholarship_percentage):.2f}%\nPayable fee: PHP {self.calculate_payable_fee(self.name,self.student_id,self.tuition_fee,self.scholarship_percentage)}"
        else:
            return f"Invalid parameters"

def main():
    books = [
        Book("Python Basics ","Maria Santos",450),
        Ebook("Learning OOP","Maria Santos",300,5),
        Ebook("Java Programming","Unknown",150,2)
    ]

    for book in books:
        print(book)
        print()

    students = [
        Student("Wilfrid","2026-001",40000),
        ScholarStudent("David","2026-002",40000,250),
        ScholarStudent("Daniel","2026-003",40000,25)
    ]

    for student in students:
        print(student)
        print()

if __name__ == "__main__":
    main()
