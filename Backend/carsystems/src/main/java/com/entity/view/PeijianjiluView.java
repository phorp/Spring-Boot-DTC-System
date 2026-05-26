package com.entity.view;

import com.entity.PeijianjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 配件记录
 * 后端返回视图实体辅助类
 */
@TableName("peijianjilu")
public class PeijianjiluView  extends PeijianjiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PeijianjiluView(){
	}
 
 	public PeijianjiluView(PeijianjiluEntity peijianjiluEntity){
 	try {
			BeanUtils.copyProperties(this, peijianjiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
