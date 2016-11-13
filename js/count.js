function countSymbols() { 
var input = document.getElementById("textA");
if (input .value.length>20){
	document.getElementById('textA').value = input .value.substr(0,20)
}
 document.getElementById('counter').innerText = input .value.length; 
 }
 
