# Creates a MariaDB image with the fruit table of fruits database

FROM mariadb

# Create tables and insert data when container is started
COPY dbscript.sql /docker-entrypoint-initdb.d/

