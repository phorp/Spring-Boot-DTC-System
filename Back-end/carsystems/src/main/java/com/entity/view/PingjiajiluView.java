package com.entity.view;

import com.entity.PingjiajiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 评价记录
 * 后端返回视图实体辅助类
 */
@TableName("pingjiajilu")
public class PingjiajiluView  extends PingjiajiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PingjiajiluView(){
	}
 
 	public PingjiajiluView(PingjiajiluEntity pingjiajiluEntity){
 	try {
			BeanUtils.copyProperties(this, pingjiajiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
