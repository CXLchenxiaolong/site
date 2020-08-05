package com.site.common.exception;

import lombok.Data;

/**
 *
 * @author cxl
 *业务异常类
 *
 */
@Data
public class BusinessException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -969419388343724261L;

	private String  errCode;
	
	private String  errMsg;


	public BusinessException(){}
	
	

	public BusinessException(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}


	
	
}
