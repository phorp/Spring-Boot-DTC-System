package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ForumEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 论坛交流
 * 后端返回视图实体辅助类
 */
@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ForumView(){
	}
 
 	public ForumView(ForumEntity forumEntity){
 	try {
			BeanUtils.copyProperties(this, forumEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
