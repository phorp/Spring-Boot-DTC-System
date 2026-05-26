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
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="服务单号" prop="fuwudanhao">
              <el-input v-model="ruleForm.fuwudanhao" placeholder="服务单号" disabled></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="用户名" prop="yonghuming">
            <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" clearable :disabled="true  ||ro.yonghuming"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="手机" prop="shouji">
            <el-input v-model="ruleForm.shouji" 
                placeholder="手机" clearable :disabled="true  ||ro.shouji"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="车牌号码" prop="chepaihaoma">
            <el-input v-model="ruleForm.chepaihaoma" 
                placeholder="车牌号码" clearable :disabled="true  ||ro.chepaihaoma"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="进度图片" v-if="type!='cross' || (type=='cross' && !ro.jindutupian)" prop="jindutupian">
            <file-upload
            tip="点击上传进度图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.jindutupian?ruleForm.jindutupian:''"
            @change="jindutupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="进度图片" prop="jindutupian">
                <img v-if="ruleForm.jindutupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.jindutupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.jindutupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="进度情况" prop="jinduqingkuang">
            <el-select v-model="ruleForm.jinduqingkuang" placeholder="请选择进度情况" :disabled=" false  ||ro.jinduqingkuang" >
              <el-option
                  v-for="(item,index) in jinduqingkuangOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="金额费用" prop="jinefeiyong">
            <el-input v-model.number="ruleForm.jinefeiyong" 
                placeholder="金额费用" clearable :disabled=" false  ||ro.jinefeiyong"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="工时信息" prop="gongshixinxi">
            <el-input v-model="ruleForm.gongshixinxi" 
                placeholder="工时信息" clearable :disabled=" false  ||ro.gongshixinxi"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="服务时间" prop="fuwushijian">
              <el-date-picker
				  :disabled=" false  ||ro.fuwushijian"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.fuwushijian" 
                  type="datetime"
                  placeholder="服务时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="服务评价" prop="fuwupingjia">
            <el-select v-model="ruleForm.fuwupingjia" placeholder="请选择服务评价" :disabled="true  ||ro.fuwupingjia" >
              <el-option
                  v-for="(item,index) in fuwupingjiaOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="维修工号" prop="weixiugonghao">
            <el-input v-model="ruleForm.weixiugonghao" 
                placeholder="维修工号" clearable :disabled="true  ||ro.weixiugonghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="联系电话" prop="lianxidianhua">
            <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" clearable :disabled="true  ||ro.lianxidianhua"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="进度说明" prop="jindushuoming">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="进度说明"
              v-model="ruleForm.jindushuoming">
            </el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="费用明细" prop="feiyongmingxi">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="费用明细"
              v-model="ruleForm.feiyongmingxi">
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
				fuwudanhao : false,
				yonghuming : false,
				shouji : false,
				chepaihaoma : false,
				jindutupian : false,
				jinduqingkuang : false,
				jindushuoming : false,
				jinefeiyong : false,
				gongshixinxi : false,
				fuwushijian : false,
				fuwupingjia : false,
				feiyongmingxi : false,
				weixiugonghao : false,
				lianxidianhua : false,
				ispay : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          fuwudanhao: this.getUUID(),
          yonghuming: '',
          shouji: '',
          chepaihaoma: '',
          jindutupian: '',
          jinduqingkuang: '进行中' ,
          jindushuoming: '',
          jinefeiyong: '',
          gongshixinxi: '',
          fuwushijian: '',
          fuwupingjia: '未评价' ,
          feiyongmingxi: '',
          weixiugonghao: '',
          lianxidianhua: '',
          ispay: '',
        },
        jinduqingkuangOptions: [],
        fuwupingjiaOptions: [],


        rules: {
          fuwudanhao: [
          ],
          yonghuming: [
          ],
          shouji: [
            { validator: this.$validate.isMobile, trigger: 'blur' },
          ],
          chepaihaoma: [
          ],
          jindutupian: [
          ],
          jinduqingkuang: [
          ],
          jindushuoming: [
          ],
          jinefeiyong: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          gongshixinxi: [
          ],
          fuwushijian: [
          ],
          fuwupingjia: [
          ],
          feiyongmingxi: [
          ],
          weixiugonghao: [
            { required: true, message: '维修工号不能为空', trigger: 'blur' },
          ],
          lianxidianhua: [
            { validator: this.$validate.isMobile, trigger: 'blur' },
          ],
          ispay: [
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
      this.ruleForm.fuwushijian = this.getCurDateTime()
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
            if(o=='fuwudanhao'){
              this.ruleForm.fuwudanhao = obj[o];
              this.ro.fuwudanhao = true;
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
            if(o=='chepaihaoma'){
              this.ruleForm.chepaihaoma = obj[o];
              this.ro.chepaihaoma = true;
              continue;
            }
            if(o=='jindutupian'){
              this.ruleForm.jindutupian = obj[o].split(",")[0];
              this.ro.jindutupian = true;
              continue;
            }
            if(o=='jinduqingkuang'){
              this.ruleForm.jinduqingkuang = obj[o];
              this.ro.jinduqingkuang = true;
              continue;
            }
            if(o=='jindushuoming'){
              this.ruleForm.jindushuoming = obj[o];
              this.ro.jindushuoming = true;
              continue;
            }
            if(o=='jinefeiyong'){
              this.ruleForm.jinefeiyong = obj[o];
              this.ro.jinefeiyong = true;
              continue;
            }
            if(o=='gongshixinxi'){
              this.ruleForm.gongshixinxi = obj[o];
              this.ro.gongshixinxi = true;
              continue;
            }
            if(o=='fuwushijian'){
              this.ruleForm.fuwushijian = obj[o];
              this.ro.fuwushijian = true;
              continue;
            }
            if(o=='fuwupingjia'){
              this.ruleForm.fuwupingjia = obj[o];
              this.ro.fuwupingjia = true;
              continue;
            }
            if(o=='feiyongmingxi'){
              this.ruleForm.feiyongmingxi = obj[o];
              this.ro.feiyongmingxi = true;
              continue;
            }
            if(o=='weixiugonghao'){
              this.ruleForm.weixiugonghao = obj[o];
              this.ro.weixiugonghao = true;
              continue;
            }
            if(o=='lianxidianhua'){
              this.ruleForm.lianxidianhua = obj[o];
              this.ro.lianxidianhua = true;
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
            if((json.weixiugonghao!=''&&json.weixiugonghao) || json.weixiugonghao==0){
                this.ruleForm.weixiugonghao = json.weixiugonghao;
				this.ro.weixiugonghao = true;
            }
            if((json.lianxidianhua!=''&&json.lianxidianhua) || json.lianxidianhua==0){
                this.ruleForm.lianxidianhua = json.lianxidianhua;
				this.ro.lianxidianhua = true;
            }
          }
        });
        this.jinduqingkuangOptions = "进行中,已完成".split(',')
        this.fuwupingjiaOptions = "已评价,未评价".split(',')

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`jinduxinxi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
		this.ruleForm.ispay = '未支付'
			if(this.ruleForm.fuwudanhao){
				this.ruleForm.fuwudanhao = String(this.ruleForm.fuwudanhao)
			}
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
						this.$http.get('jinduxinxi/list', {
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


								this.$http.post(`jinduxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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


						this.$http.post(`jinduxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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
      jindutupianUploadChange(fileUrls) {
          this.ruleForm.jindutupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
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
