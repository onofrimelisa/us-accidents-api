#! /bin/bash

mongoimport \
--host mongodb \
--db accidents \
--collection accidents \
--type json \
--jsonArray \
--file /mongo-seed/us_accidents.json