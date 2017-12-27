<header class="panel-heading">
    <h3>运营数据（数据采集日期：${collectionTime}）</h3>
</header>
<div class="panel-body">
    <div class="tab-pane" id="chartjs">
        <#--<div class="row">-->
            <#--<!-- Line &ndash;&gt;-->
            <#--<div class="col-lg-6">-->
                <#--<section class="panel">-->
                    <#--<header class="panel-heading">-->
                        <#--折线图-->
                    <#--</header>-->
                    <#--<div class="panel-body text-center" style="position: relative">-->
                        <#--<div id="echarts_line" style="height: 350px;width: auto"></div>-->
                    <#--</div>-->
                <#--</section>-->
            <#--</div>-->
            <#--<!-- Bar &ndash;&gt;-->
            <#--<div class="col-lg-6">-->
                <#--<section class="panel">-->
                    <#--<header class="panel-heading">-->
                        <#--柱状图-->
                    <#--</header>-->
                    <#--<div class="panel-body text-center"  style="position: relative">-->
                        <#--<div id="echarts_bar" style="height: 350px;width: auto"></div>-->
                    <#--</div>-->
                <#--</section>-->
            <#--</div>-->
        <#--</div>-->
        <div class="row">
            <!-- Pie -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        授权类型占比
                    </header>
                    <div class="panel-body text-center">
                        <div id="echarts_pie_producttyperatio" style="height: 350px;width: auto"></div>
                    </div>
                </section>
            </div>
            <!-- Pie -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        IT隶属部门分布
                    </header>
                    <div class="panel-body text-center">
                        <div id="echarts_pie_itdepartment" style="height: 350px;width: auto"></div>
                    </div>
                </section>
            </div>
        </div>

        <div class="row">
            <!-- Pie -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        用户行业分布
                    </header>
                    <div class="panel-body text-center">
                        <div id="echarts_pie_industryratio" style="height: 450px;width: auto"></div>
                    </div>
                </section>
            </div>
            <!-- Pie -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        提交问题模块分布
                    </header>
                    <div class="panel-body text-center">
                        <div id="problem_type" style="height: 450px;width: auto"></div>
                    </div>
                </section>
            </div>
        </div>
            <div class="row">
                <!-- Pie -->
                <div class="col-lg-6">
                    <section class="panel">
                        <header class="panel-heading">
                            运营商，代理商分布
                        </header>
                        <div class="panel-body text-center">
                            <div id="echarts_pie_agentratio" style="height: 600px;width: auto"></div>
                        </div>
                    </section>
                </div>
                <!-- Pie -->
                <div class="col-lg-6">
                    <section class="panel">
                        <header class="panel-heading">
                            地域分布
                        </header>
                        <div class="panel-body text-center">
                            <div id="echarts_pie_arearatio" style="height: 600px;width: auto"></div>
                        </div>
                    </section>
                </div>
            </div>
        <#--<div class="row">-->
            <#--<!-- Radar &ndash;&gt;-->
            <#--<div class="col-lg-6">-->
                <#--<section class="panel">-->
                    <#--<header class="panel-heading">-->
                        <#--分组柱状图-->
                    <#--</header>-->
                    <#--<div class="panel-body text-center">-->
                        <#--<div id="echarts_groupBar" style="height: 350px;width: auto"></div>-->
                    <#--</div>-->
                <#--</section>-->
            <#--</div>-->
        <#--</div>-->
        <#--<div class="row">-->
            <#--<!-- Polar Area &ndash;&gt;-->
            <#--<div class="col-lg-6">-->
                <#--<section class="panel">-->
                    <#--<header class="panel-heading">-->
                        <#--Polar Area-->
                    <#--</header>-->
                    <#--<div class="panel-body text-center">-->
                        <#--<div id="polarArea" style="height: 350px;width: auto"></div>-->
                    <#--</div>-->
                <#--</section>-->
            <#--</div>-->
            <#--<!-- Doughnut &ndash;&gt;-->
            <#--<div class="col-lg-6">-->
                <#--<section class="panel">-->
                    <#--<header class="panel-heading">-->
                        <#--Doughnut-->
                    <#--</header>-->
                    <#--<div class="panel-body text-center">-->
                        <#--<canvas id="doughnut" height="300" width="400"></canvas>-->
                    <#--</div>-->
                <#--</section>-->
            <#--</div>-->
        <#--</div>-->
    </div>
</div>

<script type="text/javascript" src="/js/echarts/echarts.js"></script>
<script type="text/javascript" src="/js/echarts/line.js"></script>
<script type="text/javascript" src="/js/echarts/bar.js"></script>
<script type="text/javascript" src="/js/echarts/groupBar.js"></script>
<script type="text/javascript" src="/js/echarts/pie.js"></script>

<script>
//    line.getData();
//    bar.getData();
//    groupBar.groupBar();
    pie.getProblemType();
    pie.getITDepartmentData();
    pie.getProductTypeRatio();
    pie.getAgentRatio();
    pie.getAreaRatio();
    pie.getIndustryRatio();

</script>