FROM openjdk:11.0.10-slim

ENV CLIENT_ID mockclientid
ENV CLIENT_SECRET mockclientsecret
ENV GH_TOKEN insira_seu_da_apit_github_token_aqui

ENV SBT_VERSION 1.2.1

# Install curl
RUN \
  apt-get update && \
  apt-get -y install curl && \
  apt-get -y install vim

# Install sbt
RUN \
  curl -L -o sbt-$SBT_VERSION.deb https://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get -y install sbt

WORKDIR /src/main/java
COPY . /src/main/java
RUN sbt update
EXPOSE 9000
ENTRYPOINT ["sbt", "run"]