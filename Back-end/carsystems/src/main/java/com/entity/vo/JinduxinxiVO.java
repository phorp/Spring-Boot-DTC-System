package com.entity.vo;

import com.entity.JinduxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 进度信息
 * @author 
 * @email 
 * @date 2024-04-22 08:42:01
 */
public class JinduxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 车牌号码
	 */
	
	private String chepaihaoma;
		
	/**
	 * 进度图片
	 */
	
	private String jindutupian;
		
	/**
	 * 进度情况
	 */
	
	private String jinduqingkuang;
		
	/**
	 * 进度说明
	 */
	
	private String jindushuoming;
		
	/**
	 * 金额费用
	 */
	
	private Integer jinefeiyong;
		
	/**
	 * 工时信息
	 */
	
	private String gongshixinxi;
		
	/**
	 * 服务时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fuwushijian;
		
	/**
	 * 服务评价
	 */
	
	private String fuwupingjia;
		
	/**
	 * 费用明细
	 */
	
	private String feiyongmingxi;
		
	/**
	 * 维修工号
	 */
	
	private String weixiugonghao;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
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
	 * 设置：车牌号码
	 */
	 
	public void setChepaihaoma(String chepaihaoma) {
		this.chepaihaoma = chepaihaoma;
	}
	
	/**
	 * 获取：车牌号码
	 */
	public String getChepaihaoma() {
		return chepaihaoma;
	}
				
	
	/**
	 * 设置：进度图片
	 */
	 
	public void setJindutupian(String jindutupian) {
		this.jindutupian = jindutupian;
	}
	
	/**
	 * 获取：进度图片
	 */
	public String getJindutupian() {
		return jindutupian;
	}
				
	
	/**
	 * 设置：进度情况
	 */
	 
	public void setJinduqingkuang(String jinduqingkuang) {
		this.jinduqingkuang = jinduqingkuang;
	}
	
	/**
	 * 获取：进度情况
	 */
	public String getJinduqingkuang() {
		return jinduqingkuang;
	}
				
	
	/**
	 * 设置：进度说明
	 */
	 
	public void setJindushuoming(String jindushuoming) {
		this.jindushuoming = jindushuoming;
	}
	
	/**
	 * 获取：进度说明
	 */
	public String getJindushuoming() {
		return jindushuoming;
	}
				
	
	/**
	 * 设置：金额费用
	 */
	 
	public void setJinefeiyong(Integer jinefeiyong) {
		this.jinefeiyong = jinefeiyong;
	}
	
	/**
	 * 获取：金额费用
	 */
	public Integer getJinefeiyong() {
		return jinefeiyong;
	}
				
	
	/**
	 * 设置：工时信息
	 */
	 
	public void setGongshixinxi(String gongshixinxi) {
		this.gongshixinxi = gongshixinxi;
	}
	
	/**
	 * 获取：工时信息
	 */
	public String getGongshixinxi() {
		return gongshixinxi;
	}
				
	
	/**
	 * 设置：服务时间
	 */
	 
	public void setFuwushijian(Date fuwushijian) {
		this.fuwushijian = fuwushijian;
	}
	
	/**
	 * 获取：服务时间
	 */
	public Date getFuwushijian() {
		return fuwushijian;
	}
				
	
	/**
	 * 设置：服务评价
	 */
	 
	public void setFuwupingjia(String fuwupingjia) {
		this.fuwupingjia = fuwupingjia;
	}
	
	/**
	 * 获取：服务评价
	 */
	public String getFuwupingjia() {
		return fuwupingjia;
	}
				
	
	/**
	 * 设置：费用明细
	 */
	 
	public void setFeiyongmingxi(String feiyongmingxi) {
		this.feiyongmingxi = feiyongmingxi;
	}
	
	/**
	 * 获取：费用明细
	 */
	public String getFeiyongmingxi() {
		return feiyongmingxi;
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
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
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
