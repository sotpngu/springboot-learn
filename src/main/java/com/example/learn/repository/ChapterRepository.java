package com.example.learn.repository;

import com.example.learn.pojo.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChapterRepository extends MongoRepository<Chapter, String> {

    public List<Chapter> findByName(String Name);

    public boolean existsByName(String name);

}
