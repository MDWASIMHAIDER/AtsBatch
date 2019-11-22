package com.batches.command;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class BatchRunSummaryCommand {
	
	private Integer SUMMARY_ID;
	private String BATCH_NAME;
	private String SUMMARY_DTLS;
	private Date CREATE_DT;
	private Date UPDATE_DT;
	private String CREATED_BY;
	private String UPDATED_BY;
}
