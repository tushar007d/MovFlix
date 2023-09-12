<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    </head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <body>
        <div class="container">
                
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>collection</th>
                    </tr>	
                </thead>
                
                <tbody>
                    <c:forEach items="${movie}" var="movie">
                        <tr>
                            <th>${movie.id}</th>
                            <th>${movie.name}</th>
                            <th>${movie.collection}</th>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>    
</html>