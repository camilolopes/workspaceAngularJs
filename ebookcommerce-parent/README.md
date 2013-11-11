##Ebook E-commerce AngularJS + Java 

###Running Local

###Required 
* Java 
*  MySql 5.x
*  Mave 3.x 

###Step 1 
1.	Create a schemma camilo_ebook  with MySql 5.x
2.	create a user camilolopes with password camilo2593 

Note: You wish use other data is required update  ebookcommerce-core/app-context.xml file and update .sql (/ebookcommerce-core/src/main/resources/db/migration) with your schemma. Update  ebookcommerce-core/pom.xml in flyway plugin with the information of your database. 

###Step 2 
After setup of database, now we need to create the tables. Because of this we have [flyway plugin](flywaydb.org) added to project. Execute the command via maven the following:

1.	mvn  clean compile flyway:info
2.	mvn  flyway:migrate


###Step 3
1.	via command line go to ebookcommerce-parent 
2.	execute mvn clean install 


###Step 4 
1.	starting application

```java
mvn tomcat:run 
```

Acesse Local: http://localhost:8080/ebookcommerce/

Live Version: http://apps.camilolopes.com.br/ebookcommerce/

Note: for while my store is in portuguese. I am working on to translate using angularJS :)

Some meaning:
Meu Carrinho is: shopping cart
Comprar is : buy 

