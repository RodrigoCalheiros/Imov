<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:loginpage>
	<jsp:body>
	<div class="loginColumns animated fadeInDown">
        <div class="row">
            <div class="col-md-6">
            	<span><img alt="image" class="img-responsive" src="img/imov2.png" width="120"/></span>
                <p></p>
                <p>
                    Software de gestão imobiliária para controle de imóveis, aluguel, e custos.
                </p>
            </div>
            <div class="col-md-6">
                <div class="ibox-content">
                    <form class="m-t" id="formLogin" name="formLogin" action="javascript:efetuarLogin()" method="POST">
                        <div class="form-group">
                            <input type="email" id="dsEmailAcesso" name="dsEmailAcesso" class="form-control" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <input type="password" id="dsSenhaAcesso" name="dsSenhaAcesso" class="form-control" placeholder="Senha">
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
	</jsp:body>
</t:loginpage>
<script>

$(document).ready(function(){
	validateForm();
});

function validateForm(){
	$("#formImovelInserir").validate({
        rules: {
        	dsEmailAcesso: {
                required: true,
                email: true
            },
            dsSenhaAcesso: {
                required: true,
                min:4
            }
        }
    });
}

function efetuarLogin(){
	var jsonRetorno = executarAjax("POST", "rest/login", getJsonUsuarioLogin());
	if($("#tpMensagem").val() == 'success'){
        window.location.href = "/Imov2/index.jsp";
    } else {
    	dispararMensagem($("#tpMensagem").val(), $("#dsMensagem").val());
    }

}

function getJsonUsuarioLogin(){
	var jsonConteudo = {dsEmailAcesso: $("#dsEmailAcesso").val(),
						dsSenhaAcesso: $("#dsSenhaAcesso").val()
        	           };
	return jsonConteudo;
}
</script>