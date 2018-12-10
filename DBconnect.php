<?php
	//Change the values according to your database
	
	define('HOST','localhost');
	define('USER','add your user id here");
	define('PASS','your password');
	define('DB','your database name');
	
	$con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
?>