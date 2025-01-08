package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessagesDAO {

    public static void createDbMessage(Messages message) {
        Conection db_connect = new Conection();

        try(Connection conection = db_connect.get_connection()) {

            PreparedStatement ps = null;
            try{
                    String query = "INSERT INTO messages (message, autor_message) VALUES (?,?)";
                    ps = conection.prepareStatement(query);
                    ps.setString(1, message.getMessage());
                    ps.setString(2, message.getAuthor_message());
                    ps.executeUpdate();
                System.out.println("Created message");
            }catch (SQLException ex) {
                System.out.println("here" + ex);
            }
        } catch (SQLException e) {
            System.out.println("here" + e);
        }

    }

    public static void readMessages() {
        Conection db_connect = new Conection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection conection = db_connect.get_connection()) {
            String query = "SELECT * FROM messages";

            ps = conection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_message"));
                System.out.println("Message: " + rs.getString("message"));
                System.out.println("Author: " + rs.getString("autor_message"));
                System.out.println("Date: " + rs.getString("message_date"));
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("Messages couldn't be retrieved");
            System.out.println("Here " + e);
        }

    }

    public static void deleteMessagesDb(int id_message) {
        Conection db_connect = new Conection();

        try(Connection conection = db_connect.get_connection()) {
            PreparedStatement ps = null;

            try {

                String query = "DELETE FROM messages WHERE id_message = ?";
                ps = conection.prepareStatement(query);
                ps.setInt(1, id_message);
                ps.executeUpdate();
                System.out.println("The message has been deleted");
            } catch (SQLException e) {
                System.out.println("Couldn't delete message");
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println("Couldn't delete message");
            System.out.println("Here " + e);
        }

    }

    public static void updateMessage(Messages message) {
        Conection db_connect = new Conection();

        try(Connection conection = db_connect.get_connection()) {

            PreparedStatement ps = null;

            try {
                String query = "UPDATE messages SET message = ? WHERE id_message = ?";
                ps = conection.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setInt(2, message.getId_message());
                ps.executeUpdate();

                System.out.println("The message was updated successfully");

            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("Couldn't update message");
            }

        } catch (SQLException e) {
            System.out.println("Here " + e);
        }

    }

}
