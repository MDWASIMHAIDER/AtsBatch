package com.batches.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@Data
@Entity
@Table(name="TagTransactionTriggerEntity")
@IdClass(CompositeId.class)
public class TagTransactionTriggerEntity {
	
	@Id
	@SequenceGenerator(name = "gen3", sequenceName = "TRG_TX_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen3", strategy = GenerationType.SEQUENCE)
	private Integer TRG_ID;//  (PK)
	@SequenceGenerator(name = "gen4", sequenceName = "TAG_TX_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen4", strategy = GenerationType.SEQUENCE)
	private Integer TAG_ID;
	@Column(length=16)
	private String VHCL_REG_NUM;
	@Column(length=6)
	private Integer TOLL_PLAZA_ID;
	@Column(length=10)
	private Float TOLL_AMT;
	@Column(length=10)
	private String TX_STATUS;
	@Column(length=8)
	private String TX_FAILURE_RSN;// -- Failed
	@Column(length=6)
	private String REMINDER_MSG_SW;// -- P
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date CREATE_DT;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date UPDATE_DT;//-- null
	@Column(length=15)
	private String CREATED_BY;
	@Column(length=15)
	private String UPDATED_BY;// --null
}
