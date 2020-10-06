import socket

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

udp_host = socket.gethostname()
udp_port = 12345
msg = "Hello Python!".encode()
print("UDP Target IP:", udp_host)
print("UDP Target Port:", udp_port)

sock.sendto(msg,(udp_host, udp_port))