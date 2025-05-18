package DAO;

import Model.Message;
import Model.Account;
import Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    public List<Message> getAllMessage()
    {
        List<Message> messages = new ArrayList<>();
        Connection newConnection = ConnectionUtil.getConnection();

        String request = "SELECT * FROM Message;";

        try{
            PreparedStatement newStatment = newConnection.prepareStatement(request);
            ResultSet rs = newStatment.executeQuery();

            while(rs.next())
            {
                Message newEntry = new Message(rs.getInt("message_id"), rs.getInt("posted_by"), rs.getString("message_text"), rs.getLong("time_posted_epoch"));
                messages.add(newEntry);
            }
        } catch(SQLException e) {

        }

        return messages;
    }

    public Message insertMessage(Message newmesage)
    {
        Connection newConnection = ConnectionUtil.getConnection();

        String request = "INSERT INTO Message(posted_by, message_text, time_posted_epoch) Values(?, ?, ?);";
        try{
        PreparedStatement preparedStatement = newConnection.prepareStatement(request);

        preparedStatement.setInt(1, newmesage.getPosted_by());
        preparedStatement.setString(2, newmesage.getMessage_text());
        preparedStatement.setLong(3, newmesage.getTime_posted_epoch());

        preparedStatement.executeUpdate();
        return newmesage;
        } catch (SQLException e)
        {

        }
        return null;
    }

    public Message getMessageByID(int id)
    {
        List<Message> messages = new ArrayList<>();
        Connection newConnection = ConnectionUtil.getConnection();

        String request = "SELECT * FROM Message WHERE message_id = ?;";

        try{
            PreparedStatement preparedStatement = newConnection.prepareStatement(request);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            Message returnMessage = new Message(rs.getInt("message_id"), rs.getInt("posted_by"), rs.getString("message_text"), rs.getLong("time_posted_epoch"));
            return returnMessage;
        } catch (SQLException e)
        {

        }
        return null;
    }

    public Message deleteMessageByID(int id)
    {
        return null;
    }

    public Message updateMessageByID(int id)
    {
        return null;
    }

    public List<Message> getAllMessagesByID(Account check)
    {
        return null;
    }
}
