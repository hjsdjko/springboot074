package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiazhengqianyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiazhengqianyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiazhengqianyueView;


/**
 * 家政签约
 *
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface JiazhengqianyueService extends IService<JiazhengqianyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiazhengqianyueVO> selectListVO(Wrapper<JiazhengqianyueEntity> wrapper);
   	
   	JiazhengqianyueVO selectVO(@Param("ew") Wrapper<JiazhengqianyueEntity> wrapper);
   	
   	List<JiazhengqianyueView> selectListView(Wrapper<JiazhengqianyueEntity> wrapper);
   	
   	JiazhengqianyueView selectView(@Param("ew") Wrapper<JiazhengqianyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiazhengqianyueEntity> wrapper);

   	

}

