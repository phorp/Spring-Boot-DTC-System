<template>
<div class="home-preview" :style='{"margin":"0 auto","flexWrap":"wrap","flexDirection":"row","background":"none","display":"flex","width":"100%","justifyContent":"center"}'>

	<!-- 搜索 -->
	<div id="search" class="search animate__animated" :style='{"padding":"10px 10%","margin":"0px auto 0","borderColor":"#eee","alignItems":"center","textAlign":"center","display":"flex","justifyContent":"center","flexWrap":"wrap","background":"#fff","borderWidth":"0px","width":"100%","borderStyle":"solid","height":"auto","zIndex":"1002"}'>
		<div :style='{"margin":"0 10px 0 0","display":"inline-block"}' class="select">
			<el-select v-model="queryIndex">
				<el-option
				  v-for="(item,index) in queryList"
				  :key="index"
				  :label="item.queryName"
				  :value="index"
				></el-option>
			</el-select>
		</div>
		<div :style='{"margin":"0 0px 0 0","display":"inline-block"}' class="input" v-if="queryIndex==0">
			<el-input v-model="qichexinxiqichemingcheng" placeholder="汽车名称"></el-input>
		</div>
		<div :style='{"margin":"0"}' class="btn" v-if="queryIndex==0">
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 12px 0 16px","margin":"0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"2px","background":"rgba(37,35,38,1)","width":"auto","lineHeight":"32px","fontSize":"16px","height":"32px"}' type="primary" @click="search('qichexinxi')">
				<span class="icon iconfont icon-chakan14" :style='{"color":"rgba(255, 255, 255, 1)","margin":"0 4px 0 0","fontSize":"20px"}'></span>
				
			</el-button>
		</div>
	</div>
	<!-- 搜索 -->


		<!-- 关于我们 -->
		<div id="about" class="animate__animated" :style='{"padding":"40px 18% 20px","margin":"0","borderColor":"#f1635f","background":"#fff","borderWidth":"0px 0 0","width":"100%","position":"relative","borderStyle":"solid","height":"auto","order":"4"}'>
		  <div :style='{"padding":"0","margin":"0","color":"#222","textAlign":"left","background":"none","width":"100%","fontSize":"24px","fontWeight":"600","height":"60px"}'>{{aboutUsDetail.title}}</div>
		  <div :style='{"margin":"0 0 30px","color":"#888","textAlign":"left","display":"none","width":"100%","lineHeight":"1.5","fontSize":"16px"}'>{{aboutUsDetail.subtitle}}</div>
		  <div :style='{"padding":"0 0px","margin":"0","flexWrap":"wrap","display":"flex","width":"40%","float":"left","height":"236px"}'>
		    <img :style='{"width":"100%","margin":"0 0px","objectFit":"cover","display":"block","height":"100%"}' :src="baseUrl + aboutUsDetail.picture1">
		    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture2">
		    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture3">
		  </div>
		  <div :style='{"padding":"14px 12px 0","margin":"0","overflow":"hidden","color":"rgb(102, 102, 102)","background":"#f6f6f6","width":"60%","fontSize":"14px","lineHeight":"24px","textIndent":"2em","float":"right","height":"236px"}' v-html="aboutUsDetail.content"></div>
		  <div :style='{"top":"0","left":"52%","background":"url(http://codegen.caihongy.cn/20230920/8a35b5134ee644b8a9a87ea99a0f1490.png) no-repeat","display":"none","width":"200px","position":"absolute","height":"100%"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"border":"0px solid #eccc19","cursor":"pointer","padding":"0 20px","margin":"0","textAlign":"center","display":"block","right":"18%","float":"left","top":"36px","borderRadius":"20px","background":"linear-gradient(to right,#f67536,#369ff6),#369ff6","width":"auto","lineHeight":"36px","position":"absolute"}' @click="toDetail('aboutusDetail',aboutUsDetail)">
		    <span :style='{"color":"#fff","fontSize":"15px"}'>查看更多</span>
		    <span class="icon iconfont icon-jiantou18" :style='{"color":"#fff","fontSize":"16px","display":"inline-block"}'></span>
		  </div>
		</div>
		<!-- 关于我们 -->

		
	<!-- 新闻资讯 -->
	<div id="animate_newsnews" class="news animate__animated" :style='{"padding":"40px 18%","margin":"0 auto","backgroundAttachment":"fixed","background":"url(http://codegen.caihongy.cn/20231004/c110df0d04d245e896879bcfb8a4503f.png) no-repeat center top / cover","width":"100%","position":"relative","order":"3"}'>
		<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
			<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		</div>
		
		<div class="title" :style='{"width":"auto","padding":"0","margin":"0 auto","textAlign":"left","background":"none","height":"60px"}'>
			<span :style='{"color":"#222","fontSize":"24px","fontWeight":"600"}'>通知公告</span>
		</div>
		
			
			
			<!-- 样式二 -->
		<div class="list list2 index-pv1" :style='{"padding":"0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}' v-if="newsList.length">
			<div :style='{"cursor":"pointer","margin":"0 0 30px","background":"#fff","display":"flex","width":"49%","fontSize":"0","position":"relative","height":"150px"}' v-for="(item,index) in newsList" :key="index" class="list-item animation-box" @click="toDetail('newsDetail', item)">
				<img :style='{"width":"40%","objectFit":"cover","display":"inline-block","height":"100%"}' :src="baseUrl + item.picture" alt="" />
				<div :style='{"width":"60%","padding":"10px","overflow":"hidden","display":"inline-block","height":"150px"}' class="item-info">
					<div class="name line1" :style='{"padding":"0 10px","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"30px","fontSize":"14px","textOverflow":"ellipsis","fontWeight":"600"}'>{{item.title}}</div>
					<div :style='{"padding":"0 10px","lineHeight":"24px"}'>
					  <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
					  <span class="text" :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{item.addtime}}</span>
					</div>
					<div :style='{"padding":"0 10px","display":"inline-block"}'>
					  <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666","display":"inline-block"}'></span>
					  <span class="text" :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{item.name}}</span>
					</div>
					<div :style='{"padding":"0 10px","display":"inline-block"}'>
					  <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
					  <span class="text" :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{item.thumbsupnum}}</span>
					</div>
					<div :style='{"padding":"0 10px","display":"inline-block"}'>
					  <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
					  <span class="text" :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{item.storeupnum}}</span>
					</div>
					<div :style='{"padding":"0 10px","display":"inline-block"}'>
					  <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#666"}'></span>
					  <span class="text" :style='{"color":"#666","lineHeight":"1.5","fontSize":"12px"}'>{{item.clicknum}}</span>
					</div>
				</div>
			</div>
		</div>
			
			
			
			
			
			
			
			
		











		<div @click="moreBtn('news')" :style='{"border":"0px solid #eccc19","cursor":"pointer","padding":"0 20px","margin":"0","textAlign":"center","display":"block","right":"18%","top":"40px","borderRadius":"20px","background":"linear-gradient(to right,#f67536,#369ff6),#369ff6","width":"auto","lineHeight":"32px","position":"absolute"}'>
			<span :style='{"color":"#fff","fontSize":"15px"}'>查看更多</span>
			<i :style='{"color":"#fff","fontSize":"16px","display":"inline-block"}' class="icon iconfont icon-jiantou18"></i>
		</div>
		
		</div>
	<!-- 新闻资讯 -->


	
