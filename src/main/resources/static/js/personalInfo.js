
$(function(){

    show_myself();

})

function sendMsg(){
    var userId = $("#userId").val();
    window.location.href='/chat/login?userId=1'

}







//个人展示窗口信息显示
function show_myself(){
    var userId = $("#userId").val();

    $.ajax({
        url: "/getUserById",
        type: "post",
        data: {userId: userId},
        dataType: "json",
        success: function(userById){

            //获取当前年
            var myDate = new Date();
            var year=myDate.getFullYear();
            //获取出生年，得到年龄
            var birthday = userById[0].birthday;
            var birthYear = birthday.split("-")[0];
            var age = year - birthYear;

            var str = "<div data-v-5b109fc3=\"\" class=\"logo f-fl\" style=\"background-image: url(&quot;"+ userById[0].idPic+"&quot;);\"></div>";
            $("#insert_img").prepend(str);

            $("#nickName").html(userById[0].userName);
            $("#my_userId").html("ID：" + userById[0].userId);
            // 北京 | 23岁 | 大学本科 | 未婚 | 162cm | 8001-12000元
            $("#many_msg").html(userById[0].nativePlace + "&nbsp;|&nbsp;" +
                age + "岁&nbsp;|&nbsp;" +
                userById[0].education + "&nbsp;|&nbsp;" +
                userById[0].maritalStatus + "&nbsp;|&nbsp;" +
                userById[0].height + "cm&nbsp;|&nbsp;" +
                userById[0].income + "元&nbsp;|&nbsp;"
            );
            if(userById[0].conduction != null && userById[0].conduction != ""){
                $("#conduction").html(userById[0].conduction);
            }
        //     <div data-v-8b1eac0c="" class="m-btn purple">162cm</div>
        //     <div data-v-8b1eac0c="" class="m-btn purple">69kg</div>
        //     <div data-v-8b1eac0c="" class="m-btn purple">工作地:北京朝阳区</div>
        //     <div data-v-8b1eac0c="" class="m-btn purple">月收入:8千-1.2万</div>
        //     <div data-v-8b1eac0c="" class="m-btn purple">运营管理</div>
    //         <div data-v-8b1eac0c="" class="m-btn purple">大学本科</div>
            if(userById[0].maritalStatus != null && userById[0].maritalStatus != ""){
                $("#base_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn purple\">"+ userById[0].maritalStatus +"</div>");
            }

            $("#base_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn purple\">"+ age +"岁</div>");

            if(userById[0].height != null && userById[0].height != ""){
                $("#base_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn purple\">"+ userById[0].height +"cm</div>");
            }

            if(userById[0].weight != null && userById[0].weight != ""){
                $("#base_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn purple\">"+ userById[0].weight +"kg</div>");
            }

            if(userById[0].workplace != null && userById[0].workplace != ""){
                $("#base_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn purple\">工作地："+ userById[0].workplace +"</div>");
            }

            if(userById[0].income != null && userById[0].income != ""){
                $("#base_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn purple\">月收入："+ userById[0].income +"</div>");
            }

            if(userById[0].jobClass != null && userById[0].jobClass != ""){
                $("#base_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn purple\">"+ userById[0].jobClass +"</div>");
            }

            if(userById[0].education != null && userById[0].education != ""){
                $("#base_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn purple\">"+ userById[0].education +"</div>");
            }

        // <div data-v-8b1eac0c="" class="m-btn pink">汉族</div>
        //         <div data-v-8b1eac0c="" class="m-btn pink">籍贯:辽宁葫芦岛</div>
        //         <div data-v-8b1eac0c="" class="m-btn pink">不喝酒</div>
        //         <div data-v-8b1eac0c="" class="m-btn pink">和家人同住</div>
        //         <div data-v-8b1eac0c="" class="m-btn pink">未买车</div>
        //         <div data-v-8b1eac0c="" class="m-btn pink">没有小孩</div>
        //         <div data-v-8b1eac0c="" class="m-btn pink">是否想要孩子:以后再告诉你</div>
        //     <div data-v-8b1eac0c="" class="m-btn pink">何时结婚:时机成熟就结婚</div>
            if(userById[0].nation != null && userById[0].nation != ""){
                $("#plus_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn pink\">"+ userById[0].nation +"</div>");
            }

            if(userById[0].nativePlace != null && userById[0].nativePlace != ""){
                $("#plus_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn pink\">籍贯："+ userById[0].nativePlace +"</div>");
            }

            if(userById[0].smoke != null && userById[0].smoke != ""){
                $("#plus_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn pink\">"+ userById[0].smoke +"</div>");
            }

            if(userById[0].drink != null && userById[0].drink != ""){
                $("#plus_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn pink\">"+ userById[0].drink +"</div>");
            }

            if(userById[0].house != null && userById[0].house != ""){
                $("#plus_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn pink\">"+ userById[0].house +"</div>");
            }

            if(userById[0].car != null && userById[0].car != ""){
                $("#plus_info").append("<div data-v-8b1eac0c=\"\" class=\"m-btn pink\">"+ userById[0].car +"</div>");
            }
        },
        error: function(){
            alert("Error");
        }
    })
}