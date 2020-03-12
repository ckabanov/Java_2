package Lesson_4;

import javax.swing.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class My_Chat {

    private JPanel mainPanel;
    private JList<String> usersList;
    private JTextField messageTextField;
    private JButton Button;
    private JTextArea chatText;

    public My_Chat() {
        addListeners();
    }

    private void addListeners() {
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = messageTextField.getText().trim();
        if (message.isEmpty()) {
            return;
        }

        appendOwnMessage(message);
        String selectedUser = usersList.getSelectedValue();
        if (selectedUser != null) {
            appendMessage(selectedUser, message);
        }
        messageTextField.setText(null);
    }

    private void appendMessage(String sender, String message) {
        String formattedMessage = String.format("%s: %s%n", sender, message);
        chatText.append(formattedMessage);
    }


    private void appendOwnMessage(String message) {
        appendMessage("Я", message);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("КабанЧат");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new My_Chat().mainPanel);
        frame.setVisible(true);
    }

}