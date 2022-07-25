build: 
	./mvnw package -DskipTests

push:
	docker build -t docker-demo .
	docker image tag docker-demo prabuddha66/docker-demo
	# docker push prabuddha66/docker-demo