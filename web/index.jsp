<%@ page contentType = "text/html;charset=utf-8" language="java"  %>
<%@page session="true" %>

<!DOCTYPE html>
<html lang="kr">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <meta name="description" content="FirstView">
  <meta name="author" content="scssm">

  <title>Shazam</title>

  <!-- Bootstrap core CSS -->
  <link href="bootstrap-3.3.6/dist/css/bootstrap.css" rel="stylesheet">

  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <link href="bootstrap-3.3.6/docs/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="bootstrap-3.3.6/docs/examples/signin/signin.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

  <style>
    html{
      height: 100%;
    }
    body {
      height: 100%;
      background-image:url("images/tizen.jpg");

      background-repeat:no-repeat;

      -webkit-background-size: cover;
      -moz-background-size: cover;
      -o-background-size: cover;
      background-size:cover;

      background-position: center;
      background-attachment: fixed;
    }
    .background_image{
      background-image:url("images/back.png");

      background-repeat:no-repeat;

      -webkit-background-size: cover;
      -moz-background-size: cover;
      -o-background-size: cover;
      background-size:cover;

      background-position: center;

    }

    h1,h2 {
      color: #f7f7f7;
      text-align: center;
    }
    </style>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script src="http://cdn.jsdelivr.net/jquery.validation/1.14.0/jquery.validate.min.js"></script>
  <script src="../bootstrap-3.3.6/dist/js/bootstrap.min.js"></script>
  <script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/sha256.js"></script>

</head>

<body style=" min-height : 100%">


  <div class="container-fluid" style="background-color: transparent;" >

      <div class="row">
        <div class="row" style="height: 20%;" role="banner">
          <h1>IMHM</h1>
        </div>

        <div class="col-lg-4 col-lg-offset-4 col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-10 col-xs-offset-1 background_image">

          <div class="row" >
            <form class ="form-signin cmxform" action="/mainview.jsp" method="post" id="loginform">
              <h2 class="form-signin-heading">Please sign in</h2>
              <label for="inputEmail" class="sr-only">Email address</label>
              <input type="email" id="inputEmail" name="id" class="form-control" placeholder="Email address" autofocus required aria-required="true" >

              <label for="inputPassword" class="sr-only">Password</label>
              <input type="password" name="pw" id="inputPassword" class="form-control" placeholder="Password" maxlength="20" required aria-required="true">

              <button type="submit" class="btn btn-lg btn-primary btn-block"  id="signin_btn" >Sign in</button>

              <button  type="button" class="btn btn-lg btn-success btn-block" id="register_btn"
                       data-toggle="modal"
                       data-target="#myModal">
                Register
              </button>
            </form>
          </div>
        </div>
      </div>


  </div> <!-- /container -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form class="cmxform" method="post" id="reg_form">

      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel"> Register </h4>
      </div>
      <div class="modal-body">
        <div id="result_alert"  class="alert"style="display: none;"></div>
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="login-group">
                <div class="form-group">
                  <label for="reg_email" class="sr-only">Email</label>
                  <input type="email" class="form-control" id="reg_email" name="id" placeholder="email" required>
                </div>

                <div class="form-group">
                  <label for="reg_password" class="sr-only">Password</label>
                  <input type="password" class="form-control" id="reg_password" name="pw" placeholder="password" minlength="4" maxlength="128" required >
                </div>

                <div class="form-group">
                  <label for="reg_password_confirm" class="sr-only">Password Confirm</label>
                  <input type="password" class="form-control" id="reg_password_confirm" name="confirm_pw" placeholder="confirm password" minlength="4"  maxlength="128"  required>
                </div>

                <div class="form-group">
                  <label for="nick-name" class="sr-only">nickname</label>
                  <input type="text" class="form-control" id="nick-name" name="nick" placeholder="nickname" maxlength="10" required>
                </div>


           </div>
          </div>

        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick='resetModal()'>close</button>
        <button type="submit" class="btn btn-primary "  name="reg_email_button" id="reg_button"  ><span id="_test">Resister</span></button>

      </div>
      </form>

    </div> <!-- 모달 콘텐츠 -->
  </div> <!-- 모달 다이얼로그 -->
</div> <!-- 모달 전체 윈도우 -->

  <script>
   $('#myModal').on('hidden.bs.modal',function(e){
     $('#reg_form').each(function(){
       this.reset();
     });
     $('#result_alert').removeClass().addClass('alert').css('display','none');
     $("#_test").text("Register");

   });
  </script>
<script>



  function login(){
    var encpw= CryptoJS.SHA256($("#inputPassword").val());

    var res=$.ajax({
      url:'/login',
      data:{id: $("#inputEmail").val(), pw:encpw.toString(CryptoJS.enc.Hex)},
      type:'post',
      async:false,
      success: function(data){},
      complete: function(){},
      error: function(a,v,c){}
    }).responseText;
    res=JSON.parse(res);

    if(res.login =='ok') {
      return true;
    }
    else {
      alert(res.login);

      return false;
    }
  }

  $("#loginform").validate(
          {submitHandler : login}
  );

  $("#reg_form").validate({
    submitHandler: function () {
      var x=CryptoJS.SHA256($("#reg_password").val());

      var res=$.ajax({
        url:'/register',
        data:{id: $("#reg_email").val(),pw:x.toString(CryptoJS.enc.Hex),nick:$("#nick-name").val()},
        type:'post',
        async:false,
        beforeSend: function(){$("#_test").text("Registering");}
      }).responseText;
      res=JSON.parse(res);
     if(res.status=='accepted'){
       $("#result_alert").addClass('alert-success').text("등록에 성공하셨습니다.").css('display','inherit');

       $("#_test").text("Registered");
       $("#reg_button").addClass("btn-success");
       $("#reg_button").attr("disabled",true);
       }
      else{
       if(res.status=='IdExists')
        $("#result_alert").addClass('alert-danger').text("이미 존재하는 아이디입니다.").css('display','inherit');
       if(res.status=='error')
        $("#result_alert").addClass('alert-danger').text("DB ERROR").css('display','inherit');

       $("#_test").text("try again");


     }
        return false;
    },

    rules: {
      id: {
        required: true,
        email: true,
      },
      pw: {required:true},
      confirm_pw: {
        required: true,
        equalTo: '#reg_password'
      },
      nick: {required:true}
    },

    messages:{
      id: {
        required: "반드시 입력해주세요",
        email: '이메일 형식에 맞춰주세요',
      },
      pw: {
        required:'반드시 입력해주세요',
        minlength:'4자 이상 입력해주세요'
      },
      confirm_pw: {
        required: '반드시 입력해주세요',
        equalTo: '비밀번호가 다릅니다',
        minlength:'4자 이상 입력해주세요'
      },
      nick: {required:'별명을 설정해주세요'}

    }
  });



</script>
</body>
</html>
