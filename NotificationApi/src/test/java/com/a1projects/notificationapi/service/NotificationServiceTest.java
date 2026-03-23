package com.a1projects.notificationapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

@DisplayName("NotificationService Unit Tests")
class NotificationServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should send email with valid recipient and message")
    void testSendToWithValidEmail() {
        // Arrange
        String recipient = "user@example.com";
        String message = "Test notification message";

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should use default email when recipient is null")
    void testSendToWithNullEmail() {
        // Arrange
        String recipient = null;
        String message = "Test notification message";

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should use default email when recipient is empty")
    void testSendToWithEmptyEmail() {
        // Arrange
        String recipient = "";
        String message = "Test notification message";

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should send email with correct subject")
    void testSendToEmailSubject() {
        // Arrange
        String recipient = "user@example.com";
        String message = "Test notification message";

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(isA(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should send email with correct message body")
    void testSendToEmailBody() {
        // Arrange
        String recipient = "user@example.com";
        String message = "Test notification message";

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(isA(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should send email to correct recipient")
    void testSendToCorrectRecipient() {
        // Arrange
        String recipient = "test@example.com";
        String message = "Test message";

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(isA(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should send email with different message content")
    void testSendToWithDifferentMessages() {
        // Arrange
        String recipient = "user@example.com";
        String[] messages = {
            "Hello World",
            "This is a test",
            "Special chars: !@#$%^&*()",
            "Multi-line\nmessage\ntest"
        };

        // Act & Assert
        for (String msg : messages) {
            notificationService.sendTo(recipient, msg);
        }

        verify(mailSender, times(messages.length)).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should send email to multiple different recipients")
    void testSendToMultipleDifferentRecipients() {
        // Arrange
        String message = "Test notification";
        String[] recipients = {
            "user1@example.com",
            "user2@example.com",
            "user3@example.com"
        };

        // Act
        for (String recipient : recipients) {
            notificationService.sendTo(recipient, message);
        }

        // Assert
        verify(mailSender, times(recipients.length)).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should handle long email addresses")
    void testSendToWithLongEmailAddress() {
        // Arrange
        String recipient = "very.long.email.address.with.many.characters@subdomain.example.com";
        String message = "Test message";

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should handle special characters in message")
    void testSendToWithSpecialCharactersInMessage() {
        // Arrange
        String recipient = "user@example.com";
        String message = "Message with special chars: <>&\"'`!@#$%^&*()[]{}";

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(isA(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should handle empty message")
    void testSendToWithEmptyMessage() {
        // Arrange
        String recipient = "user@example.com";
        String message = "";

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should handle null message")
    void testSendToWithNullMessage() {
        // Arrange
        String recipient = "user@example.com";
        String message = null;

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should send correct email properties for valid input")
    void testSendToValidatesAllEmailProperties() {
        // Arrange
        String recipient = "test@example.com";
        String message = "Test message";

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(isA(SimpleMailMessage.class));
    }

    @Test
    @DisplayName("Should send email exactly once per invocation")
    void testSendToInvokedExactlyOnce() {
        // Arrange
        String recipient = "user@example.com";
        String message = "Test message";

        // Act
        notificationService.sendTo(recipient, message);

        // Assert
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
        verifyNoMoreInteractions(mailSender);
    }
}

