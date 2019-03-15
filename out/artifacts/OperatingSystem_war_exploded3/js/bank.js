var meta = {
    "maxCount": 2,
    "curPage": 1,
    "data": []
};

var config = {
    "eventHandlers": {
        "add": function() {
            console.log("add event");
            $("#modal-add").modal('show');
        },
        "all": function() {
            console.log("all event");
            $("input[type='checkbox']:not(:checked)").click();
        },
        "delete": function(_selectedData, _selectedRow) {
            // delete
        },
        "update": function(_selectedData, _selectedRow) {
            console.log("add event");
            $("#modal-edit").modal('show');
        },
        "query": function(type) {
            if (type == 'first') meta.curPage = 1;
            else if (type == 'prev' && meta.curPage > meta.maxCount) meta.curPage -= meta.maxCount;
            else if (type == 'next') meta.curPage += meta.maxCount;
            else if (type == 'last') {}

            var req = {
                start: meta.curPage - 1,
                end: meta.maxCount,
                count: meta.maxCount,
                condition: $("condition").val()
            };

            var url = "";
            if (req.condition) url = URL.getBankListByPageAndCondition;
            else url = URL.getBankListByPage;

            $.post(url, req, function(data) {
                console.log(data);
                if (data && data.length == 0) {
                    if (type == 'next') {
                        meta.curPage -= meta.maxCount;
                    }
                } else {
                    taojjTable.flushData(data);
                    meta.data = data;
                }
            });
        }
    },
    "columns": [
        {name: "选择", style: ""},
        {name: "序号", style: ""},
        {name: "id", style: ""},
        {name: "题库名称", style: ""},
        {name: "创建时间", style: ""},
        {name: "创建人", style: ""},
        {name: "修改时间", style: ""},
        {name: "修改人", style: ""},
        {name: "操作", style: ""}
    ],
    "containerId": "table-panel",
    "buttons": {
        "add": true,
        "all": true,
        "batchUpload": false,
        "batchDelete": true,
        "batchEdit": false,
        "search": true,
        "output": false,
        "edit": true,
        "detail": false,
        "delete": true,
        "first": true,
        "next": true,
        "prev": true,
        "last": false
    },
    "properties": [
        "checkBox",
        "autoIncre",
        "id",
        "name",
        "createDate",
        "createBy",
        "updateDate",
        "updateBy",
        "operation"
    ]
};

var modalCtls = [
    {
        id: "name",
        tag: "input",
        type: "text",
        initHelper: false,
        style: "",
        label: "题库名称:"
    }
];

var taojjTable = new TaojjTable(config);
taojjTable.init();
generateForm("#modal-add .modal-body", modalCtls);
generateForm("#modal-edit .modal-body", modalCtls);

