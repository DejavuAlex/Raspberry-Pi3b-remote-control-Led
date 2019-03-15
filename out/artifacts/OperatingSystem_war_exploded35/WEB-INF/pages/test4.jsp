<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
    <title>Remote RPI-LED Control</title>

    <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">

    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="icon" type="image/png" href="static/assets/i/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="static/assets/i/app-icon72x72@2x.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="static/assets/i/app-icon72x72@2x.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="static/assets/i/app-icon72x72@2x.png">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <link rel="stylesheet" href="static/assets/css/amazeui.min.css">
    <link rel="stylesheet" href="static/assets/css/app.css">

    <script src="static/assets/js/jquery.min.js"></script>
    <!--<![endif]-->
    <!--[if lte IE 8 ]>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="static/assets/js/amazeui.ie8polyfill.min.js"></script>
    <![endif]-->
    <script src="static/assets/js/amazeui.min.js"></script>
</head>
<div style="margin: 0 auto; width: 300px; text-align: center;">
    <h1>Remote RPI-LED Control</h1>
</div>
<div style="margin: 0 auto; width: 200px; text-align: center;">
    <form class="am-form" method="post" action="/test">
        <h3 style="text-align: center;"> Led Control Panel</h3>
        <div>
            <label for="doc-select-1">Choose Led</label>
            <select id="doc-select-1" name="doc-select-1">
                <option value="LED1">LED1</option>
                <option value="LED2">LED2</option>
                <option value="LED3">LED3</option>
                <option value="LED4">LED4</option>
                <option value="LED5">LED5</option>
                <option value="LED6">LED6</option>
                <option value="LED7">LED7</option>
                <option value="LED8">LED8</option>
            </select>
            <span class="am-form-caret"></span>
            <div class="am-form-group">
                <label class="am-radio-inline">
                    <input type="radio"  name= "identity" value="Red"> Red
                </label>
                <label class="am-radio-inline">
                    <input type="radio" name= "identity" value="Green"> Green
                </label>
                <label class="am-radio-inline">
                    <input type="radio" name= "identity" value="Blue"> Blue
                </label>
            </div>
        </div>
        <p><button id="doc-single-toggle" type="submit" class="am-btn am-btn-primary btn-loading-example">Led on</button></p>
        <script>
            $('.btn-loading-example').click(function () {
                var $btn = $(this)
                $btn.button('loading');
                setTimeout(function(){
                    $btn.button('reset');
                }, 500);
            });
        </script>
        <p><a href="/test4" class="am-btn am-btn-primary btn-loading-example" type="" ="button">Led Off</a></p>
        <script>
            $('.btn-loading-example').click(function () {
                var $btn = $(this)
                $btn.button('loading');
                setTimeout(function(){
                    $btn.button('reset');
                }, 500);
            });
        </script>
        <p>statue: <%=request.getSession().getAttribute("name2")%></p>
    </form>
</div>

<div style="margin: 0 auto; width: 200px; text-align: center;">
    <a href="/brighter" id="doc-single-toggle" class="am-btn am-btn-secondary btn-loading-example" type="button">Brighter</a>
    <script>
        $('.btn-loading-example').click(function () {
            var $btn = $(this)
            $btn.button('loading');
            setTimeout(function(){
                $btn.button('reset');
            }, 500);
        });
    </script>
</div>
<p></p>
<div style="margin: 0 auto; width: 200px; text-align: center;">
    <a href="/dimmer" id="doc-single-toggle" class="am-btn am-btn-secondary btn-loading-example" type="button">Dimmer</a>
    <script>
        $('.btn-loading-example').click(function () {
            var $btn = $(this)
            $btn.button('loading');
            setTimeout(function(){
                $btn.button('reset');
            }, 500);
        });
    </script>
</div>
<p></p>
<div style="margin: 0 auto; width: 200px; text-align: center;">
    <a href="/test2" id="doc-single-toggle" class="am-btn am-btn-secondary btn-loading-example" type="button">Blinking Led</a>
    <script>
        $('.btn-loading-example').click(function () {
            var $btn = $(this)
            $btn.button('loading');
            setTimeout(function(){
                $btn.button('reset');
            }, 10000);
        });
    </script>
</div>
<p></p>
<div style="margin: 0 auto; width: 200px; text-align: center;">
    <a href="/test3" id="doc-single-toggle" class="am-btn am-btn-secondary btn-loading-example" type="button">Breathing Led</a>
    <script>
        $('.btn-loading-example').click(function () {
            var $btn = $(this)
            $btn.button('loading');
            setTimeout(function(){
                $btn.button('reset');
            }, 10000);
        });
    </script>
</div>
<p></p>
<div style="margin: 0 auto; width: 200px; text-align: center;">
    <a href="/test5" id="doc-single-toggle" class="am-btn am-btn-secondary btn-loading-example" type="button">Breathing Led</a>
    <script>
        $('.btn-loading-example').click(function () {
            var $btn = $(this)
            $btn.button('loading');
            setTimeout(function(){
                $btn.button('reset');
            }, 10000);
        });
    </script>
</div>
<!--在这里编写你的代码-->

<!--[if (gte IE 9)|!(IE)]><!-->


</body>
</html>


