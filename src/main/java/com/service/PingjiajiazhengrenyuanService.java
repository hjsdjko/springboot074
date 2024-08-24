package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PingjiajiazhengrenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PingjiajiazhengrenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PingjiajiazhengrenyuanView;


/**
 * 评价家政人员
 *
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface PingjiajiazhengrenyuanService extends IService<PingjiajiazhengrenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingjiajiazhengrenyuanVO> selectListVO(Wrapper<PingjiajiazhengrenyuanEntity> wrapper);
   	
   	PingjiajiazhengrenyuanVO selectVO(@Param("ew") Wrapper<PingjiajiazhengrenyuanEntity> wrapper);
   	
   	List<PingjiajiazhengrenyuanView> selectListView(Wrapper<PingjiajiazhengrenyuanEntity> wrapper);
   	
   	PingjiajiazhengrenyuanView selectView(@Param("ew") Wrapper<PingjiajiazhengrenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingjiajiazhengrenyuanEntity> wrapper);

   	

}

