 <?php
  include 'DBconnect.php' ;
  //this are the parameter we can say varibles which will be added by user using our application
  $officeNo = $_POST['off'];
  $mobileNo = $_POST['mob'];
  $password = $_POST['pass'];

 //the insert query to add the credential is database
 $Sql_Query = "INSERT INTO Register (officeNo,mobileNo, password) VALUES ('$officeNo','$mobileNo','$password')";
 
 if($con->query($Sql_Query) === TRUE){
 
 echo 'Data Submit Successfully';
 
 }
 else{
 
 echo 'Try Again';
 
 }
 mysqli_close($con);

?>
