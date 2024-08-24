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


import com.dao.JiazhengqianyueDao;
import com.entity.JiazhengqianyueEntity;
import com.service.JiazhengqianyueService;
import com.entity.vo.JiazhengqianyueVO;
import com.entity.view.JiazhengqianyueView;

@Service("jiazhengqianyueService")
public class JiazhengqianyueServiceImpl extends ServiceImpl<JiazhengqianyueDao, JiazhengqianyueEntity> implements JiazhengqianyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiazhengqianyueEntity> page = this.selectPage(
                new Query<JiazhengqianyueEntity>(params).getPage(),
                new EntityWrapper<JiazhengqianyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiazhengqianyueEntity> wrapper) {
		  Page<JiazhengqianyueView> page =new Query<JiazhengqianyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiazhengqianyueVO> selectListVO(Wrapper<JiazhengqianyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiazhengqianyueVO selectVO(Wrapper<JiazhengqianyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiazhengqianyueView> selectListView(Wrapper<JiazhengqianyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiazhengqianyueView selectView(Wrapper<JiazhengqianyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
