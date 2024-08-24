package com.entity.view;

import com.entity.PingjiajiazhengrenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 评价家政人员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@TableName("pingjiajiazhengrenyuan")
public class PingjiajiazhengrenyuanView  extends PingjiajiazhengrenyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PingjiajiazhengrenyuanView(){
	}
 
 	public PingjiajiazhengrenyuanView(PingjiajiazhengrenyuanEntity pingjiajiazhengrenyuanEntity){
 	try {
			BeanUtils.copyProperties(this, pingjiajiazhengrenyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
