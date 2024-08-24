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

import com.entity.FangzhuEntity;
import com.entity.view.FangzhuView;

import com.service.FangzhuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 房主
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@RestController
@RequestMapping("/fangzhu")
public class FangzhuController {
    @Autowired
    private FangzhuService fangzhuService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		FangzhuEntity u = fangzhuService.selectOne(new EntityWrapper<FangzhuEntity>().eq("fangzhuzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"fangzhu",  "房主" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody FangzhuEntity fangzhu){
    	//ValidatorUtils.validateEntity(fangzhu);
    	FangzhuEntity u = fangzhuService.selectOne(new EntityWrapper<FangzhuEntity>().eq("fangzhuzhanghao", fangzhu.getFangzhuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		fangzhu.setId(uId);
        fangzhuService.insert(fangzhu);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        FangzhuEntity u = fangzhuService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	FangzhuEntity u = fangzhuService.selectOne(new EntityWrapper<FangzhuEntity>().eq("fangzhuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        fangzhuService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangzhuEntity fangzhu,
		HttpServletRequest request){
        EntityWrapper<FangzhuEntity> ew = new EntityWrapper<FangzhuEntity>();

		PageUtils page = fangzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangzhu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangzhuEntity fangzhu, 
		HttpServletRequest request){
        EntityWrapper<FangzhuEntity> ew = new EntityWrapper<FangzhuEntity>();

		PageUtils page = fangzhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangzhu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangzhuEntity fangzhu){
       	EntityWrapper<FangzhuEntity> ew = new EntityWrapper<FangzhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangzhu, "fangzhu")); 
        return R.ok().put("data", fangzhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangzhuEntity fangzhu){
        EntityWrapper< FangzhuEntity> ew = new EntityWrapper< FangzhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangzhu, "fangzhu")); 
		FangzhuView fangzhuView =  fangzhuService.selectView(ew);
		return R.ok("查询房主成功").put("data", fangzhuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangzhuEntity fangzhu = fangzhuService.selectById(id);
        return R.ok().put("data", fangzhu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangzhuEntity fangzhu = fangzhuService.selectById(id);
        return R.ok().put("data", fangzhu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增房主") 
    public R save(@RequestBody FangzhuEntity fangzhu, HttpServletRequest request){
        if(fangzhuService.selectCount(new EntityWrapper<FangzhuEntity>().eq("fangzhuzhanghao", fangzhu.getFangzhuzhanghao()))>0) {
            return R.error("房主账号已存在");
        }
    	fangzhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangzhu);
    	FangzhuEntity u = fangzhuService.selectOne(new EntityWrapper<FangzhuEntity>().eq("fangzhuzhanghao", fangzhu.getFangzhuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		fangzhu.setId(new Date().getTime());
        fangzhuService.insert(fangzhu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增房主")
    @RequestMapping("/add")
    public R add(@RequestBody FangzhuEntity fangzhu, HttpServletRequest request){
        if(fangzhuService.selectCount(new EntityWrapper<FangzhuEntity>().eq("fangzhuzhanghao", fangzhu.getFangzhuzhanghao()))>0) {
            return R.error("房主账号已存在");
        }
    	fangzhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangzhu);
    	FangzhuEntity u = fangzhuService.selectOne(new EntityWrapper<FangzhuEntity>().eq("fangzhuzhanghao", fangzhu.getFangzhuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		fangzhu.setId(new Date().getTime());
        fangzhuService.insert(fangzhu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改房主")
    public R update(@RequestBody FangzhuEntity fangzhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangzhu);
        if(fangzhuService.selectCount(new EntityWrapper<FangzhuEntity>().ne("id", fangzhu.getId()).eq("fangzhuzhanghao", fangzhu.getFangzhuzhanghao()))>0) {
            return R.error("房主账号已存在");
        }
        fangzhuService.updateById(fangzhu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除房主")
    public R delete(@RequestBody Long[] ids){
        fangzhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
