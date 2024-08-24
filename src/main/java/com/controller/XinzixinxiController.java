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

import com.entity.XinzixinxiEntity;
import com.entity.view.XinzixinxiView;

import com.service.XinzixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 薪资信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@RestController
@RequestMapping("/xinzixinxi")
public class XinzixinxiController {
    @Autowired
    private XinzixinxiService xinzixinxiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinzixinxiEntity xinzixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiazhengrenyuan")) {
			xinzixinxi.setJiazhengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhenggongsig")) {
			xinzixinxi.setGongsizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XinzixinxiEntity> ew = new EntityWrapper<XinzixinxiEntity>();

		PageUtils page = xinzixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinzixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinzixinxiEntity xinzixinxi, 
		HttpServletRequest request){
        EntityWrapper<XinzixinxiEntity> ew = new EntityWrapper<XinzixinxiEntity>();

		PageUtils page = xinzixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinzixinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinzixinxiEntity xinzixinxi){
       	EntityWrapper<XinzixinxiEntity> ew = new EntityWrapper<XinzixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinzixinxi, "xinzixinxi")); 
        return R.ok().put("data", xinzixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinzixinxiEntity xinzixinxi){
        EntityWrapper< XinzixinxiEntity> ew = new EntityWrapper< XinzixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinzixinxi, "xinzixinxi")); 
		XinzixinxiView xinzixinxiView =  xinzixinxiService.selectView(ew);
		return R.ok("查询薪资信息成功").put("data", xinzixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinzixinxiEntity xinzixinxi = xinzixinxiService.selectById(id);
        return R.ok().put("data", xinzixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinzixinxiEntity xinzixinxi = xinzixinxiService.selectById(id);
        return R.ok().put("data", xinzixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增薪资信息") 
    public R save(@RequestBody XinzixinxiEntity xinzixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xinzixinxi);
        xinzixinxiService.insert(xinzixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增薪资信息")
    @RequestMapping("/add")
    public R add(@RequestBody XinzixinxiEntity xinzixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xinzixinxi);
        xinzixinxiService.insert(xinzixinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改薪资信息")
    public R update(@RequestBody XinzixinxiEntity xinzixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinzixinxi);
        xinzixinxiService.updateById(xinzixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除薪资信息")
    public R delete(@RequestBody Long[] ids){
        xinzixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
