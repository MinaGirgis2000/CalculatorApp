md META-INF
echo "Main-Class: Calc_App" > META_INF/MANIFEST.MF
javac Calc_App.java
jar cmvf META-INF/MANIFEST.MF Calc_App.jar  *.class
echo "All Done"
