function button_click(e) {
    var string = [[${a.todo}]];
    var ajax = new XMLHttpRequest();
    ajax.send(string);
    console.log(string);
    alert("테스트 버튼 호출" + string);
}