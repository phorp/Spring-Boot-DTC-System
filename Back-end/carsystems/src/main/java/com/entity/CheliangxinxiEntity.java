package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 车辆信息
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("cheliangxinxi")
public class CheliangxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CheliangxinxiEntity() {
		
	}
	
	public CheliangxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 汽车名称
	 */
					
	private String qichemingcheng;
	
	/**
	 * 汽车品牌
	 */
					
	private String qichepinpai;
	
	/**
	 * 汽车型号
	 */
					
	private String qichexinghao;
	
	/**
	 * 车牌号码
	 */
					
	private String chepaihaoma;
	
	/**
	 * 车辆图片
	 */
					
	private String cheliangtupian;
	
	/**
	 * 发动机号
	 */
					
	private String fadongjihao;
	
	/**
	 * 上牌时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shangpaishijian;
	
	/**
	 * 保养到期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date baoyangdaoqi;
	
	/**
	 * 行驶里程
	 */
					
	private String xingshilicheng;
	
	/**
	 * 信息备注
	 */
					
	private String xinxibeizhu;
	
	/**
	 * 保险公司
	 */
					
	private String baoxiangongsi;
	
	/**
	 * 保险金额
	 */
					
	private Integer baoxianjine;
	
	/**
	 * 起止日期
	 */
					
	private String qizhiriqi;
	
	/**
	 * 用户名
	 */
					
	private String yonghuming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：汽车名称
	 */
	public void setQichemingcheng(String qichemingcheng) {
		this.qichemingcheng = qichemingcheng;
	}
	/**
	 * 获取：汽车名称
	 */
	public String getQichemingcheng() {
		return qichemingcheng;
	}
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
	 * 设置：车辆图片
	 */
	public void setCheliangtupian(String cheliangtupian) {
		this.cheliangtupian = cheliangtupian;
	}
	/**
	 * 获取：车辆图片
	 */
	public String getCheliangtupian() {
		return cheliangtupian;
	}
	/**
	 * 设置：发动机号
	 */
	public void setFadongjihao(String fadongjihao) {
		this.fadongjihao = fadongjihao;
	}
	/**
	 * 获取：发动机号
	 */
	public String getFadongjihao() {
		return fadongjihao;
	}
	/**
	 * 设置：上牌时间
	 */
	public void setShangpaishijian(Date shangpaishijian) {
		this.shangpaishijian = shangpaishijian;
	}
	/**
	 * 获取：上牌时间
	 */
	public Date getShangpaishijian() {
		return shangpaishijian;
	}
	/**
	 * 设置：保养到期
	 */
	public void setBaoyangdaoqi(Date baoyangdaoqi) {
		this.baoyangdaoqi = baoyangdaoqi;
	}
	/**
	 * 获取：保养到期
	 */
	public Date getBaoyangdaoqi() {
		return baoyangdaoqi;
	}
	/**
	 * 设置：行驶里程
	 */
	public void setXingshilicheng(String xingshilicheng) {
		this.xingshilicheng = xingshilicheng;
	}
	/**
	 * 获取：行驶里程
	 */
	public String getXingshilicheng() {
		return xingshilicheng;
	}
	/**
	 * 设置：信息备注
	 */
	public void setXinxibeizhu(String xinxibeizhu) {
		this.xinxibeizhu = xinxibeizhu;
	}
	/**
	 * 获取：信息备注
	 */
	public String getXinxibeizhu() {
		return xinxibeizhu;
	}
	/**
	 * 设置：保险公司
	 */
	public void setBaoxiangongsi(String baoxiangongsi) {
		this.baoxiangongsi = baoxiangongsi;
	}
	/**
	 * 获取：保险公司
	 */
	public String getBaoxiangongsi() {
		return baoxiangongsi;
	}
	/**
	 * 设置：保险金额
	 */
	public void setBaoxianjine(Integer baoxianjine) {
		this.baoxianjine = baoxianjine;
	}
	/**
	 * 获取：保险金额
	 */
	public Integer getBaoxianjine() {
		return baoxianjine;
	}
	/**
	 * 设置：起止日期
	 */
	public void setQizhiriqi(String qizhiriqi) {
		this.qizhiriqi = qizhiriqi;
	}
	/**
	 * 获取：起止日期
	 */
	public String getQizhiriqi() {
		return qizhiriqi;
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

}
