/*
    @author JJ
    @function
        providing timer to control the render process and get current time
 */
function Timer () {

    this.getSeconds = function() {
        return new Date().getSeconds();
    }

    this.getMinutes = function() {
        return new Date().getMinutes();
    }

    this.getHours = function() {
        return new Date().getHours();
    }

    this.renderTime = function(_id, _format, _renderFlag) {
        if (_id == null || _id.length == 0) return;
        var time = _format(this.getHours())
                    + " : " + _format(this.getMinutes())
                    + " : " + _format(this.getSeconds());
        console.log('detect tag with id: ' + _id + ": " + time);
        if (_renderFlag)
            document.getElementById(_id).innerText = time;
        return time;
    }

    this.proxyHandler = function(_id, _format, _before, _after, _timer, _renderFlag) {
        return function() {
            console.log("proxy handler start");
            if (_before)
                _before();
            var curTime = _timer.renderTime(_id, _format, _renderFlag);
            if (_after)
                _after(curTime);
        }
    }

    this.autoRender = function(_id, _format, _timeInterval, _before, _after, _timer, _renderFlag) {
        setInterval(this.proxyHandler(_id, _format, _before, _after, _timer, _renderFlag), _timeInterval);
    }
}

/*
    @author JJ
    @function
        format set for string and number
 */
var FORMATTER = {
    "zeroFormat": function(_num) {
        return (_num <= 9 ? "0" + _num : _num);
    }
}

/*
    @author JJ
    @function
        generate general form
    @param
        controller: {
            id:
            tag:
            type:
            initHelper:
            style:
            label:
        }
 */
function generateForm(_pid, _controllerList) {
    var ctlTmp = '<#tag class="form-control" id="#id" style="#style" #type></#tag>';
    var labelTmp = "<label>#label</label>";
    //var cmd = "";

    for (var i = 0; i < _controllerList.length; i ++) {
        var curCtl = _controllerList[i];
        var cmd = (labelTmp.replace("#label", curCtl.label) + ctlTmp.replace("#id", curCtl.id)
                                                            .replace("#style", curCtl.style)
                                                            .replace("#tag", curCtl.tag)
                                                            .replace("#type", curCtl.ctype));
        $(_pid).append(cmd);
        if (curCtl.initHelper) {
            curCtl.initHelper();
        }
    }
}

function timeConverter(UNIX_timestamp){
    var a = new Date(UNIX_timestamp);
    var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
    var year = a.getFullYear();
    var month = a.getMonth() + 1;
    var date = a.getDate();
    var hour = a.getHours() - 8;
    var min = a.getMinutes();
    var sec = a.getSeconds();
    var time = year + '/' + month + '/' + date + ' ' + hour + ':' + min + ':' + sec ;
    return time;
}

/*
    @author JJ
    @function
        generate general table
    @event
        query event
        add event
        del event
        update event
        next page event
        prev page event
    @button
        toolbar
            add
            search
        row
            delete
            edit
            click
 */
