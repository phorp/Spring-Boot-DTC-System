package com.entity.view;

import com.entity.WeixiugongrenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 维修工人
 * 后端返回视图实体辅助类
 */
@TableName("weixiugongren")
public class WeixiugongrenView  extends WeixiugongrenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeixiugongrenView(){
	}
 
 	public WeixiugongrenView(WeixiugongrenEntity weixiugongrenEntity){
 	try {
			BeanUtils.copyProperties(this, weixiugongrenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
