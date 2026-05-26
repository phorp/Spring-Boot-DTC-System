package com.entity.view;

import com.entity.PeijianfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 配件分类
 * 后端返回视图实体辅助类
 */
@TableName("peijianfenlei")
public class PeijianfenleiView  extends PeijianfenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PeijianfenleiView(){
	}
 
 	public PeijianfenleiView(PeijianfenleiEntity peijianfenleiEntity){
 	try {
			BeanUtils.copyProperties(this, peijianfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
