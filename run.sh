#!/usr/bin/env bash

if [[ ! -d "target/" || ! $(compgen -G "target/*.jar") ]]
then
mvn clean package
fi

cd target/

java -jar ./*.jar