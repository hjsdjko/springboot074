package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FuwupaidanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FuwupaidanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FuwupaidanView;


/**
 * 服务派单
 *
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface FuwupaidanService extends IService<FuwupaidanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwupaidanVO> selectListVO(Wrapper<FuwupaidanEntity> wrapper);
   	
   	FuwupaidanVO selectVO(@Param("ew") Wrapper<FuwupaidanEntity> wrapper);
   	
   	List<FuwupaidanView> selectListView(Wrapper<FuwupaidanEntity> wrapper);
   	
   	FuwupaidanView selectView(@Param("ew") Wrapper<FuwupaidanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwupaidanEntity> wrapper);

   	

}

