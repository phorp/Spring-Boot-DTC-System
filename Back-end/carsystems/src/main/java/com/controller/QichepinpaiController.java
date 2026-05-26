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

import com.entity.QichepinpaiEntity;
import com.entity.view.QichepinpaiView;

import com.service.QichepinpaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 汽车品牌
 * 后端接口
 */
@RestController
@RequestMapping("/qichepinpai")
public class QichepinpaiController {
    @Autowired
    private QichepinpaiService qichepinpaiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QichepinpaiEntity qichepinpai,
		HttpServletRequest request){
        EntityWrapper<QichepinpaiEntity> ew = new EntityWrapper<QichepinpaiEntity>();

		PageUtils page = qichepinpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qichepinpai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QichepinpaiEntity qichepinpai, 
		HttpServletRequest request){
        EntityWrapper<QichepinpaiEntity> ew = new EntityWrapper<QichepinpaiEntity>();

		PageUtils page = qichepinpaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qichepinpai), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QichepinpaiEntity qichepinpai){
       	EntityWrapper<QichepinpaiEntity> ew = new EntityWrapper<QichepinpaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qichepinpai, "qichepinpai")); 
        return R.ok().put("data", qichepinpaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QichepinpaiEntity qichepinpai){
        EntityWrapper< QichepinpaiEntity> ew = new EntityWrapper< QichepinpaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qichepinpai, "qichepinpai")); 
		QichepinpaiView qichepinpaiView =  qichepinpaiService.selectView(ew);
		return R.ok("查询汽车品牌成功").put("data", qichepinpaiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QichepinpaiEntity qichepinpai = qichepinpaiService.selectById(id);
        return R.ok().put("data", qichepinpai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QichepinpaiEntity qichepinpai = qichepinpaiService.selectById(id);
        return R.ok().put("data", qichepinpai);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QichepinpaiEntity qichepinpai, HttpServletRequest request){
        if(qichepinpaiService.selectCount(new EntityWrapper<QichepinpaiEntity>().eq("qichepinpai", qichepinpai.getQichepinpai()))>0) {
            return R.error("汽车品牌已存在");
        }
    	//ValidatorUtils.validateEntity(qichepinpai);
        qichepinpaiService.insert(qichepinpai);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QichepinpaiEntity qichepinpai, HttpServletRequest request){
        if(qichepinpaiService.selectCount(new EntityWrapper<QichepinpaiEntity>().eq("qichepinpai", qichepinpai.getQichepinpai()))>0) {
            return R.error("汽车品牌已存在");
        }
    	//ValidatorUtils.validateEntity(qichepinpai);
        qichepinpaiService.insert(qichepinpai);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QichepinpaiEntity qichepinpai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qichepinpai);
        if(qichepinpaiService.selectCount(new EntityWrapper<QichepinpaiEntity>().ne("id", qichepinpai.getId()).eq("qichepinpai", qichepinpai.getQichepinpai()))>0) {
            return R.error("汽车品牌已存在");
        }
        qichepinpaiService.updateById(qichepinpai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qichepinpaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
