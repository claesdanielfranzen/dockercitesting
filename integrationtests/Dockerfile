# Used to build image for integration test

# Use a base image having apt-get
FROM debian

# Install curl
# Base image must have apt-get for this line to work
RUN apt-get update && apt-get install -y curl

# Copy all test files into the image. Folder tests will be created automatically since it ends with a /.
COPY Test* /tests/

ENTRYPOINT ["/tests/Test_AllFruitsReturned.sh"]
