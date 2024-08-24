package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjiazhenggongsiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjiazhenggongsiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjiazhenggongsiView;


/**
 * 家政公司评论表
 *
 * @author 
 * @email 
 * @date 2024-04-07 23:46:04
 */
public interface DiscussjiazhenggongsiService extends IService<DiscussjiazhenggongsiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiazhenggongsiVO> selectListVO(Wrapper<DiscussjiazhenggongsiEntity> wrapper);
   	
   	DiscussjiazhenggongsiVO selectVO(@Param("ew") Wrapper<DiscussjiazhenggongsiEntity> wrapper);
   	
   	List<DiscussjiazhenggongsiView> selectListView(Wrapper<DiscussjiazhenggongsiEntity> wrapper);
   	
   	DiscussjiazhenggongsiView selectView(@Param("ew") Wrapper<DiscussjiazhenggongsiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiazhenggongsiEntity> wrapper);

   	

}

