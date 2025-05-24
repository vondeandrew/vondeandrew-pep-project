package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.Collections;
import java.util.List;

import org.h2.util.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    MessageService messServices;
    AccountService accountServices;

    public SocialMediaController() {
        this.messServices = new MessageService();
        this.accountServices = new AccountService();
    }
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.get("example-endpoint", this::exampleHandler);
        app.post("/register", this::creatAccount);
        app.post("/login", this::login);
        app.post("/messages", this::postMessageHandler);
        app.get("/messages", this::getAllMessagesHandler);
        app.get("/messages/{message_id}", this::getMessageByIDHandler);
        app.delete("/messages/{message_id}", this::deleteMessageByIDHandler);
        app.patch("/messages/{message_id}", this::updateMessagebyIDHandler);
        app.get("/accounts/{account_id}/messages", this::getMessageByID);

        return app;
    }

    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void exampleHandler(Context context) {
        context.json("sample text");
    }

    private void getAllMessagesHandler(Context ctx)
    {
        List<Message> messages = messServices.getAllMessage();
        ctx.json(messages);
    }

    private void creatAccount (Context ctx)
    {

    }

    private void postMessageHandler (Context ctx)
    {

    }

    private void getMessageByIDHandler (Context ctx)
    {
        String parm = ctx.pathParam("message_id");
        int idNum = Integer.parseInt(parm);
        ctx.json(messServices.getMessageByID(idNum));
    }

    private void deleteMessageByIDHandler (Context ctx)
    {
        String parm = ctx.pathParam("message_id");
        int idNum = Integer.parseInt(parm);
        Message deletedmessage = messServices.deleteMessageByID(idNum);

        if(deletedmessage != null)
        {
            ctx.json(deletedmessage);
        } else {
            
            ctx.json(Collections.emptyMap());
        }
        
    }

    private void updateMessagebyIDHandler (Context ctx)
    {

    }

    private void getMessageByID (Context ctx)
    {
        String parm = ctx.pathParam("account_id");
        int idNum = Integer.parseInt(parm);
        
        ctx.json(messServices.getAllMessagesByID(idNum));
    }

    private void login (Context ctx) throws JsonProcessingException
    {
        ObjectMapper newmapp = new ObjectMapper();
        Account newAccount = newmapp.readValue(ctx.body(), Account.class);
        Account logedIn = accountServices.login(newAccount.getUsername(), newAccount.getPassword());
        if(logedIn != null)
        {
            ctx.json(logedIn);  
        }
        else
        {
            ctx.status(401);
        }
    }
}