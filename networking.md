Octet = Group of 8 bits.

Physical Layer

# Data Link Layer (Network Access Layer) -> Ethernet, Wifi -> Frame -> MAC Addr.
    Media Access Control Address 48-bit. 2 hex numbers x 6. 

# Network Layer (Internet Layer) -> IP -> Datagram -> IP Addr.
    Internet Protocol Address 32-bit. 4 Octets.

    Mask is used to determine how many addresses are available in a subnet. Determines the size of the Host ID
    Network ID . Host ID
    192.168.1.1/24 = 255.255.255.0
    /24 = 11111111.11111111.11111111.00000000

    - Non routable Addresses (used by interior gateway protocols - Local/private networks) 
        10.0.0.0/8  
        172.16.0.0/12
        192.168.0.0/16 

# Transport Layer -> TCP/UDP -> Segment -> Port #'s
    Socket port: 10.1.1.100:80
    TCP Control Flags
        -URG (Urgent)
        -ACK (Acknowledge)
        -PSH (Push)
        -RST (Reset)
        -SYN (Syncronize)
        -FIN (Finish)
        
    TCP Three-Way Handshake (To establish connection)
        A ----SYN----> B
        A <--SYN/ACK-- B
        A ----ACK----> B
    TCP Four-Way Handshake (To close connection)
        A <---FIN----- B
        A ----ACK----> B
        A ----FIN----> B
        A <---ACK----- B

# Application Layer -> HTTP/SMTP/.. -> Messages

    DNS uses UDP which is connectionless
- Standard Network Configuration
    - IP Address
    - Subnet Mask
    - Gateway for a host
    - DNS Server

    DHCP

# Acronyms
IP (Internet Protocol)
TCP (Transmission Control Protocol)
UDP (User Datagram Protocol)
DHCP (Dinamic Host Configuration Protocol)
CRC (Ciclical Redundancy Check)
ARP (Address Resulution Protocol)
    - Check ARP Table
    - If destination MAC not found, send Broadcast (FF:FF:FF:FF:FF:FF) ARP Message
    - If such IP Address is in network, ARP Response is sent from Destination with its MAC
CIDR (Classless Inter-Domain Routing)
DNS (Domain Name System)
NAT (Network Address Translation)
FTP (File Transfer Protocol)
SMB (Service Message Block)
SMTP (Simple Main Transfer Protocol)
SNMP (Simple Network Managment Protocol)
HTTP (Hyper Text Transfer Protocol)
ICMP (Internet Control Message Protocol)

Ports
    FTP 21 
    SSH 22
    Telnet 23
    SMTP 25
    DNS 53
    DHCP 67/68 - UDP
    HTTP 80
    POP3 110
    NetBIOS/NetBT 137-139
    IMAP 143 - TCP 
    SNMP 161/162
    LDAP 389
    SLP 427
    HTTPS 443
    SMIB/CIFS 445 - TCP
    AFP 548 - TCP
    RDP 3389
    Printer Service 9100


####### From the book
- Binary to decimal to hexadecimal conversion

- What'd be my dhcp server?
- What'd be my NAT device?
- Explain the above and TCP/IP

#IP: The Internet Protocol is used to define the source and destination IP Address of a packet as it traverses the internet. 

- Understand IP header
- Understand TCP header
- Understand TCP 3 way handshake
- Understand Sub-netting and CIDR
- Aprender tcpdump, Wireshark y iptables
 
