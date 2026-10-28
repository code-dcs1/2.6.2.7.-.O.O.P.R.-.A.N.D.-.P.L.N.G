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

def main():
    books = [
        Book("Python Basics ","Maria Santos",450),
        Ebook("Learning OOP","Maria Santos",300,5),
        Ebook("Java Programming","Unknown",150,2)
    ]

    for book in books:
        print(book)
        print()
    
if __name__ == "__main__":
    main()
