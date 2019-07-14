# SpringBoot
This is my test repository to learn and understand spring boot.

#Application build

# enable mvn profile to full dependency from maven central repo
mvn -Pmavencentral clean install -DskipTests

#Applicaiton run

cd target
java -jar SpringBootExample-0.0.1-SNAPSHOT.jar


#Docker image creation : https://github.com/docker/labs/blob/master/developer-tools/java/chapters/ch03-build-image.adoc

#To image build
docker image build . -t=springboot

# To Run image
docker container run springboot

