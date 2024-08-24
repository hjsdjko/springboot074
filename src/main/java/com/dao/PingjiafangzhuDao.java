package com.dao;

import com.entity.PingjiafangzhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingjiafangzhuVO;
import com.entity.view.PingjiafangzhuView;


/**
 * 评价房主
 * 
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
public interface PingjiafangzhuDao extends BaseMapper<PingjiafangzhuEntity> {
	
	List<PingjiafangzhuVO> selectListVO(@Param("ew") Wrapper<PingjiafangzhuEntity> wrapper);
	
	PingjiafangzhuVO selectVO(@Param("ew") Wrapper<PingjiafangzhuEntity> wrapper);
	
	List<PingjiafangzhuView> selectListView(@Param("ew") Wrapper<PingjiafangzhuEntity> wrapper);

	List<PingjiafangzhuView> selectListView(Pagination page,@Param("ew") Wrapper<PingjiafangzhuEntity> wrapper);

	
	PingjiafangzhuView selectView(@Param("ew") Wrapper<PingjiafangzhuEntity> wrapper);
	

}
