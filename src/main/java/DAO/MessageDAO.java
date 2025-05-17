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

        return messages;
    }

    public Message inserMessage(Message newmesage)
    {
        return null;
    }

    public Message getMessageByID(int id)
    {
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
