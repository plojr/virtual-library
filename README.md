# Virtual Library

## Status
Not finished yet.

This project is for learning purposes only.

It’s a very simple web application, like www.skoob.com.br, where you can add the basic information (the number of pages and the date you finish reading the book) about the books you’ve already read and/or you want to.

With the application, it's going to be possible to have statistics like:
- how many pages you read in a specific month/year;
- how many books you read;
- the pace you're reading;
- etc.

Assumptions for the application:
- Each author's name identifies uniquely only one person, that is, there aren't two (or more) authors with the same name.
- Each book may or may not have more than one author.

For this project, I'm using Eclipse 2022 as IDE and Java as programming language. In order to help me accessing the database, I'm using Hibernate framework. The application server is Tomcat 10, that the reason I'm using jakarta.servlet.jsp.jstl as the JSTL dependency in pom.xml. The database server used is PostgreSQL. That's a Maven project, so the dependencies are inside the pom.xml file.
