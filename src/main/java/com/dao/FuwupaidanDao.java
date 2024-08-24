package com.dao;

import com.entity.FuwupaidanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FuwupaidanVO;
import com.entity.view.FuwupaidanView;


/**
 * 服务派单
 * 
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface FuwupaidanDao extends BaseMapper<FuwupaidanEntity> {
	
	List<FuwupaidanVO> selectListVO(@Param("ew") Wrapper<FuwupaidanEntity> wrapper);
	
	FuwupaidanVO selectVO(@Param("ew") Wrapper<FuwupaidanEntity> wrapper);
	
	List<FuwupaidanView> selectListView(@Param("ew") Wrapper<FuwupaidanEntity> wrapper);

	List<FuwupaidanView> selectListView(Pagination page,@Param("ew") Wrapper<FuwupaidanEntity> wrapper);

	
	FuwupaidanView selectView(@Param("ew") Wrapper<FuwupaidanEntity> wrapper);
	

}
