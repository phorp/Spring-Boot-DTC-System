package com.entity.view;

import com.entity.CheliangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 车辆信息
 * 后端返回视图实体辅助类
 */
@TableName("cheliangxinxi")
public class CheliangxinxiView  extends CheliangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CheliangxinxiView(){
	}
 
 	public CheliangxinxiView(CheliangxinxiEntity cheliangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, cheliangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
