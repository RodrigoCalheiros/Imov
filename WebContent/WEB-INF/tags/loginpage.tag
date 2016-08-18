<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Imov</title>
    
    <link href="inspinia/css/bootstrap.min.css" rel="stylesheet">
    <link href="inspinia/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="inspinia/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="inspinia/css/animate.css" rel="stylesheet">
    <link href="inspinia/css/style.css" rel="stylesheet">

	<!-- Mainly scripts -->
	<script src="inspinia/js/jquery-2.1.1.js"></script>
	<script src="inspinia/js/bootstrap.min.js"></script>
	<script src="inspinia/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="inspinia/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	
	<!-- Custom and plugin javascript -->
	<script src="inspinia/js/inspinia.js"></script>
	<script src="inspinia/js/plugins/pace/pace.min.js"></script>
    <script src="inspinia/js/plugins/jquery-ui/jquery-ui.min.js"></script>

    <!-- Jquery Validate -->
    <script src="inspinia/js/plugins/validate/jquery.validate.min.js"></script>
    
    <!-- Input Mask -->
    <script src="inspinia/js/plugins/jasny/jasny-bootstrap.min.js"></script>
    
    <!-- Troastr -->
    <script src="inspinia/js/plugins/toastr/toastr.min.js"></script>
	
	<!-- Imov -->
	<script src="js/imovFuncoes.js" language="JavaScript"></script>
	<script src="js/imovConteudo.js" language="JavaScript"></script>
</head>
<body class="gray-bg">
	<input type="hidden" id="tpMensagem" name="tpMensagem" value=""/>
    <input type="hidden" id="dsMensagem" name="dsMensagem" value=""/>
	<input type="hidden" id="dsRedirect" name="dsRedirect" value=""/>
	
	<jsp:doBody/>
	
</body>
</html>