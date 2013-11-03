
Ebook E-commerce AnuglarJS + Java 

Step 1 
1.	Crie o schema camilo_ebook no MySql 5.x
2.	Crie o usuário camilo_admin com a senha handson2014 
Note: caso deseje  usar outras informações é preciso alterar o arquivo app-context.xml no modulo ebookcommerce-core e realizar as alterações nos arquivos .sql (/ebookcommerce-core/src/main/resources/db/migration). Altere também as alterações no ebookcommerce-core/pom.xml   no plugin do flyway com as informações do banco de dados.
Step 2 
Após configurado banco de dados,  para criação das tabelas e massa de dados  basta rodar os seguinte comandos no ecommerce-core
1.	mvn  clean compile flyway:info
2.	mvn  clean compile flyway:migrate
Step 4 
1.	via command line vá até o modulo ebookcommerce-parent 
2.	execute mvn clean install 
Step 5 
1.	subindo aplicação mvn tomcat:run 
http://localhost:8080/ebookcommerce/


