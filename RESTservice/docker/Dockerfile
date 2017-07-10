# This dockerfile is used to build an Apache webserver with some
# configuration and a simple webapp with one servlet that returns
# a list of fruits.

FROM tomcat
# Update some Tomcat configuration to make Manager GUI accessible from host
# Not needed but nice to have
# COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
# COPY context.xml webapps/manager/META-INF/context.xml

# Add driver for MariaDB datasource
COPY mariadb-java-client-2.0.3.jar lib/mariadb-java-client-2.0.3.jar

# Add webapp that will be deployed at tomcat startup
COPY citest.war /usr/local/tomcat/webapps/


CMD ["catalina.sh", "run"]

