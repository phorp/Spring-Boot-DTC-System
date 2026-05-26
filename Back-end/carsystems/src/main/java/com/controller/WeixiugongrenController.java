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

import com.entity.WeixiugongrenEntity;
import com.entity.view.WeixiugongrenView;

import com.service.WeixiugongrenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修工人
 * 后端接口
 */
@RestController
@RequestMapping("/weixiugongren")
public class WeixiugongrenController {
    @Autowired
    private WeixiugongrenService weixiugongrenService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		WeixiugongrenEntity u = weixiugongrenService.selectOne(new EntityWrapper<WeixiugongrenEntity>().eq("weixiugonghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"weixiugongren",  "维修工人" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody WeixiugongrenEntity weixiugongren){
    	//ValidatorUtils.validateEntity(weixiugongren);
    	WeixiugongrenEntity u = weixiugongrenService.selectOne(new EntityWrapper<WeixiugongrenEntity>().eq("weixiugonghao", weixiugongren.getWeixiugonghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		weixiugongren.setId(uId);
        weixiugongrenService.insert(weixiugongren);
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
        WeixiugongrenEntity u = weixiugongrenService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	WeixiugongrenEntity u = weixiugongrenService.selectOne(new EntityWrapper<WeixiugongrenEntity>().eq("weixiugonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        weixiugongrenService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiugongrenEntity weixiugongren,
		HttpServletRequest request){
        EntityWrapper<WeixiugongrenEntity> ew = new EntityWrapper<WeixiugongrenEntity>();

		PageUtils page = weixiugongrenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiugongren), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiugongrenEntity weixiugongren, 
		HttpServletRequest request){
        EntityWrapper<WeixiugongrenEntity> ew = new EntityWrapper<WeixiugongrenEntity>();

		PageUtils page = weixiugongrenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiugongren), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiugongrenEntity weixiugongren){
       	EntityWrapper<WeixiugongrenEntity> ew = new EntityWrapper<WeixiugongrenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiugongren, "weixiugongren")); 
        return R.ok().put("data", weixiugongrenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiugongrenEntity weixiugongren){
        EntityWrapper< WeixiugongrenEntity> ew = new EntityWrapper< WeixiugongrenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiugongren, "weixiugongren")); 
		WeixiugongrenView weixiugongrenView =  weixiugongrenService.selectView(ew);
		return R.ok("查询维修工人成功").put("data", weixiugongrenView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiugongrenEntity weixiugongren = weixiugongrenService.selectById(id);
        return R.ok().put("data", weixiugongren);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiugongrenEntity weixiugongren = weixiugongrenService.selectById(id);
        return R.ok().put("data", weixiugongren);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiugongrenEntity weixiugongren, HttpServletRequest request){
        if(weixiugongrenService.selectCount(new EntityWrapper<WeixiugongrenEntity>().eq("weixiugonghao", weixiugongren.getWeixiugonghao()))>0) {
            return R.error("维修工号已存在");
        }
    	weixiugongren.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiugongren);
    	WeixiugongrenEntity u = weixiugongrenService.selectOne(new EntityWrapper<WeixiugongrenEntity>().eq("weixiugonghao", weixiugongren.getWeixiugonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		weixiugongren.setId(new Date().getTime());
        weixiugongrenService.insert(weixiugongren);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiugongrenEntity weixiugongren, HttpServletRequest request){
        if(weixiugongrenService.selectCount(new EntityWrapper<WeixiugongrenEntity>().eq("weixiugonghao", weixiugongren.getWeixiugonghao()))>0) {
            return R.error("维修工号已存在");
        }
    	weixiugongren.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiugongren);
    	WeixiugongrenEntity u = weixiugongrenService.selectOne(new EntityWrapper<WeixiugongrenEntity>().eq("weixiugonghao", weixiugongren.getWeixiugonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		weixiugongren.setId(new Date().getTime());
        weixiugongrenService.insert(weixiugongren);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeixiugongrenEntity weixiugongren, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiugongren);
        if(weixiugongrenService.selectCount(new EntityWrapper<WeixiugongrenEntity>().ne("id", weixiugongren.getId()).eq("weixiugonghao", weixiugongren.getWeixiugonghao()))>0) {
            return R.error("维修工号已存在");
        }
        weixiugongrenService.updateById(weixiugongren);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiugongrenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,WeixiugongrenEntity weixiugongren, HttpServletRequest request){
        EntityWrapper<WeixiugongrenEntity> ew = new EntityWrapper<WeixiugongrenEntity>();
        int count = weixiugongrenService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiugongren), params), params));
        return R.ok().put("data", count);
    }



}
