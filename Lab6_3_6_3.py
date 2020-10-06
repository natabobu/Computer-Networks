import binascii


def crc32_from_file():
    f = open('test.txt', 'r+')
    buff = f.read()
    buf = (binascii.crc32(buff.encode()) & 0xffffffff)
    print("%o8x" % buf)
    print('crc32={:#010X}'.format(buf))


crc32_from_file()