package com.dao;

import com.entity.TousuchufaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TousuchufaVO;
import com.entity.view.TousuchufaView;


/**
 * 投诉处罚
 * 
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface TousuchufaDao extends BaseMapper<TousuchufaEntity> {
	
	List<TousuchufaVO> selectListVO(@Param("ew") Wrapper<TousuchufaEntity> wrapper);
	
	TousuchufaVO selectVO(@Param("ew") Wrapper<TousuchufaEntity> wrapper);
	
	List<TousuchufaView> selectListView(@Param("ew") Wrapper<TousuchufaEntity> wrapper);

	List<TousuchufaView> selectListView(Pagination page,@Param("ew") Wrapper<TousuchufaEntity> wrapper);

	
	TousuchufaView selectView(@Param("ew") Wrapper<TousuchufaEntity> wrapper);
	

}
