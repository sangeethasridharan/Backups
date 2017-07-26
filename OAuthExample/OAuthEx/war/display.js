var req = new XMLHttpRequest();
var showNames,divt,link,nameslist;

function showAll()
{
	document.getElementById("butt").style.visibility='hidden';
	document.getElementById("allContact").style.visibility='visible';
}
	

function show()
    {
    	var url="/showdetails";
        req.open("GET",url,true);
		req.send();
    	req.onload = function() {
    		
    		if (this.readyState == 4 && this.status !=200){
    			alert("you are wrong");
    		}
    		
    		else if (this.readyState == 4 && this.status == 200) {
    			 var personalContacts = this.responseText;
    			 var perDetails = JSON.parse(personalContacts);
    			 alert(personalContacts);
    			 var mainDiv=document.getElementById('details');
    			 var imgDiv=document.getElementById('imgDiv');
    			 var personalDetail =document.getElementById('personalDetail');
    			 
    			 
    			 var imge=document.createElement("img");
    			 imge.src=names[0].picture;
    			 imge.width="200";
    			 imge.height="200";
    			 
    			 imgDiv.appendChild(imge);
    			
    			 
    			 
    			 
    			 var p_name =document.createElement('p');
    			 p_name.setContent="Name : ";
    			 
    			 var p_email=document.createElement('p');
    			 p_email.setContent="Email : ";
    			 
    			
    			 
    			personalDetail.appendChild(p_name);
    			personalDetail.appendChild(p_email);
    			 document.getElementById('img').appendChild(imge);
    			 
    			 document.getElementById('id').innerHTML=names[0].id;
    			 
    			 document.getElementById('name').innerHTML=names[0].name;
    			 
    			 document.getElementById('fname').innerHTML=names[0].given_name;
    			 
    			 document.getElementById('lname').innerHTML=names[0].family_name;
    			 
    			 document.getElementById('email').innerHTML=names[0].email;
    			 
    			 
    			 
    			 
    			 if(names[0].link != null)
    				 {
    			       var link=document.createElement("a");
    			       lname = document.createTextNode("GOOGLE+");
				       link.setAttribute('href', 'names[0].link');
				       var li = link.appendChild(lname);
				       document.getElementById('link').appendChild(li);
    				 }*/
    		}
    	};
    }


function displayfunc() { 
        req.open('GET', 'https://randomuser.me/api/?results=1&&inc=gender,name&noinfo');
        req.onload = function() {
            if (req.status === 200) {
            	  var str= req.responseText;
            	 req.onreadystatechange=getInfo(); 
            	 document.getElementById('process').innerHTML= str;
            	 
            }
            else {
                alert('Request failed.  Returned status of ' + req.status);
            }
        };
        req.send();
	
} 	

function getInfo(){ 
	if(req.readyState==4){    
	document.getElementById('alert').innerHTML="Do you want to save this contact...";
	} 
}	


function postInfo()
{
	
	var jsonStr={};
    	  req.open("POST","servlet",true);
          req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
          jsonStr=document.getElementById('process').innerHTML;
    	  
    	  
    	  req.onreadystatechange = function() {
          	
      	    if (this.readyState == 4 && this.status == 200) {
      		alert("Contacts Saved successfully");
      		document.getElementById('names').innerHTML = this.responseText;
      		
      	    }
      	  };
      	req.send(jsonStr);
      	
  }


function search()
{
	var v = document.getElementById('se').value;
	var url="/search?val="+v;
	var fname;
	req.open("GET",url,true);
	
	
	req.onload = function() {
		
		if (this.readyState == 4 && this.status !=200){
			alert("you are wrong");
		}
		
		else if (this.readyState == 4 && this.status == 200) {
	    	alert("Result");
	    	name = req.responseText;
	    	if(name != "Not Available")
    		{
	    	var data=JSON.parse(name);
	    	
	    	var title = data[0].title;
	    	var fname = data[0].first;
	    	var lname = data[0].last;
	    	
	    	      document.getElementById("err").style.visibility='hidden';
	    		  document.getElementById("form").style.visibility='visible';
				  document.getElementById('ti').innerHTML=title;
				  document.getElementById('fn').innerHTML=fname;
				  document.getElementById('ln').innerHTML=lname;
				  
	    		}
			else
				{
				  document.getElementById("err").style.visibility='visible';
				  document.getElementById('err').innerHTML= name;
				}
	    }
	  };
	  
	req.send();
}


