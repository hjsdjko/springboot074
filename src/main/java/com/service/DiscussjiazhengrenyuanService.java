package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjiazhengrenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjiazhengrenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjiazhengrenyuanView;


/**
 * 家政人员评论表
 *
 * @author 
 * @email 
 * @date 2024-04-07 23:46:04
 */
public interface DiscussjiazhengrenyuanService extends IService<DiscussjiazhengrenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiazhengrenyuanVO> selectListVO(Wrapper<DiscussjiazhengrenyuanEntity> wrapper);
   	
   	DiscussjiazhengrenyuanVO selectVO(@Param("ew") Wrapper<DiscussjiazhengrenyuanEntity> wrapper);
   	
   	List<DiscussjiazhengrenyuanView> selectListView(Wrapper<DiscussjiazhengrenyuanEntity> wrapper);
   	
   	DiscussjiazhengrenyuanView selectView(@Param("ew") Wrapper<DiscussjiazhengrenyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiazhengrenyuanEntity> wrapper);

   	

}

