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

# script end. [n] is optional. 0 = ok, 1-255 = error code
exit 0
