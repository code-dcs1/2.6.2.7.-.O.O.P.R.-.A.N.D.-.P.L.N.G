from tkinter import *
from openpyxl import *
import pymysql.cursors

# Program 31 - How to put records from the database on Python?
def program31():
    # Database connection sentence
    connection = pymysql.connect(host='localhost',
    user='root',
    password='',
    db='students',
    charset='utf8mb4',
    cursorclass=pymysql.cursors.DictCursor)
    try:
        with connection.cursor() as cursor:
            # single line reading
            sql = "SELECT `id`, `firstname`,`lastname` FROM `users`"
            cursor.execute(sql)
            for row in cursor.fetchall():
                #read all lines
                firstname = str(row["firstname"])
                lastname = str(row["lastname"])
                #print on screen
                print("firstname : " + firstname)
                print("lastname : " + lastname)
    finally:
        connection.close()

# Program 32 - How to Use Tkinter Form on Python?
def program32():
    
    window = Tk()
    # add widgets here
    window.title('Hello Python')
    window.geometry("300x200+10+20")
    window.mainloop()

# Program 33 - How to Create Python Form Entry on Python?
def program33():
    from tkinter import messagebox
    window = Tk()
    window.title("mrhuseyin.medium.com")
    window.geometry("400x300")
    #plotting grid forms
    application = Frame(window)
    application.grid()
    L1 = Label("uygulama", text="Enter your name")
    L1.grid(padx=110, pady=10)
    E1 = Entry(application, bd =2)
    E1.grid(padx=110, pady=3)
    #draw form
    window.mainloop()

# Program 34 - How to create Python Tkinter ListBox on Python?
def program34():
    from tkinter import messagebox

    window = Tk()

    window.title("mrhuseyin.medium.com")
    window.geometry("400x300")

    #grid form
    application = Frame(window)
    application.grid()

    Lb1 = Listbox(application)
    Lb1.insert(1, "Python")
    Lb1.insert(2, "C#")
    Lb1.insert(3, "JAVA")
    Lb1.insert(4, "JAVASCRIPT")
    Lb1.grid(padx=110, pady=10)

    #draw form
    application.mainloop()

