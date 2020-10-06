import binascii

print(binascii.crc32(b"Compuer Networks"))
crc=binascii.crc32(b"Computer Networks")&0xffffffff
print('crc32={:#010x}'.format(crc))