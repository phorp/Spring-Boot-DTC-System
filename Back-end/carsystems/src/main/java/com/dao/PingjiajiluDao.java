package com.dao;

import com.entity.PingjiajiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingjiajiluVO;
import com.entity.view.PingjiajiluView;


/**
 * 评价记录
 */
public interface PingjiajiluDao extends BaseMapper<PingjiajiluEntity> {
	
	List<PingjiajiluVO> selectListVO(@Param("ew") Wrapper<PingjiajiluEntity> wrapper);
	
	PingjiajiluVO selectVO(@Param("ew") Wrapper<PingjiajiluEntity> wrapper);
	
	List<PingjiajiluView> selectListView(@Param("ew") Wrapper<PingjiajiluEntity> wrapper);

	List<PingjiajiluView> selectListView(Pagination page,@Param("ew") Wrapper<PingjiajiluEntity> wrapper);

	
	PingjiajiluView selectView(@Param("ew") Wrapper<PingjiajiluEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PingjiajiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PingjiajiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PingjiajiluEntity> wrapper);



}
