package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TousuchufaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TousuchufaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TousuchufaView;


/**
 * 投诉处罚
 *
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface TousuchufaService extends IService<TousuchufaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TousuchufaVO> selectListVO(Wrapper<TousuchufaEntity> wrapper);
   	
   	TousuchufaVO selectVO(@Param("ew") Wrapper<TousuchufaEntity> wrapper);
   	
   	List<TousuchufaView> selectListView(Wrapper<TousuchufaEntity> wrapper);
   	
   	TousuchufaView selectView(@Param("ew") Wrapper<TousuchufaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TousuchufaEntity> wrapper);

   	

}

