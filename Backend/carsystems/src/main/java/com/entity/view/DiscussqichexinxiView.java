package com.entity.view;

import com.entity.DiscussqichexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 汽车信息评论表
 * 后端返回视图实体辅助类
 */
@TableName("discussqichexinxi")
public class DiscussqichexinxiView  extends DiscussqichexinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussqichexinxiView(){
	}
 
 	public DiscussqichexinxiView(DiscussqichexinxiEntity discussqichexinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussqichexinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
