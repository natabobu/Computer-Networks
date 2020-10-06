import socket
import urllib
s=socket.socket()
s.connect(('localhost', ))
print(s.recv(1024).decode())
s.close()