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
	REMOTE_ERROR("005", "调用远程接口异常"),
	REMOTE_NODATA("006", "远程接口未返回任何数据"),
	REMOTE_CALCULATE_FAILER("007", "远程接口价格计算失败"),



	ERROR("1", "FAILED"),
	NEED_LOGIN("2050010", "NEED_LOGIN"),
	EMPTY_USER("2050012", "登录用户为空"),
	EMPTY_TOKEN("2050013", "登录token为空"),
	ILLEGAL_ARGUMENT("2050002", "ILLEGAL_ARGUMENT"),
	PASSWORD_ERROR("2050003", "PASSWORD_ERROR"),
	LANDING_TIMEOUT("2050403", "LANDING_TIMEOUT"),
	ARGUMENT_NOT_VALID("50100","系统传入参数校验不过"),
	APP_SUCCESS("0000", "SUCCESS"),
	APP_MISS_SIGN("2050024", "缺少签名参数"),
	APP_INVALID_SIGN("2050025", "非法签名");

	@Getter private  String code;
	@Getter private  String desc;

	ResponseCode(String code, String desc) 
	{
		this.code = code;
		this.desc = desc;
	}


}
