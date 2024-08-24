package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinzixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinzixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinzixinxiView;


/**
 * 薪资信息
 *
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface XinzixinxiService extends IService<XinzixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinzixinxiVO> selectListVO(Wrapper<XinzixinxiEntity> wrapper);
   	
   	XinzixinxiVO selectVO(@Param("ew") Wrapper<XinzixinxiEntity> wrapper);
   	
   	List<XinzixinxiView> selectListView(Wrapper<XinzixinxiEntity> wrapper);
   	
   	XinzixinxiView selectView(@Param("ew") Wrapper<XinzixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinzixinxiEntity> wrapper);

   	

}

