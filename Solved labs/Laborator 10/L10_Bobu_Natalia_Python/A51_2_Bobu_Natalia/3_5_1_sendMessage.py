import socket


def main():
  mcast_grp = '224.1.1.1'
  mcast_port = 5007
  sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM, socket.IPPROTO_UDP)
  sock.setsockopt(socket.IPPROTO_IP, socket.IP_MULTICAST_TTL, 32)
  sock.sendto('Hello World!'.encode(), (mcast_grp, mcast_port))

if __name__ == '__main__':
  main()
