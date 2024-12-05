package bloodbanking;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class RequestForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RequestForm frame = new RequestForm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public RequestForm() {
        setTitle("Request Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btn_backdash1 = new JButton("Back");
        btn_backdash1.setFont(new Font("Arial", Font.PLAIN, 10));
        btn_backdash1.setBounds(0, 0, 75, 15);
        contentPane.add(btn_backdash1);

        // ActionListener to navigate back to Dashboard
        btn_backdash1.addActionListener(e -> {
            Dashboard dashboard = new Dashboard(); // Create an instance of Dashboard
            dashboard.setVisible(true);            // Make it visible
            dispose();                             // Dispose of the current frame
        });
    }
}
