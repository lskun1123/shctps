//获取商品类别
getCategory();
function getCategory() {

    $.getJSON("/shctps/goods/getCategory",function (data) {
        var category = $("#category");
        category.empty();
        $.each(data.data,function (index,data) {
            var option = $("<option></option>");
            option.val(data.gcid);
            option.text(data.categoryname);
            category.append(option);
        })
    })
}


getGoodsList();
function getGoodsList() {
    var number = $("#pageNumber").text();
    console.log(number);
    $.getJSON("/shctps/goods/getGoodsList",{
        "pageNumber":number
    },function (data){
        var goodsList = $("#goodsList");
        goodsList.empty();
        $.each(data.data,function (index,data) {
            var div = $("<a name='" + data.gid + "style='display: block;' href='../goods/goodsInfo.html?gid=" + data.gid + "'></a>");

            var name = $("<p></p>");
            name.text(data.goodsname);
            console.log(data);
            var imgstring = data.goodsimg;
            var images = imgstring.split(",")
            var img = '<img class="goodsImg" src="https://shctps-1304936287.cos.ap-chengdu.myqcloud.com/goodsImg/' + images[0] + '" />';

            var price = $("<p></p>");
            price.text(data.goodsprice);

            div.append(name);
            div.append(img);
            div.append(price);
            goodsList.append(div);
            goodsList.append("<br/>");
        })
    })
}
//上一页，下一页
function prePage() {
    var number = $("#pageNumber");
    if(number.text() != 1){
        var num = number.text();
        num--;
        number.empty();
        number.text(num);
    }
    getGoodsList();
}
function afterPage() {
    var number = $("#pageNumber");
    var num = number.text();
    num++;
    number.empty();
    number.text(num);
    getGoodsList();
}
//跳转到商品详情界面
function toDetail(el) {
    var id=$(el).attr("name");
    console.log($(el).attr("name"));
    window.location.href("shctps/goods/goodsInfo&gid=" + id);
}