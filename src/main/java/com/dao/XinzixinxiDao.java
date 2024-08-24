package com.dao;

import com.entity.XinzixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinzixinxiVO;
import com.entity.view.XinzixinxiView;


/**
 * 薪资信息
 * 
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface XinzixinxiDao extends BaseMapper<XinzixinxiEntity> {
	
	List<XinzixinxiVO> selectListVO(@Param("ew") Wrapper<XinzixinxiEntity> wrapper);
	
	XinzixinxiVO selectVO(@Param("ew") Wrapper<XinzixinxiEntity> wrapper);
	
	List<XinzixinxiView> selectListView(@Param("ew") Wrapper<XinzixinxiEntity> wrapper);

	List<XinzixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XinzixinxiEntity> wrapper);

	
	XinzixinxiView selectView(@Param("ew") Wrapper<XinzixinxiEntity> wrapper);
	

}
