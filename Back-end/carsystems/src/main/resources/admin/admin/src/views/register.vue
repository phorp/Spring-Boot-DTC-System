<template>
	<div>
		<div class="container" :style='{"width":"100%","padding":"0","alignItems":"center","background":"url(http://codegen.caihongy.cn/20240111/12c6d7acd1924b6e8dff66b25dbc034d.png) 0% 0% / cover","justifyContent":"center","display":"flex"}'>
			<el-form v-if="pageFlag=='register'" :style='{"padding":"20px 40px","margin":"40px auto ","borderRadius":"5px","background":"#fff","flexDirection":"column","display":"flex","width":"600px","position":"relative","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"padding":"0  20px","margin":"20px  0 20px  -75px","color":"#fff","textAlign":"left","background":"url(http://codegen.caihongy.cn/20240116/2a4c21b93d404ff5a90bc1ef9cbafca2.png) no-repeat left center / 100% 100%","width":"100%","fontSize":"15px","lineHeight":"50px","textShadow":"none","height":"60px"}' class="title">车企数字化管理系统注册</div>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('yonghuming')?'required':''">用户名：</div>
					<el-input  v-model="ruleForm.yonghuming"  autocomplete="off" placeholder="用户名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('xingming')?'required':''">姓名：</div>
					<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yonghuxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="yonghutouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
					<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='weixiugongren'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('weixiugonghao')?'required':''">维修工号：</div>
					<el-input  v-model="ruleForm.weixiugonghao"  autocomplete="off" placeholder="维修工号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='weixiugongren'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='weixiugongren'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='weixiugongren'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('xingming')?'required':''">姓名：</div>
					<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='weixiugongren'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('zhaopian')?'required':''">照片：</div>
                    <file-upload
                        tip="点击上传照片"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.zhaopian?ruleForm.zhaopian:''"
                        @change="weixiugongrenzhaopianUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='weixiugongren'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
					<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='weixiugongren'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
					<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"100%"}' class="list-item" v-if="tableName=='weixiugongren'">
					<div v-if="false" :style='{"margin":"0 0 0 -60px","fontSize":"14px","position":"absolute","color":"#818181","fontWeight":"400"}' class="lable" :class="changeRules('shenfenzhenghao')?'required':''">身份证号：</div>
					<el-input  v-model="ruleForm.shenfenzhenghao"  autocomplete="off" placeholder="身份证号"  type="text"  />
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"none","color":"#fff","display":"block","outline":"none","borderRadius":"8px","background":"linear-gradient(to right, #E52926, #FF7A1B)","width":"100%","fontSize":"24px","fontWeight":"700","height":"50px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","margin":"10px 0 0 0","color":"#C61C14","display":"block","lineHeight":"20px","fontSize":"14px","textDecoration":"none","fontWeight":"400"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					yonghuming: '',
					mima: '',
					xingming: '',
					xingbie: '',
					touxiang: '',
					shouji: '',
					money: '',
				}
			}
			if(this.tableName=='weixiugongren'){
				this.ruleForm = {
					weixiugonghao: '',
					mima: '',
					xingming: '',
					zhaopian: '',
					nianling: '',
					lianxidianhua: '',
					shenfenzhenghao: '',
					money: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuming = [{ required: true, message: '请输入用户名', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			if ('weixiugongren' == this.tableName) {
				this.rules.weixiugonghao = [{ required: true, message: '请输入维修工号', trigger: 'blur' }]
			}
			if ('weixiugongren' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('weixiugongren' == this.tableName) {
				this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        weixiugongrenzhaopianUploadChange(fileUrls) {
            this.ruleForm.zhaopian = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.yonghuming) && `yonghu` == this.tableName){
						this.$message.error(`用户名不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `yonghu` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.xingming) && `yonghu` == this.tableName){
						this.$message.error(`姓名不能为空`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if(`yonghu` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
						this.$message.error(`手机应输入手机格式`);
						return
					}
					if((!this.ruleForm.weixiugonghao) && `weixiugongren` == this.tableName){
						this.$message.error(`维修工号不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `weixiugongren` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `weixiugongren` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.xingming) && `weixiugongren` == this.tableName){
						this.$message.error(`姓名不能为空`);
						return
					}
            if(this.ruleForm.zhaopian!=null) {
                this.ruleForm.zhaopian = this.ruleForm.zhaopian.replace(new RegExp(this.$base.url,"g"),"");
            }
					if(`weixiugongren` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
						this.$message.error(`年龄应输入整数`);
						return
					}
					if(`weixiugongren` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
					if(`weixiugongren` == this.tableName && this.ruleForm.shenfenzhenghao &&(!this.$validate.checkIdCard(this.ruleForm.shenfenzhenghao))){
						this.$message.error(`身份证号应输入身份证格式`);
						return
					}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20240111/12c6d7acd1924b6e8dff66b25dbc034d.png) 0% 0% / cover;

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid #D7D7D7;
						border-radius: 5px;
						color: #818181;
						font-size: 14px;
						height: 50px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid #D7D7D7;
						border-radius: 5px;
						padding: 0 10px;
						color: #818181;
						display: flex;
						width: 100%;
						font-size: 14px;
						height: 50px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #D7D7D7;
						border-radius: 5px;
						padding: 0 10px 0 30px;
						box-shadow: none;
						outline: none;
						color: #818181;
						width: 100%;
						font-size: 14px;
						height: 50px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #D7D7D7;
						border-radius: 5px;
						padding: 0 10px 0 30px;
						box-shadow: none;
						outline: none;
						color: #818181;
						width: 100%;
						font-size: 14px;
						height: 50px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px solid  #D7D7D7;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  margin: 0 280px 0 0 ;
		  		  color: #3D3D3D;
		  		  font-weight: 700;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 160px;
		  		  height: 160px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px solid  #D7D7D7;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  margin: 0 280px 0 0 ;
		  		  color: #3D3D3D;
		  		  font-weight: 700;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 160px;
		  		  height: 160px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px solid  #D7D7D7;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  margin: 0 280px 0 0 ;
		  		  color: #3D3D3D;
		  		  font-weight: 700;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 160px;
		  		  height: 160px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: -10px;
				display: none;
				position: absolute;
				content: "*";
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
