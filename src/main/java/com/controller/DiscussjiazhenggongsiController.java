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

import com.entity.DiscussjiazhenggongsiEntity;
import com.entity.view.DiscussjiazhenggongsiView;

import com.service.DiscussjiazhenggongsiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 家政公司评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 23:46:04
 */
@RestController
@RequestMapping("/discussjiazhenggongsi")
public class DiscussjiazhenggongsiController {
    @Autowired
    private DiscussjiazhenggongsiService discussjiazhenggongsiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjiazhenggongsiEntity discussjiazhenggongsi,
		HttpServletRequest request){
        EntityWrapper<DiscussjiazhenggongsiEntity> ew = new EntityWrapper<DiscussjiazhenggongsiEntity>();

		PageUtils page = discussjiazhenggongsiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiazhenggongsi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjiazhenggongsiEntity discussjiazhenggongsi, 
		HttpServletRequest request){
        EntityWrapper<DiscussjiazhenggongsiEntity> ew = new EntityWrapper<DiscussjiazhenggongsiEntity>();

		PageUtils page = discussjiazhenggongsiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiazhenggongsi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjiazhenggongsiEntity discussjiazhenggongsi){
       	EntityWrapper<DiscussjiazhenggongsiEntity> ew = new EntityWrapper<DiscussjiazhenggongsiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjiazhenggongsi, "discussjiazhenggongsi")); 
        return R.ok().put("data", discussjiazhenggongsiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjiazhenggongsiEntity discussjiazhenggongsi){
        EntityWrapper< DiscussjiazhenggongsiEntity> ew = new EntityWrapper< DiscussjiazhenggongsiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjiazhenggongsi, "discussjiazhenggongsi")); 
		DiscussjiazhenggongsiView discussjiazhenggongsiView =  discussjiazhenggongsiService.selectView(ew);
		return R.ok("查询家政公司评论表成功").put("data", discussjiazhenggongsiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjiazhenggongsiEntity discussjiazhenggongsi = discussjiazhenggongsiService.selectById(id);
        return R.ok().put("data", discussjiazhenggongsi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjiazhenggongsiEntity discussjiazhenggongsi = discussjiazhenggongsiService.selectById(id);
        return R.ok().put("data", discussjiazhenggongsi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增家政公司评论表") 
    public R save(@RequestBody DiscussjiazhenggongsiEntity discussjiazhenggongsi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiazhenggongsi);
        discussjiazhenggongsiService.insert(discussjiazhenggongsi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增家政公司评论表")
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjiazhenggongsiEntity discussjiazhenggongsi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiazhenggongsi);
        discussjiazhenggongsiService.insert(discussjiazhenggongsi);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussjiazhenggongsiEntity discussjiazhenggongsi = discussjiazhenggongsiService.selectOne(new EntityWrapper<DiscussjiazhenggongsiEntity>().eq("", username));
        return R.ok().put("data", discussjiazhenggongsi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussjiazhenggongsiEntity discussjiazhenggongsi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjiazhenggongsi);
        discussjiazhenggongsiService.updateById(discussjiazhenggongsi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除家政公司评论表")
    public R delete(@RequestBody Long[] ids){
        discussjiazhenggongsiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussjiazhenggongsiEntity discussjiazhenggongsi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussjiazhenggongsiEntity> ew = new EntityWrapper<DiscussjiazhenggongsiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussjiazhenggongsiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiazhenggongsi), params), params));
        return R.ok().put("data", page);
    }










}
