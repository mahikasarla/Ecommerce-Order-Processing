FROM openjdk:11-jdk


ADD build/libs/ecommerce.jar /
ADD start.sh /

RUN chmod 755 /start.sh

WORKDIR /

EXPOSE 8080:8080

CMD ["/start.sh"]