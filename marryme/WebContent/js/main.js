var celnum = 0;
/**
 * @param i
 */
function setTab03Syn ( i ){
		selectTab03Syn(i);
	}

/**
 * @param i
 */
function selectTab03Syn ( i ){
	switch(i){
		case 1:
			document.getElementById("TabCon1").style.display="block";
			document.getElementById("TabCon2").style.display="none";
			document.getElementById("font1").style.color="#134FB3";
			document.getElementById("font2").style.color="#000000";
			document.getElementById("othernum").value = "";
			document.getElementById("test").value = "";
			break;
		case 2:
			document.getElementById("TabCon1").style.display="none";
			document.getElementById("TabCon2").style.display="block";
			document.getElementById("font1").style.color="#000000";
			document.getElementById("font2").style.color="#134FB3";
			document.getElementById("selfnum").value = "";
			break;
	}
}

/**
 * @param id
 */
function player(id){
	var id=document.getElementById(id);
	id.style.display="block";
}

/**
 * @param id
 */
function clocer(id){
	var id=document.getElementById(id);
	id.style.display="none";
}

/**
 * @param id
 */
function clocer1(id){
	var friend=document.form1.friend.value;
	if(friend==""){
		var id=document.getElementById(id);
		id.style.display="none";
	}
}

/**
 * @param num
 */
function checknum(num){
	var reT = /\d\d\d\d/;
	var nvalue = num.value;
	if(reT.test(nvalue)){
		celnum = 1;
		document.getElementById('sefcel').style.display = "none";
		document.getElementById('othcel').style.display = "none";
	}
	else{
		celnum = 0;
		document.getElementById('sefcel').style.display = "block";
		document.getElementById('othcel').style.display = "block";
//		alert(celnum);
	}
}

/**
 * 
 */
function cancelx(){
	document.getElementById('sefcel').style.display = "none";
	document.getElementById('othcel').style.display = "none";
}


/**
 * 
 */
function dosubmit(){
	var form = document.getElementById('form');
	if(celnum==1){
		form.submit();
	}
}