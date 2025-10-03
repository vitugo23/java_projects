package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private AccountRepository accountRepository;
    
    public Message createMessage(Message message) {
        // Check if message text is not blank and under 255 characters
        if (message.getMessageText() == null || message.getMessageText().trim().isEmpty() || 
            message.getMessageText().length() > 255) {
            return null;
        }
        
        // Check if the account exists
        if (!accountRepository.existsById(message.getPostedBy())) {
            return null;
        }
        
        return messageRepository.save(message);
    }
    
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    
    public Message getMessageById(Integer messageId) {
        return messageRepository.findById(messageId).orElse(null);
    }
    
    public List<Message> getMessagesByAccount(Integer accountId) {
        return messageRepository.findByPostedBy(accountId);
    }
    
    public Message deleteMessage(Integer messageId) {
        Message message = messageRepository.findById(messageId).orElse(null);
        if (message != null) {
            messageRepository.delete(message);
            return message;
        }
        return null;
    }
    
    /**
     * Updates a message's text and returns the number of rows affected
     * @param messageId The ID of the message to update
     * @param updatedMessage The new message content
     * @return 1 if the update was successful, 0 if it failed
     */
    public Integer updateMessage(Integer messageId, Message updatedMessage) {
        // Get the existing message
        Message existingMessage = messageRepository.findById(messageId).orElse(null);
        if (existingMessage == null) {
            return 0;
        }
        
        // Update the message text and save
        existingMessage.setMessageText(updatedMessage.getMessageText());
        messageRepository.save(existingMessage);
        return 1;
    }
}
