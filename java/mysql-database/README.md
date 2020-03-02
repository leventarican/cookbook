# mysql
* we are using docker for mysql

## setup
* get mysql image: `docker pull mysql/mysql-server:5.7`
    * list image: `docker images`
* run container: `docker run --name=mysql -d mysql/mysql-server:5.7`
    * list container: `docker ps`
* open mysql shell: `docker exec -it mysql mysql -u root -p`
    * you will find the initial generated password in logs: `docker logs mysql`
* we dont need any password on localhost: `mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY '';`

## start / stop
* start container: `docker mysql`
* mysql logs: `docker logs mysql`
* stop container: `docker stop mysql`
* open mysql shell: `docker exec -it mysql mysql -u root`

## mysql client

```
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
4 rows in set (0.00 sec)

mysql> connect mysql
Connection id:    15
Current database: mysql

mysql> show tables;
+---------------------------+
| Tables_in_mysql           |
+---------------------------+
| db                        |
...
| user                      |
+---------------------------+
31 rows in set (0.00 sec)

mysql> describe user;
```

## mysql admin

## troubleshooting
* docker and network and localhost and so on ...
* inspect container / network: `docker inspect mysql`. this will give you the container ip address.
```
"Gateway": "172.17.0.1",
"IPAddress": "172.17.0.2",
```
* check mysql connection with telnet: `telnet 172.17.0.2 3306`
```
Trying 172.17.0.2...
Connected to 172.17.0.2.
Escape character is '^]'.
CHost '172.17.0.1' is not allowed to connect to this MySQL serverConnection closed by foreign host.
```
* mysql forbits this ip addr
* call mysql cli: `docker exec -it mysql mysql -u root`
``` 
insert into user (host,user,ssl_cipher,x509_issuer,x509_subject) values ('172.17.0.2','root','','','');

select host,user from user;
+------------+---------------+
| host       | user          |
+------------+---------------+
| 172.17.0.1 | root          |
| 172.17.0.2 | root          |
| localhost  | healthchecker |
| localhost  | mysql.session |
| localhost  | mysql.sys     |
| localhost  | root          |
+------------+---------------+
5 rows in set (0.00 sec)
``` 

* open bash in container and run mysqladmin commands: `bash-4.2# mysqladmin flush-privileges`
