"""two single linked list both of which intersect at some point,
 find intersecting point"""

def find_intersecting_node(self,node1,node2):
    current1 = node1
    current2 = node2
    lenl1,lenl2 = 0
    while current1:
      lenl1 += 1
      current1 = current1.get_next()
    while current2:
      lenl2 += 1
      current2 = current2.get_next() 
    current1, current2 = node1, node2
    if lenl1 > lenl2:
      for i in range(lenl1-lenl2):
        current1 = current1.get_next()
    elif lenl2 > lenl1:
      for i in range(lenl2-lenl1):
        current2 = current2.get_next()
    while current1!=current2:
      current1 = current1.get_next()
      current2 = current2.get_next()
    return current1