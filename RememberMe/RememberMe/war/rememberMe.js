
var xhttp = new XMLHttpRequest();

function loginFunc()
{
	if(document.getElementById("check").checked)
		{
		 var email = document.getElementById("emailId").value;
		 var pwd = document.getElementById("pwd").value;
		
		var credentials = {emailId : email, password :pwd};
		
		var json = JSON.stringify(credentials);
		var url="/loginwithcookie";
		xhttp.open("POST",url,true);
		xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        xhttp.onreadystatechange = function() {
    		
    		if (this.readyState == 4 && this.status == 200){
    			var str = this.responseText.trim();
    	
    			if(str === "false")
    				{
    				document.getElementById("login").style.visibility='visible';
    				document.getElementById("msg").style.visibility='visible';
    				document.getElementById("msg").innerHTML = "Enter Credentials correctly";
    				}
    			else
    				{
    				document.getElementById("login").style.visibility='hidden';
    				document.getElementById("msg").style.visibility='hidden';
    				document.getElementById("msg1").style.visibility='visible';
    				document.getElementById("msg1").innerHTML = this.responseText;
    				}
    			
    		}
		};
		
		console.log("Json data: "+json);
		
        xhttp.send(json);
		}
	else
		{
		    var email = document.getElementById("emailId").value;
		    var pwd = document.getElementById("pwd").value;
		    var credentials = {emailId : email, password :pwd};
		    var jsonStr = JSON.stringify(credentials);
		    var url = "/loginwithsession";
		    xhttp.open("POST",url,true);
			xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	        xhttp.onreadystatechange = function() {
	    		
	    		if (this.readyState == 4 && this.status == 200){
	    			var str = this.responseText.trim();
	    			
	    			if(str === "false")
    				{
    				document.getElementById("login").style.visibility='visible';
    				document.getElementById("msg").style.visibility='visible';
    				document.getElementById("msg").innerHTML = "Enter Credentials correctly";
    				}
    			    else
    				{
    				document.getElementById("login").style.visibility='hidden';
    				document.getElementById("msg").style.visibility='hidden';
    				document.getElementById("msg1").style.visibility='visible';
    				document.getElementById("msg1").innerHTML = this.responseText;
    				}
	    		}
	        };
	        xhttp.send(jsonStr);
		}
	
}



var logoutFunc= function()
{
	var url="/logout";
	xhttp.open("GET",url,true);
    xhttp.onreadystatechange = function() {
		
		if (this.readyState == 4 && this.status == 200){
			document.getElementById("log").style.visibility='hidden';
			alert(this.responseText);
			document.location.href = "/index.jsp";
			
		}
    };
    xhttp.send();
}



function comment()
{
	
	var para = document.createElement('p');
	var text = document.getElementById("text").value;
	var textNode = document.createTextNode(text);
	para.appendChild(textNode);
	
	document.getElementById("textmsg").appendChild(para);
	
	document.getElementById("text").value = '';
}
	