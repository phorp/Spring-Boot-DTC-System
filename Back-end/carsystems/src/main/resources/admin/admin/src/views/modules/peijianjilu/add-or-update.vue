<template>
	<div class="addEdit-block" :style='{"padding":"0 10px 60px 210px"}'>
		<el-form
			:style='{"width":"calc(100% - 18px)","padding":"30px","boxShadow":"none","borderRadius":"none","background":"#fff"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="配件名称" prop="peijianmingcheng">
					<el-input v-model="ruleForm.peijianmingcheng" placeholder="配件名称" clearable  :readonly="ro.peijianmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="配件名称" prop="peijianmingcheng">
					<el-input v-model="ruleForm.peijianmingcheng" placeholder="配件名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="配件分类" prop="peijianfenlei">
					<el-input v-model="ruleForm.peijianfenlei" placeholder="配件分类" clearable  :readonly="ro.peijianfenlei"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="配件分类" prop="peijianfenlei">
					<el-input v-model="ruleForm.peijianfenlei" placeholder="配件分类" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="配件售价" prop="peijianshoujia">
					<el-input v-model.number="ruleForm.peijianshoujia" placeholder="配件售价" clearable  :readonly="ro.peijianshoujia"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="配件售价" prop="peijianshoujia">
					<el-input v-model="ruleForm.peijianshoujia" placeholder="配件售价" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.peijiantupian" label="配件图片" prop="peijiantupian">
					<file-upload
						tip="点击上传配件图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.peijiantupian?ruleForm.peijiantupian:''"
						@change="peijiantupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.peijiantupian" label="配件图片" prop="peijiantupian">
					<img v-if="ruleForm.peijiantupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.peijiantupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.peijiantupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="配件数量" prop="peijianshuliang">
					<el-input v-model.number="ruleForm.peijianshuliang" placeholder="配件数量" clearable  :readonly="ro.peijianshuliang"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="配件数量" prop="peijianshuliang">
					<el-input v-model="ruleForm.peijianshuliang" placeholder="配件数量" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="订单金额" prop="dingdanjine">
					<el-input v-model="dingdanjine" placeholder="订单金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.dingdanjine" label="订单金额" prop="dingdanjine">
					<el-input v-model="ruleForm.dingdanjine" placeholder="订单金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="出库日期" prop="chukuriqi">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.chukuriqi" 
						type="datetime"
						:readonly="ro.chukuriqi"
						placeholder="出库日期"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.chukuriqi" label="出库日期" prop="chukuriqi">
					<el-input v-model="ruleForm.chukuriqi" placeholder="出库日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="维修工号" prop="weixiugonghao">
					<el-input v-model="ruleForm.weixiugonghao" placeholder="维修工号" clearable  :readonly="ro.weixiugonghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="维修工号" prop="weixiugonghao">
					<el-input v-model="ruleForm.weixiugonghao" placeholder="维修工号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="出库备注" prop="chukubeizhu">
					<el-input v-model="ruleForm.chukubeizhu" placeholder="出库备注" clearable  :readonly="ro.chukubeizhu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="出库备注" prop="chukubeizhu">
					<el-input v-model="ruleForm.chukubeizhu" placeholder="出库备注" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'" label="用户名" prop="yonghuming">
					<el-select :disabled="ro.yonghuming" @change="yonghumingChange" v-model="ruleForm.yonghuming" placeholder="请选择用户名">
						<el-option
							v-for="(item,index) in yonghumingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.yonghuming" label="用户名" prop="yonghuming">
					<el-input v-model="ruleForm.yonghuming" placeholder="用户名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" clearable  :readonly="ro.shouji"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","display":"none","height":"40px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","display":"none","height":"40px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
