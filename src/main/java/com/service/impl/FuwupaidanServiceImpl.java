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


import com.dao.FuwupaidanDao;
import com.entity.FuwupaidanEntity;
import com.service.FuwupaidanService;
import com.entity.vo.FuwupaidanVO;
import com.entity.view.FuwupaidanView;

@Service("fuwupaidanService")
public class FuwupaidanServiceImpl extends ServiceImpl<FuwupaidanDao, FuwupaidanEntity> implements FuwupaidanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwupaidanEntity> page = this.selectPage(
                new Query<FuwupaidanEntity>(params).getPage(),
                new EntityWrapper<FuwupaidanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwupaidanEntity> wrapper) {
		  Page<FuwupaidanView> page =new Query<FuwupaidanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FuwupaidanVO> selectListVO(Wrapper<FuwupaidanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FuwupaidanVO selectVO(Wrapper<FuwupaidanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FuwupaidanView> selectListView(Wrapper<FuwupaidanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwupaidanView selectView(Wrapper<FuwupaidanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
