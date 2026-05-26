package com.entity.model;

import com.entity.QichexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 汽车信息
 * 接收传参的实体类
 */
public class QichexinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 汽车品牌
	 */
	
	private String qichepinpai;
		
	/**
	 * 汽车型号
	 */
	
	private String qichexinghao;
		
	/**
	 * 汽车图片
	 */
	
	private String qichetupian;
		
	/**
	 * 车辆分类
	 */
	
	private String cheliangfenlei;
		
	/**
	 * 可选颜色
	 */
	
	private String kexuanyanse;
		
	/**
	 * 宣传视频
	 */
	
	private String xuanchuanshipin;
		
	/**
	 * 单限
	 */
	
	private Integer onelimittimes;
		
	/**
	 * 库存
	 */
	
	private Integer alllimittimes;
		
	/**
	 * 汽车介绍
	 */
	
	private String qichejieshao;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 价格
	 */
	
	private Double price;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：汽车品牌
	 */
	 
	public void setQichepinpai(String qichepinpai) {
		this.qichepinpai = qichepinpai;
	}
	
	/**
	 * 获取：汽车品牌
	 */
	public String getQichepinpai() {
		return qichepinpai;
	}
				
	
	/**
	 * 设置：汽车型号
	 */
	 
	public void setQichexinghao(String qichexinghao) {
		this.qichexinghao = qichexinghao;
	}
	
	/**
	 * 获取：汽车型号
	 */
	public String getQichexinghao() {
		return qichexinghao;
	}
				
	
	/**
	 * 设置：汽车图片
	 */
	 
	public void setQichetupian(String qichetupian) {
		this.qichetupian = qichetupian;
	}
	
	/**
	 * 获取：汽车图片
	 */
	public String getQichetupian() {
		return qichetupian;
	}
				
	
	/**
	 * 设置：车辆分类
	 */
	 
	public void setCheliangfenlei(String cheliangfenlei) {
		this.cheliangfenlei = cheliangfenlei;
	}
	
	/**
	 * 获取：车辆分类
	 */
	public String getCheliangfenlei() {
		return cheliangfenlei;
	}
				
	
	/**
	 * 设置：可选颜色
	 */
	 
	public void setKexuanyanse(String kexuanyanse) {
		this.kexuanyanse = kexuanyanse;
	}
	
	/**
	 * 获取：可选颜色
	 */
	public String getKexuanyanse() {
		return kexuanyanse;
	}
				
	
	/**
	 * 设置：宣传视频
	 */
	 
	public void setXuanchuanshipin(String xuanchuanshipin) {
		this.xuanchuanshipin = xuanchuanshipin;
	}
	
	/**
	 * 获取：宣传视频
	 */
	public String getXuanchuanshipin() {
		return xuanchuanshipin;
	}
				
	
	/**
	 * 设置：单限
	 */
	 
	public void setOnelimittimes(Integer onelimittimes) {
		this.onelimittimes = onelimittimes;
	}
	
	/**
	 * 获取：单限
	 */
	public Integer getOnelimittimes() {
		return onelimittimes;
	}
				
	
	/**
	 * 设置：库存
	 */
	 
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	
	/**
	 * 获取：库存
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
	}
				
	
	/**
	 * 设置：汽车介绍
	 */
	 
	public void setQichejieshao(String qichejieshao) {
		this.qichejieshao = qichejieshao;
	}
	
	/**
	 * 获取：汽车介绍
	 */
	public String getQichejieshao() {
		return qichejieshao;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
