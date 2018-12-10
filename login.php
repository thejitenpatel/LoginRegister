<?php 
    //this is login script this is called when user want to login and not register
	$ORN=$_POST['num'];
	$pass=$_POST['pass'];

	$sql="SELECT * FROM `Register`";
	$result=$conn->query($sql);
	if($result->num_rows > 0)
	{
		while($row=$result->fetch_array())
		{
			$check1=$row["off"];
			$check2=$row["pass"];
		}
	}


	if( empty($ORN)||empty($pass) )
	{
		echo "empty";
	}
	elseif($ORN!=$check1||$pass!=$check2)
	{
		echo "invalid user".$check1." ".$check2;
	}
	else
	{
		echo "welcome".$check1." ".$check2;
	}
?>