// Auteurs: Kriza Lacsamana et Sylvain Pouliot; Gr.427
package projetfinal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;


public class ResultatPanel extends JPanel {
    
    JTextArea taInfo;
    JLabel lblMessage;
    
    ResultatPanel(){
        
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        setBackground(Color.WHITE);
        
        taInfo = new JTextArea();
        taInfo.setBounds(20, 5, 240, 250);
        //taInfo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        add(taInfo);
        
        lblMessage = new JLabel("Bon camping!");
        lblMessage.setBounds(75, 250, 200, 100);
        lblMessage.setForeground(Color.MAGENTA);
        lblMessage.setFont(new Font("Arial", Font.PLAIN, 20));
        add(lblMessage);
        
        ImageIcon imageCamping = new ImageIcon("resources/camping1.png");
        JLabel image = new JLabel();
        image.setIcon(imageCamping);
        image.setBounds(40, 320, 200, 200);
        add(image); 
        
        setVisible(false);
        
    }
    
}
