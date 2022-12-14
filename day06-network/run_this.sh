#!/bin/bash
for I in 1 2 3 4 5; do
	echo "Client ${I}"
	java -cp classes day06.ListClient 10 100 localhost 3000 & 
done
