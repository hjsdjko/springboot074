package com.entity.view;

import com.entity.FuwupaidanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 服务派单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@TableName("fuwupaidan")
public class FuwupaidanView  extends FuwupaidanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FuwupaidanView(){
	}
 
 	public FuwupaidanView(FuwupaidanEntity fuwupaidanEntity){
 	try {
			BeanUtils.copyProperties(this, fuwupaidanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
