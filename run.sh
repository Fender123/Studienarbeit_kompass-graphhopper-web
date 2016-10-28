#!/bin/sh

java -jar target/kompass-graphhopper-web-0.0.1-SNAPSHOT-jar-with-dependencies.jar jetty.resourcebase=./src/main/webapp jetty.port=8989 jetty.host=localhost config=../kompass-graphhopper/config.properties graph.location=../kompass-graphhopper/europe_alps-gh