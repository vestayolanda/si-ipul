<%@page import="entity.DaftarLapangan"%>
<%@page import="entity.lapangan"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Lapangan</title>
    </head>
    <body>
        <h1>Activity</h1>
        <a href ="logout">Logout</a>
        <a href ="edit-profil">Edit Profil</a>
        <a href ="activity">Activity</a>
        <a href ="list_lapangan">Daftar Lapangan</a>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Alamat</th>
                </tr>
            </thead>
            <tbody>
                <%
                Iterator<lapangan> i = (Iterator<lapangan>) request.getAttribute("daftar_lapangan");
                int no = 0;
                while(i.hasNext()){
                    lapangan lap = i.next();
                    //Pengunjung pengunjung = lap.getPengunjung();
                    no++;
                %>
                
                <tr>
                    <td><%=(no)%></td>
                    <td><%=(lap.getAddressLap())%></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </body>
   
</html>
