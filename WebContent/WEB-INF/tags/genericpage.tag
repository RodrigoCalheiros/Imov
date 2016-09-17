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
    <link href="inspinia/css/plugins/dataTables/datatables.min.css" rel="stylesheet">
    <link href="inspinia/css/animate.css" rel="stylesheet">
    <link href="inspinia/css/style.css" rel="stylesheet">

	<!-- Mainly scripts -->
	<script src="inspinia/js/jquery-2.1.1.js"></script>
	<script src="inspinia/js/bootstrap.min.js"></script>
	<script src="inspinia/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="inspinia/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="inspinia/js/plugins/jeditable/jquery.jeditable.js"></script>
	<script src="inspinia/js/plugins/dataTables/datatables.min.js"></script>
	
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
<body class="top-navigation">
<div id="wrapper">
	<div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom white-bg">
        <nav class="navbar navbar-static-top" role="navigation">
            <div class="navbar-header">
                <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                    <i class="fa fa-reorder"></i>
                </button>
                <a href="index.jsp" class="navbar-brand">Imov</a>
            </div>
            <div class="navbar-collapse collapse" id="navbar">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Locação de imóvel <span class="caret"></span></a>
                        <ul role="menu" class="dropdown-menu">
                            <li><a href="imovel_localizar.jsp">Imóvel</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Menu item <span class="caret"></span></a>
                        <ul role="menu" class="dropdown-menu">
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Menu item <span class="caret"></span></a>
                        <ul role="menu" class="dropdown-menu">
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Menu item <span class="caret"></span></a>
                        <ul role="menu" class="dropdown-menu">
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                        </ul>
                    </li>

                </ul>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <a href="login.html">
                            <i class="fa fa-sign-out"></i> Log out
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        </div>
 		<div class="wrapper wrapper-content">
            <div class="container">
        	  	<input type="hidden" id="tpMensagem" name="tpMensagem" value=""/>
         		<input type="hidden" id="dsMensagem" name="dsMensagem" value=""/>
         		<input type="hidden" id="dsRedirect" name="dsRedirect" value=""/>
            	<jsp:doBody/>
        	</div>
        	<div class="footer">
            	<div class="pull-right">
               		10GB of <strong>250GB</strong> Free.
            	</div>
            	<div>
                	<strong>Copyright</strong> Rodrigo Calheiros &copy; 2014-2015
            	</div>
        	</div>

        </div>
	</div>
</div>
</body>
</html>