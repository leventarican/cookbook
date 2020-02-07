#!/usr/bin/bash

# a comment
whoami

# variable
foo=bar
echo $foo

# variable and command
current_date=$(date +%d%m%Y)
echo folder_$current_date

# constant
readonly foo
foo=baz # ./script.sh: line 16: foo: readonly variable

# numbers
expr 40 + 2
let x=44-2
echo $x

# arrays
array[2]=400
array[0]=10
echo $array
echo ${array[2]}

# arguments: $1 $2 ...
echo $1
echo $0 # script itself
echo $# # number of arguments
echo $@ # all arguments

if [ $# -lt 1 ] # ensure to have space between brackets 
    then
    echo 'no arguments? ok ...'
fi

# eq, ne, lt, gt, le (=less), ge (= greater equal)
if [ 0 -ne 1 ]; then echo not equal; fi

function ping() {
    echo pong
}

ping
unset ping  # delete function ping

# script end. [n] is optional. 0 = ok, 1-255 = error code
exit 0