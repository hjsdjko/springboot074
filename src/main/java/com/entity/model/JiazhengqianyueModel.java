package com.entity.model;

import com.entity.JiazhengqianyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 家政签约
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public class JiazhengqianyueModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 公司地址
	 */
	
	private String gongsidizhi;
		
	/**
	 * 负责人
	 */
	
	private String fuzeren;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 签约说明
	 */
	
	private String qianyueshuoming;
		
	/**
	 * 签约材料
	 */
	
	private String qianyuecailiao;
		
	/**
	 * 家政账号
	 */
	
	private String jiazhengzhanghao;
		
	/**
	 * 家政姓名
	 */
	
	private String jiazhengxingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 申请时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shenqingshijian;
				
	
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
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：签约说明
	 */
	 
	public void setQianyueshuoming(String qianyueshuoming) {
		this.qianyueshuoming = qianyueshuoming;
	}
	
	/**
	 * 获取：签约说明
	 */
	public String getQianyueshuoming() {
		return qianyueshuoming;
	}
				
	
	/**
	 * 设置：签约材料
	 */
	 
	public void setQianyuecailiao(String qianyuecailiao) {
		this.qianyuecailiao = qianyuecailiao;
	}
	
	/**
	 * 获取：签约材料
	 */
	public String getQianyuecailiao() {
		return qianyuecailiao;
	}
				
	
	/**
	 * 设置：家政账号
	 */
	 
	public void setJiazhengzhanghao(String jiazhengzhanghao) {
		this.jiazhengzhanghao = jiazhengzhanghao;
	}
	
	/**
	 * 获取：家政账号
	 */
	public String getJiazhengzhanghao() {
		return jiazhengzhanghao;
	}
				
	
	/**
	 * 设置：家政姓名
	 */
	 
	public void setJiazhengxingming(String jiazhengxingming) {
		this.jiazhengxingming = jiazhengxingming;
	}
	
	/**
	 * 获取：家政姓名
	 */
	public String getJiazhengxingming() {
		return jiazhengxingming;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
				
	
	/**
	 * 设置：申请时间
	 */
	 
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
	}
			
}
