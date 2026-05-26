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

import com.entity.RukujiluEntity;
import com.entity.view.RukujiluView;

import com.service.RukujiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 入库记录
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-22 08:42:00
 */
@RestController
@RequestMapping("/rukujilu")
public class RukujiluController {
    @Autowired
    private RukujiluService rukujiluService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RukujiluEntity rukujilu,
		HttpServletRequest request){
        EntityWrapper<RukujiluEntity> ew = new EntityWrapper<RukujiluEntity>();

		PageUtils page = rukujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rukujilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RukujiluEntity rukujilu, 
		HttpServletRequest request){
        EntityWrapper<RukujiluEntity> ew = new EntityWrapper<RukujiluEntity>();

		PageUtils page = rukujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, rukujilu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RukujiluEntity rukujilu){
       	EntityWrapper<RukujiluEntity> ew = new EntityWrapper<RukujiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( rukujilu, "rukujilu")); 
        return R.ok().put("data", rukujiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RukujiluEntity rukujilu){
        EntityWrapper< RukujiluEntity> ew = new EntityWrapper< RukujiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( rukujilu, "rukujilu")); 
		RukujiluView rukujiluView =  rukujiluService.selectView(ew);
		return R.ok("查询入库记录成功").put("data", rukujiluView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RukujiluEntity rukujilu = rukujiluService.selectById(id);
        return R.ok().put("data", rukujilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RukujiluEntity rukujilu = rukujiluService.selectById(id);
        return R.ok().put("data", rukujilu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RukujiluEntity rukujilu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(rukujilu);
        rukujiluService.insert(rukujilu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RukujiluEntity rukujilu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(rukujilu);
        rukujiluService.insert(rukujilu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RukujiluEntity rukujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(rukujilu);
        rukujiluService.updateById(rukujilu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        rukujiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
