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
                        <div id="line" style="height: 350px;width: auto"></div>
                    </div>
                </section>
            </div>
            <!-- Bar -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        柱状图
                    </header>
                    <div class="panel-body text-center"  style="position: relative">
                        <div id="bar" style="height: 350px;width: auto"></div>
                    </div>
                </section>
            </div>
        </div>
        <div class="row">
            <!-- Radar -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        Radar
                    </header>
                    <div class="panel-body text-center">
                        <div id="radar" style="height: 350px;width: auto"></div>
                    </div>
                </section>
            </div>
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
        </div>
        <div class="row">

            <!-- Pie -->
            <div class="col-lg-6">
                <section class="panel">
                    <header class="panel-heading">
                        Pie
                    </header>
                    <div class="panel-body text-center">
                        <canvas id="pie" height="300" width="400"></canvas>
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

<script src="/js/echarts/echarts.js"></script>
<script src="/js/indexChart/indexCharts.js"></script>
<script>

</script>