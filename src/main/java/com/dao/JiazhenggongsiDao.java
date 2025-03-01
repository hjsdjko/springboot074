package com.dao;

import com.entity.JiazhenggongsiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiazhenggongsiVO;
import com.entity.view.JiazhenggongsiView;


/**
 * 家政公司
 * 
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface JiazhenggongsiDao extends BaseMapper<JiazhenggongsiEntity> {
	
	List<JiazhenggongsiVO> selectListVO(@Param("ew") Wrapper<JiazhenggongsiEntity> wrapper);
	
	JiazhenggongsiVO selectVO(@Param("ew") Wrapper<JiazhenggongsiEntity> wrapper);
	
	List<JiazhenggongsiView> selectListView(@Param("ew") Wrapper<JiazhenggongsiEntity> wrapper);

	List<JiazhenggongsiView> selectListView(Pagination page,@Param("ew") Wrapper<JiazhenggongsiEntity> wrapper);

	
	JiazhenggongsiView selectView(@Param("ew") Wrapper<JiazhenggongsiEntity> wrapper);
	

}
