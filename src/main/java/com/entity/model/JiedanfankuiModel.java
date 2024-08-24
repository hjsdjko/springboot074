package com.entity.model;

import com.entity.JiedanfankuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 接单反馈
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public class JiedanfankuiModel  implements Serializable {
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
	 * 服务时间
	 */
	
	private String fuwushijian;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 小时价格
	 */
	
	private Double xiaoshijiage;
		
	/**
	 * 服务时长
	 */
	
	private Integer fuwushizhang;
		
	/**
	 * 总金额
	 */
	
	private Double zongjine;
		
	/**
	 * 房主账号
	 */
	
	private String fangzhuzhanghao;
		
	/**
	 * 房主姓名
	 */
	
	private String fangzhuxingming;
		
	/**
	 * 公司账号
	 */
	
	private String gongsizhanghao;
		
	/**
	 * 公司名称
	 */
	
	private String gongsimingcheng;
		
	/**
	 * 家政账号
	 */
	
	private String jiazhengzhanghao;
		
	/**
	 * 家政姓名
	 */
	
	private String jiazhengxingming;
		
	/**
	 * 反馈时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fankuishijian;
		
	/**
	 * 反馈内容
	 */
	
	private String fankuineirong;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
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
	 * 设置：服务时间
	 */
	 
	public void setFuwushijian(String fuwushijian) {
		this.fuwushijian = fuwushijian;
	}
	
	/**
	 * 获取：服务时间
	 */
	public String getFuwushijian() {
		return fuwushijian;
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
	 * 设置：小时价格
	 */
	 
	public void setXiaoshijiage(Double xiaoshijiage) {
		this.xiaoshijiage = xiaoshijiage;
	}
	
	/**
	 * 获取：小时价格
	 */
	public Double getXiaoshijiage() {
		return xiaoshijiage;
	}
				
	
	/**
	 * 设置：服务时长
	 */
	 
	public void setFuwushizhang(Integer fuwushizhang) {
		this.fuwushizhang = fuwushizhang;
	}
	
	/**
	 * 获取：服务时长
	 */
	public Integer getFuwushizhang() {
		return fuwushizhang;
	}
				
	
	/**
	 * 设置：总金额
	 */
	 
	public void setZongjine(Double zongjine) {
		this.zongjine = zongjine;
	}
	
	/**
	 * 获取：总金额
	 */
	public Double getZongjine() {
		return zongjine;
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
	 * 设置：反馈时间
	 */
	 
	public void setFankuishijian(Date fankuishijian) {
		this.fankuishijian = fankuishijian;
	}
	
	/**
	 * 获取：反馈时间
	 */
	public Date getFankuishijian() {
		return fankuishijian;
	}
				
	
	/**
	 * 设置：反馈内容
	 */
	 
	public void setFankuineirong(String fankuineirong) {
		this.fankuineirong = fankuineirong;
	}
	
	/**
	 * 获取：反馈内容
	 */
	public String getFankuineirong() {
		return fankuineirong;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
