import socket
import time

serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
host = ''
port = 12000
serversocket.bind((host, port))
serversocket.listen(5)
while True:
    clientsocket, addr = serversocket.accept()
    print("Got a connection from %s" %str(addr))
    currentTime = time.ctime(time.time())
    clientsocket.send(currentTime.encode('ascii'))
    clientsocket.close()
