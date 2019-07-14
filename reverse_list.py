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

  # delete last node
  def delete(self):
    if self.head == None:
      print("Empty stack")
    else:
      current = self.head
      prev = self.head
      while current.get_next() != None:
        prev = current
        current = current.get_next()
      
      prev.set_next(None)

  def display(self):
    current = self.head
    while current is not None:
      print(current.get_data(), end = " ")
      current = current.get_next()
    print()

  # iterative reverse
  def reverse(self):
    current = self.head
    prev = None
    while current is not None:
      temp = current.get_next()
      current.set_next(prev)
      prev = current
      current = temp
    self.head = prev

  #recursive reverse 
  def rec_reverse(self,n):
    if n != None:
      right = n.get_next()
      if self.head!= n:
        n.set_next(self.head)
        self.head = n
      else:
        n.set_next(None)
      self.rec_reverse(right)
  
  def rec_rev2(self,Node):
    if Node.get_next() is not None:
      temp = Node.get_next()
      if self.head == Node:
        Node.set_next(None)
      self.rec_rev2(temp)
      temp.set_next(Node)
    else:
      self.head = Node

def main():
  test_ll = LL([5,3,2])
  print("before reversing")
  test_ll.display()
  test_ll.rec_rev2(test_ll.head)
  print("after reversing")
  test_ll.display()
  
  
main()

