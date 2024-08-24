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


import com.dao.DiscussjiazhenggongsiDao;
import com.entity.DiscussjiazhenggongsiEntity;
import com.service.DiscussjiazhenggongsiService;
import com.entity.vo.DiscussjiazhenggongsiVO;
import com.entity.view.DiscussjiazhenggongsiView;

@Service("discussjiazhenggongsiService")
public class DiscussjiazhenggongsiServiceImpl extends ServiceImpl<DiscussjiazhenggongsiDao, DiscussjiazhenggongsiEntity> implements DiscussjiazhenggongsiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiazhenggongsiEntity> page = this.selectPage(
                new Query<DiscussjiazhenggongsiEntity>(params).getPage(),
                new EntityWrapper<DiscussjiazhenggongsiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiazhenggongsiEntity> wrapper) {
		  Page<DiscussjiazhenggongsiView> page =new Query<DiscussjiazhenggongsiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussjiazhenggongsiVO> selectListVO(Wrapper<DiscussjiazhenggongsiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiazhenggongsiVO selectVO(Wrapper<DiscussjiazhenggongsiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiazhenggongsiView> selectListView(Wrapper<DiscussjiazhenggongsiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiazhenggongsiView selectView(Wrapper<DiscussjiazhenggongsiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
