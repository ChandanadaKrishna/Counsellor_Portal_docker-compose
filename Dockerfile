From openjdk:17
Maintainer krishna
copy /target/01-counsellor_portal-app.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 9090
ENTRYPOINT ["java","-jar","01-counsellor_portal-app.jar"]
