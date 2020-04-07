<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta http-equiv="author" content="">
<meta name="keywords" content="nihao">
<title>网页</title>
<style type="text/css">
.textAreaStyle{
width:100%;
height:100%;
border:0;
}

</style>
<script tyep="text/javascript">
function update(date){
	var result=document.getElementsByName("result")[0];
	result.value=result.value+date+"\n";
}
</script>
</head>

<body>
	<table width="100%" align="center" border="0" cellpading="0" cellspacing="0">
		<tr>
			<td>
				<textarea name="result" id="result" readonly="true" wrap="off" style="padding:10;overflow:auto;" class="textareaStyle"></textarea>
			</td>
		</tr>
	</table>
	<iframe id="autoFrame" style="display:none;" src="/WebTest/AsyncContextServlet"></iframe>
</body>
</html>