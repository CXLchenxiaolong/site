package com.site.common.enums;

import lombok.Getter;

public enum ResponseCodeEnum
{
	SUCCESS("00000", "SUCCESS"),
	FAIL("00001", "FAIL"),
	SYSTEM_ERROR("00002","系统错误"),

	QUERY_ERROR("00003", "QUERY_ERROR"),
	UPDATE_ERROR("00004", "UPDATE_ERROR"),
	INSERT_ERROR("00005", "INSERT_ERROR"),
	DELETE_ERROR("00006", "DELETE_ERROR"),

	TOKEN_NULL("10000","用户授权认证没有通过!客户端请求参数中无token信息"),
	TOKEN_ILLEGAL("10001","token非法,请登录重新认证"),



	ARGUMENT_NOT_VALID("50100","系统传入参数校验不过");

	@Getter private  String code;
	@Getter private  String desc;

	ResponseCodeEnum(String code, String desc)
	{
		this.code = code;
		this.desc = desc;
	}


}