function TaojjTable(_config) {

    this.config = _config;

    this.init = function () {
        console.log(this.config);
        if (!this.config) return;
        this.draw();
        this.eventBinding();
        this.config.eventHandlers.query("first")
    };

    this.draw = function () {
        var add = this.config.buttons.add ? '<button class="btn btn-sm btn-outline-secondary" id = "add"><span data-feather="plus-square"></span> 新增 </button>' : '';
        var all = this.config.buttons.add ? '<button class="btn btn-sm btn-outline-secondary" id = "all"><span data-feather="list"></span> 全选 </button>' : '';
        var batchUpload = this.config.buttons.batchUpload ? '<button class="btn btn-sm btn-outline-secondary"><span data-feather="upload"></span> 批量上传 </button>' : '';
        var batchDelete = this.config.buttons.batchDelete ? '<button class="btn btn-sm btn-outline-secondary"><span data-feather="trash-2"></span> 批量删除 </button>' : '';
        var batchEdit = this.config.buttons.batchEdit ? '<button class="btn btn-sm btn-outline-secondary"><span data-feather="edit"></span> 批量修改 </button>' : '';
        var output = this.config.buttons.output ? '<button class="btn btn-sm btn-outline-secondary" id="output"><span data-feather="download"></span> 导出excel </button>' : '';
        var prev = this.config.buttons.prev ? '<button class="btn btn-sm btn-outline-secondary" id="prev"> 上一页 </button>' : '';
        var next = this.config.buttons.next ? '<button class="btn btn-sm btn-outline-secondary" id="next"> 下一页 </button>' : '';
        var first = this.config.buttons.first ? '<button class="btn btn-sm btn-outline-secondary" id="first"> 首页 </button>' : '';
        var last = this.config.buttons.last ? '<button class="btn btn-sm btn-outline-secondary" id="last"> 尾页 </button>' : '';
        var search = this.config.buttons.search ? '<input class="form-control form-control-dark id="condition"' +
            'type="text" placeholder="Search" aria-label="Search" style="margin-top: 2%;">' +
            '<button class="btn btn-sm btn-link id="search"><span data-feather="search"></span></button>' : '';

        var toolbarTop = '<div style="float:left"><div class="btn-toolbar mb-2 mb-md-0"> \
                            <div class="btn-group mr-2">'
            + all
            + add
            + batchUpload
            + batchDelete
            + batchEdit
            + output
            + '</div></div></div>'
            + '<div style="float:right"><div class="btn-toolbar mb-2 mb-md-0"> \
                                <div class="btn-group mr-2">'
            + search
            + '</div></div></div>'

        var table = '<div class="table-responsive" style="padding-top: 2%;"> \
                        <table class="table table-striped table-sm"> \
                            <thead>\
                                <tr>\
                                    #th \
                                </tr>\
                            </thead> \
                            <tbody>\
                            </tbody>\
                        </table> \
                    </div>';

        var thTmp = '<th style="#style">#head</th>';
        var cmd = '';

        for (var i = 0; i < this.config.columns.length; i++) {
            cmd += thTmp.replace("#head", this.config.columns[i].name).replace("#style", this.config.columns[i].style);
        }
        table = table.replace("#th", cmd);

        var toolbarButtom = '<div style="float: right;"><div class="btn-toolbar mb-2 mb-md-0"> \
                                <div class="btn-group mr-2">'
            + first
            + prev
            + next
            + last
            + '</div> \
                            </div></div>';

        $("#" + this.config.containerId).append(toolbarTop);
        $("#" + this.config.containerId).append(table);
        $("#" + this.config.containerId).append(toolbarButtom);
    };

    this.flushData = function (_data) {
        $("#" + this.config.containerId + " tbody").html("");
        var trTmp = '<tr id="#id">#td</tr>';
        var tdTmp = '<td>#t</td>';
        var cmd = '';
        for (var i = 0; i < _data.length; i++) {
            var item = _data[i];
            var line = "";
            for (var j = 0; j < this.config.properties.length; j++) {
                var property = this.config.properties[j];
                if (property == "checkBox") {
                    line += tdTmp.replace("#t", "<input type='checkbox' class=''>");
                } else if (property == "autoIncre") {
                    line += tdTmp.replace("#t", i + 1);
                } else if (property == "operation") {
                    var edit = this.config.buttons.edit ? '<button class="btn btn-sm btn-link" id = "edit" style="color: black;"><span data-feather="edit"></span> 修改 </button>' : '';
                    var del = this.config.buttons.delete ? '<button class="btn btn-sm btn-link" id = "delete" style="color: black;"><span data-feather="delete"></span> 删除 </button>' : '';
                    var detail = this.config.buttons.detail ? '<button class="btn btn-sm btn-link" id = "detail" style="color: black;"><span data-feather="plus-square"></span> 详情 </button>' : '';
                    line += tdTmp.replace("#t", edit + del + detail);
                } else {
                    line += tdTmp.replace("#t", property.indexOf("Date") >= 0 ? timeConverter(item[property]) : item[property]);
                }
            }
            cmd += trTmp.replace("#td", line).replace("#id", i);
        }
        $("#" + this.config.containerId + " tbody").append(cmd);
        feather.replace();
    };

    this.eventBinding = function () {
        $("#add").click(this.config.eventHandlers.add);

        $("#first").click(function() {config.eventHandlers.query("first")});

        $("#prev").click(function() {config.eventHandlers.query("prev")});

        $("#next").click(function() {config.eventHandlers.query("next")});

        $("#last").click(function() {config.eventHandlers.query("last")});

        $("#all").click(this.config.eventHandlers.all);
    }

}

