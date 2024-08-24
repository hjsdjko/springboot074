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

import com.entity.DiscussjiazhengrenyuanEntity;
import com.entity.view.DiscussjiazhengrenyuanView;

import com.service.DiscussjiazhengrenyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 家政人员评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 23:46:04
 */
@RestController
@RequestMapping("/discussjiazhengrenyuan")
public class DiscussjiazhengrenyuanController {
    @Autowired
    private DiscussjiazhengrenyuanService discussjiazhengrenyuanService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjiazhengrenyuanEntity discussjiazhengrenyuan,
		HttpServletRequest request){
        EntityWrapper<DiscussjiazhengrenyuanEntity> ew = new EntityWrapper<DiscussjiazhengrenyuanEntity>();

		PageUtils page = discussjiazhengrenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiazhengrenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjiazhengrenyuanEntity discussjiazhengrenyuan, 
		HttpServletRequest request){
        EntityWrapper<DiscussjiazhengrenyuanEntity> ew = new EntityWrapper<DiscussjiazhengrenyuanEntity>();

		PageUtils page = discussjiazhengrenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiazhengrenyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjiazhengrenyuanEntity discussjiazhengrenyuan){
       	EntityWrapper<DiscussjiazhengrenyuanEntity> ew = new EntityWrapper<DiscussjiazhengrenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjiazhengrenyuan, "discussjiazhengrenyuan")); 
        return R.ok().put("data", discussjiazhengrenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjiazhengrenyuanEntity discussjiazhengrenyuan){
        EntityWrapper< DiscussjiazhengrenyuanEntity> ew = new EntityWrapper< DiscussjiazhengrenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjiazhengrenyuan, "discussjiazhengrenyuan")); 
		DiscussjiazhengrenyuanView discussjiazhengrenyuanView =  discussjiazhengrenyuanService.selectView(ew);
		return R.ok("查询家政人员评论表成功").put("data", discussjiazhengrenyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjiazhengrenyuanEntity discussjiazhengrenyuan = discussjiazhengrenyuanService.selectById(id);
        return R.ok().put("data", discussjiazhengrenyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjiazhengrenyuanEntity discussjiazhengrenyuan = discussjiazhengrenyuanService.selectById(id);
        return R.ok().put("data", discussjiazhengrenyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增家政人员评论表") 
    public R save(@RequestBody DiscussjiazhengrenyuanEntity discussjiazhengrenyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiazhengrenyuan);
        discussjiazhengrenyuanService.insert(discussjiazhengrenyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增家政人员评论表")
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjiazhengrenyuanEntity discussjiazhengrenyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiazhengrenyuan);
        discussjiazhengrenyuanService.insert(discussjiazhengrenyuan);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussjiazhengrenyuanEntity discussjiazhengrenyuan = discussjiazhengrenyuanService.selectOne(new EntityWrapper<DiscussjiazhengrenyuanEntity>().eq("", username));
        return R.ok().put("data", discussjiazhengrenyuan);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussjiazhengrenyuanEntity discussjiazhengrenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjiazhengrenyuan);
        discussjiazhengrenyuanService.updateById(discussjiazhengrenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除家政人员评论表")
    public R delete(@RequestBody Long[] ids){
        discussjiazhengrenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussjiazhengrenyuanEntity discussjiazhengrenyuan, HttpServletRequest request,String pre){
        EntityWrapper<DiscussjiazhengrenyuanEntity> ew = new EntityWrapper<DiscussjiazhengrenyuanEntity>();
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
		PageUtils page = discussjiazhengrenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiazhengrenyuan), params), params));
        return R.ok().put("data", page);
    }










}
