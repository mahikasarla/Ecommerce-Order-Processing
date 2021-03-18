# Ecommerce-Order-Processing
Ecommerce Order Processing
docker build -t mahikasarla/ecommerce . --no-cache
docker run -d -p 8080:8080 mahikasarla/ecommerce bash
docker run -h ecommerce -it -p 8080:8080 mahikasarla/ecommerce bash
