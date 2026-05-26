const base = {
    get() {
        return {
            url : "http://localhost:8080/carsystems/",
            name: "carsystems",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/carsystems/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "车企数字化管理系统"
        } 
    }
}
export default base
