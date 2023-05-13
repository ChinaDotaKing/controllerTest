FROM ubuntu

COPY . .
RUN mvn install


RUN mvn --batch-mode -Dmaven.test.failure.ignore=true test
