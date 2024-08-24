package com.dao;

import com.entity.JiazhengrenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiazhengrenyuanVO;
import com.entity.view.JiazhengrenyuanView;


/**
 * 家政人员
 * 
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface JiazhengrenyuanDao extends BaseMapper<JiazhengrenyuanEntity> {
	
	List<JiazhengrenyuanVO> selectListVO(@Param("ew") Wrapper<JiazhengrenyuanEntity> wrapper);
	
	JiazhengrenyuanVO selectVO(@Param("ew") Wrapper<JiazhengrenyuanEntity> wrapper);
	
	List<JiazhengrenyuanView> selectListView(@Param("ew") Wrapper<JiazhengrenyuanEntity> wrapper);

	List<JiazhengrenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<JiazhengrenyuanEntity> wrapper);

	
	JiazhengrenyuanView selectView(@Param("ew") Wrapper<JiazhengrenyuanEntity> wrapper);
	

}
