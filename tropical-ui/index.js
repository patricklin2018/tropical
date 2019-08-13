var element = null;
var layer = null;

var v = new Vue({
    el: '#app',
    data: {
        user: null,
        menus: null,
    }
});

$(function () {
    layui.use(['element', 'layer'], function () {
        element = layui.element;
        layer = layui.layer;
        getUserInfo();
        getMenus();
    });
});

// 获取用户信息
function getUserInfo() {
    var res = ajax(host + "/me", 'get', false);
    if (res == null) {
        layer.msg("网络异常，请稍后重试", function () {
        });
    } else if (res.code == 0) {
        v.user = res.data;
    } else {
        layer.msg(res.msg, {
            time: 1500
        }, function () {
            location.href = "./modules/login/login.html";
        });
    }
};

// 获取菜单信息
function getMenus() {
    var res = ajax(host + "/menus", 'get', false);
    if (res == null) {
        layer.msg("网络异常，请稍后重试", function () {
        });
    } else if (res.code == 0) {
        v.menus = res.data;
    } else {
        layer.msg(res.msg, {
            time: 1500
        }, function () {
            location.href = "./modules/login/login.html";
        });
    }
};