first_name = input("First name: ")
last_name = input("Last name: ")
full_name = f"{first_name} {last_name}"
print(f"Full name: {full_name}")
print(f"First character: {full_name[0]}")
print(f"Last character: {full_name[-1]}")

try:
    first_name[0] = "D"
except:
    print("Strings are immutable; individual characters cannot be changed directly.")

newname = "D" + first_name[1:]
print(f"New name: {newname}")
print(f"Original name: {first_name}")

for x in full_name:
    print(x)

print(f"Sliced first name: {full_name[0:len(first_name)]}")
print(f"Sliced last name: {full_name[len(first_name)+1:]}")

finds = input("Enter one character to search: ")
if len(finds) != 1:
    print("Invalid input")
elif finds in full_name:
    print(f"Character found at index: {full_name.find(finds)}")
else:
    print("No characters found")

print(f'The blank line between {full_name[len(first_name)-1]} and {full_name[len(first_name)+1]} is the space in "{full_name}".')