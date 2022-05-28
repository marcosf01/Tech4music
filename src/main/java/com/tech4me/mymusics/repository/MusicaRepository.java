package com.tech4me.mymusics.repository;

import com.tech4me.mymusics.model.Musica;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicaRepository extends MongoRepository<Musica, String> {
    
}
