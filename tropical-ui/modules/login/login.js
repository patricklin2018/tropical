$(function () {
    layui.use('form', function () {
        var form = layui.form;
        form.verify({
            no: function (value, item) {
                if(/[\D]/.test(value)){
                    return '工号必须为全数字';
                }
                else if (!/^.{10}$/.test(value)) {
                    return '工号位数必须为10位';
                }
            },
            pass: function (value, item) {
                if (!/^.{6,32}$/.test(value)) {
                    return '密码位数必须为6~32位';
                }
            },
        });
        form.on('submit(login)', function (data) {
            $.ajax({
                url: host + "/login",
                type: 'POST',
                data: data.field,
                success: function (res) {
                    if (res.code == 0) {
                        layer.msg("登录成功", {
                            time: 1500
                        }, function () {
                            location.href = "../../index.html"
                        });
                    } else {
                        layer.msg(res.msg, function () {
                        });
                    }
                },
                error: function (res) {
                    layer.msg("网络异常，请稍后重试", function () {
                    });
                }
            });
            return false;
        });
    });
});
