package com.study;

import java.io.Serializable;

import lombok.Data;

@Data
public class RespMsg implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int code;
	String message;
	
	private RespMsg(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public static RespMsg buildResult(int code,String message) {
		return new RespMsg(code, message);
	}
}
