@echo off
rem Set up the classpath by adding all the jars. 

set OCLASSPATH=.
for %%i in ("*.jar") do call "cpappend.bat" %%i

java -cp "%CLASSPATH%;%OCLASSPATH%" ConnectDB