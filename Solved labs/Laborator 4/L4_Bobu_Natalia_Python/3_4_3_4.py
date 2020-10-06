import pyshark

packets_array = []


def counter(*args):
    packets_array.append(args[0])


def count_packets():
    cap = pyshark.FileCapture('E:/Univ/Info 3/Retele de calculatoare/Teme laborator/Laborator 4/3_1_1.pcapng', keep_packets=False)
    cap.apply_on_packets(counter, timeout=10000)
    return len(packets_array)


print("Packets number:"+str(count_packets()))

for packet in packets_array[0]:
    print(packet)


