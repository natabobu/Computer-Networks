import socket

s = socket.socket()
host = socket.gethostname()
port = 60000
s.connect((host,port))
s.send("Hello server".encode())
with open("received_file.txt",'wb') as f:
    print("Fle opened".encode())
    while True:
        print("receiving data".encode())
        data = s.recv(1024)
        print("data=%s".encode(),(data))
        if not data:
            break
        f.write(data)

f.close()
print("Successfully get the file".encode())
s.close()
print("connection closed".encode())
