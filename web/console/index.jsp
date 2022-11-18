<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Gerenciamento de Consoles

        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="../console/ConsoleCtl?action=list">Listagem</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> listagem de registros
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">

        <div class="panel-body">

            <a  href="add.jsp" class="btn  btn-primary btn-sm fa fa-plus-square-o" >Novo</a>

        </div>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">
        <form action="ConsoleCtl" method="get">
            <input type ="hidden" name="action" value="list"/>
            <div class="form-group input-group">
                <input type="text" class="form-control" name="txtFiltro" placeholder="digite aqui para a busca por nome...">
                <span class="input-group-btn"><button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button></span>
            </div>
        </form>
        <div class="panel-body">

          ${msg}
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nome</th>
                            <th>Marca</th>
                            <th>Valor</th>
                            <th >Ações</th>
                        </tr>
                    </thead>
                    <tbody>


                        <c:forEach items ="${consoles}" var="console" >
                            <tr>
                                <td>${console.numSerie}</td>
                                <td>${console.nome}</td> 
                                <td>${console.marca}</td> 
                                <td>${console.valor}</td>
                                <td>
                                    <a href="ConsoleCtl?action=upd&id=${console.idConsole}" class="btn  btn-primary btn-sm">Alterar</a>
                                    <a href="ConsoleCtl?action=del&id=${console.idConsole}" class="btn  btn-danger btn-sm">Excluir</a>
                                    <!--
                                    <button class="btn  btn-danger btn-sm" data-toggle="modal" data-target="#myModal" onclick="id =">Excluir</button>  
                                    -->
                                </td>
                            </tr>
                        </c:forEach>


                    </tbody>
                </table>

                <!-- /.table-responsive -->
            </div>

        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
</div>


<%@include file="../modalExcluir.jsp" %>
<%@include file="../rodape.jsp" %>
