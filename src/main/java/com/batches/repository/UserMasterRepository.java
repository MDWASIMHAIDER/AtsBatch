package com.batches.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batches.entity.UserMasterEntity;

@Repository
public interface UserMasterRepository extends JpaRepository<UserMasterEntity, Serializable>{

}
