package com.cvicse.uploadmvc;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpresswayRepository  extends ElasticsearchRepository<ExpresswayInfo,String> {
}
