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

import com.entity.PeijianjiluEntity;
import com.entity.view.PeijianjiluView;

import com.service.PeijianjiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 配件记录
 * 后端接口
 */
@RestController
@RequestMapping("/peijianjilu")
public class PeijianjiluController {
    @Autowired
    private PeijianjiluService peijianjiluService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeijianjiluEntity peijianjilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("weixiugongren")) {
			peijianjilu.setWeixiugonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			peijianjilu.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PeijianjiluEntity> ew = new EntityWrapper<PeijianjiluEntity>();

		PageUtils page = peijianjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peijianjilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeijianjiluEntity peijianjilu, 
		HttpServletRequest request){
        EntityWrapper<PeijianjiluEntity> ew = new EntityWrapper<PeijianjiluEntity>();

		PageUtils page = peijianjiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peijianjilu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeijianjiluEntity peijianjilu){
       	EntityWrapper<PeijianjiluEntity> ew = new EntityWrapper<PeijianjiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peijianjilu, "peijianjilu")); 
        return R.ok().put("data", peijianjiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeijianjiluEntity peijianjilu){
        EntityWrapper< PeijianjiluEntity> ew = new EntityWrapper< PeijianjiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peijianjilu, "peijianjilu")); 
		PeijianjiluView peijianjiluView =  peijianjiluService.selectView(ew);
		return R.ok("查询配件记录成功").put("data", peijianjiluView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeijianjiluEntity peijianjilu = peijianjiluService.selectById(id);
        return R.ok().put("data", peijianjilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeijianjiluEntity peijianjilu = peijianjiluService.selectById(id);
        return R.ok().put("data", peijianjilu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeijianjiluEntity peijianjilu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(peijianjilu);
        peijianjiluService.insert(peijianjilu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeijianjiluEntity peijianjilu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(peijianjilu);
        peijianjiluService.insert(peijianjilu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PeijianjiluEntity peijianjilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peijianjilu);
        peijianjiluService.updateById(peijianjilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peijianjiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
