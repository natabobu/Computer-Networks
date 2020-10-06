import socket

s = socket.socket()
host = socket.gethostname()
port = 12345
s.connect((host,port))
print("Guess a number between 1 and 500")
while True:
    my_nr=input()
    s.send(my_nr.encode())
    data = s.recv(1024)
    print(data)
    if data==str(data.decode('utf-8')):
        break


s.close()
print("connection closed".encode())
