package com.batches.atsbatches;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.batches.emailsender.EmailSender;
import com.batches.entity.BatchRunDetailsEntity;
import com.batches.entity.BatchRunSummaryEntity;
import com.batches.entity.TagMasterEntity;
import com.batches.entity.TagTransactionTriggerEntity;
import com.batches.entity.UserMasterEntity;
import com.batches.repository.BatchRunDetailRepository;
import com.batches.repository.BatchRunSummaryRepository;
import com.batches.repository.TagMasterRepository;
import com.batches.repository.TagTransactionTriggerRepository;
import com.batches.repository.UserMasterRepository;

public class Low_Bal_Reminder_Daily implements Batch{

	@Autowired
	private BatchRunDetailRepository batchRunDetailRepo; 
	@Autowired
	private TagTransactionTriggerRepository tagTriggerRepo;
	@Autowired
	private TagMasterRepository tagMasterRepo;
	@Autowired
	private UserMasterRepository userMasterRepo;
	@Autowired
	private BatchRunSummaryRepository summaryRepo;
	@Autowired
	private EmailSender emailSender;
	
	private static Integer totalCount;
	private static Integer failureCount;
	private static Integer successCount;
	
	private static final String BATCH_NAME="lowBalReminderBatch";
	
	Date date=new Date();
	java.sql.Date d= new java.sql.Date(date.getTime());  
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		List<TagTransactionTriggerEntity> allPendingRecords = tagTriggerRepo.findAllPendingRecords("LowBalance", "P",d , "Failed");
		totalCount=allPendingRecords.size();
		allPendingRecords.forEach(tagId->{
			 Integer findByTAG_ID = tagMasterRepo.findByTAG_ID(tagId.getTAG_ID());
			 Optional<UserMasterEntity> optional = userMasterRepo.findById(findByTAG_ID);
			 if(optional!=null) {
				 UserMasterEntity userMasterEntity = optional.get();
				 String email_ID = userMasterEntity.getEMAIL_ID();
				 Long mobile_NUM = userMasterEntity.getMOBILE_NUM();
				 process(email_ID,mobile_NUM);
			 }
		});
	}

	@Override
	public void preProcess() {

		BatchRunDetailsEntity entity=new BatchRunDetailsEntity();
		entity.setBATCH_NAME(BATCH_NAME);
		entity.setRUN_STATUS("start");
		entity.setSTART_DT(date);
		entity.setCREATED_BY(BATCH_NAME);
		BatchRunDetailsEntity batchRunDetailsEntity = batchRunDetailRepo.save(entity);
		Integer run_ID = batchRunDetailsEntity.getRUN_ID();
		
	}

	@Override
	@Transactional
	public void process(String email,Long phone) {
		try {
			emailSender.sendEmail(email);
			tagTriggerRepo.updateTagTxTriggerEntity("success","C",BATCH_NAME);
			successCount++;
		}
		catch(Exception e) {
			failureCount++;
		}
		
		
	}

	@Override
	public void PostProcess() {
		// TODO Auto-generated method stub
		BatchRunSummaryEntity entity=new BatchRunSummaryEntity();
		entity.setBATCH_NAME(BATCH_NAME);
		entity.setUPDATED_BY(BATCH_NAME);
		entity.setSUMMARY_DTLS("Record Detail are:"+"Total Record="+totalCount+"Success Record="+successCount+"Failure Record"+failureCount);
		summaryRepo.save(entity);
		
		
	}

	
}
