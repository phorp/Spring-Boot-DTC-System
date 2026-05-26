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


import com.dao.PeijianjiluDao;
import com.entity.PeijianjiluEntity;
import com.service.PeijianjiluService;
import com.entity.vo.PeijianjiluVO;
import com.entity.view.PeijianjiluView;

@Service("peijianjiluService")
public class PeijianjiluServiceImpl extends ServiceImpl<PeijianjiluDao, PeijianjiluEntity> implements PeijianjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeijianjiluEntity> page = this.selectPage(
                new Query<PeijianjiluEntity>(params).getPage(),
                new EntityWrapper<PeijianjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeijianjiluEntity> wrapper) {
		  Page<PeijianjiluView> page =new Query<PeijianjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PeijianjiluVO> selectListVO(Wrapper<PeijianjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeijianjiluVO selectVO(Wrapper<PeijianjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeijianjiluView> selectListView(Wrapper<PeijianjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeijianjiluView selectView(Wrapper<PeijianjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
