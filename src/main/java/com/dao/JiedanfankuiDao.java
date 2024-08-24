package com.dao;

import com.entity.JiedanfankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiedanfankuiVO;
import com.entity.view.JiedanfankuiView;


/**
 * 接单反馈
 * 
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface JiedanfankuiDao extends BaseMapper<JiedanfankuiEntity> {
	
	List<JiedanfankuiVO> selectListVO(@Param("ew") Wrapper<JiedanfankuiEntity> wrapper);
	
	JiedanfankuiVO selectVO(@Param("ew") Wrapper<JiedanfankuiEntity> wrapper);
	
	List<JiedanfankuiView> selectListView(@Param("ew") Wrapper<JiedanfankuiEntity> wrapper);

	List<JiedanfankuiView> selectListView(Pagination page,@Param("ew") Wrapper<JiedanfankuiEntity> wrapper);

	
	JiedanfankuiView selectView(@Param("ew") Wrapper<JiedanfankuiEntity> wrapper);
	

}
