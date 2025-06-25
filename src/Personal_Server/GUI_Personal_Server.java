package Personal_Server;

// GUI class for the Personal Server interface
public class GUI_Personal_Server extends javax.swing.JFrame {

    // Constructor initializes UI and sets basic window properties
    public GUI_Personal_Server() {
        initComponents();
        setTitle("Personal Server"); // Set the window title
        setResizable(false); // Disable resizing
    }

    // Initializes the components and layout.
    private void initComponents() {

        // Component initialization
        jPanel1 = new javax.swing.JPanel(); // Header panel
        jLabel11 = new javax.swing.JLabel(); // Empty placeholder
        Badge = new javax.swing.JLabel(); // Title label
        jPanel2 = new javax.swing.JPanel(); // Main display panel
        tempLabel = new javax.swing.JLabel(); 
        oxText = new javax.swing.JTextField(); 
        heartRateLabel = new javax.swing.JLabel(); 
        oxygenLabel = new javax.swing.JLabel(); 
        tempText = new javax.swing.JTextField(); 
        heartText = new javax.swing.JTextField(); 
        jLabel2 = new javax.swing.JLabel(); // Image icon label

        // Configure window close operation and layout
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Header panel style
        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        // Title label setup
        Badge.setFont(new java.awt.Font("Oriya MN", 0, 30)); // Font size and style
        Badge.setForeground(new java.awt.Color(255, 255, 255)); // White text
        Badge.setText("Personal Server"); // Title text
        Badge.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR)); // Cursor style

        // Layout setup for header panel
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Badge)
                        .addGap(280, 280, 280))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Badge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 140));

        // Main panel (white background)
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 204, 204));

        // Temperature label
        tempLabel.setFont(new java.awt.Font("Oriya MN", 0, 18));
        tempLabel.setForeground(new java.awt.Color(0, 204, 204));
        tempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempLabel.setText("Temperature");

        // Blood oxygen text field (read-only)
        oxText.setBackground(new java.awt.Color(255, 255, 255));
        oxText.setColumns(2);
        oxText.setFont(new java.awt.Font("Oriya MN", 0, 15));
        oxText.setEditable(false);
        oxText.setCaretColor(oxText.getBackground());
        oxText.setForeground(new java.awt.Color(51, 51, 51));
        oxText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        oxText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));

        // Heart rate label
        heartRateLabel.setFont(new java.awt.Font("Oriya MN", 0, 18));
        heartRateLabel.setForeground(new java.awt.Color(0, 204, 204));
        heartRateLabel.setText("Heart Rate");

        // Blood oxygen label
        oxygenLabel.setFont(new java.awt.Font("Oriya MN", 0, 18));
        oxygenLabel.setForeground(new java.awt.Color(0, 204, 204));
        oxygenLabel.setText("Blood Oxygen ");

        // Temperature text field (read-only)
        tempText.setBackground(new java.awt.Color(255, 255, 255));
        tempText.setColumns(2);
        tempText.setFont(new java.awt.Font("Oriya MN", 0, 15));
        tempText.setEditable(false);
        tempText.setCaretColor(tempText.getBackground());
        tempText.setForeground(new java.awt.Color(51, 51, 51));
        tempText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tempText.setToolTipText("");
        tempText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));
        tempText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempTextActionPerformed(evt);
            }
        });

        // Heart rate text field (read-only)
        heartText.setBackground(new java.awt.Color(255, 255, 255));
        heartText.setColumns(2);
        heartText.setFont(new java.awt.Font("Oriya MN", 0, 15));
        heartText.setEditable(false);
        heartText.setCaretColor(heartText.getBackground());
        heartText.setForeground(new java.awt.Color(51, 51, 51));
        heartText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        heartText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));

        // Smartphone image icon
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/smartphone.png")));

        // Layout for the main panel (jPanel2)
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(oxygenLabel)
                    .addComponent(heartRateLabel)
                    .addComponent(tempLabel)
                    .addComponent(oxText, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addComponent(heartText)
                    .addComponent(tempText))
                .addGap(0, 54, Short.MAX_VALUE))
        );

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17)
                        .addComponent(tempLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tempText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37)
                        .addComponent(heartRateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(heartText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37)
                        .addComponent(oxygenLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(oxText, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 790, 330));

        // Set window size and center it
        setSize(new java.awt.Dimension(1116, 674));
        setLocationRelativeTo(null);

        // Pack components tightly
        pack();
    }

    // Placeholder action method (unused)
    private void tempTextActionPerformed(java.awt.event.ActionEvent evt) {
        // No logic implemented
    }

    // Public method to update temperature text field
    public void tempToString(String str){
        tempText.setText(str);
    }

    // Public method to update heart rate text field
    public void heartToString(String str){
       heartText.setText(str);
    }

    // Public method to update oxygen level text field
    public void oxToString(String str){
        oxText.setText(str);
    }

    // Main method to launch the GUI
    public static void main(String args[]) {

        try {
            // Use Nimbus Look and Feel if available
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Personal_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Launch the GUI on the Event Dispatch Thread
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Personal_Server().setVisible(true);
            }
        });
    }

    // Variable declaration
    private javax.swing.JLabel Badge, heartRateLabel, jLabel11, jLabel2, oxygenLabel, tempLabel;
    public javax.swing.JTextField heartText, oxText, tempText;
    private javax.swing.JPanel jPanel1, jPanel2;
}