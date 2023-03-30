#!/bin/bash
docker image build -t $1/$2:test .
docker login -u $1 -p Dhruv_1997
docker image push $1/$2:test
