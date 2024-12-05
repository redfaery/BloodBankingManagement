package bloodbanking;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class ViewDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDon frame = new ViewDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewDon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Ruby Files\\Bloodbank\\blood-donation-logo_23-2147506524-removebg-preview.ico"));
		setTitle("View Donation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JButton btn_backdash4 = new JButton("Back");
        btn_backdash4.setFont(new Font("Arial", Font.PLAIN, 10));
        btn_backdash4.setBounds(0, 0, 75, 15);
        contentPane.add(btn_backdash4);

        // ActionListener for the "Back" button
        btn_backdash4.addActionListener((ActionEvent e) -> {
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            dispose(); // Close the current frame
        });
	}

}
