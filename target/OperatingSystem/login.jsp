<html>
<head><title>Remote RPI-LED Control</title></head>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.4.0/jquery.js"></script>
<script type="text/javascript">
    $(function(){
        $("#led on").click(function() {
        $.ajax({
            url:'test',
            type:'post',
            dataType:'json',
            success:function(data){
                    //方法中传入的参数data为后台获取的数据
                    for (i in data.data) //data.data指的是数组，数组里是8个对象，i为数组的索引
                    {
                        var tr;
                        tr = '<td>' + data.data[i].name + '</td>' + '<td>' + data.data[i].startTime + '</td>' + '<td>' + data.data[i].is_true + '</td>' + '<td>' + data.data[i].device + '</td>'
                        $("#tabletest").append('<tr>' + tr + '</tr>')
                    }
                }
            })
        })
    })

</script>
<script>
    function copyText()
    {
        document.getElementById("field2").value=document.getElementById("field1").value;
    }
</script>
<h2>Remote RPI-LED Control</h2>
Field1: <input type="text" id="field1" value="Hello World!"><br>
Field2: <input type="text" id="field2"><br><br>

<button onclick="copyText()">Copy</button>
<p>Copy text1 to text2</p>

<a href="/test">
    <button>led on</button>
</a>

<form action="/test2 " method=post>
    <input type=submit value="led off"/>
</form>

</body>
</html>


