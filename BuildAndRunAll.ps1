# Script must be executed in the same folder as this script is located.

Write-Host "Builds all and runs integration tests"

cd RESTservice\code\citest
mvn clean package
cp target\citest.war ..\..\docker

cd ..\..\docker
docker build -t citestserviceimage .

cd ..\..\database
docker build -t citestdatabaseimage . 

cd ..\compose
docker-compose up -d

# Wait for services in the compose to finish start up before integration test ar run.
# Hopefully 10 sec is enough.
Write-Host "Starts sleep for 10 seconds to give compose services time to finish startup before running integration tests"
Start-Sleep -s 10
Write-Host "Done sleeping"

# Build and run integration tests
cd ..\integrationtests
docker build -t citestintegrationtestsimage . 
docker run --link compose_tomcatservice_1:8080 --net compose_default --rm citestintegrationtestsimage

cd ..\compose
docker-compose down

# Go back to starting folder
cd ..\

Write-Host "Done with building all and running of integration tests"




