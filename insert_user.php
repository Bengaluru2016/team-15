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

//if posted data is not empty
if (!empty($_POST)) {
    //If the any credential is empty when the user submits
    print_r($_POST);
   if (empty($_POST['user_id']) || empty($_POST['name']) || 
        empty($_POST['score'])||empty($_POST['user_type'])) {
            $response["success"] = 0;
            $response["message"] = "Not enough credential provided";
            die(json_encode($response));                
    }
    
    else 
   {    $a=$_POST['user_id'];
		$b=$_POST['name'];
		$c=$_POST['score'];
		$d=$_POST['user_type'];  
        $query = "INSERT INTO users(user_id,name,score,user_type) VALUES('$a','$b','$c','$d')";
		// $query = "INSERT INTO users (user_id,name,score,user_type) VALUES (45,'bun',50,'m')";
       
        //Again, we need to update our tokens with the actual data:
        
        //time to run our query, and enter the message
        try {
            
           $result = mysqli_query($con,$query);
        }
        catch (PDOException $ex) {
            $response["success"] = 0;
            $response["message"] = "Database Error2. Please Try Again!";
            die(json_encode($response));
        }
        
        /*$query2 = "SELECT gcm_regid FROM joined_details WHERE group_id = :groupid";
        $query2_params = array(
            ':groupid' => $_POST['group_id'],            
        );
        try {
            $stmt2   = $db->prepare($query2);
            $stmt2->execute($query2_params);
        }
        catch (PDOException $ex) {
            $response["success"] = 0;
            $response["message"] = "Database Error2. Please Try Again!";
            die(json_encode($response));
        }
        
        $rows = $stmt2->fetchAll();
        $ids = array();
        foreach ($rows as $row) {               
            
                   if($row["gcm_regid"]!=null){   
                      if(!in_array($row["gcm_regid"], $ids))                
                       array_push($ids, $row["gcm_regid"]);
                   }          
                   
        }      
        
        
        $query2 = "SELECT user_username FROM user_details WHERE user_id = :userid";
        $query2_params = array(
            ':userid' => $_POST['user_id'],            
        );
        try {
            $stmt2   = $db->prepare($query2);
            $stmt2->execute($query2_params);
        }
        catch (PDOException $ex) {
            $response["success"] = 0;
            $response["message"] = "Database Error2. Please Try Again!";
            die(json_encode($response));
        }
        $result = $stmt2->fetch();
        date_default_timezone_set('Asia/Kolkata');
        $time = time();
        $actual_time = date('d M Y, h:i A',$time);
        //$date = date_create($actual_time, timezone_open('Asia/Kolkata'));
        //$actual_time2 = date_format($date,'d M Y, h:i A');
        $message = array(
            "group_id" => $_POST['group_id'],
            "username" => $result['user_username'],
            "message" => $_POST['message'],
            "time" => $actual_time,
        );
        
        $url = 'https://android.googleapis.com/gcm/send';
        $fields = array(
            'registration_ids' => $ids,
            'data' => $message,
        );
               	
		
        $headers = array(
            'Authorization: key=' . 'AIzaSyD-xXsyujN6wGu0q8dSiWFBrc_IydlJSZo',
            'Content-Type: application/json'
        );
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);	
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));
        $result = curl_exec($ch);				
        if ($result === FALSE) {
            $response["success"] = 0;
            $response["message"] = curl_error($ch);
            die(json_encode($response));            
        }
        curl_close($ch);
        $response["success"] = 1;
        $response["message"] = "Message sent";
        $response["result"] = $result;
        echo json_encode($response);
		*/
    }    
	
}        
else {
?>
    <h1>User Details</h1> 
    <form action="enter_group_messages.php" method="post"> 
        
        
        UserId:<br /> 
        <input type="text" name="user_id" value="" /> 
        <br /><br />
			Name:<br /> 
        <input type="text" name="name" value="" /> 
        <br /><br />
			score:<br /> 
        <input type="text" name="score"value="" /> 
        <br /><br />
		UserType:<br /> 
        <input type="text" name="user_type" value="" /> 
        <br /><br/>
        
        
        <input type="submit" value="Enter user" /> 
        
    </form>
 <?php
}
 
