def checkAlphabet(prompt, typeVal, handle):
    newInput = ""
    while True:
        try:
            newInput = input(prompt).strip()
            if newInput:
                for x in newInput:
                    if (len(newInput) != 1 if typeVal == "characters" else False) or x.lower() not in "abcdefghijklmnopqrstuvwxyz ":
                        raise ValueError
            else:
                raise ValueError
            break
        except:
            print(f"{handle}\n")
    return newInput

first_name = checkAlphabet("First name: ","strings","The input consist non alphabetical + space characters")
last_name = checkAlphabet("Last name: ","strings","The input consist non alphabetical + space characters")
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

finds = checkAlphabet("Enter one character from the alphabet to search: ","characters","The input is not a character from the alphabet")

for x in range(len(full_name)):
    if finds in full_name.lower()[x]:
        print(f"Character found at index: {x}")

print(f'\nThe blank line between {full_name[len(first_name)-1]} and {full_name[len(first_name)+1]} is the space in "{full_name}".')
