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

import com.entity.PeijianfenleiEntity;
import com.entity.view.PeijianfenleiView;

import com.service.PeijianfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 配件分类
 * 后端接口
 */
@RestController
@RequestMapping("/peijianfenlei")
public class PeijianfenleiController {
    @Autowired
    private PeijianfenleiService peijianfenleiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeijianfenleiEntity peijianfenlei,
		HttpServletRequest request){
        EntityWrapper<PeijianfenleiEntity> ew = new EntityWrapper<PeijianfenleiEntity>();

		PageUtils page = peijianfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peijianfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeijianfenleiEntity peijianfenlei, 
		HttpServletRequest request){
        EntityWrapper<PeijianfenleiEntity> ew = new EntityWrapper<PeijianfenleiEntity>();

		PageUtils page = peijianfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peijianfenlei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeijianfenleiEntity peijianfenlei){
       	EntityWrapper<PeijianfenleiEntity> ew = new EntityWrapper<PeijianfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peijianfenlei, "peijianfenlei")); 
        return R.ok().put("data", peijianfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeijianfenleiEntity peijianfenlei){
        EntityWrapper< PeijianfenleiEntity> ew = new EntityWrapper< PeijianfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peijianfenlei, "peijianfenlei")); 
		PeijianfenleiView peijianfenleiView =  peijianfenleiService.selectView(ew);
		return R.ok("查询配件分类成功").put("data", peijianfenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeijianfenleiEntity peijianfenlei = peijianfenleiService.selectById(id);
        return R.ok().put("data", peijianfenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeijianfenleiEntity peijianfenlei = peijianfenleiService.selectById(id);
        return R.ok().put("data", peijianfenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeijianfenleiEntity peijianfenlei, HttpServletRequest request){
        if(peijianfenleiService.selectCount(new EntityWrapper<PeijianfenleiEntity>().eq("peijianfenlei", peijianfenlei.getPeijianfenlei()))>0) {
            return R.error("配件分类已存在");
        }
    	//ValidatorUtils.validateEntity(peijianfenlei);
        peijianfenleiService.insert(peijianfenlei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeijianfenleiEntity peijianfenlei, HttpServletRequest request){
        if(peijianfenleiService.selectCount(new EntityWrapper<PeijianfenleiEntity>().eq("peijianfenlei", peijianfenlei.getPeijianfenlei()))>0) {
            return R.error("配件分类已存在");
        }
    	//ValidatorUtils.validateEntity(peijianfenlei);
        peijianfenleiService.insert(peijianfenlei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeijianfenleiEntity peijianfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peijianfenlei);
        if(peijianfenleiService.selectCount(new EntityWrapper<PeijianfenleiEntity>().ne("id", peijianfenlei.getId()).eq("peijianfenlei", peijianfenlei.getPeijianfenlei()))>0) {
            return R.error("配件分类已存在");
        }
        peijianfenleiService.updateById(peijianfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peijianfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
