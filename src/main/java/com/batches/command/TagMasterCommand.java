package com.batches.command;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class TagMasterCommand {
	
	private Integer TAG_MASTER_ID;// (PK)
	private Integer TAG_ID ;
	private String VEHICLE_REG_NUM;
	private String VEHICLE_TYPE;
	private Date TAG_START_DT;
	//TODO
	private Date TAG_EXPIRY_DT;
	private Float TAG_BAL;
	//TODO
	private Integer USER_ID;// --- REFERENCES FROM USER_MASTER
	private Date CREATE_DT;
	private Date UPDATE_DT;
	private String CREATED_BY;
	private String UPDATED_BY;
}
