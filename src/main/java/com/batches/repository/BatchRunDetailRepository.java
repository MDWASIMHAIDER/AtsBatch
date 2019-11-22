package com.batches.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batches.entity.BatchRunDetailsEntity;

public interface  BatchRunDetailRepository extends JpaRepository<BatchRunDetailsEntity,Serializable>{

}
