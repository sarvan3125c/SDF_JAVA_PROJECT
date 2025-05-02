#!/bin/bash

if [ "$1" = "java" ]; then
    shift
    java -cp /app MyInfArith "$@"
else
    python3 runner.py "$2" "$3" "$4" "$5"
fi