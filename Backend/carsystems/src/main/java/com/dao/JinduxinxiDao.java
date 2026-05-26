package com.dao;

import com.entity.JinduxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JinduxinxiVO;
import com.entity.view.JinduxinxiView;


/**
 * 进度信息
 */
public interface JinduxinxiDao extends BaseMapper<JinduxinxiEntity> {
	
	List<JinduxinxiVO> selectListVO(@Param("ew") Wrapper<JinduxinxiEntity> wrapper);
	
	JinduxinxiVO selectVO(@Param("ew") Wrapper<JinduxinxiEntity> wrapper);
	
	List<JinduxinxiView> selectListView(@Param("ew") Wrapper<JinduxinxiEntity> wrapper);

	List<JinduxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JinduxinxiEntity> wrapper);

	
	JinduxinxiView selectView(@Param("ew") Wrapper<JinduxinxiEntity> wrapper);
	

}
