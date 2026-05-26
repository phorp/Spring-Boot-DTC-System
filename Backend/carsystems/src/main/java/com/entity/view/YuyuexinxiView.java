package com.entity.view;

import com.entity.YuyuexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 预约信息
 * 后端返回视图实体辅助类
 */
@TableName("yuyuexinxi")
public class YuyuexinxiView  extends YuyuexinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuyuexinxiView(){
	}
 
 	public YuyuexinxiView(YuyuexinxiEntity yuyuexinxiEntity){
 	try {
			BeanUtils.copyProperties(this, yuyuexinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
