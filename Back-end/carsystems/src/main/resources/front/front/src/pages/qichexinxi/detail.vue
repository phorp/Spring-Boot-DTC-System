<template>
  <div>
    <div
        :style='{"padding":"20px 0","margin":"0px auto","borderColor":"#ddd","borderRadius":"0px","background":"none","borderWidth":"0 0 0px","width":"64%","borderStyle":"solid"}'
        class="breadcrumb-preview">
      <el-breadcrumb :separator="'='"
                     :style='{"fontSize":"14px","lineHeight":"1","justifyContent":"flex-start","display":"flex"}'>
        <el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
        <el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" to="/index/qichexinxi">
          <a>{{ item.name }}</a></el-breadcrumb-item>
        <el-breadcrumb-item class="item3"><a href="javascript:void(0);">详情</a></el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div
        :style='{"padding":"20px 0","margin":"0px auto","borderColor":"#ddd","borderRadius":"0px","background":"none","borderWidth":"0 0 0px","width":"64%","borderStyle":"solid"}'>
      <el-button size="mini" @click="backClick">返回</el-button>
    </div>
    <div class="detail-preview"
         :style='{"padding":"40px 18%","margin":"0 auto","alignItems":"flex-start","flexWrap":"wrap","background":"#efeeec","display":"flex","width":"100%","position":"relative","justifyContent":"space-between"}'>
      <div class="attr"
           :style='{"padding":"0","margin":"0","flexWrap":"wrap","background":"none","flex":"1","display":"flex","width":"51%","position":"relative","justifyContent":"space-between","order":"2"}'>

        <div class="info"
             :style='{"minHeight":"460px","padding":"20px","margin":"0","borderRadius":"8px","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","order":"2"}'>
          <div class="item"
               :style='{"padding":"0 8px","margin":"0 0 10px 0","borderColor":"#eccc19","alignItems":"center","display":"flex","justifyContent":"space-between","overflow":"hidden","borderRadius":"0px","background":"none","borderWidth":"0 0 0px","width":"100%","lineHeight":"auto","borderStyle":"solid","height":"50px"}'>
            <div
                :style='{"padding":"0px","color":"#222","flex":"1","display":"block","width":"calc(100% - 100px)","fontSize":"18px","lineHeight":"1.5","fontWeight":"600"}'>
              {{ detail.qichemingcheng }}
            </div>
            <div @click="storeup(1)" v-show="!isStoreup"
                 :style='{"border":"0px solid #eccc19","cursor":"pointer","padding":"0 10px","lineHeight":"32px","borderRadius":"20px","background":"linear-gradient(to right,#f67536,#369ff6),#369ff6"}'>
              <i v-if="true" :style='{"color":"#fff","fontSize":"18px"}' class="el-icon-star-off"></i><span
                :style='{"color":"#fff","fontSize":"15px"}'>点我收藏({{ detail.storeupnum }})</span></div>
            <div @click="storeup(-1)" v-show="isStoreup"
                 :style='{"border":"0px solid #eccc19","cursor":"pointer","padding":"0 10px","lineHeight":"32px","borderRadius":"20px","background":"linear-gradient(to right,#f67536,#369ff6),#369ff6"}'>
              <i v-if="true" :style='{"color":"#fff","fontSize":"18px"}' class="el-icon-star-on"></i><span
                :style='{"color":"#fff","fontSize":"15px"}'>取消收藏({{ detail.storeupnum }})</span></div>
          </div>
          <div class="item"
               :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'
               v-if="detail.price">
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>
              价格
            </div>
            <div style="font-weight: bold;"
                 :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>
              <span :style='{"fontSize":"12px"}'>￥</span>{{ detail.price }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'
               v-if="detail.jf">
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>
              积分
            </div>
            <div style="color: red;font-weight: bold;"
                 :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>
              {{ detail.jf }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>
              单限
            </div>
            <div
                :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>
              {{ detail.onelimittimes }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>
              库存
            </div>
            <div
                :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>
              {{ detail.alllimittimes }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>
              汽车品牌
            </div>
            <div
                :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>
              {{ detail.qichepinpai }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>
              汽车型号
            </div>
            <div
                :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>
              {{ detail.qichexinghao }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>
              车辆分类
            </div>
            <div
                :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>
              {{ detail.cheliangfenlei }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>
              可选颜色
            </div>
            <div
                :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>
              {{ detail.kexuanyanse }}
            </div>
          </div>
          <div class="item"
               :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
            <div class="lable"
                 :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>
              点击次数
            </div>
            <div
                :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>
              {{ detail.clicknum }}
            </div>
          </div>
          <div class="btn" :style='{"width":"100%","padding":"10px 0","flexWrap":"wrap","display":"flex"}'>
            <el-input-number
                :style='{"width":"140px","margin":"0 6px 0 0","lineHeight":"36px","position":"relative","display":"inline-block"}'
                v-if="detail.alllimittimes" :min=1 v-model="buynumber"></el-input-number>
            <el-button
                :style='{"border":"0px solid #1abc9e30","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#1abc9e","borderRadius":"0px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}'
                v-if="detail.alllimittimes" type="warning" size="small" @click="addCart">添加到购物车
            </el-button>
            <el-button
                :style='{"border":"0px solid #009cf530","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#009cf5","borderRadius":"0px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}'
                v-if="detail.alllimittimes" type="warning" size="small" @click="buyNow">立即购买
            </el-button>


            <el-button :style='{"border":"0px solid #1abc9e30","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#1abc9e","borderRadius":"0px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}'  @click="onAcross('shijia','','','','')" type="warning">预约试驾</el-button>

          </div>
          <div class="btn" :style='{"width":"100%","padding":"10px 0","flexWrap":"wrap","display":"flex"}'>
            <el-button
                :style='{"border":"0px solid #009cf530","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#009cf5","borderRadius":"0px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}'
                v-if="btnAuth('qichexinxi','修改')" @click="editClick">修改
            </el-button>
            <el-button
                :style='{"border":"0px solid #f5340030","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#f53400","borderRadius":"0px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}'
                v-if="btnAuth('qichexinxi','删除')" @click="delClick">删除
            </el-button>
            <el-button
                :style='{"border":"0px solid #f5340030","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#f53400","borderRadius":"0px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}'
                v-if="btnAuth('qichexinxi','私聊')&&detail.id!=mid" @click="chatClick">联系TA
            </el-button>
          </div>
        </div>
      </div>

      <div class="swiper3" v-if="detailBanner.length"
           :style='{"width":"45%","margin":"0 4% 0 0","background":"none","justifyContent":"space-between","display":"flex","height":"auto"}'>
        <div class="big"
             :style='{"border":"0px solid #1abc9e50","margin":"0 0 20px","borderRadius":"8px","background":"#fff","width":"calc(100% - 140px)","position":"relative","height":"460px","order":"2"}'>
          <img id="big"
               :style='{"objectFit":"cover","top":"0px","borderRadius":"8px","left":"0px","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}'
               :src="swiperBigUrl" class="image">
        </div>
        <div class="samll"
             :style='{"padding":"0 0px","overflow":"hidden","alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"block","width":"120px","justifyContent":"space-between","height":"auto","order":"2"}'>
          <div
              :style='{"border":"0px solid #1abc9e50","margin":"0 0px 20px","borderRadius":"4px","background":"#fff","width":"100%","position":"relative","height":"100px"}'
              v-for="item in detailBanner" :key="item.id">
            <img
                :style='{"border":"0px solid #eee","cursor":"pointer","padding":"4px","objectFit":"cover","top":"0px","left":"0px","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}'
                v-if="item.substr(0,4)=='http'" :src="item" @click="swiperClick3(item)" class="image">
            <img
                :style='{"border":"0px solid #eee","cursor":"pointer","padding":"4px","objectFit":"cover","top":"0px","left":"0px","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}'
                v-else :src="baseUrl + item" @click="swiperClick3(baseUrl + item)" class="image">
          </div>
        </div>
      </div>


      <video
          :style='{"border":"0","minHeight":"300px","margin":"30px 0 20px 0","borderRadius":"0","maxHeight":"480px","display":"block","width":"100%","order":"40"}'
          :src="baseUrl +  detail.xuanchuanshipin" controls="controls">
        您的浏览器不支持视频播放
      </video>


      <el-tabs class="detail"
               :style='{"border":"0px solid #28890b20","minHeight":"250px","boxShadow":"none","padding":"0","margin":"20px auto","borderRadius":"8px","background":"none","display":"block","width":"100%","order":"80"}'
               v-model="activeName" type="border-card">
        <el-tab-pane label="汽车介绍" name="first">
          <div v-html="detail.qichejieshao"></div>
        </el-tab-pane>
        <el-tab-pane label="评论" name="second">
          <el-form class="add comment" :style='{"padding":"15px","margin":"0 0 20px"}' :model="form" :rules="rules"
                   ref="form">
            <el-form-item class="item" :style='{"width":"100%","display":"flex","height":"auto"}' label="评论"
                          prop="content">
              <editor
                  :style='{"minHeight":"200px","border":"0","outline":"none","color":"#333","borderRadius":"4px","width":"100%","lineHeight":"32px","fontSize":"14px"}'
                  v-model="form.content"
                  class="editor"
                  action="file/upload">
              </editor>
            </el-form-item>
            <el-form-item class="btn"
                          :style='{"width":"100%","padding":"0 0 0 80px","margin":"10px 0 0","height":"auto"}'>
              <el-button
                  :style='{"border":"1px solid #eccc19","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#daba0a","borderRadius":"0px","background":"none","width":"110px","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                  type="primary" @click="submitForm('form')">立即提交
              </el-button>
              <el-button
                  :style='{"border":"1px solid #bbb","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#333","borderRadius":"0px","background":"none","width":"110px","lineHeight":"40px","fontSize":"14px","height":"40px"}'
                  @click="resetForm('form')">重置
              </el-button>
            </el-form-item>
          </el-form>

          <div v-if="infoList.length" :style='{"padding":"15px"}' class="comment">
            <div
                :style='{"padding":"8px 20px","margin":"0 0 20px","borderColor":"#28890b10","alignItems":"center","borderWidth":"0px","background":"none","width":"100%","borderStyle":"solid","height":"auto"}'
                v-for="item in infoList" :key="item.id" @mouseenter="discussEnter(item.id)"
                @mouseleave="discussLeave">
              <div class="user" :style='{"width":"100%","alignItems":"center","display":"flex","height":"auto"}'>
                <el-image v-if="item.avatarurl"
                          :style='{"width":"40px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"40px"}'
                          :size="50" :src="baseUrl + item.avatarurl"></el-image>
                <el-image v-if="!item.avatarurl"
                          :style='{"width":"40px","margin":"0 10px 0 0","borderRadius":"100%","objectFit":"cover","height":"40px"}'
                          :size="50" :src="require('@/assets/touxiang.png')"></el-image>
                <div :style='{"color":"#333","fontSize":"16px"}' class="name">{{ item.nickname }}</div>
              </div>
              <div
                  :style='{"padding":"0px","margin":"10px 0px 0px","color":"#333","borderRadius":"4px","background":"none","wordWrap":"break-word","lineHeight":"30px","fontSize":"14px"}'
                  class="content-block-ask">
                <div v-html="item.content"></div>
                <div class="btn"
                     :style='{"width":"100%","margin":"8px 0 0 0","alignItems":"center","justifyContent":"flex-end","display":"flex","height":"40px"}'>
                  <!-- <el-button :style='{"border":"1px solid #eccc19","cursor":"pointer","padding":"0 20px","margin":"0 10px","outline":"none","color":"#eccc19","borderRadius":"0px","background":"none","width":"auto","lineHeight":"32px","fontSize":"14px","height":"32px"}'>回复</el-button> -->
                  <el-button v-if="showIndex==item.id&&userid==item.userid" @click="discussDel(item.id)"
                             :style='{"border":"1px solid #ccc","cursor":"pointer","padding":"0 20px","margin":"0 10px","outline":"none","color":"#333","borderRadius":"0px","background":"none","width":"auto","lineHeight":"32px","fontSize":"14px","height":"32px"}'>
                    删除
                  </el-button>
                </div>
              </div>
              <div
                  :style='{"padding":"0px","margin":"10px 0px 0px","color":"#333","borderRadius":"4px","background":"none","wordWrap":"break-word","lineHeight":"30px","fontSize":"14px"}'
                  class="content-block-reply" v-if="item.reply">
                回复：<span v-html="item.reply"></span>
              </div>
            </div>
          </div>

          <el-pagination
              background
              id="pagination" class="pagination"
              :pager-count="7"
              :page-size="pageSize"
              prev-text="<"
              next-text=">"
              :hide-on-single-page="false"
              :layout='["total","prev","pager","next","sizes"].join()'
              :total="total"
              :style='{"padding":"0","margin":"0 auto","color":"#333","textAlign":"left","width":"100%","lineHeight":"40px","float":"left","fontWeight":"500","height":"40px","order":"50"}'
              @current-change="curChange"
              @prev-click="prevClick"
              @next-click="nextClick"
          ></el-pagination>
        </el-tab-pane>
      </el-tabs>
    </div>
    <div class="share_view"
         :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","position":"fixed","right":"0","bottom":"20%","background":"#fff","zIndex":"11"}'>
    </div>
  </div>
</template>

<script>
import CountDown from '@/components/CountDown';
import axios from 'axios'
import Swiper from "swiper";

export default {
  //数据集合
  data() {
    return {
      tablename: 'qichexinxi',
      baseUrl: '',
      breadcrumbItem: [
        {
          name: '汽车信息'
        }
      ],
      title: '',
      detailBanner: [],
      userid: localStorage.getItem('frontUserid'),
      id: 0,
      detail: {},
      activeName: 'second',
      form: {
        content: '',
        userid: localStorage.getItem('frontUserid'),
        nickname: localStorage.getItem('username'),
        avatarurl: '',
      },
      showIndex: -1,
      infoList: [],
      rules: {
        content: [
          {required: true, message: '请输入内容', trigger: 'blur'}
        ],
      },
      total: 1,
      pageSize: 5,
      totalPage: 1,
      storeupParams: {
        name: '',
        picture: '',
        refid: 0,
        tablename: 'qichexinxi',
        userid: localStorage.getItem('frontUserid')
      },
      isStoreup: false,
      storeupInfo: {},
      buynumber: 1,
      cart: {
        buynumber: 0,
        discountprice: 0,
        goodid: 0,
        goodname: '',
        picture: '',
        price: 0,
        userid: localStorage.getItem('frontUserid')
      },
      isInCart: false,
      centerType: false,
      shareUrl: location.href,
      swiperBigUrl: null,
    }
  },
  created() {
    if (this.$route.query.centerType) {
      this.centerType = true
    }

    this.init();
  },
  mounted() {
  },
  //方法集合
  methods: {
    swiperClick3(src) {
      this.swiperBigUrl = src
    },
    init() {
      this.id = this.$route.query.id
      this.baseUrl = this.$config.baseUrl;
      this.$http.get(this.tablename + '/detail/' + this.id, {}).then(res => {
        if (res.data.code == 0) {
          this.detail = res.data.data;
          this.title = this.detail.qichemingcheng;
          this.detailBanner = this.detail.qichetupian ? this.detail.qichetupian.split(",") : [];
          this.$forceUpdate();

          this.getDiscussList(1);
          if (localStorage.getItem('frontToken')) {
            this.getStoreupStatus();
            this.getCartList();
          }

        }
        if (this.detailBanner.length) {
          if (this.detailBanner[0].substr(0, 4) == 'http') {
            this.swiperBigUrl = this.detailBanner[0]
          } else {
            this.swiperBigUrl = this.baseUrl + this.detailBanner[0]
          }
        }
      });
    },
    storeup(type) {
      if (type == 1 && !this.isStoreup) {
        this.storeupParams.name = this.title;
        this.storeupParams.picture = this.detailBanner[0];
        this.storeupParams.refid = this.detail.id;
        this.storeupParams.type = type;
        this.$http.post('storeup/add', this.storeupParams).then(res => {
          if (res.data.code == 0) {
            this.isStoreup = true;
            this.detail.storeupnum++
            this.$http.post('qichexinxi/update', this.detail).then(res => {
            });
            this.$message({
              type: 'success',
              message: '收藏成功!',
              duration: 1500,
            });
          }
        });
      }
      if (type == -1 && this.isStoreup) {
        this.$http.get('storeup/list', {
          params: {
            page: 1,
            limit: 1,
            type: 1,
            refid: this.detail.id,
            tablename: 'qichexinxi',
            userid: localStorage.getItem('frontUserid')
          }
        }).then(res => {
          if (res.data.code == 0 && res.data.data.list.length > 0) {
            this.isStoreup = true;
            this.storeupInfo = res.data.data.list[0];
            let delIds = new Array();
            delIds.push(this.storeupInfo.id);
            this.$http.post('storeup/delete', delIds).then(res => {
              if (res.data.code == 0) {
                this.isStoreup = false;
                this.detail.storeupnum--
                this.$http.post('qichexinxi/update', this.detail).then(res => {
                });
                this.$message({
                  type: 'success',
                  message: '取消成功!',
                  duration: 1500,
                });
              }
            });
          }
        });
      }
    },
    getStoreupStatus() {
      if (localStorage.getItem("frontToken")) {
        this.$http.get('storeup/list', {
          params: {
            page: 1,
            limit: 1,
            type: 1,
            refid: this.detail.id,
            tablename: 'qichexinxi',
            userid: localStorage.getItem('frontUserid')
          }
        }).then(res => {
          if (res.data.code == 0 && res.data.data.list.length > 0) {
            this.isStoreup = true;
            this.storeupInfo = res.data.data.list[0];
          }
        });
      }
    },

    async onAcross(acrossTable, crossOptAudit, crossOptPay, statusColumnName, tips, statusColumnValue, type = 1) {
      localStorage.setItem('crossTable', `qichexinxi`);
      localStorage.setItem('crossObj', JSON.stringify(this.detail));
      localStorage.setItem('statusColumnName', statusColumnName);
      localStorage.setItem('statusColumnValue', statusColumnValue);
      localStorage.setItem('tips', tips);
      if (statusColumnName != '' && !statusColumnName.startsWith("[")) {
        var obj = JSON.parse(localStorage.getItem('crossObj'));
        for (var o in obj) {
          if (o == statusColumnName && obj[o] == statusColumnValue) {
            this.$message({
              type: 'error',
              message: tips,
              duration: 1500
            });
            return
          }
        }
      }
      this.$router.push({path: '/index/' + acrossTable + 'Add', query: {type: 'cross'}});
    },

    curChange(page) {
      this.getDiscussList(page);
    },
    prevClick(page) {
      this.getDiscussList(page);
    },
    nextClick(page) {
      this.getDiscussList(page);
    },
    // 返回按钮
    backClick() {
      let params = {}
      if (this.centerType) {
        params.centerType = 1
      }
      this.$router.push({path: '/index/qichexinxi', query: params});
    },
    // 下载
    download(file) {
      if (!file) {
        this.$message({
          type: 'error',
          message: '文件不存在',
          duration: 1500,
        });
        return;
      }
      let arr = file.replace(new RegExp('upload/', "g"), "")
      axios.get(this.baseUrl + '/file/download?fileName=' + arr, {
        headers: {
          token: localStorage.getItem("frontToken")
        },
        responseType: "blob"
      }).then(({
                 data
               }) => {
        const binaryData = [];
        binaryData.push(data);
        const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
          type: 'application/pdf;chartset=UTF-8'
        }))
        const a = document.createElement('a')
        a.href = objectUrl
        a.download = arr
        // a.click()
        // 下面这个写法兼容火狐
        a.dispatchEvent(new MouseEvent('click', {
          bubbles: true,
          cancelable: true,
          view: window
        }))
        window.URL.revokeObjectURL(data)
      }, err => {
        axios.get((location.href.split(this.$config.name).length > 1 ? location.href.split(this.$config.name)[0] : '') + this.$config.name + '/file/download?fileName=' + arr, {
          headers: {
            token: localStorage.getItem("frontToken")
          },
          responseType: "blob"
        }).then(({
                   data
                 }) => {
          const binaryData = [];
          binaryData.push(data);
          const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
            type: 'application/pdf;chartset=UTF-8'
          }))
          const a = document.createElement('a')
          a.href = objectUrl
          a.download = arr
          // a.click()
          // 下面这个写法兼容火狐
          a.dispatchEvent(new MouseEvent('click', {
            bubbles: true,
            cancelable: true,
            view: window
          }))
          window.URL.revokeObjectURL(data)
        })
      })
    },
    getDiscussList(page) {
      this.$http.get('discussqichexinxi/list', {
        params: {
          page,
          limit: this.pageSize,
          refid: this.detail.id
        }
      }).then(res => {
        if (res.data.code == 0) {
          this.infoList = res.data.data.list;
          this.total = res.data.data.total;
          this.pageSize = Number(res.data.data.pageSize);
          this.totalPage = res.data.data.totalPage;
        }
      });
    },
    discussEnter(index) {
      this.showIndex = index
    },
    discussLeave() {
      this.showIndex = -1
    },
    discussDel(id) {
      this.$confirm('是否删除此评论？')
          .then(_ => {
            this.$http.post('discussqichexinxi/delete', [id]).then(res => {
              if (res.data && res.data.code == 0) {
                this.addDiscussNum(1)
                this.$message({
                  type: 'success',
                  message: '删除成功!',
                  duration: 1500,
                  onClose: () => {
                    this.getDiscussList(1);
                  }
                });
              }
            })
          }).catch(_ => {
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$http.get('orders/list', {
            params: {
              page: 1,
              limit: 1,
              status: '已完成',
              goodid: this.detail.id,
              userid: localStorage.getItem('frontUserid')
            }
          }).then(res => {
            if (res.data.code == 0 && res.data.data.list.length == 0) {
              this.$message({
                type: 'success',
                message: '请完成订单后再评论!',
                duration: 1500
              });
              return false
            } else {
              this.form.refid = this.detail.id;
              this.form.avatarurl = localStorage.getItem('frontHeadportrait') ? localStorage.getItem('frontHeadportrait') : '';
              this.$http.post('discussqichexinxi/add', this.form).then(res => {
                if (res.data.code == 0) {
                  this.addDiscussNum(2)
                  this.form.content = '';
                  this.getDiscussList(1);
                  this.$message({
                    type: 'success',
                    message: '评论成功!',
                    duration: 1500,
                  });
                }
              });
            }
          });
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    addDiscussNum(type) {
      if (type == 2) {
        this.detail.discussnum++
      } else if (type == 1) {
        if (this.detail.discussnum != 0) {
          this.detail.discussnum--
        } else {
          this.detail.discussnum = 0
        }
      }
      this.$http.post('qichexinxi/update', this.detail).then(res => {

      })
    },
    getCartList() {
      this.$http.get('cart/list', {
        params: {
          userid: localStorage.getItem('frontUserid'),
          tablename: 'qichexinxi',
          goodid: this.detail.id
        }
      }).then(res => {
        if (res.data.code == 0) {
          if (res.data.data.list.length > 0) {
            this.isInCart = true;
          } else {
            this.isInCart = false;
          }
        }
      });
    },
    addCart() {
      // 单次购买限制
      if (this.detail.onelimittimes > 0 && this.detail.onelimittimes < this.buynumber) {
        this.$message.error(`每人单次只能购买${this.detail.onelimittimes}件`);
        return
      }
      // 库存不够
      if (this.detail.alllimittimes <= 0) {
        this.$message.error(`商品已售罄`);
        return
      }
      // 库存限制
      if (this.detail.alllimittimes > 0 && this.detail.alllimittimes < this.buynumber) {
        this.$message.error(`库存不足`);
        return
      }
      if (this.isInCart) {
        this.$message.error('该商品已经添加到购物车');
        return;
      }

      this.cart.buynumber = this.buynumber;
      this.cart.goodid = this.detail.id;
      this.cart.goodname = this.title;
      this.cart.tablename = this.tablename;
      this.cart.picture = this.detailBanner[0];
      this.cart.price = this.detail.price;
      this.$http.post('cart/save', this.cart).then(res => {
        if (res.data.code === 0) {
          this.getCartList();
          this.$message({
            message: '添加成功',
            type: 'success',
            duration: 1500,
          });
        } else {
          this.$message.error(res.data.msg);
        }
      });
    },
    //立即购买
    buyNow() {
      // 单次购买限制
      if (this.detail.onelimittimes > 0 && this.detail.onelimittimes < this.buynumber) {
        this.$message.error(`每人单次只能购买${this.detail.onelimittimes}件`);
        return
      }
      // 库存不够
      if (this.detail.alllimittimes <= 0) {
        this.$message.error(`商品已售罄`);
        return
      }
      // 库存限制
      if (this.detail.alllimittimes > 0 && this.detail.alllimittimes < this.buynumber) {
        this.$message.error(`库存不足`);
        return
      }
      // 保存到storage中，在确认下单页面中获取要购买的商品
      localStorage.setItem('orderGoods', JSON.stringify([{
        tablename: this.tablename,
        goodid: this.detail.id,
        goodname: this.title,

        picture: this.detailBanner[0],
        buynumber: this.buynumber,
        userid: localStorage.getItem('frontUserid'),
        price: this.detail.price,
        discountprice: this.detail.vipprice ? this.detail.vipprice : 0
      }]));
      // 跳转到确认下单页面
      let query = {
        type: 1,
      }
      this.$router.push({path: '/index/shop-order/orderConfirm', query: query});
    },


    // 权限判断
    btnAuth(tableName, key) {
      if (this.centerType) {
        return this.isBackAuth(tableName, key)
      } else {
        return this.isAuth(tableName, key)
      }
    },
    // 修改
    editClick() {
      this.$router.push(`/index/qichexinxiAdd?type=edit&&id=${this.detail.id}`);
    },
    // 删除
    async delClick() {
      await this.$confirm('是否删除此汽车信息？')
          .then(_ => {
            this.$http.post('qichexinxi/delete', [this.detail.id]).then(async res => {
              if (res.data.code == 0) {
                this.$http.get('storeup/list', {
                  params: {
                    page: 1,
                    limit: 100,
                    refid: this.detail.id,
                    tablename: 'qichexinxi',
                  }
                }).then(async obj => {
                  if (obj.data && obj.data.code == 0) {
                    let arr = []
                    for (let x in obj.data.data.list) {
                      arr.push(obj.data.data.list[x].id)
                    }
                    if (arr.length) {
                      await this.$http.post('storeup/delete', arr).then(() => {
                      })
                    }
                    this.$message({
                      type: 'success',
                      message: '删除成功!',
                      duration: 1500,
                      onClose: () => {
                        history.back()
                      }
                    });
                  }
                })
              }
            });
          }).catch(_ => {
          });
    },
  },
  components: {
    CountDown
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.editor /deep/ .avatar-uploader {
  height: 0;
  line-height: 0;
}

.detail-preview {

  .attr {
    .el-carousel /deep/ .el-carousel__indicator button {
      width: 0;
      height: 0;
      display: none;
    }

    .el-input-number__decrease:hover:not(.is-disabled) ~ .el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled) ~ .el-input .el-input__inner:not(.is-disabled) {
      border-color: none;
    }
  }

  .detail {
    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
      margin-bottom: 0;
    }

    & .add .el-textarea {
      width: auto;
    }
  }
}

.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
  width: 36px;
  font-size: 12px;
  height: 36px;
}

.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
  background: red;
}

.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
  width: 36px;
  font-size: 12px;
  height: 36px;
}

.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
  background: red;
}

