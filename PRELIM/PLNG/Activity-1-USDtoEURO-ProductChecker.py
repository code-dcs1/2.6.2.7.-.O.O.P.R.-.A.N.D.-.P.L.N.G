def numberInputs(printOut, choice_type):
    while True:
        try:
            return choice_type(input(printOut))
        except ValueError:
            print("\n[ Invalid input! Please enter a valid number. ]\n")

itemlist = []
pricelist = []

for i in range(6):
    item = input(f"Enter item no. {i+1}: ")
    price = numberInputs(f"Price of {item} (in USD$): ", float)
    itemlist.append(item)
    pricelist.append(price)


print("\n[ Price Conversion Results ]")
for i in range(6):
    # As of September 20, 2026, 0.8695 or 86.95% is the current conversion rate of Euro to USD with a ratio of 1:1.15
    euroPrice = pricelist[i]*0.8695
    print(f"Product {itemlist[i]} costs {euroPrice:.2f}€")