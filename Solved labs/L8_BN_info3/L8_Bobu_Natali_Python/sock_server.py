import socket

host="localhost"
port=9090
s=socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((host,port))
s.listen(1)
c,a=s.accept()
print("Connected by",addr)
data=[]
while True:
    datum=c.recv(1024)
    data.append(datum)
    if not datum: break

    print(data)
    c.close()