function showContact()
{
	var url="/show";
    req.open("GET",url,true);
	var contacts;
	
	req.onload = function() {
		
		if (this.readyState == 4 && this.status !=200){
			alert("you are wrong");
		}
		
		else if (this.readyState == 4 && this.status == 200) {
			contacts = this.responseText;
			showNames=JSON.parse(contacts);
			var i;
			
			document.getElementById('list').innerHTML = '';
				for(i=0;i<showNames.length;i++)
					{
					document.getElementById("dthc").style.visibility='visible'
				    	divt = document.createElement("div");
				    	
				    	link = document.createElement("a");
				    	link.setAttribute('id',`na${i}`);
				    	
    				  nameslist = document.createTextNode(showNames[i].first);
    				   
    				    
    				    link.setAttribute('onClick', 'details(showNames,\"'+showNames[i].first+'\")');
    				    link.appendChild(nameslist);
    				    divt.appendChild(link);
    				    
    				    
    				    document.getElementById("list").appendChild(divt).style.fontSize='20px';
    				    
					}	
				
				
		}
	};
	req.send();
	
}

function details(showNames,firstName)
{
  var firstName;
  for(var j=0;j<showNames.length;j++)
	  {
	  if(firstName == showNames[j].first)
		  {
		  document.getElementById("dth").style.visibility='visible';
		  document.getElementById("dtd").style.visibility='visible';
		  document.getElementById("tit").disabled=true;
		  document.getElementById("tit").value = showNames[j].title;
		  document.getElementById("fna").disabled=true;
		  document.getElementById("fna").value = showNames[j].first;
		  document.getElementById("lna").disabled=true;
		  document.getElementById("lna").value = showNames[j].last;
          
		  }
	  }
  
}

function updatevalues()
{
        document.getElementById("tit").disabled=false;
    	
    	document.getElementById("lna").disabled=false;
    	
    	document.getElementById("ubtn").style="visibility:hidden";
    	
    	document.getElementById("ubtn1").style="visibility:visible";
    	
    	
    	
 }
function update()
{
	req.open("PUT","/update",true);
    req.setRequestHeader("Content-Type", "application/json; charset=utf-8");
    
    tid = document.getElementById("tit").value;
	fnamed = document.getElementById("fna").value;
	lnamed = document.getElementById("lna").value;
	
	var values = {};
	values.title = tid;
	values.first = fnamed;
	values.last = lnamed;
 	var jstr = JSON.stringify(values);
 	
 	req.onreadystatechange = function() {
    	if (this.readyState == 4 && this.status == 200) {
    		alert(this.responseText);
    		
    		document.getElementById("tit").disabled=true;
        	
        	document.getElementById("lna").disabled=true;
        	
    		document.getElementById("ubtn").style="visibility:visible";
        	
        	document.getElementById("ubtn1").style="visibility:hidden";
        	
        	showContact();
    	}
	
    };
    req.send(jstr);
    
}

function deleteconc()
{
	var fnames = document.getElementById("fna").value;
	var req = new XMLHttpRequest();
	
	req.open("DELETE","/delete?val="+fnames,true);
    req.setRequestHeader("Content-Type", "application/json; charset=utf-8");
	
    
	req.onreadystatechange = function() {
    	if (this.readyState == 4 && this.status == 200) {
    		/*var nameList = this.responseText;
    		var contactList = JSON.parse(nameList);*/
    		document.getElementById('deletealert').innerHTML=this.responseText;
    		showContact();
    		
    		}
    	};
    	
	req.send();
	
}