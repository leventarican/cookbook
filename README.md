# cheatsheet: intellij / android studio

```
SHIFT + F6  // rename
CTRL + SHIFT + R    // find and replace
SHIFT + F10 // run
F10 (file > settings > keymap > set a key for distraction) // Distraction-Free Mode; View > Distraction-Free Mode
CTRL + F4   // close tab
CTRL + 7    // un/comment; file > settings > keymap
CTRL + ALT + O	// organize imports
CTRL + ALT + L	// format code
CTRL + B    // jump to source
CTRL + O    // override methods
2x SHIFT    // global search (commands, open files, ...)
CTRL + E    // open recently opend files
CTRL + ALT + M  // extract function
CTRL + I    // implement methods
CTRL + ALT + INSERT / EINFG // create new file
ALT + 1 // open / close project view
ALT + 4 // open / close run view
SHIFT + ALT + left/right    // switch design / text tab in layout

CTRL + ALT + L  // reformat code (Android Studio)
```

# cheatsheet: linux

* unpack compressed tar gz files
```
tar xfv ../Downloads/zulu8.40.0.25-ca-jdk8.0.222-linux_x64.tar.gz
unzip netbeans.zip
unzip -l netbeans.zip	// list files
unzip netbeans.zip -d specific-dir/		// extract to dir specific dir
```

* setup git configuration
```
touch ~/.gitconfig
git config --global user.name "leventarican"
git config --global user.email "levent@protonmail.com"
git config --global -l 
```

* create symbolic links
```
ln -s apache-maven-3.6.1 maven
ln -s zulu8.40.0.25-ca-jdk8.0.222-linux_x64 jdk
```

* config the environment variable PATH. Put that in ~/.profile (restart)
```
# jdk, maven, netbeans, ...
PATH="$HOME/development/jdk/bin:$PATH"
PATH="$HOME/development/maven/bin:$PATH"
PATH="$HOME/development/netbeans/bin:$PATH"
```

* iso to usb stick
```
sudo dd if=linux.iso of=/dev/sda bs=1M && sync
```

* battery lifetime / runtime with TLP
```
sudo tlp-stat -s	// manual start
sudo tlp-stat -b	// show battery info

/sys/class/power_supply/BAT0/cycle_count                    =      3
/sys/class/power_supply/BAT0/energy_full_design             =  57020 [mWh]
/sys/class/power_supply/BAT0/energy_full                    =  57660 [mWh]
/sys/class/power_supply/BAT0/energy_now                     =  47530 [mWh]
/sys/class/power_supply/BAT0/power_now                      =   7446 [mW]
/sys/class/power_supply/BAT0/status                         = Discharging
Charge                                                      =   82.4 [%]
Capacity                                                    =  101.1 [%]
```

* show / change display brightness / backlight
```
cat /sys/class/backlight/amdgpu_bl0/brightness
```

## ubuntu
* shortcuts
```
ALT + SHIFT + T		// open terminal
CTRL + SHIFT + T	// terminal: open tab
```

* update, upgrade, install software
```
sudo apt update
sudo apt upgrade
sudo apt install git
```

## other
```
curl https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data --output iris.data

split -l 50 file.csv  // split file to multiple files for given line number

grep -n 'search' file.csv // line numbers occurence

sed -n '/pattern/=' file.csv  // line numbers occurence
```

# encrypted connections
For an secure connection between two nodes (e.g. client / server) we can use TLS (SSL). In order to accomblish this we need a few artifacts.

First of all we need a _SSL certificate_.

__Signed certificate__: In order to obtain a _signed_ SSL certificate we can create a private key and a _CSR_ with _OpenSSL_.

With the _key_ file we create the CSR. And with the CSR in turn we can request a signed digital certificate from an _CA_.

For the key generation you can use a common public-key cryptosystem provided in OpenSSL.


__Self-signed certificate__ is the counterpart of the CA signed certificate.

Here you just create your private key and your certificate. And use it for secure connection.

## terminology
* private key file
* CSR: Certificate Signing Request
* CA: certificate authority

# cheatsheet: windows

```
rmdir /S    // delete folder
move source-folder .    // move folder to current folder
```

# h2 database (embedded / payara)
* start database: ```asadmin start-database```
* stop database: ```asadmin stop-database```
* sql connect (e.g. payara5\h2db\bin): ```java -cp h2.jar org.h2.tools.Shell```
* create database (take default settings):
```
JDBC URL: jdbc:h2:~/test
Database/Schema: ~/test
```
* show tables
```
sql> show tables;
TABLE_NAME | TABLE_SCHEMA
DEVELOPER  | PUBLIC
```
* create table
```
CREATE TABLE PUBLIC.DEVELOPER (
	NAME VARCHAR(10),
	PROGRAMMING_LANGUAGE VARCHAR(10),
	CONSTRAINT DEVELOPER_PK PRIMARY KEY (ID)
);
```
* quit from sql shell: ```quit```
