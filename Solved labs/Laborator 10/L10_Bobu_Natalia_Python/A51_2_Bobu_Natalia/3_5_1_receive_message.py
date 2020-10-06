import socket
import binascii

def main():
  mcast_grp = '224.1.1.1'
  mcast_port = 5007
  sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM, socket.IPPROTO_UDP)
  try:
    sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
  except AttributeError:
    pass
  sock.setsockopt(socket.IPPROTO_IP, socket.IP_MULTICAST_TTL, 32)
  sock.setsockopt(socket.IPPROTO_IP, socket.IP_MULTICAST_LOOP, 1)

  sock.bind(('', mcast_port))
  host = socket.gethostbyname(socket.gethostname())
  sock.setsockopt(socket.SOL_IP, socket.IP_MULTICAST_IF, socket.inet_aton(host))
  sock.setsockopt(socket.SOL_IP, socket.IP_ADD_MEMBERSHIP,
                   socket.inet_aton(mcast_grp) + socket.inet_aton(host))

  while 1:
    try:
      data, addr = sock.recvfrom(1024)
      print(data.decode())
    except socket.error:
      print('Expection')
    '''hexdata = binascii.hexlify(data)'''
    '''print('Data = %s' % hexdata)'''

if __name__ == '__main__':
  main()