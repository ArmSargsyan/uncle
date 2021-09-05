<%@ page import="itSpace.uncle.model.User" %><%--
  Created by IntelliJ IDEA.
  User: And
  Date: 14.08.2021
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Title</title>
</head>
<body>
<link href="/css/login2.css" rel="stylesheet">
<div class="cotn_principal">
    <div class="cont_centrar">

        <div class="cont_login">
            <div class="cont_info_log_sign_up">
                <div class="col_md_login">
                    <div class="cont_ba_opcitiy">

                        <h2>LOGIN</h2>
                        <p></p>
                        <button class="btn_login" onclick="cambiar_login()">LOGIN</button>
                    </div>
                </div>
                <div class="col_md_sign_up">
                    <div class="cont_ba_opcitiy">
                        <h2>SIGN UP</h2>


                        <p></p>

                        <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
                    </div>
                </div>
            </div>


            <div class="cont_back_info">
                <div class="cont_img_back_grey">
                    <img src="/css/img/carousel-2.jpg" />
                </div>

            </div>
            <div class="cont_forms" >
                <div class="cont_img_back_">
                    <img src="https://www.gtagangwars.de/suite/images/styleLogo-6bd77433ddf78bd8477ea7306e804f677bc925d0.png" alt="" />
                </div>

                <div class="cont_form_login">
                    <a href="#" onclick="ocultar_login_sign_up()" ><i class="material-icons">UNCLE</i></a>
                    <h2>LOGIN</h2>
                    <form action="/login" method="post">
                    <input type="text" name="email" placeholder="Email" />
                    <input type="password" name="password" placeholder="Password" />
                        <h4><input type="submit" value="Login"></h4>
                    </form>
                </div>

                <div class="cont_form_sign_up">
                    <a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">LEGAL SERVICES</i></a>
                    <h2>SIGN UP</h2>
                    <form action="/register" method="post">
                        <input type="text" name="name" placeholder="name"/> <br>
                        <input type="text" name="surname" placeholder="surname"/> <br>
                        <input type="text" name="email" placeholder="email"/> <br>
                        <input type="password" name="password" placeholder="password"> <br>
                        <input type="text" name="numberPhone" placeholder="Number Phone"><br>
                        <h4><input type="submit" value="Register"></h4>
                    </form>


                </div>

            </div>

        </div>
    </div>
</div>
</div>
<%--    /*<%--%>
<%--    User user = (User) session.getAttribute("user");--%>
<%--    if (user != null) {--%>
<%--        response.sendRedirect("/home");--%>
<%--    }--%>

<%--    String msg = (String)session.getAttribute("msg");%>--%>
<%--<% if (msg != null && !"".equals(msg)) {%>--%>
<%--<span><%=msg%></span>--%>
<%--<%  session.removeAttribute("msg");}%>*/--%>
<script>
    /* ------------------------------------ Click on login and Sign Up to  changue and view the effect
---------------------------------------
*/


    function cambiar_login() {
        document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
        document.querySelector('.cont_form_login').style.display = "block";
        document.querySelector('.cont_form_sign_up').style.opacity = "0";

        setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);

        setTimeout(function(){
            document.querySelector('.cont_form_sign_up').style.display = "none";
        },200);
    }

    function cambiar_sign_up(at) {
        document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
        document.querySelector('.cont_form_sign_up').style.display = "block";
        document.querySelector('.cont_form_login').style.opacity = "0";

        setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
        },100);

        setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
        },400);


    }



    function ocultar_login_sign_up() {

        document.querySelector('.cont_forms').className = "cont_forms";
        document.querySelector('.cont_form_sign_up').style.opacity = "0";
        document.querySelector('.cont_form_login').style.opacity = "0";

        setTimeout(function(){
            document.querySelector('.cont_form_sign_up').style.display = "none";
            document.querySelector('.cont_form_login').style.display = "none";
        },500);

    }
</script>

</body>
</html>
