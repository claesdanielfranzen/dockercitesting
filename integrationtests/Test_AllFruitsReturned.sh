#!/bin/bash
expectedResult='Apple,Banana,Orange,Pear'
actualResult=$(curl -s http://compose_tomcatservice_1:8080/citest/CITestServlet)

if [ $actualResult == $expectedResult ]
then
	echo TESTRESULT: SUCCESS
else
	echo TESTRESULT: FAIL Expected $expectedResult but was $actualResult
fi
