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


import com.dao.PingjiajiazhengrenyuanDao;
import com.entity.PingjiajiazhengrenyuanEntity;
import com.service.PingjiajiazhengrenyuanService;
import com.entity.vo.PingjiajiazhengrenyuanVO;
import com.entity.view.PingjiajiazhengrenyuanView;

@Service("pingjiajiazhengrenyuanService")
public class PingjiajiazhengrenyuanServiceImpl extends ServiceImpl<PingjiajiazhengrenyuanDao, PingjiajiazhengrenyuanEntity> implements PingjiajiazhengrenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingjiajiazhengrenyuanEntity> page = this.selectPage(
                new Query<PingjiajiazhengrenyuanEntity>(params).getPage(),
                new EntityWrapper<PingjiajiazhengrenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingjiajiazhengrenyuanEntity> wrapper) {
		  Page<PingjiajiazhengrenyuanView> page =new Query<PingjiajiazhengrenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PingjiajiazhengrenyuanVO> selectListVO(Wrapper<PingjiajiazhengrenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PingjiajiazhengrenyuanVO selectVO(Wrapper<PingjiajiazhengrenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PingjiajiazhengrenyuanView> selectListView(Wrapper<PingjiajiazhengrenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingjiajiazhengrenyuanView selectView(Wrapper<PingjiajiazhengrenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
