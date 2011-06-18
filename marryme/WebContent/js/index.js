var currtop;
var tar;
/**
 * 
 */
function init() {
	currtop = 0;
	tar = 0;
	//setInterval("show()",1000);
	show();
	showline();
}

/**
 * @returns
 */
function reheight() {
	return document.getElementById("Slider")["offsetHeight"];
}

/**
 * 
 */
function show() {
	if (tar == 0) {
		$("#Slider").fadeOut(1000);
		setTimeout("changeht()", 1100);
		tar = 1;
		setTimeout("show()", 1200);
	} else {
		$("#Slider").fadeIn(600);
		tar = 0;
		setTimeout("show()", 2500);
	}
}

/**
 * 
 */
function changeht() {
	if (currtop > -957) {
		move(currtop - 319);
		currtop -= 319;
	} else {
		move(0);
		currtop = 0;
	}
}

/**
 * @param count
 */
function move(count) {
	document.getElementById("Slider").style.top = count + "px";
}

var ptxt = new Array(6);
ptxt[0] = "战国时候。。";
ptxt[1] = "某人有了第一台手机。。";
ptxt[2] = "他的尾号后四位是1234。。。";
ptxt[3] = "结果，他的下辈子。。。。";
ptxt[4] = "所以。。";
ptxt[5] = "人的手机号码和下辈子的Ta有关系。。";

var pobj = new Array("p1", "p2", "p3", "p4", "p5", "p6");
//pobj[0] = "p1";
//pobj[1] = "p2";
//pobj[2] = "p3";
var obj;
/**
 * 
 */
function showline() {
	//alert("OK");
	for ( var ii = 0; ii < ptxt.length; ii++) {
		//alert(ptxt.length);
		//alert(pobj.length);
		obj = document.getElementById(pobj[ii]);
		//alert(obj);
		setTimeout("showword(" + ii + ")", 2000 * ii);
		//alert("OK");
		//showword(ptxt[ii],obj);
	}
}

/**
 * @param count
 */
function showword(count) {
	var words = ptxt[count];
	//alert(words);
	for ( var jj = 0; jj < words.length; jj++) {
		//alert(words.length);
		setTimeout("pwchange(" + count + "," + jj + ")", 60 * jj);
	}
}

/**
 * @param count
 * @param jj
 */
function pwchange(count, jj) {
	var ap = document.getElementById(pobj[count]);
	ap.innerHTML = ptxt[count].substr(0, jj);
}

function dosubmit(){
	var form = document.getElementById('form');
	form.submit();
}