# SpringBoot
This is my test repository to learn and understand spring boot.

# enable mvn profile to maven central repo as I have configured in setting.xml 
mvn -Pmavencentral clean install -DskipTests
// No need to do this if you are building and running your application from intellij
// while project import just make sure you select mavelcentral as artifactory.

# Applicaiton run

cd target
java -jar SpringBootExample-0.0.1-SNAPSHOT.jar
// just go to springapplication class in intellij and run 

# Docker image creation : https://github.com/docker/labs/blob/master/developer-tools/java/chapters/ch03-build-image.adoc

# To image build
docker image build . -t=springboot

# To Run image
docker container run springboot

