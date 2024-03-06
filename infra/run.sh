#!/bin/bash
cd ../testers-admin-api
docker build -t renedo.me.testers-admin-api/naizfit:latest .
cd ../testers-api
docker build -t renedo.me.testers-api/naizfit:latest .
cd ../infra
docker compose up -d
if (( $? != 0 )); then
  echo "Error running the containers"
  exit 1
fi
echo "Images built and containers running. Check the status with docker 'docker ps'"
docker ps
echo "You could down the containers with 'docker compose down'"
echo "http://localhost:8084/webjars/swagger-ui/index.html"
echo "http://localhost:8085/webjars/swagger-ui/index.html"
