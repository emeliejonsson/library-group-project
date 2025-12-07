#!/usr/bin/env bash

mvn clean package

cd target/

java -jar *.jar
