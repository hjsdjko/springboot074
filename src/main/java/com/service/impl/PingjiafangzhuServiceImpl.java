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


import com.dao.PingjiafangzhuDao;
import com.entity.PingjiafangzhuEntity;
import com.service.PingjiafangzhuService;
import com.entity.vo.PingjiafangzhuVO;
import com.entity.view.PingjiafangzhuView;

@Service("pingjiafangzhuService")
public class PingjiafangzhuServiceImpl extends ServiceImpl<PingjiafangzhuDao, PingjiafangzhuEntity> implements PingjiafangzhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingjiafangzhuEntity> page = this.selectPage(
                new Query<PingjiafangzhuEntity>(params).getPage(),
                new EntityWrapper<PingjiafangzhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingjiafangzhuEntity> wrapper) {
		  Page<PingjiafangzhuView> page =new Query<PingjiafangzhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PingjiafangzhuVO> selectListVO(Wrapper<PingjiafangzhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PingjiafangzhuVO selectVO(Wrapper<PingjiafangzhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PingjiafangzhuView> selectListView(Wrapper<PingjiafangzhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingjiafangzhuView selectView(Wrapper<PingjiafangzhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
