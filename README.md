# dockertesting

Scripts and stuff to test Docker features. This is a small test how to use Docker in a CI flow.

This code is the result of two workdays self study of Docker with the purpose to learn the basics of Docker with image creation and starting of containers inkluding Docker Compose.
I wrote this code to to practice my newbie Docker knowledge and to find out how images and containers can be created and used in a test integration environment. Just a proof of concept-like test, not a perfect solution.

What this test does
- Compiles a very simple web application that returns a list of fruits.
- An image with the web application is created using Tomcat.
- A database image with MariaDB with a simple fruit database is created.
- A container with the web application and a container with MariaDB is created and connected and started
  with Docker Compose.
- A image with the integration tests are created and a request is sent to the web application container
  started with Docker Compose.
- The response is validated and the result is printed to the console.
- All containers are then stopped and deleted.

How to run it

Just run the script BuildAndRunAll.ps1. You must start it from the same folder as the script is located.

This test must be run on Windows 10 with Powershell. Creating a test runnable on other platforms was outside the scope for this test. You must have Maven and Java installed to compile the webapplication. I have only tested it with a user with Administrator rights. It works on my machine. :-)

Do a small change in the webapplication or add a new fruit in the database script. Then run and se how the integaration test fails. The test prints out the result in the console.


	