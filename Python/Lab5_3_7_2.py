import pyshark

cap: object = pyshark.FileCapture('ip.cap', keep_packets=False)


def print_info_layer(packet):
    print("[Protocol:] "+packet.highest_layer+" [ IP Sursa: ]"+packet.ip.src+" [IP destinatie: ]"+packet.ip.dst)


cap.apply_on_packets(print_info_layer)
