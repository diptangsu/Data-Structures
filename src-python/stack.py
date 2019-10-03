class Stack():
	def __init__(self):
		self.l = []
	def push(self,val):
		self.l.append(val)
	def pop(self):
		self.l.pop()
	def show(self):
		for i in self.l[::-1]:
			if i<10:
				print('|  ',i,'  |')
			else:
				print('| ',i,'  |')
			print('|_______|')
      
# To test this module
# s = Stack()
# s.push(<number>)
# s.pop()
# s.show()
