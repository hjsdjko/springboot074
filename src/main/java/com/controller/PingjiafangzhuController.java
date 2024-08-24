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

import com.entity.PingjiafangzhuEntity;
import com.entity.view.PingjiafangzhuView;

import com.service.PingjiafangzhuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 评价房主
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@RestController
@RequestMapping("/pingjiafangzhu")
public class PingjiafangzhuController {
    @Autowired
    private PingjiafangzhuService pingjiafangzhuService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PingjiafangzhuEntity pingjiafangzhu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangzhu")) {
			pingjiafangzhu.setFangzhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhenggongsi")) {
			pingjiafangzhu.setGongsizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhengrenyuan")) {
			pingjiafangzhu.setJiazhengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PingjiafangzhuEntity> ew = new EntityWrapper<PingjiafangzhuEntity>();

		PageUtils page = pingjiafangzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingjiafangzhu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PingjiafangzhuEntity pingjiafangzhu, 
		HttpServletRequest request){
        EntityWrapper<PingjiafangzhuEntity> ew = new EntityWrapper<PingjiafangzhuEntity>();

		PageUtils page = pingjiafangzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingjiafangzhu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PingjiafangzhuEntity pingjiafangzhu){
       	EntityWrapper<PingjiafangzhuEntity> ew = new EntityWrapper<PingjiafangzhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pingjiafangzhu, "pingjiafangzhu")); 
        return R.ok().put("data", pingjiafangzhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PingjiafangzhuEntity pingjiafangzhu){
        EntityWrapper< PingjiafangzhuEntity> ew = new EntityWrapper< PingjiafangzhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pingjiafangzhu, "pingjiafangzhu")); 
		PingjiafangzhuView pingjiafangzhuView =  pingjiafangzhuService.selectView(ew);
		return R.ok("查询评价房主成功").put("data", pingjiafangzhuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PingjiafangzhuEntity pingjiafangzhu = pingjiafangzhuService.selectById(id);
        return R.ok().put("data", pingjiafangzhu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PingjiafangzhuEntity pingjiafangzhu = pingjiafangzhuService.selectById(id);
        return R.ok().put("data", pingjiafangzhu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增评价房主") 
    public R save(@RequestBody PingjiafangzhuEntity pingjiafangzhu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(pingjiafangzhu);
        pingjiafangzhuService.insert(pingjiafangzhu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增评价房主")
    @RequestMapping("/add")
    public R add(@RequestBody PingjiafangzhuEntity pingjiafangzhu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(pingjiafangzhu);
        pingjiafangzhuService.insert(pingjiafangzhu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改评价房主")
    public R update(@RequestBody PingjiafangzhuEntity pingjiafangzhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pingjiafangzhu);
        pingjiafangzhuService.updateById(pingjiafangzhu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除评价房主")
    public R delete(@RequestBody Long[] ids){
        pingjiafangzhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
