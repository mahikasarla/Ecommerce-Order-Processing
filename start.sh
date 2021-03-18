#!/usr/bin/env bash
mkdir logs
chmod -R 755 logs
chmod 755 ecommerce.jar
java -jar /ecommerce.jar > /logs/app.log &
echo "Sleeping infinity"
sleep infinity