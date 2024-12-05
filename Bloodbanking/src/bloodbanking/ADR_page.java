package bloodbanking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.PreparedStatement;

public class ADR_page extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txt_un;
    private JPasswordField txt_pw;

    // Database connection object
    private DatabaseConnect dbCon = new DatabaseConnect();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ADR_page frame = new ADR_page();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ADR_page() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Ruby Files\\Bloodbank\\e8828d05c16c11f1339895546bba49ea-removebg-preview.png"));
        setTitle("Blood Banking Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 470, 255);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel lbl_bbm = new JLabel("Blood Banking Management");
        lbl_bbm.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lbl_bbm.setBounds(83, 11, 314, 33);
        contentPane.add(lbl_bbm);

        JLabel lbl_pw = new JLabel("Password");
        lbl_pw.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
        lbl_pw.setBounds(77, 116, 76, 14);
        contentPane.add(lbl_pw);

        JLabel lbl_un_1 = new JLabel("Username");
        lbl_un_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
        lbl_un_1.setBounds(77, 91, 76, 14);
        contentPane.add(lbl_un_1);

        txt_un = new JTextField();
        txt_un.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
        txt_un.setBounds(153, 88, 191, 20);
        contentPane.add(txt_un);
        txt_un.setColumns(10);

        txt_pw = new JPasswordField();
        txt_pw.setFont(new Font("Segoe UI Variable", Font.PLAIN, 12));
        txt_pw.setBounds(153, 113, 191, 20);
        contentPane.add(txt_pw);

        JLabel lbl_login = new JLabel("User Login");
        lbl_login.setFont(new Font("Arial", Font.BOLD, 15));
        lbl_login.setBounds(207, 55, 96, 23);
        contentPane.add(lbl_login);

        JRadioButton btn_showpass = new JRadioButton("Show password");
        btn_showpass.setBackground(Color.WHITE);
        btn_showpass.setFont(new Font("Calibri", Font.PLAIN, 10));
        btn_showpass.setBounds(153, 137, 191, 23);
        btn_showpass.addActionListener(e -> {
            if (btn_showpass.isSelected()) {
                txt_pw.setEchoChar((char) 0);
            } else {
                txt_pw.setEchoChar('*');
            }
        });
        contentPane.add(btn_showpass);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(153, 167, 191, 25);
        btnLogin.addActionListener(e -> login());
        contentPane.add(btnLogin);
    }

    /**
     * Method to handle login logic and navigate to Dashboard on success.
     */
    public void login() {
        String username = txt_un.getText().trim();
        String password = new String(txt_pw.getPassword()).trim();

        try {
            dbCon.connect();

            String select = "SELECT * FROM bloodbank_admins WHERE username = ?";
            PreparedStatement prep = dbCon.con.prepareStatement(select);
            prep.setString(1, username);

            dbCon.result = prep.executeQuery();

            if (dbCon.result.next()) {
                String dbPassword = dbCon.result.getString("password");
                if (dbPassword.equals(password)) {
                    JOptionPane.showMessageDialog(this, "Login Successful", "Login", JOptionPane.INFORMATION_MESSAGE);

                    // Navigate to Dashboard
                    Dashboard dashboard = new Dashboard();
                    dashboard.setVisible(true);
                    this.dispose(); // Close the current login window
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect Username/Password", "Login", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username/Password", "Login", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while logging in. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (dbCon.result != null) dbCon.result.close();
            } catch (Exception ignored) {
            }
        }
    }
}
