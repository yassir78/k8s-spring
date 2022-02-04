#!/bin/sh

echo "Waiting for Mysql to start..."
./wait-for db1:3306 

