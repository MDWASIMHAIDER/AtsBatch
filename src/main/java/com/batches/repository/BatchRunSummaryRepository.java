package com.batches.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batches.entity.BatchRunSummaryEntity;

public interface BatchRunSummaryRepository extends JpaRepository<BatchRunSummaryEntity,Serializable>{

}
