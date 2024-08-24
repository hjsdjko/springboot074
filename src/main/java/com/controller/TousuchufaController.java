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

import com.entity.TousuchufaEntity;
import com.entity.view.TousuchufaView;

import com.service.TousuchufaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 投诉处罚
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@RestController
@RequestMapping("/tousuchufa")
public class TousuchufaController {
    @Autowired
    private TousuchufaService tousuchufaService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TousuchufaEntity tousuchufa,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangzhu")) {
			tousuchufa.setFangzhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhengrenyuan")) {
			tousuchufa.setJiazhengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhenggongsi")) {
			tousuchufa.setGongsizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TousuchufaEntity> ew = new EntityWrapper<TousuchufaEntity>();

		PageUtils page = tousuchufaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousuchufa), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TousuchufaEntity tousuchufa, 
		HttpServletRequest request){
        EntityWrapper<TousuchufaEntity> ew = new EntityWrapper<TousuchufaEntity>();

		PageUtils page = tousuchufaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tousuchufa), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TousuchufaEntity tousuchufa){
       	EntityWrapper<TousuchufaEntity> ew = new EntityWrapper<TousuchufaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tousuchufa, "tousuchufa")); 
        return R.ok().put("data", tousuchufaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TousuchufaEntity tousuchufa){
        EntityWrapper< TousuchufaEntity> ew = new EntityWrapper< TousuchufaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tousuchufa, "tousuchufa")); 
		TousuchufaView tousuchufaView =  tousuchufaService.selectView(ew);
		return R.ok("查询投诉处罚成功").put("data", tousuchufaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TousuchufaEntity tousuchufa = tousuchufaService.selectById(id);
        return R.ok().put("data", tousuchufa);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TousuchufaEntity tousuchufa = tousuchufaService.selectById(id);
        return R.ok().put("data", tousuchufa);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增投诉处罚") 
    public R save(@RequestBody TousuchufaEntity tousuchufa, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tousuchufa);
        tousuchufaService.insert(tousuchufa);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增投诉处罚")
    @RequestMapping("/add")
    public R add(@RequestBody TousuchufaEntity tousuchufa, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tousuchufa);
        tousuchufaService.insert(tousuchufa);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改投诉处罚")
    public R update(@RequestBody TousuchufaEntity tousuchufa, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tousuchufa);
        tousuchufaService.updateById(tousuchufa);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除投诉处罚")
    public R delete(@RequestBody Long[] ids){
        tousuchufaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
