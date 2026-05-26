<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","padding":"0","alignItems":"center","background":"url(http://codegen.caihongy.cn/20240111/12c6d7acd1924b6e8dff66b25dbc034d.png) no-repeat center top  / 100% 100%","display":"flex","width":"100%","justifyContent":"center","height":"auto"}'>
      <el-form :style='{"border":"0","boxShadow":"none","padding":"20px  40px","margin":"0 auto","borderRadius":"5px","background":"#fff","width":"600px","position":"relative"}'>
        <div v-if="true" :style='{"padding":"0  20px","margin":"30px  0 20px  -74px","color":"#fff","background":"url(http://codegen.caihongy.cn/20240116/2a4c21b93d404ff5a90bc1ef9cbafca2.png) no-repeat left center / 100% 100%","width":"100%","fontSize":"15px","lineHeight":"50px","fontWeight":"400","height":"60px"}' class="title-container">车企数字化管理系统登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"100%","padding":"10px 0","overflow":"hidden","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="false" class="lable" :style='{"margin":"0  5px 0 0","overflow":"hidden","color":"#818181","textAlign":"right","width":"24%","fontSize":"14px","lineHeight":"80px","fontWeight":"400","height":"80px"}'>用户名：</div>
          <input :style='{"border":"1px solid #DCDEE0","padding":"0 10px","outline":"none","color":"#818181","outlineOffset":"4px","borderRadius":"5px","width":"578px","fontSize":"14px","height":"50px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"100%","padding":"10px 0","overflow":"hidden","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="false" class="lable" :style='{"margin":"0  5px 0 0","overflow":"hidden","color":"#818181","textAlign":"right","width":"24%","fontSize":"14px","lineHeight":"80px","fontWeight":"400","height":"80px"}'>密码：</div>
          <input :style='{"border":"1px solid #DCDEE0","padding":"0 10px","outline":"none","color":"#818181","outlineOffset":"4px","borderRadius":"5px","width":"578px","fontSize":"14px","height":"50px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>

        <div :style='{"width":"100%","margin":"20px 0 0","background":"#fff"}' v-if="roles.length>1" prop="loginInRole" class="list-type">
          <el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
        </div>

		
        <div :style='{"width":"100%100%","background":"#fff","flexDirection":"column","display":"flex"}'>
          <el-button v-if="loginType==1" :style='{"border":"0","margin":"10px 0 10px 0","color":"#fff","borderRadius":"4px","background":"rgb(81, 130, 181)","fontWeight":"700","height":"50px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>
import menu from "@/utils/menu";
export default {
  data() {
    return {
		verifyCheck2: false,
		flag: false,
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
      },
      menus: [],
      roles: [],
      tableName: "",
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {

  },
  destroyed() {
	    },
  components: {
  },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
		this.$router.push({path:'/register',query:{pageFlag:'register'}})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}
		
		this.loginPost()
    },
	loginPost() {
		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/" });
			} else {
				this.$message.error(data.msg);
			}
		});
	},
  }
}
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20240111/12c6d7acd1924b6e8dff66b25dbc034d.png) no-repeat center top  / 100% 100%;
        
  .list-item /deep/ .el-input .el-input__inner {
		border: 1px solid #DCDEE0;
		border-radius: 5px;
		padding: 0 10px;
		outline: none;
		color: #818181;
		width: 578px;
		font-size: 14px;
		outline-offset: 4px;
		height: 50px;
	  }
  
  .list-item.select /deep/ .el-select .el-input__inner {
		border: 1px solid rgba(64, 158, 255, 1);
		padding: 0 10px;
		box-shadow: 0 0 6px rgba(64, 158, 255, .5);
		outline: 1px solid #efefef;
		color: rgba(64, 158, 255, 1);
		width: 288px;
		font-size: 14px;
		outline-offset: 4px;
		height: 44px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border: 1px solid #D7D7D7;
  	  	border-radius: 5px;
  	  	padding: 0 20px 0 20px;
  	  	outline: none;
  	  	color: #D7D7D7;
  	  	width: 100%;
  	  	font-size: 14px;
  	  	height: 50px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		background: rgba(53, 53, 53, 0);
		border-color: #666666;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        background: rgb(81, 130, 181);
        border-color: rgb(81, 130, 181);
      }
  .list-type /deep/ .el-radio__label {
		color: #666666;
		font-size: 14px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: rgb(81, 130, 181);
        font-size: 14px;
      }
}

</style>
