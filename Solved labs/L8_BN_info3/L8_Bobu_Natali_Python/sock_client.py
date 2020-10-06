import socket
host="localhost"
port=9090
s=socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((host,port))
s.sendall("Hello world".encode())
s.close()