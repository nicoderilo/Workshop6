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

//    String user = "nderilo28@gmail.com";
//    String pass ="156723pdnejoh";

    //SendMail
//    public MyFunction(String to, String sub, String msg) {
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth","true");
//        properties.put("mail.smtp.starttls.enable","true");
//        properties.put("mail.smtp.host","smtp.gmail.com");
//        properties.put("mail.smtp.port","587");
//        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
//        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
//            protected javax.mail.PasswordAuthentication getPasswordAuthentication()
//            {
//                return new javax.mail.PasswordAuthentication(user, pass);
//            }
//        });
//
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(user));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            message.setSubject(sub);
//            message.setText(msg);
//
//            Transport.send(message);
//            System.out.println("Message Sent");
//        } catch (MessagingException e) {
//            System.out.println(e);
//        }
//    }


}
