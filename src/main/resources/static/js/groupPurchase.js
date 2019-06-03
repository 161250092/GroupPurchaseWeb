Vue.http.options.emulateJSON = true;
//Vue实例
new Vue({
    el: '#app',
    data() {
        return {

            commodities:[],

            selectedCommodityId:0,
            bankAccount:"",
            password:"",
            phoneNumber:"",

            purchaseOrder:false,
            activeIndex: '1'

        }
    },
    methods: {

        getAllCommodities(){
            this.$http.post('/groupBuy/getAllCommodities').then(result => {
                console.log(result);
                this.commodities = result.body;
            });

        },


        purchase(commodity){
            this.purchaseOrder =  true;
            this.selectedCommodityId = commodity.id;
        },


        submitOrder(){
            this.$http.post('/groupBuy/submitOrder',{
                commodityId:this.selectedCommodityId,
                bankAccount:this.bankAccount,
                password:this.password,
                phoneNumber:this.phoneNumber
            }).then(result => {
                console.log(result);
                if(result.body===true){
                    this.$message({
                        showClose: true,
                        message: '恭喜你，团购成功',
                        type: 'success'
                    });
                    this.purchaseOrder = false;
                }
                else{
                    this.$message({
                        showClose: true,
                        message: '哦豁,出错了',
                        type: 'error'
                    });

                }

                this.purchaseOrder = false;

            });


        }



    },


    //声明周期钩子函数-->在data和methods渲染结束后执行
    created() {
        this.getAllCommodities();

    }



});