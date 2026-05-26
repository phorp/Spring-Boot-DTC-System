package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ShijiaEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 试驾信息
 * 后端返回视图实体辅助类
 */
@TableName("shijia")
public class ShijiaView extends ShijiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShijiaView(){
	}

 	public ShijiaView(ShijiaEntity shijiaEntity){
 	try {
			BeanUtils.copyProperties(this, shijiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
