package com.entity.vo;

import com.entity.PeijianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 配件信息
 * @author 
 * @email 
 * @date 2024-04-22 08:42:00
 */
public class PeijianxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 配件分类
	 */
	
	private String peijianfenlei;
		
	/**
	 * 配件图片
	 */
	
	private String peijiantupian;
		
	/**
	 * 配件用途
	 */
	
	private String peijianyongtu;
		
	/**
	 * 配件品牌
	 */
	
	private String peijianpinpai;
		
	/**
	 * 配件进价
	 */
	
	private Integer peijianjinjia;
		
	/**
	 * 配件售价
	 */
	
	private Integer peijianshoujia;
		
	/**
	 * 配件数量
	 */
	
	private Integer peijianshuliang;
		
	/**
	 * 配件说明
	 */
	
	private String peijianshuoming;
				
	
	/**
	 * 设置：配件分类
	 */
	 
	public void setPeijianfenlei(String peijianfenlei) {
		this.peijianfenlei = peijianfenlei;
	}
	
	/**
	 * 获取：配件分类
	 */
	public String getPeijianfenlei() {
		return peijianfenlei;
	}
				
	
	/**
	 * 设置：配件图片
	 */
	 
	public void setPeijiantupian(String peijiantupian) {
		this.peijiantupian = peijiantupian;
	}
	
	/**
	 * 获取：配件图片
	 */
	public String getPeijiantupian() {
		return peijiantupian;
	}
				
	
	/**
	 * 设置：配件用途
	 */
	 
	public void setPeijianyongtu(String peijianyongtu) {
		this.peijianyongtu = peijianyongtu;
	}
	
	/**
	 * 获取：配件用途
	 */
	public String getPeijianyongtu() {
		return peijianyongtu;
	}
				
	
	/**
	 * 设置：配件品牌
	 */
	 
	public void setPeijianpinpai(String peijianpinpai) {
		this.peijianpinpai = peijianpinpai;
	}
	
	/**
	 * 获取：配件品牌
	 */
	public String getPeijianpinpai() {
		return peijianpinpai;
	}
				
	
	/**
	 * 设置：配件进价
	 */
	 
	public void setPeijianjinjia(Integer peijianjinjia) {
		this.peijianjinjia = peijianjinjia;
	}
	
	/**
	 * 获取：配件进价
	 */
	public Integer getPeijianjinjia() {
		return peijianjinjia;
	}
				
	
	/**
	 * 设置：配件售价
	 */
	 
	public void setPeijianshoujia(Integer peijianshoujia) {
		this.peijianshoujia = peijianshoujia;
	}
	
	/**
	 * 获取：配件售价
	 */
	public Integer getPeijianshoujia() {
		return peijianshoujia;
	}
				
	
	/**
	 * 设置：配件数量
	 */
	 
	public void setPeijianshuliang(Integer peijianshuliang) {
		this.peijianshuliang = peijianshuliang;
	}
	
	/**
	 * 获取：配件数量
	 */
	public Integer getPeijianshuliang() {
		return peijianshuliang;
	}
				
	
	/**
	 * 设置：配件说明
	 */
	 
	public void setPeijianshuoming(String peijianshuoming) {
		this.peijianshuoming = peijianshuoming;
	}
	
	/**
	 * 获取：配件说明
	 */
	public String getPeijianshuoming() {
		return peijianshuoming;
	}
			
}
