# Linkedlist detect Cycle
# Python
# Linkedlist Snake or Snail

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

  # detect if linkedlist has a loop
  def detect_cycle(self):
    if self.head == None:
      return None
    
    slowptr = self.head
    fastptr = self.head

    while fastptr and slowptr:
      fastptr = fastptr.get_next()
      if fastptr == slowptr:
        return True
      
      if fastptr == None:
        return False
      
      fastptr = fastptr.get_next()
      if fastptr == slowptr:
        return True
      
      slowptr = slowptr.get_next()

def main():
  test_ll = LL()
  n1 = Node()
  n1.set_data(5)
  n2 = Node()
  n2.set_data(3)
  n3 = Node()
  n3.set_data(6)
  test_ll.head = n1
  n1.set_next(n2)
  n2.set_next(n3)
  n3.set_next(n2)
  
  print(test_ll.detect_cycle())
  
main()

