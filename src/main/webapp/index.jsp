<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/webjars/jquery/3.1.1/jquery.min.js" type="text/javascript"> </script>
        <script src="uf/js/listar_uf.js"></script>
        <script src="municipio/js/listar_municipio.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <hr>
        
        <select id="select_uf" name="id_uf"></select>
        <select id="select_mun"></select>
    </body>
</html>