.attr .el-carousel /deep/ .el-carousel__indicators {
  padding: 0;
  margin: 0;
  z-index: 2;
  position: absolute;
  list-style: none;
}

.attr .el-carousel /deep/ .el-carousel__indicators li {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 12px;
  opacity: 0.4;
  transition: 0.3s;
  height: 12px;
}

.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 24px;
  opacity: 0.7;
  height: 12px;
}

.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 24px;
  opacity: 1;
  height: 12px;
}

.attr .el-input-number /deep/ .el-input-number__decrease {
  cursor: pointer;
  z-index: 1;
  display: flex;
  border-color: #DCDFE6;
  border-radius: 0px 0 0 0px;
  top: 2px;
  left: 1px;
  background: #f5f5f5;
  width: 40px;
  justify-content: center;
  border-width: 0 1px 0 0;
  align-items: center;
  position: absolute;
  border-style: solid;
  text-align: center;
  height: 32px;
}

.attr .el-input-number /deep/ .el-input-number__decrease i {
  color: #666;
  font-size: 14px;
}

.attr .el-input-number /deep/ .el-input-number__increase {
  cursor: pointer;
  z-index: 1;
  display: flex;
  border-color: #DCDFE6;
  right: 1px;
  border-radius: 0 0px 0px 0;
  top: 2px;
  background: #f5f5f5;
  width: 40px;
  justify-content: center;
  border-width: 0 0 0 1px;
  align-items: center;
  position: absolute;
  border-style: solid;
  text-align: center;
  height: 32px;
}

