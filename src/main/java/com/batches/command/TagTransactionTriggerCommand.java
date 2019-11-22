package com.batches.command;

import java.util.Date;

import lombok.Data;

@Data
public class TagTransactionTriggerCommand {
	
	private Integer TRG_ID;//  (PK)
	private Integer TAG_ID;
	private String VHCL_REG_NUM;
	private Integer TOLL_PLAZA_ID;
	private Float TOLL_AMT;
	private String TX_STATUS;
	private String TX_FAILURE_RSN;// -- Failed
	private String REMINDER_MSG_SW;// -- P
	private Date CREATE_DT;
	private Date UPDATE_DT;//-- null
	private String CREATED_BY;
	private String UPDATED_BY;
}
