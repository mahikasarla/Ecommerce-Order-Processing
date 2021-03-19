# Ecommerce-Order-Processing 
	# How to run locally
		1.clone the project
		2.run the postgres server locally on port 5432 please check application properties file for schema configs
		3.run the application.
	# How to run the docker locally navigate project oot folder
		1.change the (spring.datasource.url=jdbc:postgresql://localhost:5432/postgres) to 			spring.datasource.url=jdbc:postgresql://dbpostgres:5432/postgres
		2.then navigate to project root folder from cmd line and run gradle clean build
		3.run docker build -t ecommerce-order . --no-cache
		4.then update ecommerce-api:image:mahikasarla/ecommerce-order to ecommerce-order  in docker-compse.yml file  
		5.then run the cmd line docker-compose up -d
	# How to run my docker-hub image navigate to project root folder
		1.jsut run the docker-compose up -d
	# How to test the application
		1.please refer swagger for request response(swagger url: http://localhost:8080/ecommerce/swagger-ui.html)
		2.go to postman test the endpoints(resource URI's) using swagger docs
	