.attr .el-input-number /deep/ .el-input-number__increase i {
  color: #666;
  font-size: 14px;
}

.attr .el-input-number /deep/ .el-input .el-input__inner {
  border: 1px solid #DCDFE6;
  border-radius: 0px;
  padding: 0 10px;
  outline: none;
  color: #666;
  background: #fff;
  display: inline-block;
  width: 100%;
  font-size: 14px;
  line-height: 34px;
  text-align: center;
  height: 34px;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
  border-radius: 8px 8px 0 0;
  margin: 0;
  background: none;
  border-color: #f8514b50;
  border-width: 0 0 0px 0;
  border-style: solid;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
  border: 0;
  padding: 0 20px;
  margin: 0;
  color: #aaa;
  font-weight: 500;
  display: inline-block;
  font-size: 18px;
  line-height: 40px;
  transition: all 0s;
  background: none;
  position: relative;
  list-style: none;
  height: 40px;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  border: 0;
  border-radius: 8px 8px 0 0;
  color: #fff;
  background: linear-gradient(to right, #f67536, #369ff6), #369ff6;
  font-size: 18px;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  border: 0;
  border-radius: 8px 8px 0 0;
  color: #fff;
  background: linear-gradient(to right, #f67536, #369ff6), #369ff6;
  font-size: 18px;
}

.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
  padding: 15px;
}

.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
  padding: 0 10px 0 0;
  color: #666;
  width: 80px;
  font-size: 14px;
  line-height: 40px;
  text-align: right;
}

