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
@Table(name="UserMasterEntity")
public class UserMasterEntity {
	
	@Id
	@SequenceGenerator(name = "gen7", sequenceName = "USER_MASTER_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen7", strategy = GenerationType.SEQUENCE)
	private Integer USER_ID;// (PK)
	@Column(length=20)
	private String FIRST_NAME;
	@Column(length=16)
	private String LAST_NAME;
	@Column(length=30)
	private String EMAIL_ID;
	@Column(length=12)
	private Long MOBILE_NUM;
	@Column(length=6)
	private String GENDER;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date CREATE_DT;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date UPDATE_DT;
	@Column(length=25)
	private String CREATED_BY;
	@Column(length=25)
	private String UPDATED_BY;
}
