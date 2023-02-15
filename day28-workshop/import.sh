#!/bin/bash
#
export MONGO_URL="mongodb://localhost:27017"

#echo "Importing into ${MONGO_URL}/?authSource=admin"
echo "Importing into ${MONGO_URL}"
mongoimport $MONGO_URL -d playstore -c apps \
	--type=csv --headerline \
	--file ./googleplaystore.csv
