package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.PingjiajiluDao;
import com.entity.PingjiajiluEntity;
import com.service.PingjiajiluService;
import com.entity.vo.PingjiajiluVO;
import com.entity.view.PingjiajiluView;

@Service("pingjiajiluService")
public class PingjiajiluServiceImpl extends ServiceImpl<PingjiajiluDao, PingjiajiluEntity> implements PingjiajiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingjiajiluEntity> page = this.selectPage(
                new Query<PingjiajiluEntity>(params).getPage(),
                new EntityWrapper<PingjiajiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingjiajiluEntity> wrapper) {
		  Page<PingjiajiluView> page =new Query<PingjiajiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PingjiajiluVO> selectListVO(Wrapper<PingjiajiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PingjiajiluVO selectVO(Wrapper<PingjiajiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PingjiajiluView> selectListView(Wrapper<PingjiajiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingjiajiluView selectView(Wrapper<PingjiajiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<PingjiajiluEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<PingjiajiluEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<PingjiajiluEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
