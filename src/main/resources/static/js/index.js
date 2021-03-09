
//择偶条件
var $local;//地区
var $age;//年龄
var $height;//身高
var $income;//收入
var user;//查询条件
var pageIndex = 1;//当前页
var pages;//总页数

$(function(){

    show();
    condition();
    rollPage();

    $("#show").on("click",".all_box>img",function(){

        var id = $(this).next().val();
        location.href = "/personalInfo.html?userId="+id;
    })
    /*******************页面跳转*******************/
    $(".profile-box").click(function(){
        location.href = "/baseInfo.html";
    })
})



/*-------------------------------------展示信息-------------------------------------*/
function show(){

    $.ajax({
        url: "/getUserByCondition",
        type: "post",
        data: {nativePlace:$local, income:$income, height:$height, age:$age, page:pageIndex},
        dataType: "json",
        success: function(allUser){

            //获取总页数
            pages = $("#pages").val();

            //获取当前年
            var myDate = new Date();
            var year=myDate.getFullYear();

            // $("#show").empty();
            for(i in allUser){
                //获取出生年，得到年龄
                var birthday = allUser[i].birthday;
                var birthYear = birthday.split("-")[0];
                var age = year - birthYear;

                //展示个人信息
                var str =
                    "<div data-v-7b4fded4=\"\" class=\"all_box recommend-item f-fl item-right-border item-bottom-border\"><img\n" +
                    "                            data-v-7b4fded4=\"\" src=\" "+allUser[i].idPic+" \"\n" +
                    "                            class=\"f-fl\">\n" +  "<input type='hidden' value='"+ allUser[i].userId +"'>" +
                    "                        <div data-v-7b4fded4=\"\" class=\"f-fl father\" >\n" +
                    "                            <div data-v-7b4fded4=\"\" class=\"f-cl son\" ><p data-v-7b4fded4=\"\" class=\"nickname f-fl\" >" + allUser[i].userName + "</p>\n" +
                    "                                <div data-v-7b4fded4=\"\" class=\"tags f-fl\">\n" +
                    "                                    <div data-v-7b4fded4=\"\" class=\"f-fl\"><span data-v-39acb34a=\"\" data-v-7b4fded4=\"\"\n" +
                    "                                                                               title=\"珍心会员\" class=\"FLAG zhenxin\"\n" +
                    "                                                                               style=\"width: 15px; height: 15px;\"></span>\n" +
                    "                                        <!----> <!----></div>\n" +
                    "                                    <div data-v-7b4fded4=\"\" class=\"f-fl\"><!----> <!----> <span data-v-39acb34a=\"\"\n" +
                    "                                                                                               data-v-7b4fded4=\"\"\n" +
                    "                                                                                               title=\"实名认证\"\n" +
                    "                                                                                               class=\"FLAG realname\"\n" +
                    "                                                                                               style=\"width: 15px; height: 15px;\"></span>\n" +
                    "                                    </div>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                            <p data-v-7b4fded4=\"\" class=\"condition f-cl\">" + age + "岁 | "+ allUser[i].nativePlace +" | "+ allUser[i].height +"cm | "+ allUser[i].jobClass +"</p>\n" +
                    "                            <p data-v-7b4fded4=\"\" class=\"heart-word\">" + allUser[i].conduction + "</p> <span data-v-7b4fded4=\"\" class=\"f-cl\"><div\n" +
                    "                                data-v-7b4fded4=\"\" class=\"default-sayhi\">打招呼</div></span></div>\n" +
                    "                    </div>";

                $("#show").append(str);

            }
        },
        error: function(){
            alert("Error");
        }
    })

    //个人信息显示
    $.ajax({
        url: "/getUserById",
        type: "post",
        dataType: "json",
        success: function(userById){

            //头像显示
            $("#index_pic img").attr("src",userById[0].idPic);
            $("#nick_name").html(userById[0].userName);
            $("#my_id").html("ID：" + userById[0].userId);
        },
        error: function(){

        }
    })
}

/*-------------------------------------择偶条件-------------------------------------*/
function condition(){

    //点击择偶条件，显现
    $("#condition").click(function(){
        $("#choice").show();
        $("#condition").parent().hide();
    })

    //选择信息的显示与隐藏
    $(".b-field-input").hover(function(){
        $(this).children().next().show();
    },function(){
        $(this).children().next().hide();
    })

    $(".SELECT").hover(function(){
        $(this).children().next().show();
    },function(){
        $(this).children().next().hide();
    })

    //选择后显示在信息中
    $(".option").click(function(){
        var option_value = $(this).html();
        $(this).parent().parent().prev().html(option_value);
    })

    //点击保存与取消
    $(".submit").click(function(){
        //将所填值存入
        $local = $("#op_place").html();
        $age = $("#op_age").html();
        $height = $("#op_height").html();
        $income = $("#op_income").html();

        $("#choice").hide();
        $("#condition").parent().show();
        //保存时将所填的内容显示出来
        $("#show_condition").html("地区:" + $local+ "&emsp;|&emsp;年龄:" +$age+ "&emsp;|&emsp;身高:" +$height+ "&emsp;|&emsp;工资:" +$income)
        //点击保存后显现条件查询后的结果
        user = {nativePlace:$local, income:$income, height:$height, age:$age}
        //empty后并重新设置首页
        $("#show").empty();
        pageIndex = 1;
        show();
    })

    $(".submit").next().click(function(){
        $("#choice").hide();
        $("#condition").parent().show();
    })
}

/*-------------------------------------滚动分页-------------------------------------*/
function rollPage(){

    $(window).scroll(function () {
        //$(window).scrollTop()这个方法是当前滚动条滚动的距离
        //$(window).height()获取当前窗体的高度
        //$(document).height()获取当前文档的高度
        var bot = 500; //bot是底部距离的高度
        if ((bot + $(window).scrollTop()) >= ($(document).height() - $(window).height())) {
            //当底部基本距离+滚动的高度〉=文档的高度-窗体的高度时；
            //我们需要去异步加载数据了
            if(pageIndex == pages){
                return false;
            }
            pageIndex++;
            show();
        }
    });
}

/**********---------------------------打招呼-----------------------------------------------********/
