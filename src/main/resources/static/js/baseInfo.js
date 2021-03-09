
var $sex;
var $marry;
var $education;
var $height;
var $username;
var $phone;
var $province;
var $income;


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

            $("#sex").val(userById[0].gender);
            $("#marry").val(userById[0].maritalStatus);
            $("#education").val(userById[0].education);
            $("#height").val(userById[0].height);

            $("#username").val(userById[0].userName);
            $("#phone").val(userById[0].phone);
            $("#province").html(userById[0].workplace);
            $("#income").html(userById[0].income);

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

    $sex = $("#sex").val();
    $marry = $("#marry").val();
    $education = $("#education").val();
    $height = $("#height").val();
    $username = $("#username").val();
    $phone = $("#phone").val();
    $province = $("#province").html();
    $income = $("#income").html();

    $.ajax({
        url: "/updateUser",
        type: "post",
        data: { gender:$sex,
                maritalStatus:$marry,
                education:$education,
                height:$height,
                username:$username,
                phone:$phone,
                province:$province,
                income:$income
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