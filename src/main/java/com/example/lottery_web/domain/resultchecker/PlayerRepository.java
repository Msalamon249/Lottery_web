package com.example.lottery_web.domain.resultchecker;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PlayerRepository extends MongoRepository<Player,String> {


}
