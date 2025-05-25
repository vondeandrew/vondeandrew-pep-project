package Service;

import Model.Account;
import Model.Message;
import DAO.AccountDAO;
import DAO.MessageDAO;

import java.sql.SQLException;
import java.util.List;

public class MessageService {
    public MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    public List<Message> getAllMessage()
    {
        return this.messageDAO.getAllMessage();
    }

    public Message insertMessage(Message newmesage)
    {
        String testString = newmesage.getMessage_text();
        if(testString.trim().equals("") || testString.length() > 255)
        {
            return null;
        }

        return this.messageDAO.insertMessage(newmesage);
    }

    public Message getMessageByID(int id)
    {
        return this.messageDAO.getMessageByID(id);
    }

    public Message deleteMessageByID(int id)
    {
        return this.messageDAO.deleteMessageByID(id);
    }

    public Message updateMessageByID(int id, String newMessage)
    {
        if(newMessage.trim().equals("") || newMessage.length() > 255 || getAllMessagesByID(id).isEmpty())
        
        {
            return null;
        }

        return this.messageDAO.updateMessageByID(id, newMessage);
    }

    public List<Message> getAllMessagesByID(int check)
    {
        return this.messageDAO.getAllMessagesByID(check);
    }
}
