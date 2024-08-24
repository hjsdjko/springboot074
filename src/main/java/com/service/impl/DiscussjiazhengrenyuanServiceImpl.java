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


import com.dao.DiscussjiazhengrenyuanDao;
import com.entity.DiscussjiazhengrenyuanEntity;
import com.service.DiscussjiazhengrenyuanService;
import com.entity.vo.DiscussjiazhengrenyuanVO;
import com.entity.view.DiscussjiazhengrenyuanView;

@Service("discussjiazhengrenyuanService")
public class DiscussjiazhengrenyuanServiceImpl extends ServiceImpl<DiscussjiazhengrenyuanDao, DiscussjiazhengrenyuanEntity> implements DiscussjiazhengrenyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiazhengrenyuanEntity> page = this.selectPage(
                new Query<DiscussjiazhengrenyuanEntity>(params).getPage(),
                new EntityWrapper<DiscussjiazhengrenyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiazhengrenyuanEntity> wrapper) {
		  Page<DiscussjiazhengrenyuanView> page =new Query<DiscussjiazhengrenyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussjiazhengrenyuanVO> selectListVO(Wrapper<DiscussjiazhengrenyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiazhengrenyuanVO selectVO(Wrapper<DiscussjiazhengrenyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiazhengrenyuanView> selectListView(Wrapper<DiscussjiazhengrenyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiazhengrenyuanView selectView(Wrapper<DiscussjiazhengrenyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