.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
}

.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
  margin: 0 9px;
  color: #ccc;
  font-weight: 500;
}

.breadcrumb-preview .el-breadcrumb .item1 /deep/ .el-breadcrumb__inner a {
  color: #333;
  display: inline-block;
}

.breadcrumb-preview .el-breadcrumb .item2 /deep/ .el-breadcrumb__inner a {
  color: #666;
  display: inline-block;
}

.breadcrumb-preview .el-breadcrumb .item3 /deep/ .el-breadcrumb__inner a {
  color: #999;
  display: inline-block;
}

#pagination.el-pagination /deep/ .el-pagination__total {
  margin: 0 10px 0 0;
  color: #666;
  font-weight: 400;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination /deep/ .btn-prev {
  border: none;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #666;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  min-width: 35px;
  height: 28px;
}

#pagination.el-pagination /deep/ .btn-next {
  border: none;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #666;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  min-width: 35px;
  height: 28px;
}

#pagination.el-pagination /deep/ .btn-prev:disabled {
  border: none;
  cursor: not-allowed;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #C0C4CC;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination /deep/ .btn-next:disabled {
  border: none;
  cursor: not-allowed;
  border-radius: 2px;
  padding: 0;
  margin: 0 5px;
  color: #C0C4CC;
  background: #f4f4f5;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pager {
  padding: 0;
  margin: 0;
  display: inline-block;
  vertical-align: top;
}

