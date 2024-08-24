package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiedanfankuiDao;
import com.entity.JiedanfankuiEntity;
import com.service.JiedanfankuiService;
import com.entity.vo.JiedanfankuiVO;
import com.entity.view.JiedanfankuiView;

@Service("jiedanfankuiService")
public class JiedanfankuiServiceImpl extends ServiceImpl<JiedanfankuiDao, JiedanfankuiEntity> implements JiedanfankuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiedanfankuiEntity> page = this.selectPage(
                new Query<JiedanfankuiEntity>(params).getPage(),
                new EntityWrapper<JiedanfankuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiedanfankuiEntity> wrapper) {
		  Page<JiedanfankuiView> page =new Query<JiedanfankuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiedanfankuiVO> selectListVO(Wrapper<JiedanfankuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiedanfankuiVO selectVO(Wrapper<JiedanfankuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiedanfankuiView> selectListView(Wrapper<JiedanfankuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiedanfankuiView selectView(Wrapper<JiedanfankuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
