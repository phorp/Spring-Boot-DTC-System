package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ShijiaEntity;
import com.entity.view.ShijiaView;
import com.entity.vo.ShijiaVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 试驾信息
 */
public interface ShijiaDao extends BaseMapper<ShijiaEntity> {
	
	List<ShijiaVO> selectListVO(@Param("ew") Wrapper<ShijiaEntity> wrapper);
	
	ShijiaVO selectVO(@Param("ew") Wrapper<ShijiaEntity> wrapper);
	
	List<ShijiaView> selectListView(@Param("ew") Wrapper<ShijiaEntity> wrapper);

	List<ShijiaView> selectListView(Pagination page,@Param("ew") Wrapper<ShijiaEntity> wrapper);

	
	ShijiaView selectView(@Param("ew") Wrapper<ShijiaEntity> wrapper);
	

}
