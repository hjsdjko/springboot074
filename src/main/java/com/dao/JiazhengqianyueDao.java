package com.dao;

import com.entity.JiazhengqianyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiazhengqianyueVO;
import com.entity.view.JiazhengqianyueView;


/**
 * 家政签约
 * 
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface JiazhengqianyueDao extends BaseMapper<JiazhengqianyueEntity> {
	
	List<JiazhengqianyueVO> selectListVO(@Param("ew") Wrapper<JiazhengqianyueEntity> wrapper);
	
	JiazhengqianyueVO selectVO(@Param("ew") Wrapper<JiazhengqianyueEntity> wrapper);
	
	List<JiazhengqianyueView> selectListView(@Param("ew") Wrapper<JiazhengqianyueEntity> wrapper);

	List<JiazhengqianyueView> selectListView(Pagination page,@Param("ew") Wrapper<JiazhengqianyueEntity> wrapper);

	
	JiazhengqianyueView selectView(@Param("ew") Wrapper<JiazhengqianyueEntity> wrapper);
	

}
