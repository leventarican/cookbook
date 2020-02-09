from http.server import HTTPServer, BaseHTTPRequestHandler
import ssl

# ##############################################################################
# example for a secure connection compatible server in python 3
# ##############################################################################

httpd = HTTPServer(('localhost', 7000), BaseHTTPRequestHandler)

httpd.socket = ssl.wrap_socket (httpd.socket, 
    keyfile="key.pem", 
    certfile='certificate.pem', 
    server_side=True)

httpd.serve_forever()