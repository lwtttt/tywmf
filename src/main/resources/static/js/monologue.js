
var $monologue;

$(function(){

    show_myself();

    $("#subm").click(function(){
        update();
    });

    $("#closeno").click(function(){
        show_myself();
    })
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

            $("#texta").val(userById[0].conduction);
        },
        error: function(){
            alert("Error");
        }
    })
}

//下拉框
// function select(){
//     $(".SELECT").hover(function(){
//         $(this).children().next().show();
//     }, function(){
//         $(this).children().next().hide();
//     })
//
//     //选择后显示在信息中
//     $(".option").click(function(){
//         var option_value = $(this).html();
//         $(this).parent().parent().prev().html(option_value);
//     })
//
//     //点击保存与取消
//     $(".submit").click(function(){
//         //update
//         update();
//     })
//     $(".jump").click(function(){
//         show_myself();
//     })
// }

function update(){

    $monologue = $("#texta").val();

    $.ajax({
        url: "/updateUser",
        type: "post",
        data: { monologue: $monologue},
        dataType: "json",
        success: function(){
            alert("提交成功");
        },
        error: function(){
            alert("修改失败!")
            show_myself();
        }
    })
}