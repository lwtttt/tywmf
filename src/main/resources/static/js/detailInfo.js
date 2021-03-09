
var $nativePlace;
var $weight;
var $nation;

$(function(){

    show_myself();

    select();
})


//个人基本资料回显
function show_myself(){
    $.ajax({
        url: "/getUserById",
        type: "post",
        dataType: "json",
        success: function(userById){

            //获取图片路径
            $(".logo").remove();
            var str = "<div class=\"logo\" style=\"background-image:url(&quot;"+ userById[0].idPic +"&quot;);\" data-v-8dc533f6>\n</div>";
            $("#insert_img").prepend(str);

            $("#nativePlace").html(userById[0].nativePlace);
            $("#weight").html(userById[0].weight);
            $("#nation").html(userById[0].nation);

        },
        error: function(){
            alert("Error");
        }
    })
}

//下拉框
function select(){
    $(".SELECT").hover(function(){
        $(this).children().next().show();
    }, function(){
        $(this).children().next().hide();
    })

    //选择后显示在信息中
    $(".option").click(function(){
        var option_value = $(this).html();
        $(this).parent().parent().prev().html(option_value);
    })

    //点击保存与取消
    $(".submit").click(function(){
        //update
        update();
    })
    $(".jump").click(function(){
        show_myself();
    })
}

function update(){

    $nativePlace = $("#nativePlace").html();
    $weight = $("#weight").html();
    $nation = $("#nation").html();

    $.ajax({
        url: "/updateUser",
        type: "post",
        data: { nativePlace:$nativePlace,
                weight:$weight,
                nation:$nation
        },
        dataType: "json",
        success: function(){
            alert("修改成功");
        },
        error: function(){
            alert("修改失败!")
            show_myself();
        }
    })
}