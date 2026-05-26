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


import com.dao.WeixiugongrenDao;
import com.entity.WeixiugongrenEntity;
import com.service.WeixiugongrenService;
import com.entity.vo.WeixiugongrenVO;
import com.entity.view.WeixiugongrenView;

@Service("weixiugongrenService")
public class WeixiugongrenServiceImpl extends ServiceImpl<WeixiugongrenDao, WeixiugongrenEntity> implements WeixiugongrenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiugongrenEntity> page = this.selectPage(
                new Query<WeixiugongrenEntity>(params).getPage(),
                new EntityWrapper<WeixiugongrenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiugongrenEntity> wrapper) {
		  Page<WeixiugongrenView> page =new Query<WeixiugongrenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WeixiugongrenVO> selectListVO(Wrapper<WeixiugongrenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeixiugongrenVO selectVO(Wrapper<WeixiugongrenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeixiugongrenView> selectListView(Wrapper<WeixiugongrenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiugongrenView selectView(Wrapper<WeixiugongrenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
