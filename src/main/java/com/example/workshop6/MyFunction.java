package com.example.workshop6;

import java.sql.*;

public class MyFunction {

    public static int countData(String tableName) throws SQLException {
        int total = 0;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
        Statement st;

        st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(*) AS 'total' FROM "+tableName);
        while (rs.next()){
            total = rs.getInt(1);
        }
        return total;
    }
}
