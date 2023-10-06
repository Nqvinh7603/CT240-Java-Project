/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.chatapp.view;

import com.chatapp.model.Account;
import com.chatapp.model.textMessage;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class ChatFrm extends javax.swing.JFrame {
    private Account account = new Account();
    private DataInputStream input;
    private DataOutputStream output;
    Thread receiverThread;
    // Tạo HashMap với khóa là tên người nhận tin nhắn và values là nội dung chat của người dùng hiện tại với khóa(người dùng dc chat chung)
    protected HashMap<String, String> messageContent = new HashMap<String, String>();
    /**
     * Creates new form ChatFrm
     */
    public ChatFrm(Account users, DataInputStream dis, DataOutputStream dos) {
        //Tạo luồng cho người vừa đăng nhập
         initComponents();
        labelUserName.setText(users.getUserName());
        account.setUserName(users.getUserName());
        account = users;
        input = dis;
        output = dos;
        //Tạo luồng cho người vừa đăng nhập
        receiverThread = new Thread(new ChatFrm.Receiver(dis));
        receiverThread.start();
        //panelAccount.setVisible(false);
    }
    private void autoScroll() {
        jScrollPane2.getVerticalScrollBar().setValue(jScrollPane2.getVerticalScrollBar().getMaximum());
    }

    public void setPassword(String pass) {
        account.setPassword(pass);
    }
    public void newMessage(String sender, String receiveString, String message, Boolean yourMessage) {
        textMessage tm = new textMessage(message, sender, receiveString, yourMessage);

        if (yourMessage == false && cbOnlineUsers.getSelectedItem().equals(sender) == false) {
            String tmp = messageContent.get(sender);
            messageContent.replace(sender, tmp + sender + ": " + message + "\n");
        } else if (yourMessage == false && sender.equals(cbOnlineUsers.getSelectedItem())) {
//            String v = chatWindow.getText();
//            chatWindow.setText(v + sender + ": " + message + "\n");

            tm.printMessage(sender, chatWindow);
            messageContent.replace(sender, chatWindow.getText());
        } else {
//            String v = chatWindow.getText();
//            chatWindow.setText(v + "You" + ": " + message + "\n");

            tm.printMessage(sender, chatWindow);
            messageContent.replace((String) cbOnlineUsers.getSelectedItem(), chatWindow.getText());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtChat = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbOnlineUsers = new javax.swing.JComboBox<>();
        labelChatWith = new javax.swing.JLabel();
        labelUserName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatWindow = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtChat.setBackground(new java.awt.Color(222, 222, 222));
        txtChat.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        txtChat.setForeground(new java.awt.Color(91, 90, 90));
        txtChat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChatActionPerformed(evt);
            }
        });
        txtChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChatKeyPressed(evt);
            }
        });

        btnSend.setBackground(new java.awt.Color(30, 30, 30));
        btnSend.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnSend.setForeground(new java.awt.Color(255, 255, 255));
        btnSend.setText("Send");
        btnSend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(222, 222, 222));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbOnlineUsers.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbOnlineUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online Users" }));
        cbOnlineUsers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbOnlineUsers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOnlineUsersItemStateChanged(evt);
            }
        });

        labelChatWith.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelChatWith.setText("Chat with");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(labelChatWith, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(cbOnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelChatWith, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelUserName.setFont(new java.awt.Font("Bahnschrift", 1, 27)); // NOI18N
        labelUserName.setForeground(new java.awt.Color(91, 90, 90));

        jPanel4.setBackground(new java.awt.Color(222, 222, 222));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        chatWindow.setBackground(new java.awt.Color(222, 222, 222));
        chatWindow.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        chatWindow.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        chatWindow.setForeground(new java.awt.Color(91, 90, 90));
        jScrollPane2.setViewportView(chatWindow);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("CHAT APP");

        btnChangePassword.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnChangePassword.setForeground(new java.awt.Color(51, 51, 51));
        btnChangePassword.setText("Change Password");
        btnChangePassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(labelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtChat.getText().equals("") && cbOnlineUsers.getSelectedItem() != null) {
                Thread sendTextThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String messageSent = "Text" + "," + labelUserName.getText() + ","
                            + (String) cbOnlineUsers.getSelectedItem() + "," + txtChat.getText();

                            output.writeUTF(messageSent);
                            output.flush();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                            newMessage("ERROR", "ERROR", "Network error!", true);
                        }
                        newMessage(labelUserName.getText(), (String) cbOnlineUsers.getSelectedItem(), txtChat.getText(), true);
                        autoScroll();
                        txtChat.setText("");
                    }

                });
                sendTextThread.start();
            }
        }
    }//GEN-LAST:event_txtChatKeyPressed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (!txtChat.getText().equals("") && cbOnlineUsers.getSelectedItem() != null) {
            Thread sendTextThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String messageSent = "Text" + "," + labelUserName.getText() + ","
                        + (String) cbOnlineUsers.getSelectedItem() + "," + txtChat.getText();
                        output.writeUTF(messageSent);
                        output.flush();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        newMessage("ERROR", "ERROR", "Network error!", true);
                    }
                    newMessage(labelUserName.getText(), (String) cbOnlineUsers.getSelectedItem(), txtChat.getText(), true);
                    autoScroll();
                    txtChat.setText("");
                }

            });
            sendTextThread.start();
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void cbOnlineUsersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOnlineUsersItemStateChanged
        chatWindow.setText("");
        for (String i : messageContent.keySet()) {
            if (i.equals(cbOnlineUsers.getSelectedItem())) {
                chatWindow.setText(messageContent.get(i));
            }
        }
    }//GEN-LAST:event_cbOnlineUsersItemStateChanged

    private void txtChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChatActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        ChangePasswordFrm jframe = new ChangePasswordFrm(this, account, input, output);
        jframe.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnChangePasswordActionPerformed
    class Receiver implements Runnable {

        private DataInputStream input;

        public Receiver(DataInputStream dis) {
            this.input = dis;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // Chờ thông điệp từ server
                    String[] messageReceived = input.readUTF().split(",");

                    if (messageReceived[0].equals("Text")) {
                        // Nhận một tin nhắn văn bản
                        String sender = messageReceived[1];
                        String receiver = messageReceived[2];
                        String message = messageReceived[3];
                        // In tin nhắn lên màn hình chat với người gửi
                        newMessage(sender, receiver, message, false);
                        autoScroll();

                    } else if (messageReceived[0].equals("File")) {
                        // Nhận một file
                        String sender = messageReceived[1];
                        String receiver = messageReceived[2];
                        String filename = messageReceived[3];
                        int size = Integer.parseInt(messageReceived[4]);
                        int bufferSize = 2048;
                        byte[] buffer = new byte[bufferSize];
                        ByteArrayOutputStream file = new ByteArrayOutputStream();

                        while (size > 0) {
                            input.read(buffer, 0, Math.min(bufferSize, size));
                            file.write(buffer, 0, Math.min(bufferSize, size));
                            size -= bufferSize;
                        }

                        

                    } else if (messageReceived[0].equals("Online users")) {
                        // Nhận yêu cầu cập nhật danh sách người dùng trực tuyến
                        String[] users = input.readUTF().split(",");

                        String chat = (String) cbOnlineUsers.getSelectedItem();
                        cbOnlineUsers.removeAllItems();
                        boolean isChattingOnline = false;

                        for (String u : users) {
                            if (u.equals(account.getUserName()) == false) {
                                // Cập nhật danh sách các người dùng trực tuyến vào ComboBox onlineUsers (trừ bản thân)
                                cbOnlineUsers.addItem(u);
                                if (messageContent.get(u) == null) {
                                    messageContent.put(u, "");
                                }
                            }
                            if ((chat != null) && chat.equals(u)) {
                                isChattingOnline = true;
                            }
                        }
                        if (isChattingOnline == true) {
                            cbOnlineUsers.setSelectedItem(chat);
                        } else if (cbOnlineUsers.getSelectedItem() != null) {
                            cbOnlineUsers.setSelectedIndex(0);
                        }
                        cbOnlineUsers.validate();
                    }

                }

            } catch (IOException ex) {
                System.err.println(ex);
            } finally {
                try {
                    if (input != null) {
                        input.close();
                    } else {
                        System.out.println("Have redundant data...");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ChatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChatFrm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnSend;
    private javax.swing.JComboBox<String> cbOnlineUsers;
    private javax.swing.JTextPane chatWindow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelChatWith;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JTextField txtChat;
    // End of variables declaration//GEN-END:variables
}
