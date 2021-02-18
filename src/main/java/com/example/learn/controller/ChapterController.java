package com.example.learn.controller;

import com.example.learn.pojo.Chapter;
import com.example.learn.repository.ChapterRepository;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChapterController {

    /* 使用repository */
    @Autowired
    ChapterRepository repository;

    @GetMapping("/chapters")
    public List<Chapter> listAllChapter() {
        return repository.findAll();
    }

    @GetMapping("/chapter")
    public List<Chapter> listOneChapter(@Param(value = "name") String name) {
        return repository.findByName(name);
    }

    @GetMapping("/insertChapter")
    public String insertOneChapter(@Param(value = "name") String name) {
        if (repository.existsByName(name)) {
            return "此章节已经存在";
        } else {
            Chapter chapter = new Chapter(name);
            repository.save(chapter);
            return "新增章节成功";
        }
    }

    /* 使用mongoTemplate */
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/updateChapter")
    public String updateChapter(@Param(value = "name") String name, @Param(value = "author") String author) {
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update().set("author", author);
        UpdateResult result = mongoTemplate.updateFirst(query, update, "chapter");
        System.out.println(result);
        if (result.getModifiedCount() > 0) {
            return "更新成功";
        } else {
            return "更新失败";
        }
    }

    @GetMapping("/deleteChapter")
    public String deleteChapter(@Param(value = "name") String name) {
        Query query = new Query(Criteria.where("name").is(name));
        DeleteResult result = mongoTemplate.remove(query, Chapter.class, "chapter");
        System.out.println(result);
        if (result.getDeletedCount() > 0) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

}
