package com.batches.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batches.entity.TagTransactionTriggerEntity;

@Repository
public interface TagTransactionTriggerRepository extends JpaRepository<TagTransactionTriggerEntity,Serializable>{
	
	@Query("from TagTransactionTriggerEntity where TX_FAILURE_RSN=:failReason and REMINDER_MSG_SW=:reminderSw and CREATE_DT=:d and TX_STATUS=:status")
	public List<TagTransactionTriggerEntity> findAllPendingRecords(String failReason,String reminderSw,Date d,String status);
	
	@Modifying
	@Query("update TagTransactionTriggerEntity set TX_STATUS=:txStatus,REMINDER_MSG_SW=:rmsgSw,UPDATED_BY=:updatedBy ")
	public Integer updateTagTxTriggerEntity(String txStatus,String rmsgSw,String updatedBy);
}
