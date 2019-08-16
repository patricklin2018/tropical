// 域名
// var host = "http://www.tropical.com/tropical";

// ajax封装
function ajax(url, type, async) {
    var result = null;
    $.ajax({
        url: url,
        type: type,
        async: async,
        success: function (res) {
            result = res;
        },
        error: function (res) {
        }
    });
    return result;
};