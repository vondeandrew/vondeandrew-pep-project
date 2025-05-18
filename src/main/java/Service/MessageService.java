package Service;

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

    
}
