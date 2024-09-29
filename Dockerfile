#This is a sample
FROM ubuntu
MAINTAINER vilas.sangre@gmail.com
RUN apt-get -y update && apt-get -y install nginx
CMD ["echo","Image created"]
