<template>
<div :style='{"width":"100%","padding":"30px 18% 40px","margin":"0px auto","position":"relative","background":"#fff"}'>
    <el-form
	  :style='{"border":"1px solid #eee","padding":"30px 0","alignItems":"flex-start","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="120px"
    >
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="汽车名称" prop="qichemingcheng">
            <el-select  @change="qichemingchengChange" v-model="ruleForm.qichemingcheng" placeholder="请选择汽车名称">
              <el-option
                  v-for="(item,index) in qichemingchengOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="汽车品牌" prop="qichepinpai">
            <el-input v-model="ruleForm.qichepinpai" 
                placeholder="汽车品牌" clearable :disabled=" false  ||ro.qichepinpai"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="汽车型号" prop="qichexinghao">
            <el-input v-model="ruleForm.qichexinghao" 
                placeholder="汽车型号" clearable :disabled=" false  ||ro.qichexinghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="车牌号码" prop="chepaihaoma">
            <el-input v-model="ruleForm.chepaihaoma" 
                placeholder="车牌号码" clearable :disabled=" false  ||ro.chepaihaoma"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="车辆图片" v-if="type!='cross' || (type=='cross' && !ro.cheliangtupian)" prop="cheliangtupian">
            <file-upload
            tip="点击上传车辆图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.cheliangtupian?ruleForm.cheliangtupian:''"
            @change="cheliangtupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="车辆图片" prop="cheliangtupian">
                <img v-if="ruleForm.cheliangtupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.cheliangtupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.cheliangtupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="发动机号" prop="fadongjihao">
            <el-input v-model="ruleForm.fadongjihao" 
                placeholder="发动机号" clearable :disabled=" false  ||ro.fadongjihao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="上牌时间" prop="shangpaishijian">
              <el-date-picker
				  :disabled=" false  ||ro.shangpaishijian"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.shangpaishijian" 
                  type="date"
                  placeholder="上牌时间">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="保养到期" prop="baoyangdaoqi">
              <el-date-picker
				  :disabled=" false  ||ro.baoyangdaoqi"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.baoyangdaoqi" 
                  type="date"
                  placeholder="保养到期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="行驶里程" prop="xingshilicheng">
            <el-input v-model="ruleForm.xingshilicheng" 
                placeholder="行驶里程" clearable :disabled=" false  ||ro.xingshilicheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="保险公司" prop="baoxiangongsi">
            <el-input v-model="ruleForm.baoxiangongsi" 
                placeholder="保险公司" clearable :disabled=" false  ||ro.baoxiangongsi"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="保险金额" prop="baoxianjine">
            <el-input v-model.number="ruleForm.baoxianjine" 
                placeholder="保险金额" clearable :disabled=" false  ||ro.baoxianjine"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="起止日期" prop="qizhiriqi">
            <el-input v-model="ruleForm.qizhiriqi" 
                placeholder="起止日期" clearable :disabled=" false  ||ro.qizhiriqi"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="用户名" prop="yonghuming">
            <el-select v-model="ruleForm.yonghuming" placeholder="请选择用户名" :disabled=" false  ||ro.yonghuming" >
              <el-option
                  v-for="(item,index) in yonghumingOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="信息备注" prop="xinxibeizhu">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="信息备注"
              v-model="ruleForm.xinxibeizhu">
            </el-input>
          </el-form-item>

      <el-form-item :style='{"width":"100%","padding":"0","margin":"0","textAlign":"center"}'>
        <el-button :style='{"border":"0px solid #eccc19","cursor":"pointer","padding":"0","margin":"0 20px 0 0","color":"#fff","borderRadius":"20px","background":"linear-gradient(to right,#f67536,#369ff6),#369ff6","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #ccc","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#666","borderRadius":"20px","background":"none","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
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
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
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
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          qizhiriqi: [
          ],
          yonghuming: [
            { required: true, message: '用户名不能为空', trigger: 'blur' },
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
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
              this.ruleForm.cheliangtupian = obj[o].split(",")[0];
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
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.$http.get('option/qichexinxi/qichemingcheng', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.qichemingchengOptions = res.data.data;
          }
        });
        this.$http.get('option/yonghu/yonghuming', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.yonghumingOptions = res.data.data;
          }
        });

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },
      // 下二随
      qichemingchengChange () {
        this.$http.get('follow/qichexinxi/qichemingcheng?columnValue=' + this.ruleForm.qichemingcheng, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            if(res.data.data.qichepinpai){
              this.ruleForm.qichepinpai = res.data.data.qichepinpai
            }
            if(res.data.data.qichexinghao){
              this.ruleForm.qichexinghao = res.data.data.qichexinghao
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`cheliangxinxi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('cheliangxinxi/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`cheliangxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`cheliangxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
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
			this.$router.go(-1);
		},
      cheliangtupianUploadChange(fileUrls) {
          this.ruleForm.cheliangtupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 120px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 120px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #ddd;
	  padding: 0 12px;
	  color: #666;
	  font-size: 14px;
	  border-color: #ddd;
	  border-radius: 0px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 200px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  border: 1px solid #ddd;
	  padding: 0 12px;
	  color: #666;
	  font-size: 14px;
	  border-color: #ddd;
	  border-radius: 0px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 200px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border-radius: 0px;
	  padding: 0 10px;
	  color: #666;
	  background: none;
	  width: auto;
	  font-size: 14px;
	  border-color: #ddd;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 250px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border-radius: 0px;
	  padding: 0 10px 0 30px;
	  color: #666;
	  background: none;
	  width: auto;
	  font-size: 14px;
	  border-color: #ddd;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 250px;
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
	  cursor: pointer;
	  color: #999;
	  font-size: 24px;
	  border-color: #ddd;
	  line-height: 54px;
	  border-radius: 2px;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  min-width: 150px;
	  height: 54px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  cursor: pointer;
	  color: #999;
	  font-size: 24px;
	  border-color: #ddd;
	  line-height: 54px;
	  border-radius: 2px;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  min-width: 150px;
	  height: 54px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  cursor: pointer;
	  color: #999;
	  font-size: 24px;
	  border-color: #ddd;
	  line-height: 54px;
	  border-radius: 2px;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  min-width: 150px;
	  height: 54px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #ddd;
	  border-radius: 0px;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: none;
	  width: 100%;
	  font-size: 14px;
	  height: 120px;
	}
</style>
