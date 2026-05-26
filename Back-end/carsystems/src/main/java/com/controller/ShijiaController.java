package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.ShijiaEntity;
import com.entity.view.ShijiaView;
import com.service.ShijiaService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * 试驾信息
 * 后端接口
 */
@RestController
@RequestMapping("/shijia")
public class ShijiaController {
    @Autowired
    private ShijiaService shijiaService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShijiaEntity shijia,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shijia.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShijiaEntity> ew = new EntityWrapper<ShijiaEntity>();

		PageUtils page = shijiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shijia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShijiaEntity shijia,
		HttpServletRequest request){
        EntityWrapper<ShijiaEntity> ew = new EntityWrapper<ShijiaEntity>();

		PageUtils page = shijiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shijia), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShijiaEntity shijia){
       	EntityWrapper<ShijiaEntity> ew = new EntityWrapper<ShijiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shijia, "shijia"));
        return R.ok().put("data", shijiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShijiaEntity shijia){
        EntityWrapper< ShijiaEntity> ew = new EntityWrapper< ShijiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shijia, "shijia"));
		ShijiaView shijiaView =  shijiaService.selectView(ew);
		return R.ok("查询试驾信息成功").put("data", shijiaView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShijiaEntity shijia = shijiaService.selectById(id);
        return R.ok().put("data", shijia);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShijiaEntity shijia = shijiaService.selectById(id);
        return R.ok().put("data", shijia);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShijiaEntity shijia, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shijia);
        shijiaService.insert(shijia);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShijiaEntity shijia, HttpServletRequest request){
//    	ValidatorUtils.validateEntity(shijia);
        shijiaService.insert(shijia);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShijiaEntity shijia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shijia);
        shijiaService.updateById(shijia);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shijiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
