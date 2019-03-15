$(".nav-link").click(function() {
    console.log("try jump to: " + this.href);
    document.getElementById('inner-page').src = this.href;
    return false;
});
