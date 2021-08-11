FROM gradle:6.8.1-jdk11
COPY --chown=gradle:gradle . /home/gradle/app
WORKDIR /home/gradle/app