/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;



import controllers.Observer;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import models.User;

/**
 *
 * @author otsaan
 */
public class LoginFrame extends javax.swing.JFrame {

    private Vector<Observer> observers;
    
    
    public LoginFrame() {
        
        observers = new Vector<Observer>();
        
        
        initComponents();
        jPanel1.setVisible(true);
        password.addKeyListener(new KeyAdapter() {
            User user = new User();
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER ) {        
                    user.setUsername(usernameTextField.getText());
                    MessageDigest md5 = null;
                    try {
                        md5 = MessageDigest.getInstance("md5");
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    user.setPassword(new String(md5.digest(new String(password.getPassword()).getBytes())));
                    notifyObservers(user,"login");
                }
            } 
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        config = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        seConnecterLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        driver = new javax.swing.JTextField();
        url = new javax.swing.JTextField();
        port = new javax.swing.JTextField();
        dbUser = new javax.swing.JTextField();
        dbPassword = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medcinium");

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        config.setText("Config");
        config.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configMouseClicked(evt);
            }
        });
        mainPanel.add(config, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, -1, -1));

        usernameTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        usernameTextField.setBorder(null);
        mainPanel.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 265, 250, 30));

        password.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        password.setBorder(null);
        mainPanel.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 315, 250, 30));

        seConnecterLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        seConnecterLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seConnecterLabelMouseClicked(evt);
            }
        });
        mainPanel.add(seConnecterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 396, 140, 40));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/login.png"))); // NOI18N
        backgroundLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundLabelMouseClicked(evt);
            }
        });
        mainPanel.add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setText("Driver");

        jLabel2.setText("URL");

        jlabel3.setText("Utilisateur");

        jLabel4.setText("Port");

        jLabel5.setText("Mot de Passe");

        save.setText("Enregistrer");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        login.setText("Login");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(save)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jlabel3)
                            .addComponent(jLabel5))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(driver)
                            .addComponent(url)
                            .addComponent(port)
                            .addComponent(dbUser)
                            .addComponent(dbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(login)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(driver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel3)
                    .addComponent(dbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(save)
                .addGap(18, 18, 18)
                .addComponent(login)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backgroundLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundLabelMouseClicked

    }//GEN-LAST:event_backgroundLabelMouseClicked

    private void seConnecterLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seConnecterLabelMouseClicked
        
        User user = new User();
        user.setUsername(usernameTextField.getText());
         MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        user.setPassword(new String(md5.digest(new String(password.getPassword()).getBytes())));
        notifyObservers(user,"login");
    }//GEN-LAST:event_seConnecterLabelMouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        Properties prop = new Properties();
	OutputStream output = null;
 
	try {
 
		output = new FileOutputStream("config.properties");
 
		// set the properties value
		prop.setProperty("driver", driver.getText());
		prop.setProperty("url", url.getText());
		prop.setProperty("port", port.getText());
                prop.setProperty("dbUser", dbUser.getText());
                prop.setProperty("dbPassword", dbPassword.getText());
 
		// save properties to project root folder
		prop.store(output, null);
                 driver.setText("");
                 url.setText("");
                 port.setText("");
                 dbUser.setText("");
                 dbPassword.setText("");
	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
	}
    }//GEN-LAST:event_saveActionPerformed

    private void configMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configMouseClicked
        mainPanel.setVisible(false);
        jPanel1.setVisible(true);
        
    }//GEN-LAST:event_configMouseClicked

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        mainPanel.setVisible(true);
        jPanel1.setVisible(false);
    }//GEN-LAST:event_loginMouseClicked
    
    
    public void addObserver(Observer observer) {
       observers.add(observer);
    }
    
    public void notifyObservers(User user, String action ) {
        for (Observer observer : observers) {
            observer.execute(this, user,action);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel config;
    private javax.swing.JTextField dbPassword;
    private javax.swing.JTextField dbUser;
    private javax.swing.JTextField driver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel login;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField port;
    private javax.swing.JButton save;
    private javax.swing.JLabel seConnecterLabel;
    private javax.swing.JTextField url;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
