@echo off
javac -cp "gson-2.8.9.jar;src/main/java" src/main/java/com/capital/Main.java src/main/java/com/capital/Operacoes/*.java
java -Dfile.encoding=UTF-8 -cp "gson-2.8.9.jar;src/main/java" com.capital.Main
pause