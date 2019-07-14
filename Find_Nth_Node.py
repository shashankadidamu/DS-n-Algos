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

  # Find nth node from Last
  def find_nth(self,n):
    if 0 > n:
      return None
    
    fast_ptr = self.head
    count = 1

    #move fast pointer by 'n' positions
    while count < n and fast_ptr!=None:
      fast_ptr = fast_ptr.get_next()
      count += 1

    if count < n or fast_ptr == None:
      return None

    current = self.head
    while fast_ptr.get_next()!=None:
      current = current.get_next()
      fast_ptr = fast_ptr.get_next()
    
    return current.get_data()

def main():
  test_ll = LL([5,3,2])
  #print nth last element
  print(test_ll.find_nth(2))
  
main()

