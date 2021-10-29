/**
 * Author: Nicolino Derilo
 * WHEN: October 2021
 * WHAT: Threaded Project 6,7,8
 */

package com.example.workshop6;

import java.sql.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 * this function will COUNT total number of rows for tables.
 */
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
