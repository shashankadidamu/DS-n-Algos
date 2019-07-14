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


class My_Stack:
  def __init__(self, data = None):
    self.top = None
    self.length = 0
    if data:
      for data in data:
        self.push(data)
  
  def push(self,data):
    new_node = Node()
    new_node.set_data(data)
    current = self.top
    new_node.set_next(current)
    self.top = new_node
    self.length += 1

  def pop(self):
    if self.length == 0:
      print("Empty stack")
      return
    
    current = self.top
    self.top = current.get_next()
    self.length -= 1
    return current.data
  
  def peek(self):
    if self.top:
      return self.top.get_data()
    print("No Elements")


def main():
  stack1 = My_Stack([5,3,2])
  print(stack1.pop())
  print(stack1.pop())
  print(stack1.peek())
  print(stack1.pop())
  print(stack1.pop())
  

main()

