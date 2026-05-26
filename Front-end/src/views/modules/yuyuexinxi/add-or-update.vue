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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="车牌号码" prop="chepaihaoma">
					<el-input v-model="ruleForm.chepaihaoma" placeholder="车牌号码" clearable  :readonly="ro.chepaihaoma"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="车牌号码" prop="chepaihaoma">
					<el-input v-model="ruleForm.chepaihaoma" placeholder="车牌号码" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="预约类型" prop="yuyueleixing">
					<el-select :disabled="ro.yuyueleixing" v-model="ruleForm.yuyueleixing" placeholder="请选择预约类型" multiple filterable>
						<el-option
							v-for="(item,index) in yuyueleixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="预约类型" prop="yuyueleixing">
					<el-input v-model="ruleForm.yuyueleixing"
						placeholder="预约类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="预约情况" prop="yuyueqingkuang">
					<el-select :disabled="ro.yuyueqingkuang" v-model="ruleForm.yuyueqingkuang" placeholder="请选择预约情况" >
						<el-option
							v-for="(item,index) in yuyueqingkuangOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="预约情况" prop="yuyueqingkuang">
					<el-input v-model="ruleForm.yuyueqingkuang"
						placeholder="预约情况" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="预约日期" prop="yuyueriqi">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.yuyueriqi" 
						type="date"
						:readonly="ro.yuyueriqi"
                        :picker-options="yuyueriqiPickerOptions"
						placeholder="预约日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.yuyueriqi" label="预约日期" prop="yuyueriqi">
					<el-input v-model="ruleForm.yuyueriqi" placeholder="预约日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="时间段" prop="shijianduan">
					<el-select :disabled="ro.shijianduan" v-model="ruleForm.shijianduan" placeholder="请选择时间段" >
						<el-option
							v-for="(item,index) in shijianduanOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="时间段" prop="shijianduan">
					<el-input v-model="ruleForm.shijianduan"
						placeholder="时间段" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="用户名" prop="yonghuming">
					<el-input v-model="ruleForm.yonghuming" placeholder="用户名" clearable  :readonly="ro.yonghuming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="用户名" prop="yonghuming">
					<el-input v-model="ruleForm.yonghuming" placeholder="用户名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" clearable  :readonly="ro.shouji"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="故障描述" prop="guzhangmiaoshu">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="故障描述"
					  v-model="ruleForm.guzhangmiaoshu" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.guzhangmiaoshu" label="故障描述" prop="guzhangmiaoshu">
					<span :style='{"fontSize":"14px","lineHeight":"40px","color":"#666","fontWeight":"500","display":"inline-block"}'>{{ruleForm.guzhangmiaoshu}}</span>
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
		return {
			id: '',
			type: '',
			
			
			ro:{
				qichepinpai : false,
				qichexinghao : false,
				cheliangtupian : false,
				chepaihaoma : false,
				yuyueleixing : false,
				guzhangmiaoshu : false,
				yuyueqingkuang : false,
				yuyueriqi : false,
				shijianduan : false,
				yonghuming : false,
				shouji : false,
				shhf : false,
			},
			
			
			ruleForm: {
				qichepinpai: '',
				qichexinghao: '',
				cheliangtupian: '',
				chepaihaoma: '',
				yuyueleixing: [],
				guzhangmiaoshu: '',
				yuyueqingkuang: '未受理',
				yuyueriqi: '',
				shijianduan: '',
				yonghuming: '',
				shouji: '',
				shhf: '',
			},
		
			yuyueleixingOptions: [],
			yuyueqingkuangOptions: [],
			shijianduanOptions: [],

            yuyueriqiPickerOptions: {
                disabledDate(time) {
                    return time.getTime() < Date.now() - 8.64e7;
                }
            },
			
			rules: {
				qichepinpai: [
				],
				qichexinghao: [
				],
				cheliangtupian: [
				],
				chepaihaoma: [
				],
				yuyueleixing: [
				],
				guzhangmiaoshu: [
				],
				yuyueqingkuang: [
				],
				yuyueriqi: [
					{ required: true, message: '预约日期不能为空', trigger: 'blur' },
				],
				shijianduan: [
					{ required: true, message: '时间段不能为空', trigger: 'blur' },
				],
				yonghuming: [
					{ required: true, message: '用户名不能为空', trigger: 'blur' },
				],
				shouji: [
					{ validator: validateMobile, trigger: 'blur' },
				],
				shhf: [
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
						if(o=='cheliangtupian'){
							this.ruleForm.cheliangtupian = obj[o];
							this.ro.cheliangtupian = true;
							continue;
						}
						if(o=='chepaihaoma'){
							this.ruleForm.chepaihaoma = obj[o];
							this.ro.chepaihaoma = true;
							continue;
						}
						if(o=='yuyueleixing'){
							this.ruleForm.yuyueleixing = obj[o];
							this.ro.yuyueleixing = true;
							continue;
						}
						if(o=='guzhangmiaoshu'){
							this.ruleForm.guzhangmiaoshu = obj[o];
							this.ro.guzhangmiaoshu = true;
							continue;
						}
						if(o=='yuyueqingkuang'){
							this.ruleForm.yuyueqingkuang = obj[o];
							this.ro.yuyueqingkuang = true;
							continue;
						}
						if(o=='yuyueriqi'){
							this.ruleForm.yuyueriqi = obj[o];
							this.ro.yuyueriqi = true;
							continue;
						}
						if(o=='shijianduan'){
							this.ruleForm.shijianduan = obj[o];
							this.ro.shijianduan = true;
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
				this.ruleForm.yuyueqingkuang = '未受理'; 			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
					if(this.$storage.get("role")!="管理员") {
						this.ro.yuyueqingkuang = true;
					}
					if(((json.yonghuming!=''&&json.yonghuming) || json.yonghuming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.yonghuming = json.yonghuming
						this.ro.yonghuming = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.yonghuming = true;
					}
					if(((json.shouji!=''&&json.shouji) || json.shouji==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.shouji = json.shouji
						this.ro.shouji = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.shouji = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
            this.yuyueleixingOptions = "保养,维修".split(',')
            this.yuyueqingkuangOptions = "已受理,未受理".split(',')
            this.$http({
				url: `option/shijianduan/shijianduan`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.shijianduanOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `yuyuexinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.yuyueleixing = this.ruleForm.yuyueleixing.split(",");
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
				this.ruleForm.yuyueleixing = this.ruleForm.yuyueleixing.join(",");
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
					url: "yuyuexinxi/page", 
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
								url: `yuyuexinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.yuyuexinxiCrossAddOrUpdateFlag = false;
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
				url: `yuyuexinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
							this.parent.yuyuexinxiCrossAddOrUpdateFlag = false;
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
      this.parent.yuyuexinxiCrossAddOrUpdateFlag = false;
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
