<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>CSS3创意开关切换按钮DEMO演示</title>

    <!--核心-->
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="static/assets/css/amazeui.min.css">
    <link rel="stylesheet" href="static/assets/css/app.css">
    <style>
        /*! normalize.css v3.0.2 | MIT License | git.io/normalize */html{font-family:sans-serif;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}body{margin:0}article,aside,details,figcaption,figure,footer,header,hgroup,main,menu,nav,section,summary{display:block}audio,canvas,progress,video{display:inline-block;vertical-align:baseline}audio:not([controls]){display:none;height:0}[hidden],template{display:none}a{background-color:transparent}a:active,a:hover{outline:0}abbr[title]{border-bottom:1px dotted}b,strong{font-weight:bold}dfn{font-style:italic}h1{font-size:2em;margin:0.67em 0}mark{background:#ff0;color:#000}small{font-size:80%}sub,sup{font-size:75%;line-height:0;position:relative;vertical-align:baseline}sup{top:-0.5em}sub{bottom:-0.25em}img{border:0}svg:not(:root){overflow:hidden}figure{margin:1em 40px}hr{-moz-box-sizing:content-box;-webkit-box-sizing:content-box;box-sizing:content-box;height:0}pre{overflow:auto}code,kbd,pre,samp{font-family:monospace, monospace;font-size:1em}button,input,optgroup,select,textarea{color:inherit;font:inherit;margin:0}button{overflow:visible}button,select{text-transform:none}button,html input[type="button"],input[type="reset"],input[type="submit"]{-webkit-appearance:button;cursor:pointer}button[disabled],html input[disabled]{cursor:default}button::-moz-focus-inner,input::-moz-focus-inner{border:0;padding:0}input{line-height:normal}input[type="checkbox"],input[type="radio"]{-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box;padding:0}input[type="number"]::-webkit-inner-spin-button,input[type="number"]::-webkit-outer-spin-button{height:auto}input[type="search"]{-webkit-appearance:textfield;-moz-box-sizing:content-box;-webkit-box-sizing:content-box;box-sizing:content-box}input[type="search"]::-webkit-search-cancel-button,input[type="search"]::-webkit-search-decoration{-webkit-appearance:none}fieldset{border:1px solid #c0c0c0;margin:0 2px;padding:0.35em 0.625em 0.75em}legend{border:0;padding:0}textarea{overflow:auto}optgroup{font-weight:bold}table{border-collapse:collapse;border-spacing:0}td,th{padding:0}

    </style>

    <style>
        *, *:before,
        *:after {
            box-sizing: border-box;
        }
        .button1 {
            display: inline-block;
            color: #FFFFFF;
            text-align: center;
            font-size: 14px;
            height: 0px;
            width: 0px;
            margin: 5px;
            transition: all 0.5s;
            cursor: pointer;
            border-top:40px solid transparent;
            border-bottom:40px solid transparent;
            border-right:40px solid lightblue;
        }
        }

        .button1 span {
            cursor: pointer;
            display: inline-block;
            position: relative;
            transition: 0.5s;
        }

        .button1 span:after {
            content: '+';
            font-size: 30px;
            opacity: 0;
            top: 0;
            transition: 0.5s;
        }

        .button1:hover span {
            padding-right: 20px;
        }

        .button1:hover span:after {
            opacity: 1;
            right: 0;
        }

        .button2 {
            display: inline-block;
            color: #FFFFFF;
            text-align: center;
            font-size: 14px;
            height: 0px;
            width: 0px;
            transition: all 0.5s;
            cursor: pointer;
            margin: 5px;
            border-top:40px solid transparent;
            border-bottom:40px solid transparent;
            border-left:40px solid lightblue;
        }

        .button2 span {
            cursor: pointer;
            display: inline-block;
            position: relative;
            transition: 0.5s;
        }

        .button2 span:after {
            content: '-';
            font-size: 30px;
            opacity: 0;
            top: 0;
            transition: 0.5s;
        }

        .button2:hover span {
            padding-right: 20px;
        }

        .button2:hover span:after {
            opacity: 1;
            right: 0;
        }

        h1 {
            font-size: 44px;
            margin-top: 0;
            margin-bottom: 20px;
        }
        h2 {
            font-size: 24px;
            margin-top: 0;
            margin-bottom: 20px;
        }


    </style>

    <script src="js/prefixfree.min.js"></script>

</head>

<body>
<div style="margin: 0 auto; width: 500px; text-align: center;">
    <h1>LED Control</h1>
    <form class="am-form" method="post" action="/test">
        <div style="margin: 0 auto; width: 200px; text-align: center;">
            <h2 for="doc-select-1">Choose Led</h2>
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
        <div class="effect-group-container toolbar-2">
            <a href="/brighter" class="button1"><span> </span></a>
            <div class="btn-border" style="margin: 0 auto; width: 125px; text-align: center;">
                <button type="submit" class="btn btn-blue" style="width: 120px">Led on</button>
                <p></p>
    </form>
    <a href="/test4" class="btn btn-red">Led off</a>
</div>
<a href="/dimmer" class="button2"><span> </span></a>
<div style="margin: 0 auto; width: 200px; text-align: center;">
    <p></p>
    <div class="btn-border btn-round btn-white btn9" style="float: left;">
        <a href="/test3" class="btn btn-white">1</a>
    </div>
    <p></p>
    <div class="btn-border btn-round btn-white btn10" style="float: left;">
        <a href="/test2" class="btn btn-white">2</a>
    </div>
    <p></p>
    <div class="btn-border btn-round btn-white btn9" style="float: left;">
        <a href="/test5" class="btn btn-white">3</a>
    </div>
</div>



<script src='js/jquery.js'></script>
<script src="js/main.js"></script>
<script src="js/index.js"></script>
<div style="text-align:center;clear:both;">
    <script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
    <script src="/follow.js" type="text/javascript"></script>
</div>

</body>

</html>