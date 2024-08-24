package com.entity.vo;

import com.entity.XinzixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 薪资信息
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public class XinzixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 家政账号
	 */
	
	private String jiazhengzhanghao;
		
	/**
	 * 家政姓名
	 */
	
	private String jiazhengxingming;
		
	/**
	 * 基本工资
	 */
	
	private Double jibengongzi;
		
	/**
	 * 加班奖金
	 */
	
	private Double jiabanjiangjin;
		
	/**
	 * 绩效奖励
	 */
	
	private Double jixiaojiangli;
		
	/**
	 * 全勤奖励
	 */
	
	private Double quanqinjiangli;
		
	/**
	 * 五险一金
	 */
	
	private Double wuxianyijin;
		
	/**
	 * 扣款金额
	 */
	
	private Double koukuanjine;
		
	/**
	 * 实发工资
	 */
	
	private Double shifagongzi;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 公司账号
	 */
	
	private String gongsizhanghao;
		
	/**
	 * 公司名称
	 */
	
	private String gongsimingcheng;
				
	
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
	 * 设置：基本工资
	 */
	 
	public void setJibengongzi(Double jibengongzi) {
		this.jibengongzi = jibengongzi;
	}
	
	/**
	 * 获取：基本工资
	 */
	public Double getJibengongzi() {
		return jibengongzi;
	}
				
	
	/**
	 * 设置：加班奖金
	 */
	 
	public void setJiabanjiangjin(Double jiabanjiangjin) {
		this.jiabanjiangjin = jiabanjiangjin;
	}
	
	/**
	 * 获取：加班奖金
	 */
	public Double getJiabanjiangjin() {
		return jiabanjiangjin;
	}
				
	
	/**
	 * 设置：绩效奖励
	 */
	 
	public void setJixiaojiangli(Double jixiaojiangli) {
		this.jixiaojiangli = jixiaojiangli;
	}
	
	/**
	 * 获取：绩效奖励
	 */
	public Double getJixiaojiangli() {
		return jixiaojiangli;
	}
				
	
	/**
	 * 设置：全勤奖励
	 */
	 
	public void setQuanqinjiangli(Double quanqinjiangli) {
		this.quanqinjiangli = quanqinjiangli;
	}
	
	/**
	 * 获取：全勤奖励
	 */
	public Double getQuanqinjiangli() {
		return quanqinjiangli;
	}
				
	
	/**
	 * 设置：五险一金
	 */
	 
	public void setWuxianyijin(Double wuxianyijin) {
		this.wuxianyijin = wuxianyijin;
	}
	
	/**
	 * 获取：五险一金
	 */
	public Double getWuxianyijin() {
		return wuxianyijin;
	}
				
	
	/**
	 * 设置：扣款金额
	 */
	 
	public void setKoukuanjine(Double koukuanjine) {
		this.koukuanjine = koukuanjine;
	}
	
	/**
	 * 获取：扣款金额
	 */
	public Double getKoukuanjine() {
		return koukuanjine;
	}
				
	
	/**
	 * 设置：实发工资
	 */
	 
	public void setShifagongzi(Double shifagongzi) {
		this.shifagongzi = shifagongzi;
	}
	
	/**
	 * 获取：实发工资
	 */
	public Double getShifagongzi() {
		return shifagongzi;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
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
			
}
