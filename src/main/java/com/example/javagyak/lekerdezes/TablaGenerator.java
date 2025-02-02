package com.example.javagyak.lekerdezes;

import java.sql.*;

public class TablaGenerator {
    public String getTableHtml() throws SQLException {
        StringBuilder htmlTable = new StringBuilder();
        htmlTable.append("<table border='1'>");
        htmlTable.append("<tr><th>Hely ID</th><th>Település</th><th>Utca</th><th>Szerelő neve</th><th>Munkaóra</th><th>Anyagár</th></tr>");

        String url = "jdbc:mysql://localhost:3306/feladat";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT m.helyaz, h.telepules, h.utca, sz.nev, m.munkaora, m.anyagar " +
                             "FROM szerelo sz " +
                             "JOIN munkalap m ON sz.az = m.szereloaz " +
                             "JOIN hely h ON m.helyaz = h.az " +
                             "ORDER BY m.helyaz")) {

            while (rs.next()) {
                htmlTable.append("<tr>");
                htmlTable.append("<td>").append(rs.getInt("helyaz")).append("</td>");
                htmlTable.append("<td>").append(rs.getString("telepules")).append("</td>");
                htmlTable.append("<td>").append(rs.getString("utca")).append("</td>");
                htmlTable.append("<td>").append(rs.getString("nev")).append("</td>");
                htmlTable.append("<td>").append(rs.getInt("munkaora")).append("</td>");
                htmlTable.append("<td>").append(rs.getInt("anyagar")).append("</td>");
                htmlTable.append("</tr>");
            }
        }

        htmlTable.append("</table>");
        return htmlTable.toString();
    }
}