#pagination.el-pagination /deep/ .el-pager .number {
  cursor: pointer;
  padding: 0 4px;
  margin: 0 5px;
  color: #666;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 2px;
  background: #f4f4f5;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pager .number:hover {
  cursor: pointer;
  padding: 0 4px;
  margin: 0 5px;
  color: #fff;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 2px;
  background: #3693a4;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pager .number.active {
  cursor: default;
  padding: 0 4px;
  margin: 0 5px;
  color: #FFF;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  border-radius: 2px;
  background: #3693a4;
  text-align: center;
  min-width: 30px;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pagination__sizes {
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
  margin: 0 5px;
  width: 100px;
  position: relative;
}

#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
  border: 0px solid #DCDFE6;
  cursor: pointer;
  padding: 0 25px 0 8px;
  color: #606266;
  display: inline-block;
  font-size: 13px;
  line-height: 28px;
  border-radius: 3px;
  outline: 0;
  background: #FFF;
  width: 100%;
  text-align: center;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
  top: 0;
  position: absolute;
  right: 0;
  height: 100%;
}

#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
  cursor: pointer;
  color: #C0C4CC;
  width: 25px;
  font-size: 14px;
  line-height: 28px;
  text-align: center;
}

#pagination.el-pagination /deep/ .el-pagination__jump {
  margin: 0 0 0 24px;
  color: #606266;
  display: inline-block;
  vertical-align: top;
  font-size: 13px;
  line-height: 28px;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pagination__jump .el-input {
  border-radius: 3px;
  padding: 0 2px;
  margin: 0 2px;
  display: inline-block;
  width: 50px;
  font-size: 14px;
  line-height: 18px;
  position: relative;
  text-align: center;
  height: 28px;
}

#pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
  border: 1px solid #DCDFE6;
  cursor: pointer;
  padding: 0 3px;
  color: #606266;
  display: inline-block;
  font-size: 14px;
  line-height: 28px;
  border-radius: 3px;
  outline: 0;
  background: #FFF;
  width: 100%;
  text-align: center;
  height: 28px;
}

.share_view {
  position: fixed;
  right: 0;
  bottom: 20%;
  background: #fff;
  box-shadow: 0 4px 6px rgba(0, 0, 0, .1);

  .share {
    width: 40px;
    height: 40px;
    display: flex;
    align-items: center;
    justify-content: center;
    border-bottom: 1px solid #eee;
    cursor: pointer;
  }

  .share:last-of-type {
    border: none;
  }
}


.detail-preview .el-rate /deep/ .el-rate__item {
  cursor: pointer;
  display: inline-block;
  vertical-align: middle;
  font-size: 0;
  position: relative;
}

.detail-preview .el-rate /deep/ .el-rate__item .el-rate__icon {
  margin: 0 3px;
  display: block;
  font-size: 18px;
  position: relative;
  transition: .3s;
}
</style>
