package com.dao;

import com.entity.SyslogEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SyslogVO;
import com.entity.view.SyslogView;


/**
 * 系统日志
 * 
 * @author 
 * @email 
 * @date 2024-04-07 23:46:04
 */
public interface SyslogDao extends BaseMapper<SyslogEntity> {
	
	List<SyslogVO> selectListVO(@Param("ew") Wrapper<SyslogEntity> wrapper);
	
	SyslogVO selectVO(@Param("ew") Wrapper<SyslogEntity> wrapper);
	
	List<SyslogView> selectListView(@Param("ew") Wrapper<SyslogEntity> wrapper);

	List<SyslogView> selectListView(Pagination page,@Param("ew") Wrapper<SyslogEntity> wrapper);

	
	SyslogView selectView(@Param("ew") Wrapper<SyslogEntity> wrapper);
	

}
