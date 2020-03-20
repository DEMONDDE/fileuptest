<%--
  Created by IntelliJ IDEA.
  User: 胡建德
  Date: 2020/3/20
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script>
      function check() {
        var file = document.getElementById("file").value;
        if(file.length==0||file==""){
          return false;
          alert("失败")
        }
        alert("成功")
        return true;
      }
    </script>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data" onsubmit="return check()">
      请选择文件:<input id="file" type="file" name="uploadfile" multiple="multiple">
      <input type="submit" value="上传">
    </form>

  <form action="${pageContext.request.contextPath}/one" >
    <input type="submit" value="test">
  </form>

  </body>
</html>
