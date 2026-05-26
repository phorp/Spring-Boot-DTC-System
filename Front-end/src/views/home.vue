<template>
<div class="content" :style='{"padding":"20px  10px  60px 210px","overflow-x":"hidden","position":"relative","flexDirection":"column","display":"flex"}'>
	<!-- notice -->
	<!-- title -->
	<div class="text" :style='{"margin":"50px auto","fontSize":"24px","color":"rgb(51, 51, 51)","textAlign":"center","fontWeight":"bold","display":"none"}'>欢迎使用 {{this.$project.projectName}}</div>
	<!-- statis -->
	<div :style='{"minHeight":"13vh","margin":"10px 0 20px 0","alignItems":"center","background":"#fff","display":"flex","width":"100%","justifyContent":"space-around"}'>
		<div :style='{"boxShadow":"none","padding":"10px 0","margin":"0 10px","borderRadius":"4px","background":"#FFF0F0","display":"flex"}' v-if="isAuth('yonghu','首页总数')">
			<div :style='{"padding":"0 20px","alignItems":"center","display":"flex","width":"auto","justifyContent":"center","height":"80px","order":"1"}'>
				<span class="icon iconfont icon-menu12" :style='{"transform":"rotate(270deg)","borderColor":"#D32821","fontSize":"32px","color":"#D32821","borderStyle":"solid","borderWidth":"0 0 0 1px"}'></span>
			</div>
			<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
				<div :style='{"margin":"5px 0","color":"#000000","lineHeight":"24px","fontSize":"24px","fontWeight":"700","height":"24px","order":"1"}'>{{yonghuCount}}</div>
				<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"14px","color":"#000000","height":"24px"}'>用户总数</div>
			</div>
		</div>
		<div :style='{"boxShadow":"none","padding":"10px","margin":"0 10px","borderRadius":"4px","background":"#FFF0F0","display":"flex"}' v-if="isAuth('weixiugongren','首页总数')">
			<div :style='{"width":"80px","alignItems":"center","background":"red","justifyContent":"center","display":"none","height":"80px"}'>
				<span class="icon iconfont icon-xihuan" :style='{"color":"#fff","fontSize":"24px"}'></span>
			</div>
			<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
				<div :style='{"margin":"5px 0","color":"#000000","lineHeight":"24px","fontSize":"24px","fontWeight":"700","height":"24px","order":"1"}'>{{weixiugongrenCount}}</div>
				<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"14px","color":"#000000","height":"24px"}'>维修工人总数</div>
			</div>
		</div>
		<div :style='{"boxShadow":"none","padding":"10px","margin":"0 10px","borderRadius":"4px","background":"#FFF0F0","display":"flex"}' v-if="isAuth('qichexinxi','首页总数')">
			<div :style='{"width":"80px","alignItems":"center","background":"red","justifyContent":"center","display":"none","height":"80px"}'>
				<span class="icon iconfont icon-xihuan" :style='{"color":"#fff","fontSize":"24px"}'></span>
			</div>
			<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
				<div :style='{"margin":"5px 0","color":"#000000","lineHeight":"24px","fontSize":"24px","fontWeight":"bold","height":"24px","order":"1"}'>{{qichexinxiCount}}</div>
				<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"14px","color":"#000000","height":"24px"}'>汽车信息总数</div>
			</div>
		</div>
		<div :style='{"boxShadow":"none","padding":"10px","margin":"0 10px","borderRadius":"4px","background":"#FFF0F0","display":"flex"}' v-if="isAuth('peijianxinxi','首页总数')">
			<div :style='{"width":"80px","alignItems":"center","background":"red","justifyContent":"center","display":"none","height":"80px"}'>
				<span class="icon iconfont icon-xihuan" :style='{"color":"#fff","fontSize":"24px"}'></span>
			</div>
			<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
				<div :style='{"margin":"5px 0","color":"#000000","lineHeight":"24px","fontSize":"24px","fontWeight":"700","height":"24px","order":"1"}'>{{peijianxinxiCount}}</div>
				<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"14px","color":"#000000","height":"24px"}'>配件信息总数</div>
			</div>
		</div>
		<div :style='{"boxShadow":"none","padding":"10px","margin":"0 10px","borderRadius":"4px","background":"#FFF0F0","display":"flex"}' v-if="isAuth('pingjiajilu','首页总数')">
			<div :style='{"width":"80px","alignItems":"center","background":"red","justifyContent":"center","display":"none","height":"80px"}'>
				<span class="icon iconfont icon-xihuan" :style='{"color":"#fff","fontSize":"24px"}'></span>
			</div>
			<div :style='{"width":"160px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
				<div :style='{"margin":"5px 0","color":"#000000","lineHeight":"24px","fontSize":"20px","fontWeight":"bold","height":"24px","order":"1"}'>{{pingjiajiluCount}}</div>
				<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"14px","color":"#000000","height":"24px"}'>评价记录总数</div>
			</div>
		</div>
	</div>
	<!-- statis -->
	

	
	<!-- echarts -->
	<!-- 4 -->
	<div class="type4" :style='{"alignContent":"flex-start","padding":"0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","position":"relative","justifyContent":"space-between","height":"auto"}'>
		<div id="qichexinxiChart1" class="echarts1" v-if="isAuth('qichexinxi','首页统计')"></div>
		<div id="qichexinxiChart2" class="echarts2" v-if="isAuth('qichexinxi','首页统计')"></div>
		<div id="peijianxinxiChart1" class="echarts3" v-if="isAuth('peijianxinxi','首页统计')"></div>
		<div id="pingjiajiluChart1" class="echarts4" v-if="isAuth('pingjiajilu','首页统计')"></div>
	</div>
