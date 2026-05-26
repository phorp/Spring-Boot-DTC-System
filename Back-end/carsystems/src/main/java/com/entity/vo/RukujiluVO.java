package com.entity.vo;

import com.entity.RukujiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 入库记录
 * @author 
 * @email 
 * @date 2024-04-22 08:42:00
 */
public class RukujiluVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 配件分类
	 */
	
	private String peijianfenlei;
		
	/**
	 * 配件进价
	 */
	
	private Integer peijianjinjia;
		
	/**
	 * 配件数量
	 */
	
	private Integer peijianshuliang;
		
	/**
	 * 订单金额
	 */
	
	private Integer dingdanjine;
		
	/**
	 * 入库日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date rukuriqi;
		
	/**
	 * 入库备注
	 */
	
	private String rukubeizhu;
				
	
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
	 * 设置：入库日期
	 */
	 
	public void setRukuriqi(Date rukuriqi) {
		this.rukuriqi = rukuriqi;
	}
	
	/**
	 * 获取：入库日期
	 */
	public Date getRukuriqi() {
		return rukuriqi;
	}
				
	
	/**
	 * 设置：入库备注
	 */
	 
	public void setRukubeizhu(String rukubeizhu) {
		this.rukubeizhu = rukubeizhu;
	}
	
	/**
	 * 获取：入库备注
	 */
	public String getRukubeizhu() {
		return rukubeizhu;
	}
			
}
