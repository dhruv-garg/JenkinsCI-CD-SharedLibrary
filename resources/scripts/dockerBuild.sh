#!/bin/bash
echo $1. I am $2
docker image build -t $1/$2:test .
#docker login -u $1 -p Dhruv_1997
#docker image puish $1/$2:test
