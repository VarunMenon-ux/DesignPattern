package PTBS;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Login extends JDialog{
    boolean mBExit = false;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JButton loginButton = new JButton();
    JButton buttonExit = new JButton();
    JTextField userNameText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JRadioButton buyerRadio = new JRadioButton();
    JRadioButton sellerRadio = new JRadioButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();

    private String userBox = null;

    public Login() {
        try {
            jbInit();
            setSize(300, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        jLabel1.setText("UserName");
        jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
        jLabel2.setText("Password");
        jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
        loginButton.setText("Login");
        loginButton.setBounds(new Rectangle(31, 212, 85, 28));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButton_actionPerformed(e);
            }
        });
        buttonExit.setText("Exit");
        buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonExit_actionPerformed(e);
            }
        });
        userNameText.setBounds(new Rectangle(119, 52, 144, 22));
        passwordText.setBounds(new Rectangle(118, 119, 147, 22));
        buyerRadio.setSelected(true);
        buyerRadio.setText("Buyer");
        buyerRadio.setBounds(new Rectangle(37, 164, 103, 26));
        sellerRadio.setText("Seller");
        sellerRadio.setBounds(new Rectangle(177, 162, 103, 26));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(loginButton, null);
        this.getContentPane().add(buttonExit, null);
        this.getContentPane().add(userNameText, null);
        this.getContentPane().add(passwordText, null);
        this.getContentPane().add(buyerRadio, null);
        this.getContentPane().add(sellerRadio, null);
        buttonGroup1.add(buyerRadio);
        buttonGroup1.add(sellerRadio);
    }

    void loginButton_actionPerformed(ActionEvent e) {
        Scanner scanner;
        UserInfoItem.USER_TYPE userType;
        mBExit = false;
        System.out.println("login clicked");
        try {
            if (buyerRadio.isSelected() == true)
            {
                userType = UserInfoItem.USER_TYPE.Buyer;
                File file = new File("buyInfo.txt");
                scanner = new Scanner(file);
                System.out.println("buyer selected");
            } else// instructor
            {
                userType = UserInfoItem.USER_TYPE.Seller; // 1 for instructor
                File file = new File("sellInfo.txt");
                scanner = new Scanner(file);
            }
            userBox = userNameText.getText();
            String passwordBox = new String(passwordText.getPassword());
            String loginName = null;
            String UserName = null, Password = null;
            while (scanner.hasNextLine()) {
                String user = scanner.nextLine();
                UserName = GetUserName(user);
                Password = GetPassword(user);
                System.out.println(userBox + "\n" + UserName);
                if (UserName.compareTo(userBox) == 0 && Password.compareTo(passwordBox) == 0)
                    loginName = UserName;
            }
            scanner.close();
            if (loginName != null) {
                this.setVisible(false);
            }
        } catch (Exception ee) {
            System.out.println(ee.toString());
        }

    }
    private String GetUserName(String aline) {
        int Sep = aline.lastIndexOf(':');
        return aline.substring(0, Sep);
    }

    /*
     * get the password from aline UserName:Password
     */
    private String GetPassword(String aline) {
        int Sep = aline.lastIndexOf(':');
        return aline.substring(Sep + 1, aline.length());
    }

    public String GetUserName() {
        return userBox;
    }

    public UserInfoItem.USER_TYPE GetUserType() {
        UserInfoItem.USER_TYPE userType;
        return userType;
    }

    public boolean isExit() {
        return mBExit;
    }

    void buttonExit_actionPerformed(ActionEvent e) {
        mBExit = true;
        setVisible(false);
    }
}

