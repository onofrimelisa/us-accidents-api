#! /bin/bash

mongoimport \
--host mongodb \
--db accidents \
--collection accidents \
--type json \
--jsonArray \
--file /mongo/us_accidents.json \
--mode upsert \
--upsertFields accident_id