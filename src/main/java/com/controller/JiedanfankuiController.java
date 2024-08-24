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

import com.entity.JiedanfankuiEntity;
import com.entity.view.JiedanfankuiView;

import com.service.JiedanfankuiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 接单反馈
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@RestController
@RequestMapping("/jiedanfankui")
public class JiedanfankuiController {
    @Autowired
    private JiedanfankuiService jiedanfankuiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiedanfankuiEntity jiedanfankui,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangzhu")) {
			jiedanfankui.setFangzhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhenggongsi")) {
			jiedanfankui.setGongsizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhengrenyuan")) {
			jiedanfankui.setJiazhengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiedanfankuiEntity> ew = new EntityWrapper<JiedanfankuiEntity>();

		PageUtils page = jiedanfankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiedanfankui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiedanfankuiEntity jiedanfankui, 
		HttpServletRequest request){
        EntityWrapper<JiedanfankuiEntity> ew = new EntityWrapper<JiedanfankuiEntity>();

		PageUtils page = jiedanfankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiedanfankui), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiedanfankuiEntity jiedanfankui){
       	EntityWrapper<JiedanfankuiEntity> ew = new EntityWrapper<JiedanfankuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiedanfankui, "jiedanfankui")); 
        return R.ok().put("data", jiedanfankuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiedanfankuiEntity jiedanfankui){
        EntityWrapper< JiedanfankuiEntity> ew = new EntityWrapper< JiedanfankuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiedanfankui, "jiedanfankui")); 
		JiedanfankuiView jiedanfankuiView =  jiedanfankuiService.selectView(ew);
		return R.ok("查询接单反馈成功").put("data", jiedanfankuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiedanfankuiEntity jiedanfankui = jiedanfankuiService.selectById(id);
        return R.ok().put("data", jiedanfankui);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiedanfankuiEntity jiedanfankui = jiedanfankuiService.selectById(id);
        return R.ok().put("data", jiedanfankui);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增接单反馈") 
    public R save(@RequestBody JiedanfankuiEntity jiedanfankui, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiedanfankui);
        jiedanfankuiService.insert(jiedanfankui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增接单反馈")
    @RequestMapping("/add")
    public R add(@RequestBody JiedanfankuiEntity jiedanfankui, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiedanfankui);
        jiedanfankuiService.insert(jiedanfankui);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改接单反馈")
    public R update(@RequestBody JiedanfankuiEntity jiedanfankui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiedanfankui);
        jiedanfankuiService.updateById(jiedanfankui);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除接单反馈")
    public R delete(@RequestBody Long[] ids){
        jiedanfankuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
