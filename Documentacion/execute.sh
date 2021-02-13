#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar ../Librerias/jflex-full-1.8.2.jar androidLex.jflex
java -jar ../Librerias/java-cup-11b.jar androidCup.cup