</div>
</template>
<script>
//4
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
            yonghuCount: 0,
            weixiugongrenCount: 0,
            qichexinxiCount: 0,
            peijianxinxiCount: 0,
            pingjiajiluCount: 0,
			line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"#333","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"showSymbol":true,"symbol":"emptyCircle","symbolSize":4},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"}},
			bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00ff00","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"#333","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"barWidth":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"colorBy":"data","barCategoryGap":"20%"},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"base":{"animate":false,"interval":2000}},
			pie: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":14,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":2,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":0,"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":2,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#666","color":"inherit","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#666","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
			funnel: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"center","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#666","textShadowColor":"transparent","fontSize":14,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":2,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":2,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
			boardBase: {"funnelNum":8,"lineNum":8,"gaugeNum":8,"barNum":8,"pieNum":8},
			gauge: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"top":"top","left":"left","textStyle":{"fontSize":14,"lineHeight":24,"color":"#333","fontWeight":600}},"series":{"pointer":{"offsetCenter":[0,"10%"],"icon":"path://M2.9,0.7L2.9,0.7c1.4,0,2.6,1.2,2.6,2.6v115c0,1.4-1.2,2.6-2.6,2.6l0,0c-1.4,0-2.6-1.2-2.6-2.6V3.3C0.3,1.9,1.4,0.7,2.9,0.7z","width":8,"length":"80%"},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"opacity":0.5,"shadowBlur":1,"shadowColor":"#000"},"roundCap":true},"anchor":{"show":true,"itemStyle":{"color":"inherit"},"size":18,"showAbove":true},"emphasis":{"disabled":false},"progress":{"show":true,"roundCap":true,"overlap":true},"splitNumber":25,"detail":{"formatter":"{value}","backgroundColor":"inherit","color":"#fff","borderRadius":3,"width":20,"fontSize":12,"height":10},"title":{"fontSize":14},"animation":true}},
		};
	},
	mounted(){
		this.init();
		this.getyonghuCount();
		this.getweixiugongrenCount();
		this.getqichexinxiCount();
		this.qichexinxiChat1();
		this.qichexinxiChat2();
		this.getpeijianxinxiCount();
		this.peijianxinxiChat1();
		this.getpingjiajiluCount();
		this.pingjiajiluChat1();
	},
	methods:{
		// 统计图动画
		myChartInterval(type, xAxisData, seriesData, myChart) {
			this.$nextTick(() => {
				setInterval(() => {
					let xAxis = xAxisData.shift()
					xAxisData.push(xAxis)
					let series = seriesData.shift()
					seriesData.push(series)
				
					if (type == 1) {
						myChart.setOption({
							xAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
					if (type == 2) {
						myChart.setOption({
							yAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
				}, $template2.back.board.bar.base.interval);
			})
		},
		init(){
			if(this.$storage.get('Token')){
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code != 0) {
				router.push({ name: 'login' })
				}
			});
			}else{
				router.push({ name: 'login' })
			}
		},
		getyonghuCount() {
			this.$http({
				url: `yonghu/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.yonghuCount = data.data
				}
			})
		},
		getweixiugongrenCount() {
			this.$http({
				url: `weixiugongren/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.weixiugongrenCount = data.data
				}
			})
		},
		getqichexinxiCount() {
			this.$http({
				url: `qichexinxi/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.qichexinxiCount = data.data
				}
			})
		},
// 1234 饼
		qichexinxiChat1() {
			this.$nextTick(()=>{

        var qichexinxiChart1 = echarts.init(document.getElementById("qichexinxiChart1"),'macarons');
        this.$http({
            url: "qichexinxi/group/qichepinpai",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
					if(this.boardBase&&i==this.boardBase.pieNum){
						break;
					}
                    xAxis.push(res[i].qichepinpai);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].qichepinpai
                    })
                }
                var option = {};
				let titleObj = this.pie.title
				titleObj.text = '汽车品牌占比'
				
				const legendObj = this.pie.legend
				let tooltipObj = {trigger: 'item',formatter: '{b} : {c} ({d}%)'}
				tooltipObj = Object.assign(tooltipObj , this.pie.tooltip?this.pie.tooltip:{})
				
				let seriesObj = {
					type: 'pie',
					radius: '55%',
					center: ['50%', '60%'],
					data: pArray,
					emphasis: {
						itemStyle: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
				seriesObj = Object.assign(seriesObj , this.pie.series)
				const gridObj = this.pie.grid
                option = {
                	backgroundColor: this.pie.backgroundColor,
                	color: this.pie.color,
                	title: titleObj,
                	legend: legendObj,
					grid: gridObj,
                	tooltip: tooltipObj,
                	series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                qichexinxiChart1.setOption(option);
				
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    qichexinxiChart1.resize();
                };
            }
        });
      })
    },

    qichexinxiChat2() {
      this.$nextTick(()=>{

        var qichexinxiChart2 = echarts.init(document.getElementById("qichexinxiChart2"),'macarons');
        this.$http({
            url: `qichexinxi/value/qichemingcheng/alllimittimes`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
					if(this.boardBase&&i==this.boardBase.barNum){
						break;
					}
                    xAxis.push(res[i].qichemingcheng);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].qichemingcheng
                    })
                }
                var option = {};
                let titleObj = this.bar.title
				titleObj.text = '汽车库存统计'
				
				const legendObj = this.bar.legend
				let tooltipObj = {trigger: 'item',formatter: '{b} : {c}'}
				tooltipObj = Object.assign(tooltipObj , this.bar.tooltip?this.bar.tooltip:{})
				
				let xAxisObj = this.bar.xAxis
				xAxisObj.type = 'category'
				xAxisObj.data = xAxis
                xAxisObj.axisLabel.rotate=40
				
				let yAxisObj = this.bar.yAxis
				yAxisObj.type = 'value'
				let seriesObj = {
						data: yAxis,
						type: 'bar'
					}
				seriesObj = Object.assign(seriesObj , this.bar.series)
				const gridObj = this.bar.grid

				option = {
					backgroundColor: this.bar.backgroundColor,
					color: this.bar.color,
					title: titleObj,
					legend: legendObj,
					tooltip: tooltipObj,
					xAxis: xAxisObj,
					yAxis: yAxisObj,
					series: [seriesObj],
					grid: gridObj
				};
                // 使用刚指定的配置项和数据显示图表。
                qichexinxiChart2.setOption(option);
				
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    qichexinxiChart2.resize();
                };
            }
        });
      })
    },

		getpeijianxinxiCount() {
			this.$http({
				url: `peijianxinxi/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.peijianxinxiCount = data.data
				}
			})
		},
// 1234 折滑
		peijianxinxiChat1() {
			this.$nextTick(()=>{

        var peijianxinxiChart1 = echarts.init(document.getElementById("peijianxinxiChart1"),'macarons');
        this.$http({
            url: `peijianxinxi/value/peijianmingcheng/peijianshuliang`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
					if(this.boardBase&&i==this.boardBase.lineNum){
						break;
					}
                    xAxis.push(res[i].peijianmingcheng);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].peijianmingcheng
                    })
                }
                var option = {};
				let titleObj = this.line.title
				titleObj.text = '配件库存统计'
				
				const legendObj = this.line.legend
				let tooltipObj = { trigger: 'item',formatter: '{b} : {c}'}
				tooltipObj = Object.assign(tooltipObj , this.line.tooltip?this.line.tooltip:{})
				let xAxisObj = this.line.xAxis
				xAxisObj.type = 'category'
				xAxisObj.boundaryGap = false
				xAxisObj.data = xAxis
				xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.line.yAxis
				yAxisObj.type = 'value'
				const gridObj = this.line.grid
				
				let seriesObj = {
					data: yAxis,
					type: 'line',
					smooth: true
				}
				seriesObj = Object.assign(seriesObj , this.line.series)
                option = {
					backgroundColor: this.line.backgroundColor,
					color: this.line.color,
                    title: titleObj,
					legend: legendObj,
					grid: gridObj,
                    tooltip: tooltipObj,
                    xAxis: xAxisObj,
                    yAxis: yAxisObj,
                    series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                peijianxinxiChart1.setOption(option);
				
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    peijianxinxiChart1.resize();
                };
            }
        });
      })
    },


		getpingjiajiluCount() {
			this.$http({
				url: `pingjiajilu/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.pingjiajiluCount = data.data
				}
			})
		},
// 1234 饼2
		pingjiajiluChat1() {
			this.$nextTick(()=>{

        var pingjiajiluChart1 = echarts.init(document.getElementById("pingjiajiluChart1"),'macarons');
        this.$http({
            url: "pingjiajilu/group/fuwupingfen",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
					if(this.boardBase&&i==this.boardBase.pieNum){
						break;
					}
                    xAxis.push(res[i].fuwupingfen);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].fuwupingfen
                    })
                }
                var option = {};
				let titleObj = this.pie.title
				titleObj.text = '服务评分统计'
				
				const legendObj = this.pie.legend
				let tooltipObj = {trigger: 'item',formatter: '{b} : {c} ({d}%)'}
				tooltipObj = Object.assign(tooltipObj , this.pie.tooltip?this.pie.tooltip:{})
				
				let seriesObj = {
					type: 'pie',
					radius: ['25%', '55%'],
					center: ['50%', '60%'],
					data: pArray,
					emphasis: {
						itemStyle: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
				seriesObj = Object.assign(seriesObj , this.pie.series)
				const gridObj = this.pie.grid
                option = {
                	backgroundColor: this.pie.backgroundColor,
                	color: this.pie.color,
                	title: titleObj,
                	legend: legendObj,
					grid: gridObj,
                	tooltip: tooltipObj,
                	series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                pingjiajiluChart1.setOption(option);
				
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    pingjiajiluChart1.resize();
                };
            }
        });
      })
    },


  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
	
	// 日历
	.calendar td .text {
				border-radius: 12px;
				flex-direction: column;
				background: #fff;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td .text:hover {
				background: rgba(78,110,242,.1);
			}
	.calendar td .text .new {
				color: #000;
				font-weight: 400;
				font-size: 18px;
				line-height: 1.4;
			}
	.calendar td .text .old {
				color: #666;
				font-size: 16px;
				line-height: 1.4;
			}
	.calendar td.festival .text {
				border-radius: 12px;
				flex-direction: column;
				background: rgba(235,51,51,.05);
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td.festival .text:hover {
				background: rgba(78,110,242,.1);
			}
	.calendar td.festival .text .new {
				color: #000;
				font-size: 24px;
				line-height: 1.4;
			}
	.calendar td.festival .text .old {
				color: #666;
				font-size: 16px;
				line-height: 1.4;
			}
	.calendar td.other .text {
				border-radius: 12px;
				flex-direction: column;
				background: #fff;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				opacity: 0.3;
				height: 100%;
			}
	.calendar td.other .text:hover {
				background: rgba(78,110,242,.1);
			}
	.calendar td.other .text .new {
				color: #000;
				font-size: 24px;
				line-height: 1.4;
			}
	.calendar td.other .text .old {
				color: #666;
				font-size: 16px;
				line-height: 1.4;
			}
	.calendar td.today .text {
				border-radius: 12px;
				flex-direction: column;
				color: #fff;
				background: #fe781b;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td.today .text:hover {
				background: rgba(64, 158, 255,.5);
			}
	.calendar td.today .text .new {
				color: inherit;
				font-size: 24px;
				line-height: 1.4;
			}
	.calendar td.today .text .old {
				color: inherit;
				font-size: 16px;
				line-height: 1.4;
			}
	
	// echarts1
	.type1 .echarts1 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type1 .echarts1:hover {
			}
	// echarts2
	.type2 .echarts1 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type2 .echarts1:hover {
			}
	.type2 .echarts2 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type2 .echarts2:hover {
			}
	// echarts3
	.type3 .echarts1 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type3 .echarts1:hover {
			}
	.type3 .echarts2 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type3 .echarts2:hover {
			}
	.type3 .echarts3 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type3 .echarts3:hover {
			}
	// echarts4
	.type4 .echarts1 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,.1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts1:hover {
			}
	.type4 .echarts2 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts2:hover {
			}
	.type4 .echarts3 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts3:hover {
			}
	.type4 .echarts4 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts4:hover {
			}
	// echarts5
	.type5 .echarts1 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts1:hover {
			}
	.type5 .echarts2 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts2:hover {
			}
	.type5 .echarts3 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts3:hover {
			}
	.type5 .echarts4 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts4:hover {
			}
	.type5 .echarts5 {
				border: 1px solid #ddd;
				border-radius: 8px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: 49%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts5:hover {
			}
	
	.echarts-flag-2 {
	  display: flex;
	  flex-wrap: wrap;
	  justify-content: space-between;
	  padding: 10px 20px;
	  background: rebeccapurple;
	
	  &>div {
	    width: 32%;
	    height: 300px;
	    margin: 10px 0;
	    background: rgba(255,255,255,.1);
	    border-radius: 8px;
	    padding: 10px 20px;
	  }
	}
</style>