import { 
	isIntNumer,
	isMobile,
} from "@/utils/validate";
export default {
	data() {
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				peijianmingcheng : false,
				peijianfenlei : false,
				peijianshoujia : false,
				peijiantupian : false,
				peijianshuliang : false,
				dingdanjine : false,
				chukuriqi : false,
				weixiugonghao : false,
				chukubeizhu : false,
				yonghuming : false,
				shouji : false,
				ispay : false,
			},
			
			
			ruleForm: {
				peijianmingcheng: '',
				peijianfenlei: '',
				peijianshoujia: '',
				peijiantupian: '',
				peijianshuliang: '',
				dingdanjine: '',
				chukuriqi: '',
				weixiugonghao: '',
				chukubeizhu: '',
				yonghuming: '',
				shouji: '',
			},
		
			yonghumingOptions: [],

			
			rules: {
				peijianmingcheng: [
				],
				peijianfenlei: [
				],
				peijianshoujia: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				peijiantupian: [
				],
				peijianshuliang: [
					{ required: true, message: '配件数量不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				dingdanjine: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				chukuriqi: [
				],
				weixiugonghao: [
					{ required: true, message: '维修工号不能为空', trigger: 'blur' },
				],
				chukubeizhu: [
				],
				yonghuming: [
					{ required: true, message: '用户名不能为空', trigger: 'blur' },
				],
				shouji: [
					{ validator: validateMobile, trigger: 'blur' },
				],
				ispay: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {


		dingdanjine:{
			get: function () {
				return 1*this.ruleForm.peijianshoujia*this.ruleForm.peijianshuliang
			}
		},

	},
    components: {
    },
	created() {
		this.ruleForm.chukuriqi = this.getCurDateTime()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='peijianmingcheng'){
							this.ruleForm.peijianmingcheng = obj[o];
							this.ro.peijianmingcheng = true;
							continue;
						}
						if(o=='peijianfenlei'){
							this.ruleForm.peijianfenlei = obj[o];
							this.ro.peijianfenlei = true;
							continue;
						}
						if(o=='peijianshoujia'){
							this.ruleForm.peijianshoujia = obj[o];
							this.ro.peijianshoujia = true;
							continue;
						}
						if(o=='peijiantupian'){
							this.ruleForm.peijiantupian = obj[o];
							this.ro.peijiantupian = true;
							continue;
						}
						if(o=='peijianshuliang'){
							this.ruleForm.peijianshuliang = obj[o];
							this.ro.peijianshuliang = true;
							continue;
						}
						if(o=='dingdanjine'){
							this.ruleForm.dingdanjine = obj[o];
							this.ro.dingdanjine = true;
							continue;
						}
						if(o=='chukuriqi'){
							this.ruleForm.chukuriqi = obj[o];
							this.ro.chukuriqi = true;
							continue;
						}
						if(o=='weixiugonghao'){
							this.ruleForm.weixiugonghao = obj[o];
							this.ro.weixiugonghao = true;
							continue;
						}
						if(o=='chukubeizhu'){
							this.ruleForm.chukubeizhu = obj[o];
							this.ro.chukubeizhu = true;
							continue;
						}
						if(o=='yonghuming'){
							this.ruleForm.yonghuming = obj[o];
							this.ro.yonghuming = true;
							continue;
						}
						if(o=='shouji'){
							this.ruleForm.shouji = obj[o];
							this.ro.shouji = true;
							continue;
						}
				}
				this.ruleForm.peijianshuliang = 0
				this.ro.peijianshuliang = false;
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
					if(this.$storage.get("role")!="管理员") {
						this.ro.peijianmingcheng = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.peijianfenlei = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.peijianshoujia = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.chukuriqi = true;
					}
					if(((json.weixiugonghao!=''&&json.weixiugonghao) || json.weixiugonghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.weixiugonghao = json.weixiugonghao
						this.ro.weixiugonghao = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.weixiugonghao = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
            this.$http({
				url: `option/yonghu/yonghuming`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.yonghumingOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
			// 下二随
			yonghumingChange () {
				this.$http({
					url: `follow/yonghu/yonghuming?columnValue=`+ this.ruleForm.yonghuming,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.shouji){
							this.ruleForm.shouji = data.data.shouji
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `peijianjilu/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
		this.ruleForm.ispay = '未支付'
        this.ruleForm.dingdanjine = this.dingdanjine
	if(this.ruleForm.peijiantupian!=null) {
		this.ruleForm.peijiantupian = this.ruleForm.peijiantupian.replace(new RegExp(this.$base.url,"g"),"");
	}
var objcross = this.$storage.getObj('crossObj');
      var table = this.$storage.getObj('crossTable');
      if(objcross!=null) {
		  if(!this.ruleForm.peijianshuliang){
			  this.$message.error("配件数量不能为空");
			  return
		  }
	      objcross.peijianshuliang = objcross.peijianshuliang - this.ruleForm.peijianshuliang
	      if(objcross.peijianshuliang<0){
				this.$message.error("配件数量不足");
				return
	      }
                }
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                              this.$http({
                                  url: `${table}/update`,
                                  method: "post",
                                  data: objcross
                                }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "peijianjilu/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `peijianjilu/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.peijianjiluCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
									this.$http({
										url: `${table}/update`,
										method: "post",
										data: objcross
									}).then(({ data }) => {});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `peijianjilu/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$http({
						url: `${table}/update`,
						method: "post",
						data: objcross
					}).then(({ data }) => {});
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.peijianjiluCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
			   }
			});
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.peijianjiluCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    peijiantupianUploadChange(fileUrls) {
	    this.ruleForm.peijiantupian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 150px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 3px solid #9C9C9C;
	  	  border-radius: 0;
	  	  padding: 0 12px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #666;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border: 3px solid #9C9C9C;
	  	  border-radius: 0;
	  	  padding: 0 12px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #666;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 3px solid #9C9C9C;
	  	  border-radius: 0;
	  	  padding: 0 10px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #666;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 3px solid #9C9C9C;
	  	  border-radius: 0;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #666;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 3px solid #9C9C9C;
	  	  cursor: pointer;
	  	  border-radius: 0;
	  	  color: #666;
	  	  font-weight: 700;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 3px solid #9C9C9C;
	  	  cursor: pointer;
	  	  border-radius: 0;
	  	  color: #666;
	  	  font-weight: 700;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 3px solid #9C9C9C;
	  	  cursor: pointer;
	  	  border-radius: 0;
	  	  color: #666;
	  	  font-weight: 700;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 3px solid #9C9C9C;
	  	  border-radius: 0;
	  	  padding: 12px;
	  	  box-shadow: none;
	  	  outline: none;
	  	  color: #666;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #C61C14;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #C61C14;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #000000;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #000000;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #000000;
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>
