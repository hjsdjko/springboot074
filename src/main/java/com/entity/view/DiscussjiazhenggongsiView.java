package com.entity.view;

import com.entity.DiscussjiazhenggongsiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 家政公司评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-07 23:46:04
 */
@TableName("discussjiazhenggongsi")
public class DiscussjiazhenggongsiView  extends DiscussjiazhenggongsiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussjiazhenggongsiView(){
	}
 
 	public DiscussjiazhenggongsiView(DiscussjiazhenggongsiEntity discussjiazhenggongsiEntity){
 	try {
			BeanUtils.copyProperties(this, discussjiazhenggongsiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
