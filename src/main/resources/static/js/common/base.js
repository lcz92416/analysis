$(document).ready(function() {
    indexShow();
    $(".sidebar-menu a").on("click",function(){
        var url = $(this).data("path");
        if(url != "" && url != null){
            $.ajax({
                url : url,
                type : "GET",
                data : {},
                success : function(result){
                    $("#mainContent").html(result);
                },
                error : function(){
                    $.dialog.error("获取数据失败！");
                }
            })
        }
    })
});

function indexShow(){
    var url = "/charts/chartIndex";
    $.ajax({
        url : url,
        type : "GET",
        data : {},
        success : function(result){
            $("#mainContent").html(result);
        },
        error : function(){

        }
    })
}