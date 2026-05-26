package com.entity.view;

import com.entity.RukujiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 入库记录
 * 后端返回视图实体辅助类
 */
@TableName("rukujilu")
public class RukujiluView  extends RukujiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RukujiluView(){
	}
 
 	public RukujiluView(RukujiluEntity rukujiluEntity){
 	try {
			BeanUtils.copyProperties(this, rukujiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
