package com.zhang.practice.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * 交易结果对象
 * 
 * @author Lord Buddha Bless
 * @since  2021/06/08
 *
 */
public class Result<T> {

	/**
	 * 请求状态
	 */
	private boolean success = false;
	
	/**
	 * 提示信息
	 */
	private String msg = "";
	
	/**
	 * 返回的数据
	 */
	private T data = null;


	/**
	 * 是否成功
	 */
	public boolean isSuccess() {
		return success;
	}
	
	@JsonIgnore
	public  boolean isFail() {
		return !success;
	}

	/**
	 * 请求状态
	 */
	public Result<T> setSuccess(boolean success) {
		this.success = success;
		
		return this;
	}

	/**
	 * 提示信息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 提示信息
	 */
	public Result<T> setMsg(String msg) {
		this.msg = msg;
		
		return this;
	}

	/**
	 * 返回的数据
	 */
	public T getData() {
		return data;
	}

	/**
	 * 设置返回的数据
	 */
	public Result<T> setData(T data) {
		this.data = data;
		return this;
	}

	/**
	 * 设置返回的信息与数据
	 */
	public Result<T> setData(String msg, T data) {
		this.data = data;
		this.msg = msg;
		
		return this;
	}

	
	/**
	 * 静态方法创建"错误信息"对象
	 */
	public static <T> Result<T> err(String msg) {
		return new Result<T>().setMsg(msg);
	}
	
	/**
	 * 静态方法创建"成功信息"对象
	 */
	public static <T> Result<T> success(T data) {
		return new Result<T>().setSuccess(true).setData(data);
	}
	
	/**
	 * 静态方法创建"成功信息"对象
	 */
	public static <T> Result<T> success(String msg, T data) {
		return new Result<T>().setSuccess(true).setData(data).setMsg(msg);
	}
	
	/**
	 * 静态方法创建"成功信息"对象
	 * @param value
	 * @param badRequestMsg
	 * @param collect
	 */
	public static <T> Result<T> success(int value, String badRequestMsg, List<String> collect) {
		return new Result<T>().setSuccess(true);
	}


}
