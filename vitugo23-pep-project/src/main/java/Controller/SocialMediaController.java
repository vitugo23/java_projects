package Controller;

import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;
import DAO.AccountDAO;
import DAO.MessageDAO;
import io.javalin.Javalin;
import io.javalin.http.Context;
import java.util.List;

public class SocialMediaController {
    private AccountService accountService;
    private MessageService messageService;

    public SocialMediaController() {
        this.accountService = new AccountService(new AccountDAO());
        this.messageService = new MessageService(new MessageDAO());
    }

    public Javalin startAPI() {
        Javalin app = Javalin.create();
        
        app.post("/register", this::registerUser);
    app.post("/login", this::loginUser);
    app.post("/messages", this::createMessage);
    app.get("/messages", this::getAllMessages);
    app.get("/messages/{message_id}", this::getMessageById);
    app.delete("/messages/{message_id}", this::deleteMessage);
    app.patch("/messages/{message_id}", this::updateMessage);
    app.get("/accounts/{account_id}/messages", this::getMessagesByUser);

    // Remove the app.start(8080) from here
    return app;
}

    private void registerUser(Context ctx) {
        Account account = ctx.bodyAsClass(Account.class);
        Account registeredAccount = accountService.registerUser(account.getUsername(), account.getPassword());
        
        if (registeredAccount != null) {
            ctx.json(registeredAccount);
            ctx.status(200);
        } else {
            ctx.status(400);
        }
    }

    private void loginUser(Context ctx) {
        Account account = ctx.bodyAsClass(Account.class);
        Account loggedInAccount = accountService.loginUser(account.getUsername(), account.getPassword());
        
        if (loggedInAccount != null) {
            ctx.json(loggedInAccount);
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    }

    private void createMessage(Context ctx) {
        Message message = ctx.bodyAsClass(Message.class);
        Message createdMessage = messageService.createMessage(message);
        
        if (createdMessage != null) {
            ctx.json(createdMessage);
            ctx.status(200);
        } else {
            ctx.status(400);
            ctx.result("");  // Empty response body for 400 status
        }
    }

    private void getAllMessages(Context ctx) {
        List<Message> messages = messageService.getAllMessages();
        ctx.json(messages);
        ctx.status(200);
    }

    private void getMessageById(Context ctx) {
        int messageId = Integer.parseInt(ctx.pathParam("message_id"));
        Message message = messageService.getMessageById(messageId);
        
        if (message != null) {
            ctx.json(message);
            ctx.status(200);
        } else {
            ctx.status(200);  // Return 200 even when no message found
            ctx.json("");     // Empty response body
        }
    }

    private void deleteMessage(Context ctx) {
        int messageId = Integer.parseInt(ctx.pathParam("message_id"));
        Message deletedMessage = messageService.getMessageById(messageId);
        
        if (deletedMessage != null && messageService.deleteMessage(messageId)) {
            ctx.json(deletedMessage);
            ctx.status(200);
        } else {
            ctx.status(200);  // Return 200 even when no message found
            ctx.json("");     // Empty response body
        }
    }

    private void updateMessage(Context ctx) {
        int messageId = Integer.parseInt(ctx.pathParam("message_id"));
        Message message = ctx.bodyAsClass(Message.class);
        Message updatedMessage = messageService.updateMessage(messageId, message.getMessage_text());
        
        if (updatedMessage != null) {
            ctx.json(updatedMessage);
            ctx.status(200);
        } else {
            ctx.status(400);
            ctx.result("");  // Empty response body for 400 status
        }
    }

    private void getMessagesByUser(Context ctx) {
        int accountId = Integer.parseInt(ctx.pathParam("account_id"));
        List<Message> messages = messageService.getMessagesByUserId(accountId);
        ctx.json(messages);
        ctx.status(200);
    }
}