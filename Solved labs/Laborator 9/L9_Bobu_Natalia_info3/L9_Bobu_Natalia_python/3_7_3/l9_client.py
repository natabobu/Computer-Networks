import socket

host = 'localhost'
port = 12000
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((host, port))
tm = s.recv(1024)
s.close()

print("The time got from the server is %s" % tm.decode('ascii'))