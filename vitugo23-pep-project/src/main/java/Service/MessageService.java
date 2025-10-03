package Service;

import DAO.MessageDAO;
import Model.Message;
import java.util.List;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public Message createMessage(Message message) {
        // Check for null message
        if (message == null) {
            return null;
        }

        // Validate message text (not null, not blank, not too long)
        if (message.getMessage_text() == null || 
            message.getMessage_text().trim().isEmpty() || 
            message.getMessage_text().length() > 254) {
            return null;
        }

        return messageDAO.createMessage(message);
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Message getMessageById(int messageId) {
        return messageDAO.getMessageById(messageId);
    }

    public boolean deleteMessage(int messageId) {
        Message message = messageDAO.getMessageById(messageId);
        if (message != null) {
            return messageDAO.deleteMessage(messageId);
        }
        return false;
    }

    public Message updateMessage(int messageId, String newText) {
        // Validate new text
        if (newText == null || newText.trim().isEmpty() || newText.length() > 254) {
            return null;
        }
        
        Message existingMessage = messageDAO.getMessageById(messageId);
        if (existingMessage == null) {
            return null;
        }

        return messageDAO.updateMessage(messageId, newText);
    }

    public List<Message> getMessagesByUserId(int userId) {
        return messageDAO.getMessagesByUserId(userId);
    }
}