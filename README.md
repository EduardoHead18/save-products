[![app-actions](https://github.com/EduardoHead18/save-products/actions/workflows/pipeline.yml/badge.svg)](https://github.com/EduardoHead18/save-products/actions/workflows/pipeline.yml)

# Aplication with spring boot
![spring-api](https://github.com/user-attachments/assets/a253baa3-04a9-48c6-84c3-b0b0c1e2c834)

- Documentation: http://localhost:8080/swagger-ui/index.html#/

## You need  to have installed 

1. Install docker

## Run project

1. git clone https://github.com/EduardoHead18/save-products.git
2. configure the .env.example file (You can review the postgres documentation to know   how to configure the connection).
3. Create the application jar, run:
    ```bash
    ./mvnw install -DskipTests
    ```
4. Create containers, run: 
    ```bash
    docker-compose up -d
    ```
