#!/bin/sh
set -e

foo=$1
python_version=$2

# return JSON
echo "{\"key\":\"${foo}-${python_version}\"}"