layui.use('util', function () {
    var util = layui.util;
    //执行
    util.fixbar({
        bar1: true
        , bar2: true
        , bgcolor: "#1F9A6C"
        , click: function (type) {
            console.log(type);
            if (type === 'bar1') {
                alert('点击了bar1');
            } else if (type === 'bar2') {
                alert('点击了bar2');
            }
        }
    });
});