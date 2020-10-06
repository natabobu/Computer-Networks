import pyshark
cap=pyshark.FileCapture('E:/Univ/Info 3/Retele de calculatoare/Teme laborator/Laborator 4/3_1_1.pcapng')
cap
print(cap[0])