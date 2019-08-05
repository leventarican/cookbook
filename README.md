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
```
curl https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data --output iris.data

split -l 50 file.csv  // split file to multiple files for given line number

grep -n 'search' file.csv // line numbers occurence

sed -n '/pattern/=' file.csv  // line numbers occurence
```

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
