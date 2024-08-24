package com.dao;

import com.entity.PingjiajiazhengrenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingjiajiazhengrenyuanVO;
import com.entity.view.PingjiajiazhengrenyuanView;


/**
 * 评价家政人员
 * 
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface PingjiajiazhengrenyuanDao extends BaseMapper<PingjiajiazhengrenyuanEntity> {
	
	List<PingjiajiazhengrenyuanVO> selectListVO(@Param("ew") Wrapper<PingjiajiazhengrenyuanEntity> wrapper);
	
	PingjiajiazhengrenyuanVO selectVO(@Param("ew") Wrapper<PingjiajiazhengrenyuanEntity> wrapper);
	
	List<PingjiajiazhengrenyuanView> selectListView(@Param("ew") Wrapper<PingjiajiazhengrenyuanEntity> wrapper);

	List<PingjiajiazhengrenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<PingjiajiazhengrenyuanEntity> wrapper);

	
	PingjiajiazhengrenyuanView selectView(@Param("ew") Wrapper<PingjiajiazhengrenyuanEntity> wrapper);
	

}
