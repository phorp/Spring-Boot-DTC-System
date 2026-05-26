package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ShijiaDao;
import com.entity.ShijiaEntity;
import com.entity.view.ShijiaView;
import com.entity.vo.ShijiaVO;
import com.service.ShijiaService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("shijiaService")
public class ShijiaServiceImpl extends ServiceImpl<ShijiaDao, ShijiaEntity> implements ShijiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShijiaEntity> page = this.selectPage(
                new Query<ShijiaEntity>(params).getPage(),
                new EntityWrapper<ShijiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShijiaEntity> wrapper) {
		  Page<ShijiaView> page =new Query<ShijiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShijiaVO> selectListVO(Wrapper<ShijiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShijiaVO selectVO(Wrapper<ShijiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShijiaView> selectListView(Wrapper<ShijiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShijiaView selectView(Wrapper<ShijiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
