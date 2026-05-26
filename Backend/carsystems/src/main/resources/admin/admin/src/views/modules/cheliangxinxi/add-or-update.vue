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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'" label="汽车名称" prop="qichemingcheng">
					<el-select :disabled="ro.qichemingcheng" @change="qichemingchengChange" v-model="ruleForm.qichemingcheng" placeholder="请选择汽车名称">
						<el-option
							v-for="(item,index) in qichemingchengOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.qichemingcheng" label="汽车名称" prop="qichemingcheng">
					<el-input v-model="ruleForm.qichemingcheng" placeholder="汽车名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="汽车品牌" prop="qichepinpai">
					<el-input v-model="ruleForm.qichepinpai" placeholder="汽车品牌" clearable  :readonly="ro.qichepinpai"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="汽车品牌" prop="qichepinpai">
					<el-input v-model="ruleForm.qichepinpai" placeholder="汽车品牌" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="汽车型号" prop="qichexinghao">
					<el-input v-model="ruleForm.qichexinghao" placeholder="汽车型号" clearable  :readonly="ro.qichexinghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="汽车型号" prop="qichexinghao">
					<el-input v-model="ruleForm.qichexinghao" placeholder="汽车型号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="车牌号码" prop="chepaihaoma">
					<el-input v-model="ruleForm.chepaihaoma" placeholder="车牌号码" clearable  :readonly="ro.chepaihaoma"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="车牌号码" prop="chepaihaoma">
					<el-input v-model="ruleForm.chepaihaoma" placeholder="车牌号码" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.cheliangtupian" label="车辆图片" prop="cheliangtupian">
					<file-upload
						tip="点击上传车辆图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.cheliangtupian?ruleForm.cheliangtupian:''"
						@change="cheliangtupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.cheliangtupian" label="车辆图片" prop="cheliangtupian">
					<img v-if="ruleForm.cheliangtupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.cheliangtupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.cheliangtupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="发动机号" prop="fadongjihao">
					<el-input v-model="ruleForm.fadongjihao" placeholder="发动机号" clearable  :readonly="ro.fadongjihao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="发动机号" prop="fadongjihao">
					<el-input v-model="ruleForm.fadongjihao" placeholder="发动机号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="上牌时间" prop="shangpaishijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.shangpaishijian" 
						type="date"
						:readonly="ro.shangpaishijian"
						placeholder="上牌时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.shangpaishijian" label="上牌时间" prop="shangpaishijian">
					<el-input v-model="ruleForm.shangpaishijian" placeholder="上牌时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="保养到期" prop="baoyangdaoqi">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.baoyangdaoqi" 
						type="date"
						:readonly="ro.baoyangdaoqi"
						placeholder="保养到期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.baoyangdaoqi" label="保养到期" prop="baoyangdaoqi">
					<el-input v-model="ruleForm.baoyangdaoqi" placeholder="保养到期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="行驶里程" prop="xingshilicheng">
					<el-input v-model="ruleForm.xingshilicheng" placeholder="行驶里程" clearable  :readonly="ro.xingshilicheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="行驶里程" prop="xingshilicheng">
					<el-input v-model="ruleForm.xingshilicheng" placeholder="行驶里程" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="保险公司" prop="baoxiangongsi">
					<el-input v-model="ruleForm.baoxiangongsi" placeholder="保险公司" clearable  :readonly="ro.baoxiangongsi"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="保险公司" prop="baoxiangongsi">
					<el-input v-model="ruleForm.baoxiangongsi" placeholder="保险公司" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="保险金额" prop="baoxianjine">
					<el-input v-model.number="ruleForm.baoxianjine" placeholder="保险金额" clearable  :readonly="ro.baoxianjine"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="保险金额" prop="baoxianjine">
					<el-input v-model="ruleForm.baoxianjine" placeholder="保险金额" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="起止日期" prop="qizhiriqi">
					<el-input v-model="ruleForm.qizhiriqi" placeholder="起止日期" clearable  :readonly="ro.qizhiriqi"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="起止日期" prop="qizhiriqi">
					<el-input v-model="ruleForm.qizhiriqi" placeholder="起止日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="用户名" prop="yonghuming">
					<el-select :disabled="ro.yonghuming" v-model="ruleForm.yonghuming" placeholder="请选择用户名" >
						<el-option
							v-for="(item,index) in yonghumingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="用户名" prop="yonghuming">
					<el-input v-model="ruleForm.yonghuming"
						placeholder="用户名" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="信息备注" prop="xinxibeizhu">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="信息备注"
					  v-model="ruleForm.xinxibeizhu" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.xinxibeizhu" label="信息备注" prop="xinxibeizhu">
					<span :style='{"fontSize":"14px","lineHeight":"40px","color":"#666","fontWeight":"500","display":"inline-block"}'>{{ruleForm.xinxibeizhu}}</span>
				</el-form-item>
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
} from "@/utils/validate";
export default {
	data() {
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
				qichemingcheng : false,
				qichepinpai : false,
				qichexinghao : false,
				chepaihaoma : false,
				cheliangtupian : false,
				fadongjihao : false,
				shangpaishijian : false,
				baoyangdaoqi : false,
				xingshilicheng : false,
				xinxibeizhu : false,
				baoxiangongsi : false,
				baoxianjine : false,
				qizhiriqi : false,
				yonghuming : false,
			},
			
			
			ruleForm: {
				qichemingcheng: '',
				qichepinpai: '',
				qichexinghao: '',
				chepaihaoma: '',
				cheliangtupian: '',
				fadongjihao: '',
				shangpaishijian: '',
				baoyangdaoqi: '',
				xingshilicheng: '',
				xinxibeizhu: '',
				baoxiangongsi: '',
				baoxianjine: '',
				qizhiriqi: '',
				yonghuming: '',
			},
		
			qichemingchengOptions: [],
			yonghumingOptions: [],

			
			rules: {
				qichemingcheng: [
					{ required: true, message: '汽车名称不能为空', trigger: 'blur' },
				],
				qichepinpai: [
					{ required: true, message: '汽车品牌不能为空', trigger: 'blur' },
				],
				qichexinghao: [
					{ required: true, message: '汽车型号不能为空', trigger: 'blur' },
				],
				chepaihaoma: [
					{ required: true, message: '车牌号码不能为空', trigger: 'blur' },
				],
				cheliangtupian: [
					{ required: true, message: '车辆图片不能为空', trigger: 'blur' },
				],
				fadongjihao: [
					{ required: true, message: '发动机号不能为空', trigger: 'blur' },
				],
				shangpaishijian: [
				],
				baoyangdaoqi: [
				],
				xingshilicheng: [
				],
				xinxibeizhu: [
				],
				baoxiangongsi: [
				],
				baoxianjine: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				qizhiriqi: [
				],
				yonghuming: [
					{ required: true, message: '用户名不能为空', trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
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
						if(o=='qichemingcheng'){
							this.ruleForm.qichemingcheng = obj[o];
							this.ro.qichemingcheng = true;
							continue;
						}
						if(o=='qichepinpai'){
							this.ruleForm.qichepinpai = obj[o];
							this.ro.qichepinpai = true;
							continue;
						}
						if(o=='qichexinghao'){
							this.ruleForm.qichexinghao = obj[o];
							this.ro.qichexinghao = true;
							continue;
						}
						if(o=='chepaihaoma'){
							this.ruleForm.chepaihaoma = obj[o];
							this.ro.chepaihaoma = true;
							continue;
						}
						if(o=='cheliangtupian'){
							this.ruleForm.cheliangtupian = obj[o];
							this.ro.cheliangtupian = true;
							continue;
						}
						if(o=='fadongjihao'){
							this.ruleForm.fadongjihao = obj[o];
							this.ro.fadongjihao = true;
							continue;
						}
						if(o=='shangpaishijian'){
							this.ruleForm.shangpaishijian = obj[o];
							this.ro.shangpaishijian = true;
							continue;
						}
						if(o=='baoyangdaoqi'){
							this.ruleForm.baoyangdaoqi = obj[o];
							this.ro.baoyangdaoqi = true;
							continue;
						}
						if(o=='xingshilicheng'){
							this.ruleForm.xingshilicheng = obj[o];
							this.ro.xingshilicheng = true;
							continue;
						}
						if(o=='xinxibeizhu'){
							this.ruleForm.xinxibeizhu = obj[o];
							this.ro.xinxibeizhu = true;
							continue;
						}
						if(o=='baoxiangongsi'){
							this.ruleForm.baoxiangongsi = obj[o];
							this.ro.baoxiangongsi = true;
							continue;
						}
						if(o=='baoxianjine'){
							this.ruleForm.baoxianjine = obj[o];
							this.ro.baoxianjine = true;
							continue;
						}
						if(o=='qizhiriqi'){
							this.ruleForm.qizhiriqi = obj[o];
							this.ro.qizhiriqi = true;
							continue;
						}
						if(o=='yonghuming'){
							this.ruleForm.yonghuming = obj[o];
							this.ro.yonghuming = true;
							continue;
						}
				}
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
            this.$http({
				url: `option/qichexinxi/qichemingcheng`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.qichemingchengOptions = data.data;
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
			qichemingchengChange () {
				this.$http({
					url: `follow/qichexinxi/qichemingcheng?columnValue=`+ this.ruleForm.qichemingcheng,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.qichepinpai){
							this.ruleForm.qichepinpai = data.data.qichepinpai
						}
						if(data.data.qichexinghao){
							this.ruleForm.qichexinghao = data.data.qichexinghao
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `cheliangxinxi/info/${id}`,
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
	if(this.ruleForm.cheliangtupian!=null) {
		this.ruleForm.cheliangtupian = this.ruleForm.cheliangtupian.replace(new RegExp(this.$base.url,"g"),"");
	}
var objcross = this.$storage.getObj('crossObj');
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
					url: "cheliangxinxi/page", 
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
								url: `cheliangxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.cheliangxinxiCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
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
				url: `cheliangxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
							this.parent.cheliangxinxiCrossAddOrUpdateFlag = false;
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
      this.parent.cheliangxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    cheliangtupianUploadChange(fileUrls) {
	    this.ruleForm.cheliangtupian = fileUrls;
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
