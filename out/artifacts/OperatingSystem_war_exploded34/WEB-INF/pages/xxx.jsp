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



        .toggle {
            position: relative;
            display: block;
            margin: 0 auto;
            width: 150px;
            height: 60px;
            color: white;
            outline: 0;
            text-decoration: none;
            border-radius: 100px;
            border: 2px solid #546E7A;
            background-color: #263238;
            transition: all 500ms;
        }
        .toggle:active {
            background-color: #1c2429;
        }
        .toggle:hover:not(.toggle--moving):after {
            background-color: #455A64;
        }
        .toggle:after {
            display: block;
            position: absolute;
            top: 4px;
            bottom: 4px;
            left: 4px;
            width: calc(50% - 4px);
            line-height: 45px;
            text-align: center;
            text-transform: uppercase;
            font-size: 20px;
            color: white;
            background-color: #37474F;
            border: 2px solid;
            transition: all 500ms;
        }

        .toggle--on:after {
            content: 'On';
            border-radius: 50px 5px 5px 50px;
            color: #66BB6A;
        }

        .toggle--off:after {
            content: 'Off';
            border-radius: 5px 50px 50px 5px;
            transform: translate(100%, 0);
            color: #f44336;
        }

        .toggle--moving {
            background-color: #1c2429;
        }
        .toggle--moving:after {
            color: transparent;
            border-color: #435862;
            background-color: #222c31;
            transition: color 0s, transform 500ms, border-radius 500ms,           background-color 500ms;
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
<div style="margin: 0 auto; width: 400px; text-align: center;">
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
            <div class="btn-border btn-round btn-blue btn9">
                <a href="/test2" class="btn btn-blue">Bliking Led1</a>
            </div>
            <div class="btn-border btn-round btn-red btn6">
                <a href="/test2" class="btn btn-red">Bliking Led2</a>
            </div>
            <div class="btn-border btn-round btn-blue btn9">
                <a href="/test2" class="btn btn-black">Bliking Led3</a>
            </div>
            <div class="btn-border btn-round btn-black btn10">
                <a href="/test2" class="btn btn-green">Bliking Led4</a>
            </div>
        </div>
        <h2>statue: <%=request.getSession().getAttribute("name")%></h2>
    </form>



    <script src='js/jquery.js'></script>
    <script src="js/main.js"></script>
    <script src="js/index.js"></script>
    <div style="text-align:center;clear:both;">
        <script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
        <script src="/follow.js" type="text/javascript"></script>
    </div>

</body>

</html>