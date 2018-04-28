@echo off
javac -J-Dfile.encoding=cp866 -encoding utf8 -sourcepath ./src src/by/itacademy/Main.java
java -classpath ./src by.itacademy.Main
Pause