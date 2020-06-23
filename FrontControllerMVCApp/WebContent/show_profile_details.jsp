<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <h1 style="color:red;text-align:center">Profile Information</h1>
    
    <table>
      <tr> <th> id </th><th>name</th><th>desg </th> <th>address </th> <th> DOB </th> <th> income</th> </tr>
      <tr> 
         <td>${profileInfo.id} </td>
         <td>${profileInfo.name } </td>
         <td>${profileInfo.desg } </td>
         
         <td>${profileInfo.addrs } </td>
          <td>${profileInfo.dob } </td>
         <td>${profileInfo.income } </td>
         </tr>
    </table>
     <br><br>
     <a href="index.jsp">home</a>
    