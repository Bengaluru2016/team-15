<?php

$host='ec2-54-169-56-8.ap-southeast-1.compute.amazonaws.com';
$name='root';
$pass='team15';
$db='villgro';
$con=mysqli_connect($host,$name,$pass,$db);
if(mysqli_connect_errno())
{
	die("connection error" . mysqli_connect_error());
}


//initial query
if (!empty($_POST)) {
	$a=$_POST['user_id'];
	
    $query = " SELECT * from users WHERE user_id = '$a'" ;
   // $query_params = array(
     //       '$a' => $_POST['user_id'],
       // );
    //execute query
    try {
        //$stmt   = $con->prepare($query);
        $result = mysqli_query($con, $query);
		
    }
    catch (PDOException $ex) {
        $response["success"] = 0;
        $response["message"] = "Database Error!";
        die(json_encode($response));
    }

    // Finally, we can retrieve all of the found rows into an array using fetchAll 
    //$rows = $stmt->fetchAll(); 
      
    $output = array();
  
			while($row = mysqli_fetch_array($result,MYSQL_ASSOC))
			{
            $post["user_id"] = $row["user_id"];
            $post["name"] = $row["name"];
            $post["score"]    = $row["score"];
            $post["user_type"]  = $row["user_type"];   
            }
			
                        
            //update our repsonse JSON data
            array_push($output, $post);
              
        // echoing JSON response
        echo json_encode($output);
        
        
     
       // $response["success"] = 0;
        //$response["message"] = "No groups here yet! start by creating one!";
        //die(json_encode($response));
    
}

else {
?>
    <h1>Bwahahahaha</h1> 
    <form action="retrieve_all_groups.php" method="post"> 
         Location:<br /> 
        <input type="text" name="user_id" value="" /> 
        <br /><br />                        

        <input type="submit" value="get all groups" /> 
        
    </form>
    <?php
}

?>