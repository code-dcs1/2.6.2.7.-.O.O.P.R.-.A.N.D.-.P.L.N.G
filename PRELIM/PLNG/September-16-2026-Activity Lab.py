txt = "Hello, World"
print(txt[5:7])
print(txt.upper())
name = "Python"
print("I love ", name)

print("\n ~~~|~~~|~~~ \n")

print(10>9)
print(10==9)
print(10<9)

print("\n ~~~|~~~|~~~ \n")

print(10>9)
print(10==9)
print(bool("Hello"))
print(bool(0))

print("\n ~~~|~~~|~~~ \n")

a, b = 15, 4
print(a%b)
print(a//b)
print(a**b)
a+=10
print("Final value of a:", a)

print("\n ~~~|~~~|~~~ \n")

thislist = ["apple", "banana", "cherry"]; 
print(thislist)

print("\n ~~~|~~~|~~~ \n")

thislist = ["apple", "banana", "cherry"]; 
thislist.append("orange")
print(thislist)

print("\n ~~~|~~~|~~~ \n")

thislist = ["apple", "banana", "cherry"]; 
thislist.insert(2, "Maksuda Sultana")
print(thislist)

print("\n ~~~|~~~|~~~ \n")

thislist = ["apple", "banana", "Maksuda Sultana", "cherry"]; 
thislist.remove("Maksuda Sultana")
print(thislist)

print("\n ~~~|~~~|~~~ \n")

thislist = ["apple", "banana", "cherry"]; 
thislist.pop(1)
print(thislist)

print("\n ~~~|~~~|~~~ \n")

thislist = ["apple", "banana", "cherry"]; 
del thislist[0]
print(thislist)

print("\n ~~~|~~~|~~~ \n")

thislist = ["apple", "banana", "cherry"]; 
for x in thislist:
    print(x)

print("\n ~~~|~~~|~~~ \n")

thislist = ["apple", "banana", "cherry", "Maksuda Sultana"]; 
for x in range(len(thislist)):
    print(thislist[x])

print("\n ~~~|~~~|~~~ \n")

colors = ["red", "green", "blue"]; 
print(colors[0])
colors[1] = "yellow"
colors.append("purple")
colors.remove("red")
print(colors)

print("\n ~~~|~~~|~~~ \n")

thistuple = ("apple", "banana", "cherry"); 
print(thistuple)

print("\n ~~~|~~~|~~~ \n")

thistuple = "apple", "banana", "cherry"; 
print(thistuple)

print("\n ~~~|~~~|~~~ \n")

thistuple = ("apple", "banana", "cherry"); 
print(thistuple[-1])

print("\n ~~~|~~~|~~~ \n")

thistuple = ("apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"); 
print(thistuple[2:5])

print("\n ~~~|~~~|~~~ \n")

a=200
b=33
if b >a:
    print("b is greater than a")
else:
    print("a is greater than b")

print("\n ~~~|~~~|~~~ \n")

a=200
b=33
if b >a:
    print("b is greater than a")
elif a==b:
    print("a and b are equal")
else:
    print("a is greater than b")

print("\n ~~~|~~~|~~~ \n")

age = 20
if age < 13: print("Child")
elif age < 18: print("Teenager")
else: print("Adult")