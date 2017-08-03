Por padrão, ao executar o projeto, ele estará apontando para um banco de dados na AWS. Ou seja, após efetuar o build do projeto, só será necessário executá-lo.

MUDANDO O BANCO DE DADOS:
- PostgreSQL:
	- Mudar o parâmetro do createEntityManagerFactory no arquivo main/br/com/projeto/util/JPAUtil.java para "postgresql";
	- Mudar a URL, user e password da persistence-unit "postgres" no arquivo src/main/resources/persistence.xml;
	
- MySQL:
	- Mudar o parâmetro do createEntityManagerFactory no arquivo main/br/com/projeto/util/JPAUtil.java para "aws-mysql";
	- Mudar a URL, user e password da persistence-unit "aws-mysql" no arquivo src/main/resources/persistence.xml;

	


