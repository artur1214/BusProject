<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.07.2018
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

вот вот вот
</body>
</html>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>s
<body>
<table border="1" width="100%" cellpadding="5">
    <%
        ArrayList users = new ArrayList();
        if (request.getAttribute("bot") != null){
            users = (ArrayList) request.getAttribute("users");

            //for (Object oRow : users.toArray()){
            for(int i=0; i < users.size(); i++){
                //ArrayList row = (ArrayList) oRow;
                ArrayList row = (ArrayList) users.get(i);
    %>
    <tr>
            <%
                //for(Object oCell : row.toArray()){
                for(int j=0; i < users.size(); i++){
                String cell = (String) row.get(j);
             %>
        <th>
            <%= cell %>
        </th>
            <% } %>

</table>
<% }
}
else out.print("что то не пришло");%>
</body>
</html>
