package com.entity.model;

import com.entity.PeijianjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 配件记录
 * 接收传参的实体类
 */
public class PeijianjiluModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 配件分类
	 */
	
	private String peijianfenlei;
		
	/**
	 * 配件售价
	 */
	
	private Integer peijianshoujia;
		
	/**
	 * 配件图片
	 */
	
	private String peijiantupian;
		
	/**
	 * 配件数量
	 */
	
	private Integer peijianshuliang;
		
	/**
	 * 订单金额
	 */
	
	private Integer dingdanjine;
		
	/**
	 * 出库日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chukuriqi;
		
	/**
	 * 维修工号
	 */
	
	private String weixiugonghao;
		
	/**
	 * 出库备注
	 */
	
	private String chukubeizhu;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
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
	 * 设置：订单金额
	 */
	 
	public void setDingdanjine(Integer dingdanjine) {
		this.dingdanjine = dingdanjine;
	}
	
	/**
	 * 获取：订单金额
	 */
	public Integer getDingdanjine() {
		return dingdanjine;
	}
				
	
	/**
	 * 设置：出库日期
	 */
	 
	public void setChukuriqi(Date chukuriqi) {
		this.chukuriqi = chukuriqi;
	}
	
	/**
	 * 获取：出库日期
	 */
	public Date getChukuriqi() {
		return chukuriqi;
	}
				
	
	/**
	 * 设置：维修工号
	 */
	 
	public void setWeixiugonghao(String weixiugonghao) {
		this.weixiugonghao = weixiugonghao;
	}
	
	/**
	 * 获取：维修工号
	 */
	public String getWeixiugonghao() {
		return weixiugonghao;
	}
				
	
	/**
	 * 设置：出库备注
	 */
	 
	public void setChukubeizhu(String chukubeizhu) {
		this.chukubeizhu = chukubeizhu;
	}
	
	/**
	 * 获取：出库备注
	 */
	public String getChukubeizhu() {
		return chukubeizhu;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
