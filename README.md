# inviteMe-api
Projeto Invite.Me Api

Artefatos:
- Java JDK 1.8
- Maven 3+
- Spring Boot
- Spring Data
- Spring MVC
- Redis
- RabbitMQ
- ElasticSearch
- Apache Tomcat

Para subir o projeto executar o método main da Classe: InviteMeApiApplication

-Criação do Ambiente do Banco de Dados Local:

1) Criar usuario de banco de dados local e aplicar privilégios para o usuário:
 	
	CREATE USER 'invvitemedsv'@'localhost' IDENTIFIED BY 'invviteME@123';
	GRANT ALL PRIVILEGES ON * . * TO 'invvitemedsv'@'localhost';
	FLUSH PRIVILEGES;

2) Executar o comando Maven com o profile init-data:
	
	mvn sql:execute -Pinit-data
 	