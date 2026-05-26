import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import peijianfenlei from '@/views/modules/peijianfenlei/list'
    import pingjiajilu from '@/views/modules/pingjiajilu/list'
    import news from '@/views/modules/news/list'
    import aboutus from '@/views/modules/aboutus/list'
    import peijianjilu from '@/views/modules/peijianjilu/list'
    import discussqichexinxi from '@/views/modules/discussqichexinxi/list'
    import yuyuexinxi from '@/views/modules/yuyuexinxi/list'
import shijia from '@/views/modules/shijia/list'
    import shijianduan from '@/views/modules/shijianduan/list'
    import rukujilu from '@/views/modules/rukujilu/list'
    import weixiugongren from '@/views/modules/weixiugongren/list'
    import peijianxinxi from '@/views/modules/peijianxinxi/list'
    import xiaoxitixing from '@/views/modules/xiaoxitixing/list'
    import jinduxinxi from '@/views/modules/jinduxinxi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import qichexinxi from '@/views/modules/qichexinxi/list'
    import qichepinpai from '@/views/modules/qichepinpai/list'
    import orders from '@/views/modules/orders/list'
    import cheliangxinxi from '@/views/modules/cheliangxinxi/list'
    import config from '@/views/modules/config/list'
    import newstype from '@/views/modules/newstype/list'
import forum from '@/views/modules/forum/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/peijianfenlei',
        name: '配件分类',
        component: peijianfenlei
      }
      ,{
	path: '/pingjiajilu',
        name: '评价记录',
        component: pingjiajilu
      }
      ,{
	path: '/news',
        name: '通知公告',
        component: news
      }
        ,{
            path: '/forum',
            name: '论坛交流',
            component: forum
        }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/peijianjilu',
        name: '配件记录',
        component: peijianjilu
      }
      ,{
	path: '/discussqichexinxi',
        name: '汽车信息评论',
        component: discussqichexinxi
      }
      ,{
	path: '/yuyuexinxi',
        name: '预约信息',
        component: yuyuexinxi
      }
        ,{
            path: '/shijia',
            name: '试驾信息',
            component: shijia
        }
      ,{
	path: '/shijianduan',
        name: '时间段',
        component: shijianduan
      }
      ,{
	path: '/rukujilu',
        name: '入库记录',
        component: rukujilu
      }
      ,{
	path: '/weixiugongren',
        name: '维修工人',
        component: weixiugongren
      }
      ,{
	path: '/peijianxinxi',
        name: '配件信息',
        component: peijianxinxi
      }
      ,{
	path: '/xiaoxitixing',
        name: '消息提醒',
        component: xiaoxitixing
      }
      ,{
	path: '/jinduxinxi',
        name: '进度信息',
        component: jinduxinxi
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/qichexinxi',
        name: '汽车信息',
        component: qichexinxi
      }
      ,{
	path: '/qichepinpai',
        name: '汽车品牌',
        component: qichepinpai
      }
      ,{
        path: '/orders/:status',
        name: '订单管理',
        component: orders
      }
      ,{
	path: '/cheliangxinxi',
        name: '车辆信息',
        component: cheliangxinxi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/newstype',
        name: '通知公告分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
