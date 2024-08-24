package com.entity.vo;

import com.entity.JiazhenggongsiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 家政公司
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public class JiazhenggongsiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 公司名称
	 */
	
	private String gongsimingcheng;
		
	/**
	 * 负责人
	 */
	
	private String fuzeren;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 公司地址
	 */
	
	private String gongsidizhi;
		
	/**
	 * 服务电话
	 */
	
	private String fuwudianhua;
		
	/**
	 * 注册时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date zhuceshijian;
		
	/**
	 * 公司介绍
	 */
	
	private String gongsijieshao;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：公司名称
	 */
	 
	public void setGongsimingcheng(String gongsimingcheng) {
		this.gongsimingcheng = gongsimingcheng;
	}
	
	/**
	 * 获取：公司名称
	 */
	public String getGongsimingcheng() {
		return gongsimingcheng;
	}
				
	
	/**
	 * 设置：负责人
	 */
	 
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	
	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：公司地址
	 */
	 
	public void setGongsidizhi(String gongsidizhi) {
		this.gongsidizhi = gongsidizhi;
	}
	
	/**
	 * 获取：公司地址
	 */
	public String getGongsidizhi() {
		return gongsidizhi;
	}
				
	
	/**
	 * 设置：服务电话
	 */
	 
	public void setFuwudianhua(String fuwudianhua) {
		this.fuwudianhua = fuwudianhua;
	}
	
	/**
	 * 获取：服务电话
	 */
	public String getFuwudianhua() {
		return fuwudianhua;
	}
				
	
	/**
	 * 设置：注册时间
	 */
	 
	public void setZhuceshijian(Date zhuceshijian) {
		this.zhuceshijian = zhuceshijian;
	}
	
	/**
	 * 获取：注册时间
	 */
	public Date getZhuceshijian() {
		return zhuceshijian;
	}
				
	
	/**
	 * 设置：公司介绍
	 */
	 
	public void setGongsijieshao(String gongsijieshao) {
		this.gongsijieshao = gongsijieshao;
	}
	
	/**
	 * 获取：公司介绍
	 */
	public String getGongsijieshao() {
		return gongsijieshao;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
