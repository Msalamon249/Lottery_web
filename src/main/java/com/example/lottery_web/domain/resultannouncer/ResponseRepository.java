package com.example.lottery_web.domain.resultannouncer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ResponseRepository extends MongoRepository<ResultResponse,String> {


}
