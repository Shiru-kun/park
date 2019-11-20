/*<![CDATA[*/
function inOut(){

    document.getElementById("menu").classList.toggle('active');
   document.getElementById("content").classList.toggle('active');
    
}

function car() {
    var x = document.getElementById("car");
    if (x.className.indexOf("w3-show") == -1) {
      x.className += " w3-show";
    } else {
      x.className = x.className.replace(" w3-show", "");
    }
  }
  function owner() {
    var x = document.getElementById("owner");
    if (x.className.indexOf("w3-show") == -1) {
      x.className += " w3-show";
    } else {
      x.className = x.className.replace(" w3-show", "");
    }
  }
  function parkAndPay() {
    var x = document.getElementById("parkAndPay");
    if (x.className.indexOf("w3-show") == -1) {
      x.className += " w3-show";
    } else {
      x.className = x.className.replace(" w3-show", "");
    }
  }
  
  
 function funcMoney(){
	  
	  var days= document.getElementById("daysOn").value;
	  var money= document.getElementById("money").value;
	 var result = parseFloat(days) * parseFloat(money);
	 if (!isNaN(result)) {
		 document.getElementById('moneyAwaited').value = result+' Mtn';   
         funcDate();
       } 

   }
 
   function funcDate(){
    
     var dat=new Date();
     document.getElementById('start').value= dat.getFullYear()+"/"+dat.getMonth()+"/"+dat.getDay();
//     var newData= new Date();
//     newData.setDate(dat.getDate()+document.getElementById('daysOn').value);
//  document.getElementById('final').value= newData.getFullYear()+"/"+newData.getMonth()+"/"+newData.getDay();
     
     
   
   }
   
   
   // validate fields
   
   
   function check(){
   	var form =document.getElementById("formCar");
   	var plate = document.getElementById("plate").value;
   	var control = true;
        if(plate.length<1){
    		control = false;

    		$('#plate').after('<span class="alert alert-warning" >'+'incorrect plate'+'*</span>');
   	}else {
   		
    	     var regEx = /[A-Z]{3}\-[0-9]{3}/;
   	     
    	     var validplate = regEx.test(plate);
    	     if(!validplate){
    	    	 control = false;
   	         $('#plate').after('<span class="alert alert-warning">'+'incorrect plate'+'</span>');
    	        }
    	     } 
        
        if(control){
        	form.submit();
        }
       
       

   }
   
   /*]]>*/