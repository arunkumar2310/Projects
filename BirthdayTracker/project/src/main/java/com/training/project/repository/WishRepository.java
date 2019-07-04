package com.training.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.project.entity.Wish;

@Repository
public interface WishRepository extends JpaRepository <Wish ,Long>{

    List<Wish> findAllByWishedToUserId(String Id);
}
