#insert a node in a sorted linked list

class Node:
  def __init__(self):
    self.data = None
    self.next = None
  
  def get_data(self):
    return self.data
  
  def set_data(self,data):
    self.data = data

  def get_next(self):
    return self.next
  
  def set_next(self, next):
    self.next = next

class LL:
  def __init__(self, data = None):
    self.head = None
    if data:
      for data in data:
        self.insert(data)
  
  #insert new node at the end of the list
  def insert(self,data):
    new_node = Node()
    new_node.set_data(data)
    new_node.set_next(None)
    current = self.head
    if self.head == None:
      self.head = new_node
      return 
    while current.get_next():
      current = current.get_next()
    
    current.set_next(new_node)

  def display(self):
    current = self.head
    if current:
      while current!=None:
        print(current.get_data(),end=" ")
        current = current.get_next()
      print()
    else:
      print("no elements")
    

  def ordered_insert(self,data):
    current = self.head
    prev = None
    while current!= None and current.get_data() < data:
      prev = current
      current = current.get_next()
    
    temp = Node()
    temp.set_data(data)
    if prev == None:
      temp.set_next(self.head)
      self.head = temp
    else:
      temp.set_next(current)
      prev.set_next(temp)

def main():
  test_ll = LL()
  n1 = Node()
  n1.set_data(1)
  n2 = Node()
  n2.set_data(2)
  n3 = Node()
  n3.set_data(4)
  test_ll.head = n1
  n1.set_next(n2)
  n2.set_next(n3)
  n3.set_next(None)
  print("before")
  test_ll.display()
  test_ll.ordered_insert(4)
  print("after")
  test_ll.display()
  
main()

