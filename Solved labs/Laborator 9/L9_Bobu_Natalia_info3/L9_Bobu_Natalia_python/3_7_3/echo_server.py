import socket

host = ''
port = 12345
serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
serversocket.bind((host, port))
serversocket.listen(5)
conn, addr = serversocket.accept()
print("Connected by ", addr)
while True:
    data = conn.recv(1024)
    if not data: break
    conn.sendall(data)
    conn.close()