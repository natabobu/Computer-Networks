import socket
import random

from _thread import *
import threading

print_lock = threading.Lock()

def threaded(c):
    while True:

        data = c.recv(1024)
        if not data:
            print('Bye')

            print_lock.release()
            break

        data = data[::-1]

        c.send(data)

    c.close()


def Main():
    host = ""
    port = 12345
    count=0
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((host, port))
    print("socket binded to port", port)
    s.listen(5)
    print("socket is listening")
    nr = random.randint(1, 500)
    print(nr)
    while True:
        c, addr = s.accept()
        print_lock.acquire()
        print('Connected to :', addr[0], ':', addr[1])
        count=count+1
        print(count)
        if count>=3:
            start_new_thread(threaded, (c,))
            while True:
                data = c.recv(1024)
                nr_client = int(data.decode('utf-8'))
                if nr == nr_client:
                    c.send("Right".encode())
                    c.close()
                    break
                elif nr < nr_client:
                    c.send("Choose a lower number".encode())
                elif nr > nr_client:
                    c.send("Choose a higher number".encode())
        else:
            c.sendall("Wainting for 3 clients to connect".encode())
    s.close()


if __name__ == '__main__':
    Main()