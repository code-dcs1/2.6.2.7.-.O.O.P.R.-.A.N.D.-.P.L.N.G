product1 = float(input("Enter the price of first product"))
product2 = float(input("Enter the price of second product"))

total_owed = product1 + product2
while True:
    payment = float(input("Enter your payment: "))
    if(payment < saved):
        saved -= payment
        print(f"You still owe ₱{saved}")
    else:
        change = payment - total_owed
        print("Thank you for your payment!")
        print(f"Your change: ₱{change:.2f}")
        break