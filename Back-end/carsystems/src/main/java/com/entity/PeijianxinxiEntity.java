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
 * 配件信息
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("peijianxinxi")
public class PeijianxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PeijianxinxiEntity() {
		
	}
	
	public PeijianxinxiEntity(T t) {
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
	 * 配件名称
	 */
					
	private String peijianmingcheng;
	
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
	 * 设置：配件名称
	 */
	public void setPeijianmingcheng(String peijianmingcheng) {
		this.peijianmingcheng = peijianmingcheng;
	}
	/**
	 * 获取：配件名称
	 */
	public String getPeijianmingcheng() {
		return peijianmingcheng;
	}
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