# Program 35 - How to make a simple registration form using Python Tkinter on Python?
def program35():
    # import openpyxl and tkinter modules
    # globally declare wb and sheet variable
    # opening the existing excel file
    wb = load_workbook('C:\\Users\\Admin\\Desktop\\excel.xlsx')
    
    # create the sheet object
    sheet = wb.active
    
    def excel():
        # resize the width of columns in excel spreadsheet
        sheet.column_dimensions['A'].width = 30
        sheet.column_dimensions['B'].width = 10
        sheet.column_dimensions['C'].width = 10
        sheet.column_dimensions['D'].width = 20
        sheet.column_dimensions['E'].width = 20
        sheet.column_dimensions['F'].width = 40
        sheet.column_dimensions['G'].width = 50
    
        # write given data to an excel spreadsheet at particular location
        sheet.cell(row=1, column=1).value = "Name"
        sheet.cell(row=1, column=2).value = "Course"
        sheet.cell(row=1, column=3).value = "Semester"
        sheet.cell(row=1, column=4).value = "Form Number"
        sheet.cell(row=1, column=5).value = "Contact Number"
        sheet.cell(row=1, column=6).value = "Email id"
        sheet.cell(row=1, column=7).value = "Address"

    # Function to set focus (cursor)
    def focus1(event):
        # set focus on the course_field box
        course_field.focus_set()
    
    # Function to set focus
    def focus2(event):
        # set focus on the sem_field box
        sem_field.focus_set()
    
    # Function to set focus
    def focus3(event):
        # set focus on the form_no_field box
        form_no_field.focus_set()

    # Function to set focus
    def focus4(event):
        # set focus on the contact_no_field box
        contact_no_field.focus_set()
    
    # Function to set focus
    def focus5(event):
        # set focus on the email_id_field box
        email_id_field.focus_set()
    
    # Function to set focus
    def focus6(event):
        # set focus on the address_field box
        address_field.focus_set()
    
    # Function for clearing the contents of text entry boxes
    def clear():
        # clear the content of text entry box
        name_field.delete(0, END)
        course_field.delete(0, END)
        sem_field.delete(0, END)
        form_no_field.delete(0, END)
        contact_no_field.delete(0, END)
        email_id_field.delete(0, END)
        address_field.delete(0, END)
    
        # Function to take data from GUI window and write to an excel file
    def insert():
        # if user not fill any entry then print "empty input"
        if (name_field.get() == "" and
            course_field.get() == "" and
            sem_field.get() == "" and
            form_no_field.get() == "" and
            contact_no_field.get() == "" and
            email_id_field.get() == "" and
            address_field.get() == ""):
            print("empty input")
        else:
            # assigning the max row and max column value upto which data is written in an excel sheet to the variable
            current_row = sheet.max_row
            current_column = sheet.max_column
            # get method returns current text as string which we write into excel spreadsheet at particular location
            sheet.cell(row=current_row + 1, column=1).value = name_field.get()
            sheet.cell(row=current_row + 1, column=2).value = course_field.get()
            sheet.cell(row=current_row + 1, column=3).value = sem_field.get()
            sheet.cell(row=current_row + 1, column=4).value = form_no_field.get()
            sheet.cell(row=current_row + 1, column=5).value = contact_no_field.get()
            sheet.cell(row=current_row + 1, column=6).value = email_id_field.get()
            sheet.cell(row=current_row + 1, column=7).value = address_field.get()
            # save the file
            wb.save('C:\\Users\\Admin\\Desktop\\excel.xlsx')
            # set focus on the name_field box
            name_field.focus_set()
            # call the clear() function
            clear()
    
    # Driver code
    if __name__ == "__main__":
        # create a GUI window
        root = Tk()
        # set the background colour of GUI window
        root.configure(background='light green')
        # set the title of GUI window
        root.title("registration form")
        # set the configuration of GUI window
        root.geometry("500x300")
        excel()
        # create a Form label
        heading = Label(root, text="Form", bg="light green")
        # create a Name label
        name = Label(root, text="Name", bg="light green")
        # create a Course label
        course = Label(root, text="Course", bg="light green")
        # create a Semester label
        sem = Label(root, text="Semester", bg="light green")
        # create a Form No. lable
        form_no = Label(root, text="Form No.", bg="light green")
        # create a Contact No. label
        contact_no = Label(root, text="Contact No.", bg="light green")
        # create a Email id label
        email_id = Label(root, text="Email id", bg="light green")
        # create a address label
        address = Label(root, text="Address", bg="light green")
        # grid method is used for placing the widgets at respective positions in table like structure .
        heading.grid(row=0, column=1)
        name.grid(row=1, column=0)
        course.grid(row=2, column=0)
        sem.grid(row=3, column=0)
        form_no.grid(row=4, column=0)
        contact_no.grid(row=5, column=0)
        email_id.grid(row=6, column=0)
        address.grid(row=7, column=0)
        # create a text entry box for typing the information
        name_field = Entry(root)
        course_field = Entry(root)
        sem_field = Entry(root)
        form_no_field = Entry(root)
        contact_no_field = Entry(root)
        email_id_field = Entry(root)
        address_field = Entry(root)
        # bind method of widget is used for the binding the function with the events whenever the enter key is pressed then call the focus1 function
        name_field.bind("<Return>", focus1)
        # whenever the enter key is pressed then call the focus2 function
        course_field.bind("<Return>", focus2)
        # whenever the enter key is pressed then call the focus3 function
        sem_field.bind("<Return>", focus3)
        # whenever the enter key is pressed then call the focus4 function
        form_no_field.bind("<Return>", focus4)
        # whenever the enter key is pressed then call the focus5 function
        contact_no_field.bind("<Return>", focus5)
        # whenever the enter key is pressed then call the focus6 function
        email_id_field.bind("<Return>", focus6)
        # grid method is used for placing the widgets at respective positions in table like structure .
        name_field.grid(row=1, column=1, ipadx="100")
        course_field.grid(row=2, column=1, ipadx="100")
        sem_field.grid(row=3, column=1, ipadx="100")
        form_no_field.grid(row=4, column=1, ipadx="100")
        contact_no_field.grid(row=5, column=1, ipadx="100")
        email_id_field.grid(row=6, column=1, ipadx="100")
        address_field.grid(row=7, column=1, ipadx="100")
        # call excel function
        excel()
        # create a Submit Button and place into the root window
        submit = Button(root, text="Submit", fg="Black",
        bg="Red", command=insert)
        submit.grid(row=8, column=1)
        # start the GUI
        root.mainloop()

