function daumPost(){
	    new daum.Postcode({
	    	oncomplete: function(data) {
	    		// 도로명일 경우  R, 지번일 경우 J 의 값을 가지고 있다.
	    		console.log(data);
	    		console.log('data.userSelectType : ' + data.userSelectedType);
	    		console.log('data.roadAddress : ' + data.roadAddress);
	    		console.log('data.jinunAddress : ' + data.jibunAddress);
	    		console.log('data.zonecode(우편번호) : ' + data.zonecode);
	    		
	    		var addr = "";
	    		if(data.userSelectedType === 'R'){
	    			addr = data.roadAddress;
	    		}else{
	    			addr = data.jibunAddress;
	    		}
	    		
	    		document.getElementById('addr1').value = data.zonecode;
	    		$('#addr2').val(addr);
	    		$('#addr3').focus();
	    		
	    	}
	    }).open();
	}
