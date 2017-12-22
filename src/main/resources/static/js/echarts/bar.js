bar={
    getData:function () {
        $.ajax({
            url:"/charts/getProblemTypeCount",
            type:"GET",
            success:function (result) {
                bar.bar(result);
            },
            error:function (result) {

            }
        })
    },
    bar:function (result) {
        var dom = document.getElementById("echarts_bar");
        var myChart = echarts.init(dom);
        var type = [];
        var count = [];
        var title=""
        for (var i = 0; i <result.length; i++) {
            title=result[i].analysisDate;
            type.push(result[i].type);
            count.push(result[i].count);
        }
        option = null;
        option = {
            title : {
                text: '提交问题模块分析',
                subtext: title
            },
            tooltip : {
                trigger: 'axis'
            },
            toolbox: {
                show : true,
                feature : {
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data : type
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'问题数',
                    type:'bar',
                    data:count,
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    },
                    markLine : {
                        data : [
                            {type : 'average', name: '平均值'}
                        ]
                    }
                }
            ]
        };
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    }
};
