$("#btn").click(function () {
    //询问框
    layer.confirm('您是如何看待前端开发？', {
        btn: ['重要', '奇葩', '不想回答'] //按钮
    }, function () {
        layer.msg('的确很重要', {icon: 1});
    }, function () {
        layer.msg('也可以这样', {
            icon: 2,
            time: 1000 * 3, //20s后自动关闭
            btn: ['好', '不好']
        });
    }, function () {
        layer.msg('好吧，拜拜', {
            icon: 2,
            time: 20000, //20s后自动关闭
            btn: ['好', '不好']
        });
    });
});
