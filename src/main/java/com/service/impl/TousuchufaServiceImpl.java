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


import com.dao.TousuchufaDao;
import com.entity.TousuchufaEntity;
import com.service.TousuchufaService;
import com.entity.vo.TousuchufaVO;
import com.entity.view.TousuchufaView;

@Service("tousuchufaService")
public class TousuchufaServiceImpl extends ServiceImpl<TousuchufaDao, TousuchufaEntity> implements TousuchufaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TousuchufaEntity> page = this.selectPage(
                new Query<TousuchufaEntity>(params).getPage(),
                new EntityWrapper<TousuchufaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TousuchufaEntity> wrapper) {
		  Page<TousuchufaView> page =new Query<TousuchufaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TousuchufaVO> selectListVO(Wrapper<TousuchufaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TousuchufaVO selectVO(Wrapper<TousuchufaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TousuchufaView> selectListView(Wrapper<TousuchufaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TousuchufaView selectView(Wrapper<TousuchufaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
