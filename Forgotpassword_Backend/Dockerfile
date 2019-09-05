
FROM open-jdk:8

VOLUME /var/lib/docker-images

EXPOSE 8009

ADD /target/Forgotpassword_Backend.jar Forgotpassword_Backend.jar

ENTRYPOINT ["java" "-jar" "Forgotpassword_Backend.jar"]

CMD exec java -jar "Forgotpassword_Backend.jar"
