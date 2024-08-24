package com.entity.vo;

import com.entity.TousuchufaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 投诉处罚
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public class TousuchufaVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 服务名称
	 */
	
	private String fuwumingcheng;
		
	/**
	 * 服务类型
	 */
	
	private String fuwuleixing;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 房主账号
	 */
	
	private String fangzhuzhanghao;
		
	/**
	 * 房主姓名
	 */
	
	private String fangzhuxingming;
		
	/**
	 * 家政账号
	 */
	
	private String jiazhengzhanghao;
		
	/**
	 * 家政姓名
	 */
	
	private String jiazhengxingming;
		
	/**
	 * 公司账号
	 */
	
	private String gongsizhanghao;
		
	/**
	 * 公司名称
	 */
	
	private String gongsimingcheng;
		
	/**
	 * 负责人
	 */
	
	private String fuzeren;
		
	/**
	 * 投诉处罚
	 */
	
	private String tousuchufa;
		
	/**
	 * 处罚时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chufashijian;
		
	/**
	 * 处罚原因
	 */
	
	private String chufayuanyin;
				
	
	/**
	 * 设置：服务名称
	 */
	 
	public void setFuwumingcheng(String fuwumingcheng) {
		this.fuwumingcheng = fuwumingcheng;
	}
	
	/**
	 * 获取：服务名称
	 */
	public String getFuwumingcheng() {
		return fuwumingcheng;
	}
				
	
	/**
	 * 设置：服务类型
	 */
	 
	public void setFuwuleixing(String fuwuleixing) {
		this.fuwuleixing = fuwuleixing;
	}
	
	/**
	 * 获取：服务类型
	 */
	public String getFuwuleixing() {
		return fuwuleixing;
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
	 * 设置：房主账号
	 */
	 
	public void setFangzhuzhanghao(String fangzhuzhanghao) {
		this.fangzhuzhanghao = fangzhuzhanghao;
	}
	
	/**
	 * 获取：房主账号
	 */
	public String getFangzhuzhanghao() {
		return fangzhuzhanghao;
	}
				
	
	/**
	 * 设置：房主姓名
	 */
	 
	public void setFangzhuxingming(String fangzhuxingming) {
		this.fangzhuxingming = fangzhuxingming;
	}
	
	/**
	 * 获取：房主姓名
	 */
	public String getFangzhuxingming() {
		return fangzhuxingming;
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
	 * 设置：公司账号
	 */
	 
	public void setGongsizhanghao(String gongsizhanghao) {
		this.gongsizhanghao = gongsizhanghao;
	}
	
	/**
	 * 获取：公司账号
	 */
	public String getGongsizhanghao() {
		return gongsizhanghao;
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
	 * 设置：投诉处罚
	 */
	 
	public void setTousuchufa(String tousuchufa) {
		this.tousuchufa = tousuchufa;
	}
	
	/**
	 * 获取：投诉处罚
	 */
	public String getTousuchufa() {
		return tousuchufa;
	}
				
	
	/**
	 * 设置：处罚时间
	 */
	 
	public void setChufashijian(Date chufashijian) {
		this.chufashijian = chufashijian;
	}
	
	/**
	 * 获取：处罚时间
	 */
	public Date getChufashijian() {
		return chufashijian;
	}
				
	
	/**
	 * 设置：处罚原因
	 */
	 
	public void setChufayuanyin(String chufayuanyin) {
		this.chufayuanyin = chufayuanyin;
	}
	
	/**
	 * 获取：处罚原因
	 */
	public String getChufayuanyin() {
		return chufayuanyin;
	}
			
}