</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        aboutUsDetail: {},
        queryList:[
          {
              queryName:"汽车名称",
          },
        ],
        queryIndex: 0,
        qichexinxiqichemingcheng: '',
        newsList: [],





      }
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.getNewsList();
		this.getAboutUs();
		this.getList();
    },
	mounted() {
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
		
		this.swiperChanges()
	},
	beforeDestroy() {
	  window.removeEventListener('scroll', this.handleScroll)
	},
    //方法集合
    methods: {
		swiperChanges() {
			setTimeout(()=>{
			},750)
		},


		handleScroll() {
			let arr = [
				{id:'search',css:'animate__fadeInUp'},
				{id:'about',css:'animate__'},
				{id:'system',css:'animate__'},
				{id:'animate_newsnews',css:'animate__'},
				{id:'msgs',css:'animate__'},
				{id:'friendly',css:'animate__'}
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
      getAboutUs() {
          this.$http.get('aboutus/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.aboutUsDetail = res.data.data;
            }
          })
      },
      search(tablename) {
        if (this.queryIndex == 0 && this.qichexinxiqichemingcheng) {
          this.$router.push({path: '/index/' + tablename, query: {indexQueryCondition: this.qichexinxiqichemingcheng}});
        }
      },
		getNewsList() {
			let data = {
				page: 1,
				limit: 4,
                sort: 'addtime',
				order: 'desc'
			}
			this.$http.get('news/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
			let autoSortUrl = "";
			let data = {}
			
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {id: item.id}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		// -------- search --------
		.search .select /deep/ .el-input__inner {
			border: 1px solid #ddd;
			border-radius: 2px;
			padding: 0 30px 0 10px;
			box-shadow: 0 0 0px rgba(64, 158, 255, .3);
			outline: none;
			color: rgba(64, 158, 255, 1);
			width: 180px;
			font-size: 14px;
			height: 32px;
		}
		
		.search .input /deep/ .el-input__inner {
			border-radius: 2px;
			padding: 0 10px;
			color: rgba(64, 158, 255, 1);
			width: 280px;
			font-size: 14px;
			border-color: #ddd;
			border-width: 1px;
			border-style: solid;
			height: 32px;
		}
		// -------- search --------
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				box-shadow: 0px 0px 0px 0px #e7e7e7;
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(0.98) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
	








	.home-preview .recommend .list17 .item .image {
				border-radius: 8px 8px 0 0;
				object-fit: cover;
				display: block;
				width: 100%;
				transition: 0.3s;
				height: 280px;
			}

	.home-preview .recommend .list17 .item:hover .image {
				transform: scale(1);
			}
	
	.home-preview .recommend .list17 .item .content {
				border-radius: 0 0 8px 8px;
				padding: 10px 0;
				left: 0;
				bottom: 0;
				background: #fff;
				display: flex;
				width: 100%;
				position: inherit;
				transition: 0.3s;
				height: auto;
			}
	
	.home-preview .recommend .list17 .item:hover .content {
				bottom: 0;
			}


	.home-preview .lists .list17 .item .image {
				border-radius: 8px;
				object-fit: cover;
				display: block;
				width: 100%;
				transition: 0.3s;
				height: 100%;
			}

	.home-preview .lists .list17 .item:hover .image {
				transform: scale(1);
			}
	
	.home-preview .lists .list17 .item .content {
				border-radius: 0 0 8px 8px;
				padding: 5px 10px;
				overflow: hidden;
				left: 0;
				bottom: 0px;
				background: rgba(0,0,0,.2);
				display: flex;
				width: 100%;
				align-items: center;
				position: absolute;
				transition: 0.3s;
				height: auto;
			}
	
	.home-preview .lists .list17 .item:hover .content {
				bottom: 0;
			}
</style>
