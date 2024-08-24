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

import com.entity.FuwuxinxiEntity;
import com.entity.view.FuwuxinxiView;

import com.service.FuwuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 服务信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-07 23:46:03
 */
@RestController
@RequestMapping("/fuwuxinxi")
public class FuwuxinxiController {
    @Autowired
    private FuwuxinxiService fuwuxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwuxinxiEntity fuwuxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangzhu")) {
			fuwuxinxi.setFangzhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FuwuxinxiEntity> ew = new EntityWrapper<FuwuxinxiEntity>();

		PageUtils page = fuwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FuwuxinxiEntity fuwuxinxi, 
		HttpServletRequest request){
        EntityWrapper<FuwuxinxiEntity> ew = new EntityWrapper<FuwuxinxiEntity>();

		PageUtils page = fuwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwuxinxiEntity fuwuxinxi){
       	EntityWrapper<FuwuxinxiEntity> ew = new EntityWrapper<FuwuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwuxinxi, "fuwuxinxi")); 
        return R.ok().put("data", fuwuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwuxinxiEntity fuwuxinxi){
        EntityWrapper< FuwuxinxiEntity> ew = new EntityWrapper< FuwuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwuxinxi, "fuwuxinxi")); 
		FuwuxinxiView fuwuxinxiView =  fuwuxinxiService.selectView(ew);
		return R.ok("查询服务信息成功").put("data", fuwuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwuxinxiEntity fuwuxinxi = fuwuxinxiService.selectById(id);
		fuwuxinxi.setClicknum(fuwuxinxi.getClicknum()+1);
		fuwuxinxi.setClicktime(new Date());
		fuwuxinxiService.updateById(fuwuxinxi);
        fuwuxinxi = fuwuxinxiService.selectView(new EntityWrapper<FuwuxinxiEntity>().eq("id", id));
        return R.ok().put("data", fuwuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwuxinxiEntity fuwuxinxi = fuwuxinxiService.selectById(id);
		fuwuxinxi.setClicknum(fuwuxinxi.getClicknum()+1);
		fuwuxinxi.setClicktime(new Date());
		fuwuxinxiService.updateById(fuwuxinxi);
        fuwuxinxi = fuwuxinxiService.selectView(new EntityWrapper<FuwuxinxiEntity>().eq("id", id));
        return R.ok().put("data", fuwuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增服务信息") 
    public R save(@RequestBody FuwuxinxiEntity fuwuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fuwuxinxi);
        fuwuxinxiService.insert(fuwuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增服务信息")
    @RequestMapping("/add")
    public R add(@RequestBody FuwuxinxiEntity fuwuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fuwuxinxi);
        fuwuxinxiService.insert(fuwuxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改服务信息")
    public R update(@RequestBody FuwuxinxiEntity fuwuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwuxinxi);
        fuwuxinxiService.updateById(fuwuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除服务信息")
    public R delete(@RequestBody Long[] ids){
        fuwuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,FuwuxinxiEntity fuwuxinxi, HttpServletRequest request,String pre){
        EntityWrapper<FuwuxinxiEntity> ew = new EntityWrapper<FuwuxinxiEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = fuwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuxinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,FuwuxinxiEntity fuwuxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "fuwuleixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "fuwuxinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<FuwuxinxiEntity> fuwuxinxiList = new ArrayList<FuwuxinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                fuwuxinxiList.addAll(fuwuxinxiService.selectList(new EntityWrapper<FuwuxinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<FuwuxinxiEntity> ew = new EntityWrapper<FuwuxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = fuwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuxinxi), params), params));
        List<FuwuxinxiEntity> pageList = (List<FuwuxinxiEntity>)page.getList();
        if(fuwuxinxiList.size()<limit) {
            int toAddNum = (limit-fuwuxinxiList.size())<=pageList.size()?(limit-fuwuxinxiList.size()):pageList.size();
            for(FuwuxinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(FuwuxinxiEntity o2 : fuwuxinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    fuwuxinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(fuwuxinxiList.size()>limit) {
            fuwuxinxiList = fuwuxinxiList.subList(0, limit);
        }
        page.setList(fuwuxinxiList);
        return R.ok().put("data", page);
    }








}
