
<%@include file="../cabecalho.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Sistema de Com�rcio Eletr�nico
            <small>Admin</small>
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.jsp">�rea Administrativa</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Aqui vai o conte�do de apresenta��o
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            Console
        </div>
        <div class="panel-body">

            <div class="alert ">
                ${msg}
            </div>
            <form action="ConsoleCtl" method="post">
                
                <div class="col-lg-6">

                    
                    <div class="form-group">
                        <label>Id Console</label>
                        <input class="form-control" type="text" name="txtIdConsole" readonly value="${console.getIdConsole()}"/>
                    </div>
                    
                    <div class="form-group">
                        <label>N�mero de S�rie</label>
                        <input class="form-control" type="text" name="txtNumSerie" required value="${console.getNumSerie()}"/>
                    </div>
                    
                    <div class="form-group">
                        <label>Nome</label>
                        <input class="form-control" type="text" name="txtNome" required value="${console.getNome()}" />
                    </div>
                    
                    <div class="form-group">
                        <label>Marca</label>
                        <input class="form-control" type="text" name="txtMarca" required value="${console.getMarca()}" />
                    </div>
                    
                    <div class="form-group">
                        <label>Valor</label>
                        <input class="form-control" type="text" name="txtValor" required value="${console.getValor()}" />
                    </div>


                <button class="btn btn-primary btn-sm" type="submit">Salvar</button>
                
            </form>

        </div>


    </div>
</div>
<!-- /.row -->
<%@include file="../rodape.jsp" %>