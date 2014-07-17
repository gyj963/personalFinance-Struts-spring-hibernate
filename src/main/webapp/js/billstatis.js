/**
 * Created by Administrator on 13-12-28.
 */
/**
 * Created with JetBrains WebStorm.
 * User: Administrator
 * Date: 13-11-28
 * Time: 下午10:13
 * To change this template use File | Settings | File Templates.
 */
$(function(){
    $("div#data div").css("z-index","1");
    $("div#data div#statisDetailStyle").css("z-index","2");
    ajaxChartStyle();
    $("#statisNav li").on("click",function(){
        $("#statisNav li.active").removeClass("active");
        $(this).addClass("active");
        var ss=$(this).attr("way");
        $("div#data div").css("z-index","1");
        $("div#data div").each(function(){
           if($(this).attr("way")==ss){
               $(this).css("z-index","2");
               return ;
           }
        });
        if(ss=="statisDetailStyle"){
            ajaxChartStyle();
        }else if(ss=="statisDetailCreateTime"){
            ajaxChartCreatedTime();
        }else if(ss=="statisDetailMemo"){
            ajaxChartMemo();
        }
    });
});

function  createChartStyle(data){
    var plot1 = jQuery.jqplot ('chart1', [data],
        {
            title:'根据收支类型的账单百分比统计图',
            seriesDefaults: {
                // Make this a pie chart.
                renderer: jQuery.jqplot.PieRenderer,
                rendererOptions: {
                    // Put data labels on the pie slices.
                    // By default, labels show the percentage of the slice.
                    showDataLabels: true
                }
            },
            legend: { show:true, location: 'e' }
        }
    );
}

function createLineChart(line1,line2){
    $.jqplot.config.enablePlugins = true;
    var plot1 = $.jqplot('chart2', [line1,line2], {
        title:'根据时间及类型的资金走向折线图',
        axes:{
            xaxis:{
                renderer:$.jqplot.DateAxisRenderer,
                rendererOptions:{
                    tickRenderer:$.jqplot.CanvasAxisTickRenderer
                },
                tickOptions:{
                    fontSize:'10pt',
                    fontFamily:'Tahoma',
                    angle:-40
                }
            },
            yaxis:{
                rendererOptions:{
                    tickRenderer:$.jqplot.CanvasAxisTickRenderer},
                tickOptions:{
                    fontSize:'10pt',
                    fontFamily:'Tahoma',
                    angle:30,
                    prefix: '$'
                }
            }
        },
        series:[{ lineWidth:4, markerOptions:{ style:'square' },label:'支出'},{label:'收入'}],
        cursor:{
            zoom:true,
            looseZoom: true
        },
        legend:{show:true, location:'se'}
    });
}

function  createChartMemo(data){
    var plot1 = jQuery.jqplot ('chart3', [data],
        {
            title:'根据用途的账单百分比统计图',
            seriesDefaults: {
                // Make this a pie chart.
                renderer: jQuery.jqplot.PieRenderer,
                rendererOptions: {
                    // Put data labels on the pie slices.
                    // By default, labels show the percentage of the slice.
                    showDataLabels: true
                }
            },
            legend: { show:true, location: 'e' }
        }
    );
}

function ajaxChartStyle(){
    $.ajax({
        url:'/pf/bill/billStatisByStyle.action',
        dataType:'json',
        error:function(){
            alert("error");
        },
        success:function(data){
            chartData = [];
            $(".table tr:not(:first)").remove();
            console.log(data);
            $.each(data,function(index){
                var option="<tr>"+
                    "<td>"+(index+1)+"</td>"+
                    "<td>"+data[index].billStyle+"</td>"+
                    "<td>"+data[index].cnt+"</td>"+
                    "</tr>";
                $(".statisDetailStyle").append(option);
                item=[];
                item.push(data[index].billStyle);
                item.push(data[index].cnt);
                chartData.push(item);
            });
            createChartStyle(chartData);
        }
    });
}

function ajaxChartCreatedTime(){
    $.ajax({
        url:'/pf/bill/billStatisByCreatedTime.action',
        dataType:'json',
        error:function(){
            alert("error");
        },
        success:function(data){
            LineData1 = [];
            LineData2 = [];
//            $(".table tr:not(:first)").remove();
            console.log("所有的"+data);
            console.log(data);
            console.log("支出的"+data[0]);
            console.log(data[0]);
            console.log("收入的"+data[1]);
            console.log(data[1]);
            var data1=data[0];
            var data2=data[1];
            $.each(data1,function(index){
                item=[];
                item.push(data1[index].billCreatedTime);
                item.push(data1[index].billMoney);
                LineData1.push(item);
            });
            $.each(data2,function(index){
                item=[];
                item.push(data2[index].billCreatedTime);
                item.push(data2[index].billMoney);
                LineData2.push(item);
            });
            createLineChart(LineData1,LineData2);
        }
    });
}

function ajaxChartMemo(){
    $.ajax({
        url:'/pf/bill/billStatisByMemo.action',
        dataType:'json',
        error:function(){
            alert("error");
        },
        success:function(data){
            chartData = [];
            console.log(data);
            $.each(data,function(index){
                item=[];
                item.push(data[index].billMemo);
                item.push(data[index].cnt);
                chartData.push(item);
            });
            createChartMemo(chartData);
        }
    });
}




