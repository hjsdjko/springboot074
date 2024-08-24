package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiedanfankuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiedanfankuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiedanfankuiView;


/**
 * 接单反馈
 *
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface JiedanfankuiService extends IService<JiedanfankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiedanfankuiVO> selectListVO(Wrapper<JiedanfankuiEntity> wrapper);
   	
   	JiedanfankuiVO selectVO(@Param("ew") Wrapper<JiedanfankuiEntity> wrapper);
   	
   	List<JiedanfankuiView> selectListView(Wrapper<JiedanfankuiEntity> wrapper);
   	
   	JiedanfankuiView selectView(@Param("ew") Wrapper<JiedanfankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiedanfankuiEntity> wrapper);

   	

}

