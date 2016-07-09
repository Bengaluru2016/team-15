<?php
$total = 5000;
$current = 1767;
$percent = round (($current/$total)*100),1);
echo "$current is $percent% of $total.";
?>
<style type="text/CSS">
.outter
{
	height:30px;
	width:500px;
	border:solid lpx #000;
	
}
.inner
{
	height:30px;
	width:<?php echo $percent ?>%;
	border-right:solid lpx #000;
}
</style>
<div class="outter">
<div class="inner"></div>
</div>