package bloodbanking;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class DonorForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DonorForm frame = new DonorForm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public DonorForm() {
        setTitle("Donation Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btn_backdash2 = new JButton("Back");
        btn_backdash2.setFont(new Font("Arial", Font.PLAIN, 10));
        btn_backdash2.setBounds(0, 0, 75, 15);
        contentPane.add(btn_backdash2);

        // ActionListener for navigating back to Dashboard
        btn_backdash2.addActionListener(e -> {
            Dashboard dashboard = new Dashboard(); // Create a new instance of Dashboard
            dashboard.setVisible(true);            // Make Dashboard visible
            dispose();                             // Close the current frame
        });
    }
}
