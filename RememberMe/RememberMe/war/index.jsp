<html>
  <head>
    <title>Login</title>
    
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
   
  </head>

  <body>


  <p id ="msg1" style="visibility:hidden"></p>
  <form id="login" align ="center" style="visibility:visible">
  <div class="form-group">
    <h1>Login<small>PAGE</small></h1>
    <h3>UserName</h3><input type="email" class="form-control" id="emailId" placeholder="Email" value="san@gmail.com"><br>
    <h3>Password</h3><input type="password" class="form-control" id="pwd" placeholder="Password" value="1234">
    
    <input type="checkbox" id="check"> RememberMe
    
  
   <button type="button" class="btn btn-default" onClick="loginFunc()">SignIn</button>
  </div> 
    
    
  </form> 
  
  
  <p id="msg" style="visibility:hidden"></p>
  
  <script type="text/javascript" src="rememberMe.js"></script>

  </body>
</html>
