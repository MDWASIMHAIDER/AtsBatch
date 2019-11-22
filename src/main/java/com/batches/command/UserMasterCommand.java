package com.batches.command;

import java.util.Date;

import lombok.Data;

@Data
public class UserMasterCommand {
	private Integer USER_ID;// (PK)
	private String FIRST_NAME;
	private String LAST_NAME;
	private String EMAIL_ID;
	private Long MOBILE_NUM;
	private String GENDER;
	private Date CREATE_DT;
	private Date UPDATE_DT;
	private String CREATED_BY;
	private String UPDATED_BY;
}
