package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JinduxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JinduxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JinduxinxiView;


/**
 * 进度信息
 */
public interface JinduxinxiService extends IService<JinduxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JinduxinxiVO> selectListVO(Wrapper<JinduxinxiEntity> wrapper);
   	
   	JinduxinxiVO selectVO(@Param("ew") Wrapper<JinduxinxiEntity> wrapper);
   	
   	List<JinduxinxiView> selectListView(Wrapper<JinduxinxiEntity> wrapper);
   	
   	JinduxinxiView selectView(@Param("ew") Wrapper<JinduxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JinduxinxiEntity> wrapper);

   	

}

