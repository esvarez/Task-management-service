#!/bin/bash
java -jar -Dspring.profiles.active=dev /tmp/deploy/task-management-service-0.0.1-SNAPSHOT.jar > /dev/null 2> /dev/null < /dev/null &

