package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeijianjiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeijianjiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeijianjiluView;


/**
 * 配件记录
 */
public interface PeijianjiluService extends IService<PeijianjiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeijianjiluVO> selectListVO(Wrapper<PeijianjiluEntity> wrapper);
   	
   	PeijianjiluVO selectVO(@Param("ew") Wrapper<PeijianjiluEntity> wrapper);
   	
   	List<PeijianjiluView> selectListView(Wrapper<PeijianjiluEntity> wrapper);
   	
   	PeijianjiluView selectView(@Param("ew") Wrapper<PeijianjiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeijianjiluEntity> wrapper);

   	

}

