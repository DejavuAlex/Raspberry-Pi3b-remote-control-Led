$("document").ready(function() {
    $("#inputPassword").hide();
});

// 点击教师checkbox弹出密码框
$("#is-teacher").change(function() {
    if (this.checked) {
        $("#inputPassword").show();
    } else {
        $("#inputPassword").hide();
    }
});
