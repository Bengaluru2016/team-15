<?php
$host='localhost';
$name='root';
$pass='';
$db='villgro';
$con=mysqli_connect($host,$name,$pass,$db);
if(mysqli_connect_errno())
{
	die("connection error" . mysqli_connect_error());
}
?>
<html>
<head>
</head>
<body>
<?php
if(isset($_POST['submit']))
   {
	$ID=$_POST['user_id'];
    $Name=$_POST['name'];
	$Score=$_POST['score'];
	$User_type=$_POST['user type'];
	if(empty($ID)||empty($Name)||empty($Score) ||empty($User_type))
	{
		echo "cant leave blank!";
	}
	else
	{
		//$sql="insert into user(user_id,name,score,user type) values('$ID','$Name','$Score','$User_type')";
	    $query=mysqli_query($con,$sql);
		if(!$query)
		{
			die("query failed" . mysqli_error($con));
		}
		else
		echo "insertion successful";
		
	}
   }
   ?>
   </body>
   </html>
   