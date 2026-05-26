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
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="配件名称" prop="peijianmingcheng">
            <el-input v-model="ruleForm.peijianmingcheng" 
                placeholder="配件名称" clearable :disabled="true  ||ro.peijianmingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="配件分类" prop="peijianfenlei">
            <el-input v-model="ruleForm.peijianfenlei" 
                placeholder="配件分类" clearable :disabled="true  ||ro.peijianfenlei"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="配件售价" prop="peijianshoujia">
            <el-input v-model.number="ruleForm.peijianshoujia" 
                placeholder="配件售价" clearable :disabled="true  ||ro.peijianshoujia"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="配件图片" v-if="type!='cross' || (type=='cross' && !ro.peijiantupian)" prop="peijiantupian">
            <file-upload
            tip="点击上传配件图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.peijiantupian?ruleForm.peijiantupian:''"
            @change="peijiantupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="配件图片" prop="peijiantupian">
                <img v-if="ruleForm.peijiantupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.peijiantupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.peijiantupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="配件数量" prop="peijianshuliang">
            <el-input v-model.number="ruleForm.peijianshuliang" 
                placeholder="配件数量" clearable :disabled=" false  ||ro.peijianshuliang"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="订单金额" prop="dingdanjine">
              <el-input v-model="dingdanjine" placeholder="订单金额" disabled></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="出库日期" prop="chukuriqi">
              <el-date-picker
				  :disabled="true  ||ro.chukuriqi"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.chukuriqi" 
                  type="datetime"
                  placeholder="出库日期">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="维修工号" prop="weixiugonghao">
            <el-input v-model="ruleForm.weixiugonghao" 
                placeholder="维修工号" clearable :disabled="true  ||ro.weixiugonghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="出库备注" prop="chukubeizhu">
            <el-input v-model="ruleForm.chukubeizhu" 
                placeholder="出库备注" clearable :disabled=" false  ||ro.chukubeizhu"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="用户名" prop="yonghuming">
            <el-select  @change="yonghumingChange" v-model="ruleForm.yonghuming" placeholder="请选择用户名">
              <el-option
                  v-for="(item,index) in yonghumingOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="手机" prop="shouji">
            <el-input v-model="ruleForm.shouji" 
                placeholder="手机" clearable :disabled=" false  ||ro.shouji"></el-input>
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
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
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
          ispay: '',
        },
        yonghumingOptions: [],


        rules: {
          peijianmingcheng: [
          ],
          peijianfenlei: [
          ],
          peijianshoujia: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          peijiantupian: [
          ],
          peijianshuliang: [
            { required: true, message: '配件数量不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          dingdanjine: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
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
            { validator: this.$validate.isMobile, trigger: 'blur' },
          ],
          ispay: [
          ],
        },
		centerType: false,
      };
    },
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
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.chukuriqi = this.getCurDateTime()
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
              this.ruleForm.peijiantupian = obj[o].split(",")[0];
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
            this.ruleForm.peijianshuliang = 0;
            this.ro.peijianshuliang = false;
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.weixiugonghao!=''&&json.weixiugonghao) || json.weixiugonghao==0){
                this.ruleForm.weixiugonghao = json.weixiugonghao;
				this.ro.weixiugonghao = true;
            }
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
      yonghumingChange () {
        this.$http.get('follow/yonghu/yonghuming?columnValue=' + this.ruleForm.yonghuming, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            if(res.data.data.shouji){
              this.ruleForm.shouji = res.data.data.shouji
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`peijianjilu/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
		this.ruleForm.ispay = '未支付'
			this.ruleForm.dingdanjine = this.dingdanjine
			if(!this.ruleForm.peijianshuliang){
				this.$message.error("配件数量不能为空");
				return
			}
			var obj = JSON.parse(localStorage.getItem('crossObj'));
			var table = localStorage.getItem('crossTable');
			obj.peijianshuliang = obj.peijianshuliang - this.ruleForm.peijianshuliang
			if(obj.peijianshuliang<0){
				this.$message.error("配件数量不足");
				return
			}
			//this.$http.post(table+`/update`, obj).then(res => {});
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
						this.$http.get('peijianjilu/list', {
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
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								var table = localStorage.getItem('crossTable');

								obj.peijianshuliang = parseFloat(obj.peijianshuliang) - parseFloat(this.ruleForm.peijianshuliang)

								this.$http.post(table+`/update`,obj).then(res => {});
								this.$http.post(`peijianjilu/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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
						var obj = JSON.parse(localStorage.getItem('crossObj'));
						var table = localStorage.getItem('crossTable');

						obj.peijianshuliang = parseFloat(obj.peijianshuliang) - parseFloat(this.ruleForm.peijianshuliang)

						this.$http.post(table+`/update`,obj).then(res => {});
						this.$http.post(`peijianjilu/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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
      peijiantupianUploadChange(fileUrls) {
          this.ruleForm.peijiantupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
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
