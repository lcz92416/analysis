<header class="panel-heading">
    <h3>图表展示区域</h3>
</header>
<div class="panel-body">
    <div class="tab-pane" id="chartjs">
        <div class="row">
            <!-- Line -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        折线图
                    </header>
                    <div class="panel-body text-center" style="position: relative">
                        <div id="echarts_line" style="height: 350px;width: auto"></div>
                    </div>
                </section>
            </div>
        </div>
        <div class="row">
        <!-- Bar -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        柱状图
                    </header>
                    <div class="panel-body text-center"  style="position: relative">
                        <div id="echarts_bar" style="height: 350px;width: auto"></div>
                    </div>
                </section>
            </div>
        </div>
        <div class="row">
            <!-- Radar -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        分组柱状图
                    </header>
                    <div class="panel-body text-center">
                        <div id="echarts_groupBar" style="height: 350px;width: auto"></div>
                    </div>
                </section>
            </div>
            <!-- Pie -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        饼图
                    </header>
                    <div class="panel-body text-center">
                        <canvas id="echarts_pie" height="300" width="400"></canvas>
                    </div>
                </section>
            </div>
        </div>
        <div class="row">
            <!-- Polar Area -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        Polar Area
                    </header>
                    <div class="panel-body text-center">
                        <div id="polarArea" style="height: 350px;width: auto"></div>
                    </div>
                </section>
            </div>
            <!-- Doughnut -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        Doughnut
                    </header>
                    <div class="panel-body text-center">
                        <canvas id="doughnut" height="300" width="400"></canvas>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/js/echarts/echarts.js"></script>
<script type="text/javascript" src="/js/echarts/line.js"></script>
<script type="text/javascript" src="/js/echarts/bar.js"></script>
<script type="text/javascript" src="/js/echarts/groupBar.js"></script>
<script type="text/javascript" src="/js/echarts/pie.js"></script>

<script>
    line.getData();
    bar.getData();
    groupBar.groupBar();
    pie.pie();
</script>