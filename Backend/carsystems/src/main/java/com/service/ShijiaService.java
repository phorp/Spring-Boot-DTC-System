package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ShijiaEntity;
import com.entity.view.ShijiaView;
import com.entity.vo.ShijiaVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 试驾信息
 */
public interface ShijiaService extends IService<ShijiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShijiaVO> selectListVO(Wrapper<ShijiaEntity> wrapper);
   	
   	ShijiaVO selectVO(@Param("ew") Wrapper<ShijiaEntity> wrapper);
   	
   	List<ShijiaView> selectListView(Wrapper<ShijiaEntity> wrapper);
   	
   	ShijiaView selectView(@Param("ew") Wrapper<ShijiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShijiaEntity> wrapper);

   	

}

