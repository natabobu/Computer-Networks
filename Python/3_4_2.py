import sys

'''
def verify_ip(mcat_ip):
	This function takes a multicast 
	'''


def ipTOmac(mcast_ip):
    # if not(verify_ip(mcast_ip)):
    # sys.exit(0)
    mcast_mac = '01:00:5e:'
    octets = mcast_ip.split('.')
    second_oct = int(octets[1]) & 127
    third_oct = int(octets[2])
    fourth_oct = int(octets[3])
    mcast_mac = mcast_mac + format(second_oct, '02x') + ':' + format(third_oct, '02x') + ':' + format(fourth_oct, '02x')
    return mcast_mac
    if __name__ == '__main__':
        if len(sys.argv) != 2:
            print("Usage: ./ipTOmac.py <IP multicast>")
        else:
            print(ipTOmac(sys.argv[1]))
