package bloodbanking;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class ViewReq extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewReq frame = new ViewReq();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public ViewReq() {
        setTitle("View Request");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null); // Center the window on the screen
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JButton btn_backdash3 = new JButton("Back");
        btn_backdash3.setFont(new Font("Arial", Font.PLAIN, 10));
        btn_backdash3.setBounds(0, 0, 75, 15);
        contentPane.add(btn_backdash3);

        // ActionListener for the "Back" button
        btn_backdash3.addActionListener((ActionEvent e) -> {
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            dispose(); // Close the current frame
        });
    }
}
