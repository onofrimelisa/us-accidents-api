package com.unlp.bbdd2.accidents.service;

import com.unlp.bbdd2.accidents.repository.AccidentRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentService {

    @Autowired
    private AccidentRepository accidentRepository;

    @Resource
    private RestHighLevelClient client;

    public Object findByAirportCode(String airportCode) {
        return this.accidentRepository.findByAirportCode(airportCode, Pageable.ofSize(10));
    }

    public Object findAll() {
        return this.accidentRepository.findAll(Pageable.ofSize(10));
    }


    public Object findByPolygon() throws IOException {
        List<GeoPoint> allPoints = new ArrayList<>();
        allPoints.add(new GeoPoint(22.733, 68.859));
        allPoints.add(new GeoPoint(24.733, 68.859));
        allPoints.add(new GeoPoint(23, 70.859));

        QueryBuilder queryBuilder = QueryBuilders.geoPolygonQuery("end_location", allPoints);
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(queryBuilder);
        searchRequest.indices("us_accidents");
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        return response.getHits();


    }
}
