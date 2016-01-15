
<%--
  Created by IntelliJ IDEA.
  User: ParkBeomChan-PC-W1
  Date: 2016-01-05
  Time: 오전 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%


    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    response.setHeader("Pragma","no-cache");

    String idparam=request.getParameter("id");

    String id=(String)request.getSession().getAttribute("id");
    String nick=(String)request.getSession().getAttribute("nick");
    if((id)!=null){

%>
<!DOCTYPE html>
    <html >
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
            <meta name="description" content="FirstView">
            <meta name="author" content="scssm">

            <title><%=nick%>'s shazam</title>

            <!-- Bootstrap core CSS -->
            <link href="bootstrap-3.3.6/dist/css/bootstrap.css" rel="stylesheet">

            <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
            <link href="bootstrap-3.3.6/docs/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

            <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
            <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
            <![endif]-->

            <style>
                html{
                    height:100%;
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
                #contents{
                    height: 100%;
                }
                .container-map{
                    width:100%
                }
                #map{
                    height:100%;
                    width:100%
                }

                #navbar_above{
                    background-color: transparent;
                }
                .table>tbody>tr>th , .table>tbody>tr>td{
                   border-top: none 1px;
                }
            </style>
        </head>
        <body>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
            <script src="../bootstrap-3.3.6/dist/js/bootstrap.min.js"></script>
            <nav class="navbar navbar-default" id="navbar_above">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">IMHM</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#map">MAP</a></li>
                            <li><a href="#historyContainer">History</a></li>

                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="active"><a href="index.jsp" onclick="logout">Log out <span class="sr-only">(current)</span></a></li>

                        </ul>
                    </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
            </nav>

            <div class="container-fluid" id="contents">


                <div class="row" style="margin-top:1%; margin-bottom: 1%;margin-left: 0px; margin-right: 0px; ">
                    <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12" style=" padding-left: 0px; padding-right: 0px;">
                        <div class="container-map" style="padding-bottom: 20px">

                            <div id="map"></div>
                        </div>
                        <style>
                            img .align_center{
                                text-align: center;
                            }
                        </style>
                        <div id="historyContainer">
                             <button class="btn btn-default btn-block" id="more_button" onclick="draw()"><span>more</span></button>

                        </div>
                        <!--history end -->
                    </div>



                </div>
            </div>
            <%--지도 width height 사이즈 리사이징--%>
            <script>
                $(function(){

                        var $content = $('.container-map');
                        var $window = $(window).on('resize', function(){
                            var height = $content.width() < 1080/2? $content.width() :1080/2;
                            $content.height(height);
                    }).trigger('resize'); //on page load

                });

            </script>

            <script  src="http://maps.google.com/maps/api/js" ></script>

            <script>
                var limit= 0,offset= 5;

                var    map = new google.maps.Map($("#map")[0], {
                    center: {lat: 37.574515, lng: 126.976930},
                    draggable: true,
                    zoom: 12
                });

                var bounds = new google.maps.LatLngBounds();
                var marker_icon = 'images/1452705802_map-marker.png';
                var geocoder = new google.maps.Geocoder;
                var infowindowarr=[];

                function geocodeLatLng(geocoder, lat, lng, obj,titleinfo, next){
                    var latlng = {lat: lat, lng: lng};
                    geocoder.geocode({'location': latlng}, function (results,status) {
                        if (status === google.maps.GeocoderStatus.OK) {
                            if (results[1]) {
                                var marker = new google.maps.Marker({position: latlng, map: map ,icon:marker_icon});

                                // 윈도우는 하나만 보게 하자
                                marker.info = new google.maps.InfoWindow({
                                    content: '<div><h5>장소: '+results[1].formatted_address+'</h5><h5>제목: '+$(titleinfo).text()+'</h5></div>'
                                });

                                infowindowarr.push(marker.info);
                                bounds.extend(marker.position);


                                google.maps.event.addListener(marker, 'click', function() {
                                    for(var idx=0;idx<infowindowarr.length;idx++){
                                        infowindowarr[idx].close();
                                    }

                                    marker.info.open(map, marker);

                                });
                                $(obj).text (results[1].formatted_address);
                            }

                        }
                        else{
                                nextAddress--;
                                delay++;

                        }

                        console.log("next 진입");
                        next();
                    }
                    );
                }

                 function  addmarkers(lat, lng) {
//                    alert(lat+' '+lng);
                    var marker = new google.maps.Marker(
                            {
                                position: {lat: lat , lng: lng},
                                map: map,
                                icon: marker_icon
                            }
                    );

                     marker.info = new google.maps.InfoWindow({
                         content: 'test'
                     });

                     google.maps.event.addListener(marker, 'click', function() {
                         marker.info.open(map, marker);});
                };
                var nextAddress = 0;
                var delay=100;
                var latitudearr =[];
                var longtitudearr =[];
                var size=0;
                function draw(){

                    $.ajax({

                                url:'/loadhistory',
                                data:{limit:limit,offset:offset},
                                type:'post',
                                success:function (data){
                                    latitudearr =[];
                                    longtitudearr =[];

                                    if(parseInt(data.arraysize==0)) $('#more_button').hide();
                                    data=JSON.parse(data);

                                    for( var iter=0; iter<data.arraysize ;iter++){
                                        latitudearr[iter]=data.result[iter].Latitude;
                                        longtitudearr[iter]=data.result[iter].Longtitude;

                                        var div1=document.getElementById('historyContainer');//get the div element
                                        var div2=document.createElement("div");//create a new div
                                        div2.innerHTML="<div class='thumbnail'>"+
                                        "<div class='row' >"+
                                                "<div class='col-md-4'>"+
                                                "<img class='img-responsive thumbnail' src='/loadimage?titlename="+data.result[iter].musicIdx+"' alt='TEST' style='margin: 0 auto;'>"+
                                                "</div>"+
                                                "<div class='col-md-8'>"+
                                                "<div class='table-responsive'>"+
                                                "<table class='table' style='border: none;'>"+
                                                "<tbody><tr>"+
                                                "<th class='row '>Title</th>"+
                                                "<td id='title"+(limit+iter)+"'>"+data.result[iter].title+"</td>"+
                                                "</tr>"+
                                                "<tr>"+
                                                "<th class='row'>Artist</th>"+
                                                "<td>"+data.result[iter].artist+"</td>"+
                                                "</tr>"+
                                                "<tr>"+
                                                "<th class='row '>Album</th>"+
                                                "<td>"+data.result[iter].albumname+"</td>"+
                                                "</tr>"+
                                                "<tr>"+
                                                "<th class='row'>Date</th>"+
                                                "<td>"+data.result[iter].search_date+"</td>"+
                                                "</tr>"+
                                                "<tr>"+
                                                "<th class='row'>Location</th>"+
                                                "<td id='location"+(limit+iter)+"'>"+data.result[iter].Longtitude+" "+data.result[iter].Latitude+"</td>"+
                                                "</tr>"+
                                                "</tbody>"+
                                                "</table>"+
                                                "</div>"+
                                                "</div>"+
                                                "</div>"+
                                                "<hr style='border-color: #00cdcd'>"+
                                                "<p  align='right'> <a href='http://www.melon.com/search/total/index.htm?q="+data.result[iter].title+" "+data.result[iter].artist+"&section=&ipath=srch_form' class='btn btn-success' role='button' target='_blank' style='margin-right: 10px'>외부음원 듣기</a></p>"+
                                        "</div>";
//                                        addmarkers(data.result[iter].Longtitude, data.result[iter].Latitude);
                                        div1.appendChild(div2);
                                    }
                                    $("#historyContainer").children().last().after( $("#more_button"));
                                    size=data.arraysize;
                                    limit+=size;
                                    console.log("size: "+size+",limit: "+limit);
                                    theNext();
                                }
                    }
                    );
                }
                draw();

                function theNext() {
                    if (nextAddress < size) {
                        setTimeout('geocodeLatLng(geocoder,'+longtitudearr[nextAddress]+','+latitudearr[nextAddress]+',$("#location'+(nextAddress+limit-size)+'")'+',$("#title'+(nextAddress+limit-size)+'")'+',theNext)', delay);
                        console.log(nextAddress+" location:#location"+(nextAddress+limit-size));
                        nextAddress++;
                    } else {
                        // We're done. Show map bounds
                        map.fitBounds(bounds);
                        nextAddress=0;
                        delay=100;
                    }
                }
   </script>


            <script>

                // Logout Timer 객체 정의

                var LogOutTimer = function() {
                    var S = {
                        timer : null,
                        limit : 1000 * 60 * 5,
                        fnc   : function() {},
                        start : function() {
                            S.timer = window.setTimeout(S.fnc, S.limit);
                        },
                        reset : function() {
                            window.clearTimeout(S.timer);
                            S.start();
                        }
                    };
                    document.onmousemove = function() { S.reset(); };
                    return S;

                }();



                // 로그아웃 체크시간 설정
                LogOutTimer.limit = <%=session.getMaxInactiveInterval()*1000%>;
                // 로그아웃 함수 설정

                LogOutTimer.fnc = function() {
                    alert("자동 로그아웃 되었습니다.");
                    window.location='./logout';

                }

                function logout(){
                    window.location='./logout';

                }

                // 로그아웃 타이머 실행

                LogOutTimer.start();



            </script>
        </body>
    </html>
<%
    }//end main block
    //지랄말라 전해라
    else{
        %>
            <!DOCTYPE html>
            <html>
                <head></head>
                <body>
                <h1>
                   ID: <%=session.getAttribute("id")%>
                </h1>
                </body>
            </html>
        <%
    }
%>