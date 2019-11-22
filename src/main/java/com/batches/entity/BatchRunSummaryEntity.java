package com.batches.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@Data
@Entity
@Table(name="BatchRunSummaryEntity")
public class BatchRunSummaryEntity {
	
	@Id
	@SequenceGenerator(name = "gen2", sequenceName = "BATCH_RUN_SUMMARY_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen2", strategy = GenerationType.SEQUENCE)
	private Integer SUMMARY_ID;// -- PK
	@Column(length=30)
	private String BATCH_NAME;
	@Column(length=15)
	private String SUMMARY_DTLS;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date CREATE_DT;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date UPDATE_DT;
	@Column(length=15)
	private String CREATED_BY;
	@Column(length=15)
	private String UPDATED_BY;
}
