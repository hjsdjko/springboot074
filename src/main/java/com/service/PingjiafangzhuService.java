package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PingjiafangzhuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PingjiafangzhuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PingjiafangzhuView;


/**
 * 评价房主
 *
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface PingjiafangzhuService extends IService<PingjiafangzhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingjiafangzhuVO> selectListVO(Wrapper<PingjiafangzhuEntity> wrapper);
   	
   	PingjiafangzhuVO selectVO(@Param("ew") Wrapper<PingjiafangzhuEntity> wrapper);
   	
   	List<PingjiafangzhuView> selectListView(Wrapper<PingjiafangzhuEntity> wrapper);
   	
   	PingjiafangzhuView selectView(@Param("ew") Wrapper<PingjiafangzhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingjiafangzhuEntity> wrapper);

   	

}

