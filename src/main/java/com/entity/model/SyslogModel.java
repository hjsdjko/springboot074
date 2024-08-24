package com.entity.model;

import com.entity.SyslogEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 系统日志
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-07 23:46:04
 */
public class SyslogModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户操作
	 */
	
	private String operation;
		
	/**
	 * 请求方法
	 */
	
	private String method;
		
	/**
	 * 请求参数
	 */
	
	private String params;
		
	/**
	 * 请求时长(毫秒)
	 */
	
	private Long time;
		
	/**
	 * IP地址
	 */
	
	private String ip;
				
	
	/**
	 * 设置：用户操作
	 */
	 
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	/**
	 * 获取：用户操作
	 */
	public String getOperation() {
		return operation;
	}
				
	
	/**
	 * 设置：请求方法
	 */
	 
	public void setMethod(String method) {
		this.method = method;
	}
	
	/**
	 * 获取：请求方法
	 */
	public String getMethod() {
		return method;
	}
				
	
	/**
	 * 设置：请求参数
	 */
	 
	public void setParams(String params) {
		this.params = params;
	}
	
	/**
	 * 获取：请求参数
	 */
	public String getParams() {
		return params;
	}
				
	
	/**
	 * 设置：请求时长(毫秒)
	 */
	 
	public void setTime(Long time) {
		this.time = time;
	}
	
	/**
	 * 获取：请求时长(毫秒)
	 */
	public Long getTime() {
		return time;
	}
				
	
	/**
	 * 设置：IP地址
	 */
	 
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 * 获取：IP地址
	 */
	public String getIp() {
		return ip;
	}
			
}
