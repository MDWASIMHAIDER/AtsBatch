package com.batches.command;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
public class BatchRunDetailsCommand {
	
	private Integer RUN_ID ;
	private String BATCH_NAME;
	private Date START_DT;
	private String RUN_STATUS;
	private Date END_DT;
	private Date CREATE_DT;
	private Date UPDATE_DT;
	private String CREATED_BY;
	private String UPDATED_BY;
}
