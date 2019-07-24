<?php
$servername="localhost";
$mysql_user="root";
$mysql_pass="";
$dbname="register";
$conn=mysqli_connect($servername, $mysql_user, $mysql_pass, $dbname);
if($conn){
    echo("connected successfully!");
}else{
    echo("connection was unsuccessful!");
}
if($_SERVER['REQUEST_METHOD']=='POST'){
    $username=$_POST['username'];
    $firstname=$_POST['firstname'];
    $lastname=$_POST['lastname'];
    $email=$_POST['email'];
    $password=$_POST['password'];
    $query="INSERT INTO `register`(`username`, `firstname`, `lastname`, `email`, `password`) VALUES ('$username', '$firstname', '$lastname', '$email', '$password')";
    if(mysqli_query($conn, $query)){
        echo("Registered successfully!");
    }else{
        echo("An error occurred while registering!");
    }
}else{
    echo("An error occurred in the request method!");
}


?>