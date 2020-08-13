<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link rel="stylesheet" href="style/common.css">
    <link rel="stylesheet" href="style/regStyle.css">
    <!--设置标签图标-->
    <link href="favicon.ico" rel="shortcut icon">
    <link rel="stylesheet" href="style/footerStyle.css">
</head>
<body>

<!--注册头部-->
<div id="reg_header">
    <div class="reg_h_center">

            <img src="images/logo.png" alt="">
            <h3>欢迎注册</h3>

            <div class="reg_h_right">
                <span>已有账户</span><a href="login.jsp">请登录</a>
            </div>
    </div>
</div>

<div id="reg_main">
        <div class="main_left">
            <form action="/_war_exploded/ten" id="reg-from" method="post">
                <div>
                    <label>用户名</label>
                    <input type="text" placeholder="请输入用户名" id="name" name="username">
                </div>
                <div>
                    <label>密码</label>
                    <input type="text" placeholder="请输入密码" id="pwd" name="password">
                </div>
                <div>
                    <label>确认密码</label>
                    <input type="text" placeholder="请输入密码" id="pwd2">
                </div>
                <div>
                    <label>电话</label>
                    <input type="text" placeholder="请输入电话" id="phone" name="tephone">
                </div>
                <div class="check_box">
                    <label>验证码</label>
                    <input type="text" name="code">
                    <img src="/_war_exploded/CreateCode" onclick="change(this)">
                </div>
                <div class="submit_button">
                    <input type="button" value="立即注册" onclick="checkDate()">
                </div>
            </form>
        </div>
        <div class="main_right">
             <img src="images/reg_right.png" alt="">
        </div>
</div>
<!--尾部-->
<div id="footer">
    <!--关于我们-->
    <div class="link">
        <a href="#">关于我们</a>
        |
        <a href="#">联系我们</a>
        |
        <a href="#">人才招聘</a>
        |
        <a href="#">商家入驻</a>
        |
        <a href="#">广告服务</a>
        |
        <a href="#">手机码蚁</a>
        |
        <a href="#">友情链接</a>
        |
        <a href="#">销售联盟</a>
        |
        <a href="#">码蚁社区</a>
        |
        <a href="#">码蚁公益</a>
    </div>
    <!--版权-->
    <div class="copyright">
        Copyright&nbsp;&copy;&nbsp;2017-2018&nbsp;&nbsp;码蚁My.com&nbsp;版权所有
    </div>
</div>
<script type="text/javascript">
    function change(object) {
        object.src="/_war_exploded/CreateCode?time="+new Date().getTime();
    }

    function checkDate() {
        //1.获取用户名，密码，手机
        var username= document.getElementById("name");
        var pwd=document.getElementById("pwd");
        var pwd2=document.getElementById("pwd2");
        var phone=document.getElementById("phone");

        if (username.value==""){
            alert("请输入用户名");
            return;
        }
        if (pwd.value==""){
            alert("请输入用密码");
            return;
        }
        if (pwd2.value==""){
            alert("请输入验证密码");
            return;
        }
        if (phone.value==""){
            alert("请输入手机");
            return;
        }
        if (pwd.value==pwd2.value){
          var form=document.getElementById("reg-from");
            //执行表单
            form.submit();
        }else {
            alert("两次密码错误");
        }
    }
</script>





</body>
</html>


