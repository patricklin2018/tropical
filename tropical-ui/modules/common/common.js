

// 域名
var host = "http://www.tropical.com";

// ajax封装
function ajax(url, type, async, data) {
    var result = null;
    $.ajax({
        url: host + url,
        type: type,
        async: async,
        data: data,
        beforeSend: function(xhr) {
            xhr.setRequestHeader("token", getCookie("token"));
        },
        success: function (res) {
            result = res;
        },
        error: function (res) {
            layer.msg("网络异常，请稍后重试", function () {
            });
        }
    });
    return result;
};

// 获取 cookie
function getCookie(name) {
    var cookieValue = null;
    if (document.cookie && document.cookie !== '') {
        var cookies = document.cookie.split(';');
        for (var i = 0; i < cookies.length; i++) {
            var cookie = $.trim(cookies[i]);
            if (cookie.substring(0, name.length + 1) === (name + '=')) {
                cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                break;
            }
        }
    }
    return cookieValue;
};