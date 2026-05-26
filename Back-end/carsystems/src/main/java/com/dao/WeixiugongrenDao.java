package com.dao;

import com.entity.WeixiugongrenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeixiugongrenVO;
import com.entity.view.WeixiugongrenView;


/**
 * 维修工人
 */
public interface WeixiugongrenDao extends BaseMapper<WeixiugongrenEntity> {
	
	List<WeixiugongrenVO> selectListVO(@Param("ew") Wrapper<WeixiugongrenEntity> wrapper);
	
	WeixiugongrenVO selectVO(@Param("ew") Wrapper<WeixiugongrenEntity> wrapper);
	
	List<WeixiugongrenView> selectListView(@Param("ew") Wrapper<WeixiugongrenEntity> wrapper);

	List<WeixiugongrenView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiugongrenEntity> wrapper);

	
	WeixiugongrenView selectView(@Param("ew") Wrapper<WeixiugongrenEntity> wrapper);
	

}
