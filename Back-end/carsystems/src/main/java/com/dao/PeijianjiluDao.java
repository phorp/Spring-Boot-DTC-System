package com.dao;

import com.entity.PeijianjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeijianjiluVO;
import com.entity.view.PeijianjiluView;


/**
 * 配件记录
 */
public interface PeijianjiluDao extends BaseMapper<PeijianjiluEntity> {
	
	List<PeijianjiluVO> selectListVO(@Param("ew") Wrapper<PeijianjiluEntity> wrapper);
	
	PeijianjiluVO selectVO(@Param("ew") Wrapper<PeijianjiluEntity> wrapper);
	
	List<PeijianjiluView> selectListView(@Param("ew") Wrapper<PeijianjiluEntity> wrapper);

	List<PeijianjiluView> selectListView(Pagination page,@Param("ew") Wrapper<PeijianjiluEntity> wrapper);

	
	PeijianjiluView selectView(@Param("ew") Wrapper<PeijianjiluEntity> wrapper);
	

}
