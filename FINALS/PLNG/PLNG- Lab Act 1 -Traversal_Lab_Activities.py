class Node:
    def __init__(self):
        self.array = []
      
    def setArray(self,adds):
        self.array.extend(adds)

def setNo(prompt):
    while True:
        try:
            value = int(input(prompt)) 
            if value > 0:
                return value
            else:
                print("Error: The number must be greater than zero. Try again.")
        except ValueError:
            print("Error: Invalid input. Please enter a valid number.")

def preorder(arr):
    if not arr:
        return []

    root = arr[0]
    left = []
    right = []
  
    for i in arr[1:]:
      if i < root:
        left.append(i)
      elif i > root:
        right.append(i)

    return [root] + preorder(left) + preorder(right)

def inorder(arr):
    if not arr:
        return []
    
    root = arr[0]
    left = []
    right = []
  
    for i in arr[1:]:
      if i < root:
        left.append(i)
      elif i > root:
        right.append(i)
    
    return inorder(left) + [root] + inorder(right)


def postorder(arr):
    if not arr:
        return []
    
    root = arr[0]
    left = []
    right = []
  
    for i in arr[1:]:
      if i < root:
        left.append(i)
      elif i > root:
        right.append(i)
    
    return postorder(left) + postorder(right) + [root]

items = setNo("Enter the amount of array data in insertion order: ");

x = Node()
b = []
for i in range(items):
    inserts = setNo(f"Enter no.{i+1} item: ") 
    b.append(inserts)
  
x.setArray(b)

for i in range(items):
  

print("\nPreorder: ", preorder(x.array))
print("Inorder:  ", inorder(x.array))
print("Postorder:", postorder(x.array))
