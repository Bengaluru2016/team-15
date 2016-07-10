<?php>
$current=10;
$total=100;
$percent=round(($current/$total)*100));
echo $percent;
?>
<style type="text/css">
.outer
{
	height:25px;
	width:500px;
	border:solid 1px #000;
}
.inner
{
	height:25px;
	width:<?php echo $percent?>%;
	border-right:solid 1px #000;
	background-color:lightblue;
}
</style>
<div class="outer">
<div class="inner">
</div>
</div>
