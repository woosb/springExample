/**
 * 
 */
	function daumPost(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	var addr1, addr2, addr3, addr4;
				if(data.addressType === "R"){
					addr2 = document.getElementById("addr2").value = data.roadAddress;	
				}else{
					add2 = document.getElementById("addr2").value = data.jinbunAddress;
				}
				addr1 = document.getElementById("addr1").value = data.zonecode;
				addr = document.getElementById("addr").value = addr1+"/"+addr2+"/";
	        }
	    }).open();
	}
	
	function postLoginForm(){
		addr = document.getElementById("addr").value;
		addr1 = document.getElementById("addr1").value
		addr2 = document.getElementById("addr2").value
		addr3 = document.getElementById("addr3").value;
		addr = addr +"/"+ addr1 +"/"+ addr2 +"/"+ addr3;
		document.getElementById("addr").value = addr;
	}