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

import com.entity.FuwupaidanEntity;
import com.entity.view.FuwupaidanView;

import com.service.FuwupaidanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 服务派单
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@RestController
@RequestMapping("/fuwupaidan")
public class FuwupaidanController {
    @Autowired
    private FuwupaidanService fuwupaidanService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwupaidanEntity fuwupaidan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangzhu")) {
			fuwupaidan.setFangzhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhenggongsi")) {
			fuwupaidan.setGongsizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhengrenyuan")) {
			fuwupaidan.setJiazhengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FuwupaidanEntity> ew = new EntityWrapper<FuwupaidanEntity>();

		PageUtils page = fuwupaidanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwupaidan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FuwupaidanEntity fuwupaidan, 
		HttpServletRequest request){
        EntityWrapper<FuwupaidanEntity> ew = new EntityWrapper<FuwupaidanEntity>();

		PageUtils page = fuwupaidanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwupaidan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwupaidanEntity fuwupaidan){
       	EntityWrapper<FuwupaidanEntity> ew = new EntityWrapper<FuwupaidanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwupaidan, "fuwupaidan")); 
        return R.ok().put("data", fuwupaidanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwupaidanEntity fuwupaidan){
        EntityWrapper< FuwupaidanEntity> ew = new EntityWrapper< FuwupaidanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwupaidan, "fuwupaidan")); 
		FuwupaidanView fuwupaidanView =  fuwupaidanService.selectView(ew);
		return R.ok("查询服务派单成功").put("data", fuwupaidanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwupaidanEntity fuwupaidan = fuwupaidanService.selectById(id);
        return R.ok().put("data", fuwupaidan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwupaidanEntity fuwupaidan = fuwupaidanService.selectById(id);
        return R.ok().put("data", fuwupaidan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增服务派单") 
    public R save(@RequestBody FuwupaidanEntity fuwupaidan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fuwupaidan);
        fuwupaidanService.insert(fuwupaidan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增服务派单")
    @RequestMapping("/add")
    public R add(@RequestBody FuwupaidanEntity fuwupaidan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fuwupaidan);
        fuwupaidanService.insert(fuwupaidan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改服务派单")
    public R update(@RequestBody FuwupaidanEntity fuwupaidan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwupaidan);
        fuwupaidanService.updateById(fuwupaidan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除服务派单")
    public R delete(@RequestBody Long[] ids){
        fuwupaidanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