# Program 36 - How to make a game that guesses the number the user holds on Python?
def program36():
    from random import randint
    
    rand = randint(1, 100)
    counter = 0

    while True:
        counter+=1
        num=int(input("Enter values between 1 and 100 (0 exit):"))
        if(num==0):
            print("You canceled the game.")
            break
        elif num < rand:
            print("Enter a Higher Number.")
            continue
        elif num > rand:
            print("Enter a Lower Number.")
            continue
        else:
            print("Randomly selected number {0}!".format(rand))
            print("Your guess number {0}".format(counter))

# Program 37 - How to make a list of your favorite fruits and print them on the screen on Python?
def program37():
    favorite_fruits = ['apples', 'erics', 'oranges']
    print("My favourite fruits {}".format(favorite_fruits))

# Program 38 - How to print “the number of pi in order, the equivalent of the inch unit in cm, the abbreviation of microprocessors, the name of the operating system you are using” on Python?
def program38():
    list=[3.14,2.54,"CPU","WINDOWS 10"]
    print(list)

# Program 39 - How to make a list of the days of the week beginning with Monday and ending with Friday. Also, how to print the element of the list you have created with an index of 4 on the screen on Python?
def program39():
    weekdays=["Monday","Tuesday","Wednesday","Thursday","Friday"]
    print(weekdays[4])

# Program 40 - How to change the list from 3,1,2 values to 1,1,2 respectively on Python?
def program40():
    list=[3,1,2]
    list[0]=1
    list[1]=1
    list[2]=2
    print(list)

# Program 41 - How to make a list of the week's names and check if some days are on the list on Python?
def program41():
    weekdays=["Monday","Tuesday","Wednesday","Thursday","Friday"]
    print("Friday" in weekdays)
    print("Saturday" in weekdays)

# Program 42 - How to print even numbers in a list on Python?
def program42():
    list1 = [10, 21, 4, 45, 66, 93]
    for num in list1:
    # checking condition
        if num % 2 == 0:
            print(num, end = " ")

# Program 43 - Create a list named numbers consisting of 3-18 numbers. Combine the list created with the list of "numbers2 = [21,22,23,24,25]", then print the numbers divided by 4 on the screen.
def program43():
    numbers = [3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18]
    numbers2 = [21,22,23,24,25]
    combine = numbers + numbers2
    for number in combine:
        if number%4==0:
            print(number)

# Program 44 - How to write the code with the screen output as below with the while loop on Python?
def program44():
    i = 1
    while i <= 12:
        print(" {}. class".format(i))
        i += 1

# Program 45 - How to sum the digits of the number the user entered on Python?
def program45():
    number = input("enter a number: ")
    sum=0
    for numberofdigit in number:
        sum += int(numberofdigit)
    print("the sum of the digits of the number:",sum)

# Program 46 - How to multiply the digits of the number entered by the user (except zero) on Python?
def program46():
    number = input("enter an number: ")
    for digitofnumber in str(number):
        if int(digitofnumber) != 0:
            multiplication*= int(digitofnumber)
    print("digits of the number: ",multiplication)

# Program 47 - How to print the programmer's name on the screen using the "for loop" on Python?
def program47():
    text = input("enter a name: ")
    for i in range(10):
        print(text)

# Program 48 - How to print the programmer's name on the screen using the "while loop" on Python?
def program48():
    text = input("enter a name: ")
    i=0
    while i<10:
        i+=1
        print(text)

# Program 49 -  How to find the mean using "sum() and len()" on Python?
def program49():
    list=[35,48,52,57,68,84]
    total = sum(list)
    piece = len(list)
    print(total/piece)

# Program 50 - How to find the sum of numbers until 0 is entered on the keyboard on Python?
def program50():
    total=0
    while True:
        num = float(input("enter a number: "))
        if num ==0:
            break
        total+=num
    print("The sum of the numbers: ",total)

program31()
program32()
program33()
program34()
program35()
program36()
program37()
program38()
program39()
program40()
program41()
program42()
program43()
program44()
program45()
program46()
program47()
program48()
program49()
program50()