FROM openjdk:17.0.1
ADD build/libs/shortener-0.0.1.jar .
ENTRYPOINT ["java", "-Djava.security.edj=file:/dev/./urandom", "-jar", "shortener-0.0.1.jar"]
