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

import com.entity.PingjiajiazhengrenyuanEntity;
import com.entity.view.PingjiajiazhengrenyuanView;

import com.service.PingjiajiazhengrenyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 评价家政人员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@RestController
@RequestMapping("/pingjiajiazhengrenyuan")
public class PingjiajiazhengrenyuanController {
    @Autowired
    private PingjiajiazhengrenyuanService pingjiajiazhengrenyuanService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PingjiajiazhengrenyuanEntity pingjiajiazhengrenyuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangzhu")) {
			pingjiajiazhengrenyuan.setFangzhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhenggongsi")) {
			pingjiajiazhengrenyuan.setGongsizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhengrenyuan")) {
			pingjiajiazhengrenyuan.setJiazhengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PingjiajiazhengrenyuanEntity> ew = new EntityWrapper<PingjiajiazhengrenyuanEntity>();

		PageUtils page = pingjiajiazhengrenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingjiajiazhengrenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PingjiajiazhengrenyuanEntity pingjiajiazhengrenyuan, 
		HttpServletRequest request){
        EntityWrapper<PingjiajiazhengrenyuanEntity> ew = new EntityWrapper<PingjiajiazhengrenyuanEntity>();

		PageUtils page = pingjiajiazhengrenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingjiajiazhengrenyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PingjiajiazhengrenyuanEntity pingjiajiazhengrenyuan){
       	EntityWrapper<PingjiajiazhengrenyuanEntity> ew = new EntityWrapper<PingjiajiazhengrenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pingjiajiazhengrenyuan, "pingjiajiazhengrenyuan")); 
        return R.ok().put("data", pingjiajiazhengrenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PingjiajiazhengrenyuanEntity pingjiajiazhengrenyuan){
        EntityWrapper< PingjiajiazhengrenyuanEntity> ew = new EntityWrapper< PingjiajiazhengrenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pingjiajiazhengrenyuan, "pingjiajiazhengrenyuan")); 
		PingjiajiazhengrenyuanView pingjiajiazhengrenyuanView =  pingjiajiazhengrenyuanService.selectView(ew);
		return R.ok("查询评价家政人员成功").put("data", pingjiajiazhengrenyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PingjiajiazhengrenyuanEntity pingjiajiazhengrenyuan = pingjiajiazhengrenyuanService.selectById(id);
        return R.ok().put("data", pingjiajiazhengrenyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PingjiajiazhengrenyuanEntity pingjiajiazhengrenyuan = pingjiajiazhengrenyuanService.selectById(id);
        return R.ok().put("data", pingjiajiazhengrenyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增评价家政人员") 
    public R save(@RequestBody PingjiajiazhengrenyuanEntity pingjiajiazhengrenyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(pingjiajiazhengrenyuan);
        pingjiajiazhengrenyuanService.insert(pingjiajiazhengrenyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增评价家政人员")
    @RequestMapping("/add")
    public R add(@RequestBody PingjiajiazhengrenyuanEntity pingjiajiazhengrenyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(pingjiajiazhengrenyuan);
        pingjiajiazhengrenyuanService.insert(pingjiajiazhengrenyuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改评价家政人员")
    public R update(@RequestBody PingjiajiazhengrenyuanEntity pingjiajiazhengrenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pingjiajiazhengrenyuan);
        pingjiajiazhengrenyuanService.updateById(pingjiajiazhengrenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除评价家政人员")
    public R delete(@RequestBody Long[] ids){
        pingjiajiazhengrenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
