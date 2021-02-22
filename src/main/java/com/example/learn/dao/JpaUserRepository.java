package com.example.learn.dao;

import com.example.learn.pojo.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<JpaUser, Long> {

    @Query("from JpaUser where userName like concat('%', ?1, '%') " + "or note like concat('%', ?2, '%') ")
    public List<JpaUser> findUsers(String userName, String note);

    public List<JpaUser> findByUserNameLike(String userName);

    public JpaUser getUserById(Long id);

    public List<JpaUser> findByUserNameLikeOrNoteLike(String userName, String note);

}
