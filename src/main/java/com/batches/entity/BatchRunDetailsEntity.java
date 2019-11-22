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
@Table(name="BatchRunDetailsEntity")
public class BatchRunDetailsEntity {
	
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "BATCH_RUN_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer RUN_ID ;// -- PK
	@Column(length=30)
	private String BATCH_NAME;
	/*@CreationTimestamp
	@Column(updatable=false)
	@Temporal(TemporalType.TIMESTAMP)*/
	private Date START_DT;
	@Column(length=8)
	private String RUN_STATUS;//st,c
	@CreationTimestamp
	@Column(updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date END_DT;
	@CreationTimestamp
	@Column(updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date CREATE_DT;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date UPDATE_DT;
	@Column(length=12)
	private String CREATED_BY;
	@Column(length=12)
	private String UPDATED_BY;
}
