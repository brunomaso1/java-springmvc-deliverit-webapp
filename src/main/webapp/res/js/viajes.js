/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function nuevoPedido(nombreTabla) {
    var table = document.getElementById(nombreTabla);
	var row = table.insertRow(-1);
	var cell1 = row.insertCell(-1);
	var cell2 = row.insertCell(-1);
	var cell3 = row.insertCell(-1);
	var cell4 = row.insertCell(-1);
	var cell5 = row.insertCell(-1);
    cell1.innerHTML = "NEW CELL1";
    cell2.innerHTML = "NEW CELL2";
	cell3.innerHTML = "NEW CELL3";
    cell4.innerHTML = "NEW CELL4";
	cell5.innerHTML = "NEW CELL5";
}


