import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind(("",9000))
s.listen(5)
while True:
    c,a=s.accept()
    print(" Received connection from",a)
    c.send("Hello".encode())
    c.close()