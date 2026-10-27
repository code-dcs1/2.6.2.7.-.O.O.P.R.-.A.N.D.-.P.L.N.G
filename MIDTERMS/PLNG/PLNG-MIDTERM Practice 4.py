import math
from datetime import date, datetime

DATE_FORMAT = "%m, %d, %Y"


def regular_input(prompt, guidelines):
    """Keep asking until the user enters a valid integer."""
    while True:
        try:
            return int(input(prompt))
        except ValueError:
            print(f"Input error, try to follow the guidelines for the input\n[ {guidelines} ]\n")


def read_date(prompt):
    """Keep asking until the user enters a valid date. Returns a date object."""
    while True:
        text = input(prompt).strip()
        try:
            return datetime.strptime(text, DATE_FORMAT).date()
        except ValueError:
            print("Input error, try to input a proper date time\n")


def main():
    book_prompt = ("How many pages does the book have? ", "The input should be a number ")
    read_prompt = ("How many pages have you read? ", "The input should be a number ")

    user_name = input("Enter your name: ")
    print(f"\nWelcome {user_name}\n")

    while True:
        book_pages = regular_input(*book_prompt)
        if book_pages < 0:
            print("The number of pages cannot be negative\n")
        else:
            break

    print()

    while True:
        read_pages = regular_input(*read_prompt)
        if read_pages < 0:
            print("Pages read cannot be negative\n")
        elif read_pages > book_pages:
            print("Pages read is more than the book pages\n")
        else:
            break

    print()

    issue_date = read_date("Issue date (MM, DD, YYYY): ")
    print()

    while True:
        due_date = read_date("Due date (MM, DD, YYYY): ")
        if due_date < issue_date:
            print("Input error, try to input a proper date time\n")
        else:
            break

    percent_read = (read_pages / book_pages) * 100 if book_pages else 100
    if percent_read < 100:
        print(f"\nYou have read {percent_read:.2f}% of the book.", end="")
    else:
        print("\nYou have read the book entirely.", end="")

    current_date = date.today()
    days_remaining = (due_date - current_date).days
    if days_remaining < 0:
        print("\nYou have to return the book today.", end="")
    else:
        print(f"\nYou have {days_remaining} day/s remaining to return the book.", end="")

    remaining_pages = book_pages - read_pages
    if days_remaining > 0:
        pages_per_day = math.ceil(remaining_pages / days_remaining)
        print(f"\nYou should read {pages_per_day} pages per day.")
    else:
        print("\nYou should read all of the pages today.")


if __name__ == "__main__":
    main()
