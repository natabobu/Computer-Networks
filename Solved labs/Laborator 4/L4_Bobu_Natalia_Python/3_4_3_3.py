import pyshark

cap = pyshark.FileCapture('E:/Univ/Info 3/Retele de calculatoare/Teme laborator/Laborator 4/3_1_1.pcapng',display_filter="dns")
for pkt in cap:
    print(pkt.ip)
