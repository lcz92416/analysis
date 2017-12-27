pie={
    getITDepartmentData:function () {
        $.ajax({
            url:"/charts/getITDepartmentModel",
            type:"GET",
            success:function (result) {
                pie.pie(result,"getITDepartmentData");
            },
            error:function (result) {

            }
        })
    },
    getProductTypeRatio:function () {
        $.ajax({
            url:"/charts/getProductTypeRatio",
            type:"GET",
            success:function (result) {
                pie.pie(result,"getProductTypeRatio");
            },
            error:function (result) {

            }
        })
    },
    getAgentRatio:function () {
        $.ajax({
            url:"/charts/getAgentRatio",
            type:"GET",
            success:function (result) {
                pie.pie(result,"getAgentRatio");
            },
            error:function (result) {

            }
        })
    },
    getAreaRatio:function (type) {
        $.ajax({
            url:"/charts/getAreaRatio",
            data:{"type":type},
            type:"GET",
            success:function (result) {
                pie.pie(result,"getAreaRatio");
            },
            error:function (result) {

            }
        })
    },
    getIndustryRatio:function () {
        $.ajax({
            url:"/charts/getIndustryRatio",
            type:"GET",
            success:function (result) {
                pie.pie(result,"getIndustryRatio");
            },
            error:function (result) {

            }
        })
    },
    getProblemType:function () {
        $.ajax({
            url:"/charts/getProblemTypeCount",
            type:"GET",
            success:function (result) {
                pie.pie(result,"getProblemTypeCount");
            },
            error:function (result) {

            }
        })
    },
    pie:function (result,dataType) {
        var type = [];
        var count = [];
        var json = [];
        var text="";
        var subtext="";
        var dom;
        var myChart;
        var size="65%"
        var height="50%";
        var width="50%";
        //IT隶属部门分布
        if("getITDepartmentData"==dataType){
            var weatherIcons = {
                'Sunny': './data/asset/img/weather/sunny_128.png',
                'Cloudy': './data/asset/img/weather/cloudy_128.png',
                'Showers': './data/asset/img/weather/showers_128.png'
            };
             dom = document.getElementById("echarts_pie_itdepartment");
             myChart = echarts.init(dom);
            text="IT隶属部门分布";
            height="53%";
            subtext=result[0].date;
            for (var i = 0; i <result.length; i++) {
                type.push(result[i].itdepartment);
                json.push({value:result[i].count, name:result[i].itdepartment})
            }
        }
        //授权类型占比
        if("getProductTypeRatio"==dataType){
            dom = document.getElementById("echarts_pie_producttyperatio");
            myChart = echarts.init(dom);
            text="授权类型占比";
            subtext=result[0].date;
            for (var i = 0; i <result.length; i++) {
                type.push(result[i].productType);
                json.push({value:result[i].count, name:result[i].productType})
            }
        }
        //运营商，代理商分布
        if("getAgentRatio"==dataType){
            dom = document.getElementById("echarts_pie_agentratio");
            myChart = echarts.init(dom);
            text="运营商，代理商分布";
            subtext=result[0].date;
            size="60%";
            height="55%";
            for (var i = 0; i <result.length; i++) {
                // type.push(result[i].agentname);
                json.push({value:result[i].count, name:result[i].agentname})
            }
        }
        //地域分布
        if("getAreaRatio"==dataType){
            dom = document.getElementById("echarts_pie_arearatio");
            myChart = echarts.init(dom);
            text="地域分布";
            subtext=result[0].date;
            size="70%";
            height="47%";
            for (var i = 0; i <result.length; i++) {
                if(null == result[i].province || ""==result[i].province){
                    type.push("未填写");
                    json.push({value:result[i].count, name:"未填写"})
                }else{
                    type.push(result[i].province);
                    json.push({value:result[i].count, name:result[i].province})
                }
            }
        }
        //用户行业分布
        if("getIndustryRatio"==dataType){
            dom = document.getElementById("echarts_pie_industryratio");
            myChart = echarts.init(dom);
            text="用户行业分布";
            subtext=result[0].date;
            size="60%";
            for (var i = 0; i <result.length; i++) {
                type.push(result[i].industry);
                json.push({value:result[i].count, name:result[i].industry})
            }
        }
        //提交问题模块分布
        if("getProblemTypeCount"==dataType){
            dom = document.getElementById("problem_type");
            myChart = echarts.init(dom);
            text="提交问题模块分布";
            subtext=result[0].analysisDate;
            for (var i = 0; i <result.length; i++) {
                type.push(result[i].modulename);
                json.push({value:result[i].count, name:result[i].modulename})
            }
        }
        option = null;
        option = {
            title: {
                text: text,
                subtext: subtext,
                left: 'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{b} : {c} ({d}%)"
            },
            legend: {
                // orient: 'vertical',
                // top: 'middle',
                bottom: 5,
                left: 'center',
                data: type
            },
            series : [
                {
                    type: 'pie',
                    radius : size,
                    center: [width, height],
                    selectedMode: 'single',
                    data:json,
                        // [
                    //     {
                    //         value:1548,
                    //         name: '幽州',
                    //         label: {
                    //             normal: {
                    //                 formatter: [
                    //                     '{title|{b}}{abg|}',
                    //                     '  {weatherHead|天气}{valueHead|天数}{rateHead|占比}',
                    //                     '{hr|}',
                    //                     '  {Sunny|}{value|202}{rate|55.3%}',
                    //                     '  {Cloudy|}{value|142}{rate|38.9%}',
                    //                     '  {Showers|}{value|21}{rate|5.8%}'
                    //                 ].join('\n'),
                    //                 backgroundColor: '#eee',
                    //                 borderColor: '#777',
                    //                 borderWidth: 1,
                    //                 borderRadius: 4,
                    //                 rich: {
                    //                     title: {
                    //                         color: '#eee',
                    //                         align: 'center'
                    //                     },
                    //                     abg: {
                    //                         backgroundColor: '#333',
                    //                         width: '100%',
                    //                         align: 'right',
                    //                         height: 25,
                    //                         borderRadius: [4, 4, 0, 0]
                    //                     },
                    //                     Sunny: {
                    //                         height: 30,
                    //                         align: 'left',
                    //                         backgroundColor: {
                    //                             image: weatherIcons.Sunny
                    //                         }
                    //                     },
                    //                     Cloudy: {
                    //                         height: 30,
                    //                         align: 'left',
                    //                         backgroundColor: {
                    //                             image: weatherIcons.Cloudy
                    //                         }
                    //                     },
                    //                     Showers: {
                    //                         height: 30,
                    //                         align: 'left',
                    //                         backgroundColor: {
                    //                             image: weatherIcons.Showers
                    //                         }
                    //                     },
                    //                     weatherHead: {
                    //                         color: '#333',
                    //                         height: 24,
                    //                         align: 'left'
                    //                     },
                    //                     hr: {
                    //                         borderColor: '#777',
                    //                         width: '100%',
                    //                         borderWidth: 0.5,
                    //                         height: 0
                    //                     },
                    //                     value: {
                    //                         width: 20,
                    //                         padding: [0, 20, 0, 30],
                    //                         align: 'left'
                    //                     },
                    //                     valueHead: {
                    //                         color: '#333',
                    //                         width: 20,
                    //                         padding: [0, 20, 0, 30],
                    //                         align: 'center'
                    //                     },
                    //                     rate: {
                    //                         width: 40,
                    //                         align: 'right',
                    //                         padding: [0, 10, 0, 0]
                    //                     },
                    //                     rateHead: {
                    //                         color: '#333',
                    //                         width: 40,
                    //                         align: 'center',
                    //                         padding: [0, 10, 0, 0]
                    //                     }
                    //                 }
                    //             }
                    //         }
                    //     },
                    //     {value:535, name: '荆州'},
                    //     {value:510, name: '兖州'},
                    //     {value:634, name: '益州'},
                    //     {value:735, name: '西凉'}
                    // ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    },

    pie_simple:function (result,dataType) {
        var dom = document.getElementById("echarts_pie");
        var myChart = echarts.init(dom);
        var type = [];
        var count = [];
        var json = [];
        var text="";
        var subtext="";
        debugger;
        if("getITDepartmentData"==dataType){
            text="IT隶属部门分布";
            subtext=result[0].analysisDate;
            for (var i = 0; i <result.length; i++) {
                type.push(result[i].type);
                json.push({value:result[i].count, name:result[i].type})
            }
        }
        option = null;
        option = {
            title : {
                text: text,
                subtext: subtext,
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: type
            },
            series : [
                {
                    name: '数量',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:json,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    }
};
