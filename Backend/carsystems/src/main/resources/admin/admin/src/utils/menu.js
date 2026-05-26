const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "首页总数"],
                    "appFrontIcon": "cuIcon-album",
                    "buttons": ["新增", "查看", "修改", "删除", "首页总数"],
                    "menu": "用户",
                    "menuJump": "列表",
                    "tableName": "yonghu"
                }], "menu": "用户管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-form",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "时间段",
                    "menuJump": "列表",
                    "tableName": "shijianduan"
                }], "menu": "时间段管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "首页总数"],
                    "appFrontIcon": "cuIcon-full",
                    "buttons": ["新增", "查看", "修改", "删除", "首页总数"],
                    "menu": "维修工人",
                    "menuJump": "列表",
                    "tableName": "weixiugongren"
                }], "menu": "维修工人管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-brand",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "配件分类",
                    "menuJump": "列表",
                    "tableName": "peijianfenlei"
                }], "menu": "配件分类管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-phone",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "汽车品牌",
                    "menuJump": "列表",
                    "tableName": "qichepinpai"
                }], "menu": "汽车品牌管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "汽车品牌占比", "汽车库存统计", "查看评论", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-taxi",
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论", "首页总数", "首页统计"],
                    "menu": "汽车信息",
                    "menuJump": "列表",
                    "tableName": "qichexinxi"
                }], "menu": "汽车信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "配件库存统计", "首页总数", "首页统计", "配件入库", "配件使用"],
                    "appFrontIcon": "cuIcon-keyboard",
                    "buttons": ["新增", "查看", "修改", "删除", "首页总数", "首页统计", "配件入库"],
                    "menu": "配件信息",
                    "menuJump": "列表",
                    "tableName": "peijianxinxi"
                }], "menu": "配件信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "服务预约"],
                    "appFrontIcon": "cuIcon-link",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "车辆信息",
                    "menuJump": "列表",
                    "tableName": "cheliangxinxi"
                }], "menu": "车辆信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "服务接单"],
                    "appFrontIcon": "cuIcon-vip",
                    "buttons": ["查看", "修改", "删除", "审核"],
                    "menu": "预约信息",
                    "menuJump": "列表",
                    "tableName": "yuyuexinxi"
                }], "menu": "预约信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "服务接单"],
                    "appFrontIcon": "cuIcon-vip",
                    "buttons": ["查看", "修改", "删除", "审核"],
                    "menu": "试驾信息",
                    "menuJump": "列表",
                    "tableName": "shijia"
                }], "menu": "试驾信息管理"
            }
            , {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-wenzi",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "入库记录",
                    "menuJump": "列表",
                    "tableName": "rukujilu"
                }], "menu": "入库记录管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付", "服务评价"],
                    "appFrontIcon": "cuIcon-wenzi",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "进度信息",
                    "menuJump": "列表",
                    "tableName": "jinduxinxi"
                }], "menu": "进度信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付"],
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "配件记录",
                    "menuJump": "列表",
                    "tableName": "peijianjilu"
                }], "menu": "配件记录管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "服务评分统计", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-keyboard",
                    "buttons": ["查看", "修改", "删除", "审核", "首页总数", "首页统计"],
                    "menu": "评价记录",
                    "menuJump": "列表",
                    "tableName": "pingjiajilu"
                }], "menu": "评价记录管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-present",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "消息提醒",
                    "menuJump": "列表",
                    "tableName": "xiaoxitixing"
                }], "menu": "消息提醒管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-group",
                    "buttons": ["查看", "删除"],
                    "menu": "论坛交流",
                    "tableName": "forum"
                }], "menu": "论坛交流"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-vip",
                    "buttons": ["查看", "修改"],
                    "menu": "轮播图管理",
                    "tableName": "config"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "通知公告",
                    "tableName": "news"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-news",
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "通知公告分类",
                    "tableName": "newstype"
                }, {
                    "allButtons": ["查看", "修改"],
                    "appFrontIcon": "cuIcon-vip",
                    "buttons": ["查看", "修改"],
                    "menu": "关于我们",
                    "tableName": "aboutus"
                }], "menu": "系统管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额"],
                    "appFrontIcon": "cuIcon-shop",
                    "buttons": ["查看"],
                    "menu": "未支付订单",
                    "tableName": "orders/未支付"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "发货", "物流", "核销"],
                    "appFrontIcon": "cuIcon-cardboard",
                    "buttons": ["查看", "核销"],
                    "menu": "已支付订单",
                    "tableName": "orders/已支付"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "物流", "退货审核"],
                    "appFrontIcon": "cuIcon-camera",
                    "buttons": ["查看", "退货审核", "品销额", "品销量"],
                    "menu": "已完成订单",
                    "tableName": "orders/已完成"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额"],
                    "appFrontIcon": "cuIcon-qrcode",
                    "buttons": ["查看"],
                    "menu": "已取消订单",
                    "tableName": "orders/已取消"
                }, {
                    "allButtons": ["新增", "查看", "修改", "删除", "导出", "日销量", "月销量", "年销量", "品销量", "类销量", "日销额", "月销额", "年销额", "品销额", "类销额", "物流"],
                    "appFrontIcon": "cuIcon-phone",
                    "buttons": ["查看"],
                    "menu": "已退款订单",
                    "tableName": "orders/已退款"
                }], "menu": "订单管理"
            }],
            "frontMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "汽车品牌占比", "汽车库存统计", "查看评论", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-full",
                    "buttons": ["查看"],
                    "menu": "汽车信息列表",
                    "menuJump": "列表",
                    "tableName": "qichexinxi"
                }], "menu": "汽车信息模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "users"
        }, {
            "backMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "服务预约"],
                    "appFrontIcon": "cuIcon-link",
                    "buttons": ["查看", "服务预约"],
                    "menu": "车辆信息",
                    "menuJump": "列表",
                    "tableName": "cheliangxinxi"
                }], "menu": "车辆信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "服务接单"],
                    "appFrontIcon": "cuIcon-vip",
                    "buttons": ["查看"],
                    "menu": "预约信息",
                    "menuJump": "列表",
                    "tableName": "yuyuexinxi"
                }], "menu": "预约信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付", "服务评价"],
                    "appFrontIcon": "cuIcon-wenzi",
                    "buttons": ["查看", "支付", "服务评价"],
                    "menu": "进度信息",
                    "menuJump": "列表",
                    "tableName": "jinduxinxi"
                }], "menu": "进度信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付"],
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["查看", "支付"],
                    "menu": "配件记录",
                    "menuJump": "列表",
                    "tableName": "peijianjilu"
                }], "menu": "配件记录管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "服务评分统计", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-keyboard",
                    "buttons": ["查看"],
                    "menu": "评价记录",
                    "menuJump": "列表",
                    "tableName": "pingjiajilu"
                }], "menu": "评价记录管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除"],
                    "appFrontIcon": "cuIcon-present",
                    "buttons": ["查看"],
                    "menu": "消息提醒",
                    "menuJump": "列表",
                    "tableName": "xiaoxitixing"
                }], "menu": "消息提醒管理"
            }],
            "frontMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "汽车品牌占比", "汽车库存统计", "查看评论", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-full",
                    "buttons": ["查看"],
                    "menu": "汽车信息列表",
                    "menuJump": "列表",
                    "tableName": "qichexinxi"
                }], "menu": "汽车信息模块"
            }],
            "hasBackLogin": "否",
            "hasBackRegister": "否",
            "hasFrontLogin": "是",
            "hasFrontRegister": "是",
            "roleName": "用户",
            "tableName": "yonghu"
        }, {
            "backMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "配件库存统计", "首页总数", "首页统计", "配件入库", "配件使用"],
                    "appFrontIcon": "cuIcon-keyboard",
                    "buttons": ["查看", "配件使用"],
                    "menu": "配件信息",
                    "menuJump": "列表",
                    "tableName": "peijianxinxi"
                }], "menu": "配件信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "服务接单"],
                    "appFrontIcon": "cuIcon-vip",
                    "buttons": ["查看", "审核", "服务接单"],
                    "menu": "预约信息",
                    "menuJump": "列表",
                    "tableName": "yuyuexinxi"
                }], "menu": "预约信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付", "服务评价"],
                    "appFrontIcon": "cuIcon-wenzi",
                    "buttons": ["查看", "修改"],
                    "menu": "进度信息",
                    "menuJump": "列表",
                    "tableName": "jinduxinxi"
                }], "menu": "进度信息管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "支付"],
                    "appFrontIcon": "cuIcon-clothes",
                    "buttons": ["查看"],
                    "menu": "配件记录",
                    "menuJump": "列表",
                    "tableName": "peijianjilu"
                }], "menu": "配件记录管理"
            }, {
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "审核", "服务评分统计", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-keyboard",
                    "buttons": ["查看"],
                    "menu": "评价记录",
                    "menuJump": "列表",
                    "tableName": "pingjiajilu"
                }], "menu": "评价记录管理"
            }],
            "frontMenu": [{
                "child": [{
                    "allButtons": ["新增", "查看", "修改", "删除", "汽车品牌占比", "汽车库存统计", "查看评论", "首页总数", "首页统计"],
                    "appFrontIcon": "cuIcon-full",
                    "buttons": ["查看"],
                    "menu": "汽车信息列表",
                    "menuJump": "列表",
                    "tableName": "qichexinxi"
                }], "menu": "汽车信息模块"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "维修工人",
            "tableName": "weixiugongren"
        }]
    }
}
export default menu;
