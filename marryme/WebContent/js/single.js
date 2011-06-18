/**
 * @param tag
 */
function show(tag){
	var light=document.getElementById(tag);
	var fade=document.getElementById('fade');
	light.style.display='block';
	fade.style.display='block';
}

/**
 * @param tag
 */
function hide(tag){
	var light=document.getElementById(tag);
	var fade=document.getElementById('fade');
	light.style.display='none';
	fade.style.display='none';
}

var pubtextc = 0;    //这个标记用来说明textarea里的字数是否超出，超出为1，否则为0
function checkword(){
	var count=0;
    pubtextc = 0;
    var wordsarea = document.getElementById("textarea");
    for(var i=0;i<wordsarea.value.length;i++){
    	var value = wordsarea.value.substr(i,1);
    	var nvalue = escape(value);
    	if(nvalue.substring(0,2)=="%u"){
        	count++;
		}else{
        	count+=0.5;
		}
	}
    if(count>140){
    	count = Math.ceil(count);
		pubtextc = 1;
		document.getElementById("remain1").innerHTML="已超出";
		document.getElementById("word").innerHTML = count-140;
		document.getElementById("remain1").style.color='red';
		document.getElementById("remain2").style.color='red';
	}else{
		count = Math.floor(count);
		pubtextc = 0;
		document.getElementById("remain1").innerHTML="还可输入";
		document.getElementById("word").innerHTML = 140-count;
		document.getElementById("remain1").style.color='#808080';
		document.getElementById("remain2").style.color='#808080';
	}     
}     
function changeColor(){
	var color = new Array("#FFD0D0","#FFFFFF");
	for(ii=0;ii<=3;ii++){
		setTimeout("document.getElementById('textarea').style.backgroundColor='"+color[ii%2]+"'",160*ii);
	}
}
/**
 * 
 */
function dosubmit(){
	var form = document.getElementById("form");
	if(pubtextc != 1){
		form.submit();
	}else{
		changeColor();
	}
}