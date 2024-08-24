package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SyslogEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SyslogVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SyslogView;


/**
 * 系统日志
 *
 * @author 
 * @email 
 * @date 2024-04-07 23:46:04
 */
public interface SyslogService extends IService<SyslogEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SyslogVO> selectListVO(Wrapper<SyslogEntity> wrapper);
   	
   	SyslogVO selectVO(@Param("ew") Wrapper<SyslogEntity> wrapper);
   	
   	List<SyslogView> selectListView(Wrapper<SyslogEntity> wrapper);
   	
   	SyslogView selectView(@Param("ew") Wrapper<SyslogEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SyslogEntity> wrapper);

   	

}

