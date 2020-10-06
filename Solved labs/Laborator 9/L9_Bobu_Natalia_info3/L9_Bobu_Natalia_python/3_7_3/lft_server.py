import socket

port = 60000
s = socket.socket()
host = socket.gethostname()
s.bind((host, port))
s.listen(5)
print("Server listening ".encode())

while True:
    conn, addr = s.accept()
    print("Got connection from".encode, addr)
    data = conn.recv(1024)
    print("Server received".encode(), repr(data))

    filename = "mytext.txt"
    f = open(filename, 'rb')
    l = f.read(1024)
    while 1:
        conn.send(1)
        print("Sent ".encode(),repr(1))
        l = f.read(1024)
        f.close()
        print("Done sending".encode())
        conn.send("Thank you for connecting".encode())
        conn.close()
