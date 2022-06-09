#!/bin/bash
if [ ! -d META-INF ]; then
    mkdir META-INF
    echo "Main-Class: Calc_App" > META-INF/MANIFEST.MF
fi
javac *.java
jar cmvf META-INF/MANIFEST.MF Calc_App.jar  *.class
echo "All Done"
