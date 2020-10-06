import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect(("localhost",9000))
s.send("First client".encode())
data = s.recv(1000)
print(data.decode())
s.close()