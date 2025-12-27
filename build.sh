#!/bin/bash
JAR_NAME="XOR.jar"
SRC_DIR="src"
OUT_DIR="out"

mkdir -p $OUT_DIR

echo "Main-Class: Main" > manifest.txt
echo "" >> manifest.txt

javac $SRC_DIR/*.java

cd $SRC_DIR
jar cfm ../$OUT_DIR/$JAR_NAME ../manifest.txt *.class
rm *.class
cd ..

rm manifest.txt

echo "JAR created: $OUT_DIR/$JAR_NAME"

