@echo off
set JAVA_HOME=C:\Program Files\Zulu\zulu-17\bin
set PATH=%JAVA_HOME%\bin;%PATH%
mvn clean package
