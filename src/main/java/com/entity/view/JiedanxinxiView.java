package com.entity.view;

import com.entity.JiedanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 接单信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@TableName("jiedanxinxi")
public class JiedanxinxiView  extends JiedanxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiedanxinxiView(){
	}
 
 	public JiedanxinxiView(JiedanxinxiEntity jiedanxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jiedanxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
