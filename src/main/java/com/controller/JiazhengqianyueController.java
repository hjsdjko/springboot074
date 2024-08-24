package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.JiazhengqianyueEntity;
import com.entity.view.JiazhengqianyueView;

import com.service.JiazhengqianyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 家政签约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@RestController
@RequestMapping("/jiazhengqianyue")
public class JiazhengqianyueController {
    @Autowired
    private JiazhengqianyueService jiazhengqianyueService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiazhengqianyueEntity jiazhengqianyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiazhengrenyuan")) {
			jiazhengqianyue.setJiazhengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiazhengqianyueEntity> ew = new EntityWrapper<JiazhengqianyueEntity>();

		PageUtils page = jiazhengqianyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiazhengqianyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiazhengqianyueEntity jiazhengqianyue, 
		HttpServletRequest request){
        EntityWrapper<JiazhengqianyueEntity> ew = new EntityWrapper<JiazhengqianyueEntity>();

		PageUtils page = jiazhengqianyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiazhengqianyue), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiazhengqianyueEntity jiazhengqianyue){
       	EntityWrapper<JiazhengqianyueEntity> ew = new EntityWrapper<JiazhengqianyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiazhengqianyue, "jiazhengqianyue")); 
        return R.ok().put("data", jiazhengqianyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiazhengqianyueEntity jiazhengqianyue){
        EntityWrapper< JiazhengqianyueEntity> ew = new EntityWrapper< JiazhengqianyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiazhengqianyue, "jiazhengqianyue")); 
		JiazhengqianyueView jiazhengqianyueView =  jiazhengqianyueService.selectView(ew);
		return R.ok("查询家政签约成功").put("data", jiazhengqianyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiazhengqianyueEntity jiazhengqianyue = jiazhengqianyueService.selectById(id);
        return R.ok().put("data", jiazhengqianyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiazhengqianyueEntity jiazhengqianyue = jiazhengqianyueService.selectById(id);
        return R.ok().put("data", jiazhengqianyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增家政签约") 
    public R save(@RequestBody JiazhengqianyueEntity jiazhengqianyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiazhengqianyue);
        jiazhengqianyueService.insert(jiazhengqianyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增家政签约")
    @RequestMapping("/add")
    public R add(@RequestBody JiazhengqianyueEntity jiazhengqianyue, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiazhengqianyue);
        jiazhengqianyueService.insert(jiazhengqianyue);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改家政签约")
    public R update(@RequestBody JiazhengqianyueEntity jiazhengqianyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiazhengqianyue);
        jiazhengqianyueService.updateById(jiazhengqianyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除家政签约")
    public R delete(@RequestBody Long[] ids){
        jiazhengqianyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
