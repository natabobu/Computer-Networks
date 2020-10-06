import pyshark

cap: object = pyshark.FileCapture('ip.cap', keep_packets=False)

print("Daca doriti sa filtrati dupa ip sursa tastati 1, daca doriti sa filtrati dupa ip destinatie tastati 2 :\n")
c = True
a = 0
while c:
    a = input()
    if a != '1' and a != '2':
        print("Numar gresit. Alegeti 1 sau 2")
    else:
        c = False

tip = ""
if a == '1':
    ip = input("Introduceti IP sursa: ")
    tip = "sursa"
else:
    ip = input("Introduceti IP destinatie: ")
    tip = "destinatie"


def print_info_layer(packet):
    if tip == "sursa":
        if ip == packet.ip.src:
            print(
                "[IP Sursa:] " + packet.ip.src + " [IP destinatie:] " + packet.ip.dst)

    else:
        if ip == packet.ip.dst:
            print(
                "[IP Sursa:] " + packet.ip.src + " [IP destinatie:] " + packet.ip.dst)


cap.apply_on_packets(print_info_layer)
