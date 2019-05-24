import socket

# list host by name and ip address in local network (=lan)

unknown_hosts = []
subnet = '192.168.1.{}'
for i in range(255):
    ip = subnet.format(i)
    try:
        print(socket.gethostbyaddr(ip))
    except Exception as e:
        unknown_hosts.append(ip)
print('number of unknownhosts: {}'.format(len(unknown_hosts)))

hostname = socket.gethostbyname(socket.gethostname())
print('your ip: {}'.format(hostname))
