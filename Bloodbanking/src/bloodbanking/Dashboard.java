package bloodbanking;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panel_dash;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Dashboard frame = new Dashboard();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Dashboard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 919, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        panel_dash = new JPanel();
        panel_dash.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_dash.setBackground(new Color(255, 182, 193));

        JButton btn_viewreq = new JButton("View Requestors");
        btn_viewreq.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
        btn_viewreq.setBackground(new Color(255, 182, 193));
        btn_viewreq.addActionListener(e -> {
            ViewReq viewReq = new ViewReq();
            viewReq.setVisible(true);
            dispose();
        });

        JButton btn_viewdonor = new JButton("View Donors");
        btn_viewdonor.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
        btn_viewdonor.setBackground(new Color(255, 182, 193));
        btn_viewdonor.addActionListener(e -> {
            ViewDon viewDon = new ViewDon();
            viewDon.setVisible(true);
            dispose();
        });

        JButton btn_addreq = new JButton("Add Request");
        btn_addreq.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
        btn_addreq.setBackground(new Color(255, 182, 193));
        btn_addreq.addActionListener(e -> {
            RequestForm requestForm = new RequestForm();
            requestForm.setVisible(true);
            dispose();
        });

        JButton btn_donor = new JButton("Add Donor");
        btn_donor.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
        btn_donor.setBackground(new Color(255, 182, 193));
        btn_donor.addActionListener(e -> {
            DonorForm donorForm = new DonorForm();
            donorForm.setVisible(true);
            dispose();
        });

        JButton btn_Logout = new JButton("Logout");
        btn_Logout.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
        btn_Logout.setBackground(new Color(255, 182, 193));
        btn_Logout.addActionListener(e -> {
            ADR_page loginPage = new ADR_page();
            loginPage.setVisible(true);
            dispose();
        });

        JLabel lbl_time = new JLabel("time");
        JLabel lbl_date = new JLabel("date");

        GroupLayout gl_panel_dash = new GroupLayout(panel_dash);
        gl_panel_dash.setHorizontalGroup(
            gl_panel_dash.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_dash.createSequentialGroup()
                    .addGroup(gl_panel_dash.createParallelGroup(Alignment.LEADING)
                        .addComponent(btn_viewreq, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_viewdonor, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_addreq, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_donor, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Logout, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_panel_dash.createSequentialGroup()
                            .addGap(36)
                            .addGroup(gl_panel_dash.createParallelGroup(Alignment.TRAILING)
                                .addComponent(lbl_time, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_date, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panel_dash.setVerticalGroup(
            gl_panel_dash.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_dash.createSequentialGroup()
                    .addGap(36)
                    .addComponent(lbl_time, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbl_date, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addGap(29)
                    .addComponent(btn_viewreq, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_viewdonor, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_addreq, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_donor, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                    .addComponent(btn_Logout, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
        );
        panel_dash.setLayout(gl_panel_dash);

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(panel_dash, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(719, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(panel_dash, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );
        contentPane.setLayout(gl_contentPane);
    }
}
