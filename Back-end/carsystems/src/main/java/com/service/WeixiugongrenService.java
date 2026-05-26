package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeixiugongrenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeixiugongrenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiugongrenView;


/**
 * 维修工人
 */
public interface WeixiugongrenService extends IService<WeixiugongrenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiugongrenVO> selectListVO(Wrapper<WeixiugongrenEntity> wrapper);
   	
   	WeixiugongrenVO selectVO(@Param("ew") Wrapper<WeixiugongrenEntity> wrapper);
   	
   	List<WeixiugongrenView> selectListView(Wrapper<WeixiugongrenEntity> wrapper);
   	
   	WeixiugongrenView selectView(@Param("ew") Wrapper<WeixiugongrenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiugongrenEntity> wrapper);

   	

}

