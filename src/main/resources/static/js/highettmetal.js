$(document).ready(function ($) {
    var activePage = window.location.href;
    $('.nav-sidebar li a').each(function () {
        var linkPage = this.href;

        if (activePage == linkPage) {
            $(this).closest("li").addClass("active");
        }
    });
});