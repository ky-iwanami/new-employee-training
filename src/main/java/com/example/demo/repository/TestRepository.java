package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {
	
	  @Query(value = ""
	  		+ "SELECT"
	  		+ "    id"
	  		+ "    , item1"
	  		+ "    , item2"
	  		+ "    , item3"
	  		+ "    , item4"
	  		+ "    , item5"
	  		+ "    , item6"
	  		+ "    , item7"
	  		+ "    , item8"
	  		+ "    , item9"
	  		+ "    , item10 "
	  		+ "FROM"
	  		+ "    TEST "
	  		+ "ORDER BY"
	  		+ "    id DESC "
	  		+ "LIMIT"
	  		+ "    1", nativeQuery = true)
	  TestEntity findOne();
}