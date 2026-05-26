import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import AddrList from '../pages/shop-address/list'
import AddrAdd from '../pages/shop-address/addOrUpdate'
import Order from '../pages/shop-order/list'
import OrderConfirm from '../pages/shop-order/confirm'
import Cart from '../pages/shop-cart/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import shijianduanList from '../pages/shijianduan/list'
import shijianduanDetail from '../pages/shijianduan/detail'
import shijianduanAdd from '../pages/shijianduan/add'
import weixiugongrenList from '../pages/weixiugongren/list'
import weixiugongrenDetail from '../pages/weixiugongren/detail'
import weixiugongrenAdd from '../pages/weixiugongren/add'
import peijianfenleiList from '../pages/peijianfenlei/list'
import peijianfenleiDetail from '../pages/peijianfenlei/detail'
import peijianfenleiAdd from '../pages/peijianfenlei/add'
import qichepinpaiList from '../pages/qichepinpai/list'
import qichepinpaiDetail from '../pages/qichepinpai/detail'
import qichepinpaiAdd from '../pages/qichepinpai/add'
import qichexinxiList from '../pages/qichexinxi/list'
import qichexinxiDetail from '../pages/qichexinxi/detail'
import qichexinxiAdd from '../pages/qichexinxi/add'
import peijianxinxiList from '../pages/peijianxinxi/list'
import peijianxinxiDetail from '../pages/peijianxinxi/detail'
import peijianxinxiAdd from '../pages/peijianxinxi/add'
import cheliangxinxiList from '../pages/cheliangxinxi/list'
import cheliangxinxiDetail from '../pages/cheliangxinxi/detail'
import cheliangxinxiAdd from '../pages/cheliangxinxi/add'
import yuyuexinxiList from '../pages/yuyuexinxi/list'
import yuyuexinxiDetail from '../pages/yuyuexinxi/detail'
import yuyuexinxiAdd from '../pages/yuyuexinxi/add'

import shijiaList from '../pages/shijia/list'
import shijiaDetail from '../pages/shijia/detail'
import shijiaAdd from '../pages/shijia/add'

import rukujiluList from '../pages/rukujilu/list'
import rukujiluDetail from '../pages/rukujilu/detail'
import rukujiluAdd from '../pages/rukujilu/add'
import jinduxinxiList from '../pages/jinduxinxi/list'
import jinduxinxiDetail from '../pages/jinduxinxi/detail'
import jinduxinxiAdd from '../pages/jinduxinxi/add'
import peijianjiluList from '../pages/peijianjilu/list'
import peijianjiluDetail from '../pages/peijianjilu/detail'
import peijianjiluAdd from '../pages/peijianjilu/add'
import pingjiajiluList from '../pages/pingjiajilu/list'
import pingjiajiluDetail from '../pages/pingjiajilu/detail'
import pingjiajiluAdd from '../pages/pingjiajilu/add'
import xiaoxitixingList from '../pages/xiaoxitixing/list'
import xiaoxitixingDetail from '../pages/xiaoxitixing/detail'
import xiaoxitixingAdd from '../pages/xiaoxitixing/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import discussqichexinxiList from '../pages/discussqichexinxi/list'
import discussqichexinxiDetail from '../pages/discussqichexinxi/detail'
import discussqichexinxiAdd from '../pages/discussqichexinxi/add'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'


const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
                {
                    path: 'shop-address/list',
                    component: AddrList
                },
                {
                    path: 'shop-address/addOrUpdate',
                    component: AddrAdd
                },
				{
					path: 'shop-order/order',
					component: Order
				},
				{
					path: 'cart',
					component: Cart
				},
				{
					path: 'shop-order/orderConfirm',
					component: OrderConfirm
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'shijianduan',
					component: shijianduanList
				},
				{
					path: 'shijianduanDetail',
					component: shijianduanDetail
				},
				{
					path: 'shijianduanAdd',
					component: shijianduanAdd
				},
				{
					path: 'weixiugongren',
					component: weixiugongrenList
				},
				{
					path: 'weixiugongrenDetail',
					component: weixiugongrenDetail
				},
				{
					path: 'weixiugongrenAdd',
					component: weixiugongrenAdd
				},
				{
					path: 'peijianfenlei',
					component: peijianfenleiList
				},
				{
					path: 'peijianfenleiDetail',
					component: peijianfenleiDetail
				},
				{
					path: 'peijianfenleiAdd',
					component: peijianfenleiAdd
				},
				{
					path: 'qichepinpai',
					component: qichepinpaiList
				},
				{
					path: 'qichepinpaiDetail',
					component: qichepinpaiDetail
				},
				{
					path: 'qichepinpaiAdd',
					component: qichepinpaiAdd
				},
				{
					path: 'qichexinxi',
					component: qichexinxiList
				},
				{
					path: 'qichexinxiDetail',
					component: qichexinxiDetail
				},
				{
					path: 'qichexinxiAdd',
					component: qichexinxiAdd
				},
				{
					path: 'peijianxinxi',
					component: peijianxinxiList
				},
				{
					path: 'peijianxinxiDetail',
					component: peijianxinxiDetail
				},
				{
					path: 'peijianxinxiAdd',
					component: peijianxinxiAdd
				},
				{
					path: 'cheliangxinxi',
					component: cheliangxinxiList
				},
				{
					path: 'cheliangxinxiDetail',
					component: cheliangxinxiDetail
				},
				{
					path: 'cheliangxinxiAdd',
					component: cheliangxinxiAdd
				},
				{
					path: 'yuyuexinxi',
					component: yuyuexinxiList
				},
				{
					path: 'yuyuexinxiDetail',
					component: yuyuexinxiDetail
				},
				{
					path: 'yuyuexinxiAdd',
					component: yuyuexinxiAdd
				},

				{
					path: 'shijia',
					component: shijiaList
				},
				{
					path: 'shijiaDetail',
					component: shijiaDetail
				},
				{
					path: 'shijiaAdd',
					component: shijiaAdd
				},

				{
					path: 'rukujilu',
					component: rukujiluList
				},
				{
					path: 'rukujiluDetail',
					component: rukujiluDetail
				},
				{
					path: 'rukujiluAdd',
					component: rukujiluAdd
				},
				{
					path: 'jinduxinxi',
					component: jinduxinxiList
				},
				{
					path: 'jinduxinxiDetail',
					component: jinduxinxiDetail
				},
				{
					path: 'jinduxinxiAdd',
					component: jinduxinxiAdd
				},
				{
					path: 'peijianjilu',
					component: peijianjiluList
				},
				{
					path: 'peijianjiluDetail',
					component: peijianjiluDetail
				},
				{
					path: 'peijianjiluAdd',
					component: peijianjiluAdd
				},
				{
					path: 'pingjiajilu',
					component: pingjiajiluList
				},
				{
					path: 'pingjiajiluDetail',
					component: pingjiajiluDetail
				},
				{
					path: 'pingjiajiluAdd',
					component: pingjiajiluAdd
				},
				{
					path: 'xiaoxitixing',
					component: xiaoxitixingList
				},
				{
					path: 'xiaoxitixingDetail',
					component: xiaoxitixingDetail
				},
				{
					path: 'xiaoxitixingAdd',
					component: xiaoxitixingAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'discussqichexinxi',
					component: discussqichexinxiList
				},
				{
					path: 'discussqichexinxiDetail',
					component: discussqichexinxiDetail
				},
				{
					path: 'discussqichexinxiAdd',
					component: discussqichexinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
