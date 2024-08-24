package com.entity.view;

import com.entity.TousuchufaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 投诉处罚
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@TableName("tousuchufa")
public class TousuchufaView  extends TousuchufaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TousuchufaView(){
	}
 
 	public TousuchufaView(TousuchufaEntity tousuchufaEntity){
 	try {
			BeanUtils.copyProperties(this, tousuchufaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}