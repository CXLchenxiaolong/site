package com.site.common.enums;

import lombok.Getter;

public enum ResponseCode
{
	SUCCESS("00", "SUCCESS"),
	FAIL("001", "FAIL"),
	QUERY_ERROR("001", "QUERY_ERROR"),
	UPDATE_ERROR("002", "UPDATE_ERROR"),
	INSERT_ERROR("003", "INSERT_ERROR"),
	DELETE_ERROR("004", "DELETE_ERROR"),

	ARGUMENT_NOT_VALID("50100","系统传入参数校验不过");

	@Getter private  String code;
	@Getter private  String desc;

	ResponseCode(String code, String desc) 
	{
		this.code = code;
		this.desc = desc;
	}


}
