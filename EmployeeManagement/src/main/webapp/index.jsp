<html>
<head>
<style>
input
{

 color: white;
 background-color: white;
 border: 0;
}
form
{
height: 100vh;
width :100vw;
background-color: rgba(0,0,0,0.8);
}
</style>
</head>
<body>
<center><form action="all" method="post" id="myform">
	<input type="submit" value="open Application">
	</form></center>
	<script>
window.onload = function() {
    document.getElementById('myForm').submit(); // Submit the form
};
</script>
</body>
</html>
