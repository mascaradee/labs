var n = 0;
function fn2() {
    console.log(n++ + ': 안녕하세요. 체크박스에오.');
}
$('input:checkbox').on('click', fn2); // 이 이벤트가 생성될 때 존재하는 checkbox에만 적용된다. 

// 방법1 
// 나중에 추가된 태그에는 핸들러를 따로 할당해야 제대로 작동한다. 
/*
$('#appendCheckBoxBtn').click(function() {
    $('<input type="checkbox">').appendTo('#appendAfterMe');
    $('input:checkbox').click(fn2); // 추가된 태그에 핸들러 할당 
});
*/

// 방법2
// 하지만 버블링 방식의 .on()을 활용하면 간단히 해결된다. 
// 이벤트가 전달되는 상위로 전달되는 버블링 특성을 이용해 myForm 이하의 checkbox에서 발생한 이벤트를 핸들하는 방법   
$('#appendCheckBoxBtn').click(function() {
    $('<input type="checkbox">').appendTo('#appendAfterMe');
});
$('#myForm').on('click', 'input:checkbox', fn2); // 기존 것과 새로 추가된 것 모두에 이벤트가 적용된다. 


// .on()으로 이벤트를 할당하는 또 다른 방법들 
//  공백으로 구분된 문자열로 이벤트를 여러개 할당 할 수 있다. 
$('#address').on('click mouseover keydown', function() {
    console.log(n++ + ': 안녕하신가! 만일 내게 묻는다면 나는 주소창.')
});
// + 버블링 
$('#myForm').on('click mouseover keydown', '#address', function(){});

// Object 방식
function fn3() {
    console.log(n++ + ': 이제 콘솔은 지겨워');
}
$('#address2').on({
    click: fn3, 
    mouseover: fn3
});
// + 버블링
$('#myForm').on({
    click: fn3,
    mouseover: fn3,
}, '#address2');

// 네임스페이스 이용
// 특정 이벤트에 여러 핸들러를 부착할 때, 네임스페이스를 이용해서 각각의 핸들러에 이름을 지정하고 나중에 지울 때 활용할 수 있다. 
$('#zip').on('click.abc', function(){
    console.log(n++ + ': 응애에요');
});
$('#zip').on('click.efg', function(){
    console.log(n++ + ': 아 들이대');
});
// 여기서 모종의 이유로 첫 번째 핸들러를 지우고 싶다면?
$('#zip').off('click.abc');

// 네임스페이스를 Object 방식으로 
$('#zip').on({
    'click.aaa': function() { console.log(1); },
    'click.bbb': function() { console.log(2); }
});
