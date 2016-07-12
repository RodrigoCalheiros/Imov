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

    <div class="loginColumns animated fadeInDown">
        <div class="row">
            <div class="col-md-6">
            	<span><img alt="image" class="img-responsive" src="img/imov2.png" width="80"/></span>
                <p></p>
                <p>
                    Software de gestão imobiliária para controle de imóveis, aluguel, e custos.
                </p>
            </div>
            <div class="col-md-6">
                <div class="ibox-content">
                    <form class="m-t" role="form" action="index.html">
                        <div class="form-group">
                            <input type="email" class="form-control" placeholder="Email" required="">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Senha" required="">
                        </div>
                        <button type="submit" class="btn btn-primary block full-width m-b">Login</button>
                        <a href="#">
                            <small>Esqueci a senha</small>
                        </a>
                    </form>
                </div>
            </div>
        </div>
        <hr/>
        <div class="row">
            <div>
                <strong>Copyright</strong>Rodrigo Calheiros &copy; 2014-2015
            </div>
        </div>
    </div>

</body>
</html>