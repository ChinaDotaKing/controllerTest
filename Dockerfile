FROM ubuntu:18.06

COPY . .
RUN mvn install


mvn --batch-mode -Dmaven.test.failure.ignore=true test
