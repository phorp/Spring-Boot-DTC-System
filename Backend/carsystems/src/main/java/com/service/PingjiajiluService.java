package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PingjiajiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PingjiajiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PingjiajiluView;


/**
 * 评价记录
 */
public interface PingjiajiluService extends IService<PingjiajiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingjiajiluVO> selectListVO(Wrapper<PingjiajiluEntity> wrapper);
   	
   	PingjiajiluVO selectVO(@Param("ew") Wrapper<PingjiajiluEntity> wrapper);
   	
   	List<PingjiajiluView> selectListView(Wrapper<PingjiajiluEntity> wrapper);
   	
   	PingjiajiluView selectView(@Param("ew") Wrapper<PingjiajiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingjiajiluEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<PingjiajiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<PingjiajiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<PingjiajiluEntity> wrapper);



}

