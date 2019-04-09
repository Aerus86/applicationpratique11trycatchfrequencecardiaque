package applicationpratique11trycatchfrequencecardiaque;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame{
    private JPanel container = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();
    private JPanel panel6 = new JPanel();
    private JPanel panel7 = new JPanel();
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel();
    private JComboBox combo1 = new JComboBox();
    private JTextField jtf1 = new JTextField();
    private JTextField jtf2 = new JTextField();
    private JRadioButton radio1 = new JRadioButton("Perte de poids", true);
    private JRadioButton radio2 = new JRadioButton("Endurance", false);
    private JRadioButton radio3 = new JRadioButton("Performance", false);
    private JButton bouton1 = new JButton("Calculer");
    private JButton bouton2 = new JButton("Effacer");
    private JOptionPane jop1 = new JOptionPane();
    private JOptionPane jop2 = new JOptionPane();
    private JOptionPane jop3 = new JOptionPane();
    private int variablemin = 0;
    private int variablemax = 0;

    public Fenetre(){
        
        this.setTitle("Calcul de la fréquence caridque optimale");
        this.setSize(500, 270);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
        // container
        container.setLayout(new GridLayout(7,1));
        container.add(panel1);
        container.add(panel2);
        container.add(panel3);
        container.add(panel4);
        container.add(panel5);
        container.add(panel6);
        container.add(panel7);
        
        // Panel1
        panel1.add(combo1);
        combo1.setPreferredSize(new Dimension(460, 30));
        combo1.addItem("Veuillez choisir...");
        combo1.addItem("Femme");
        combo1.addItem("Homme");

        //panel2
        panel2.add(label1);
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
        label1.setText("    Spécifiez votre age:");
        
        //Panel3
        panel3.add(jtf1);
        jtf1.setPreferredSize(new Dimension(460, 30));
        
        //panel4
        panel4.add(radio1);
        panel4.add(radio2);
        panel4.add(radio3);
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
          
        //Grouper les boutons radio afin qu'il soient exclusiif les un par rapport aux autres
         ButtonGroup groupe = new ButtonGroup();
         groupe.add(radio1);
         groupe.add(radio2);
         groupe.add(radio3);
         
         //panel5
        panel5.add(label2);
        panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
        label2.setText("    Votre fréquence cardique conseillée:");
        
        //panel6
        panel6.add(jtf2);
        jtf2.setPreferredSize(new Dimension(460, 30));
        
        //panel7
        panel7.add(bouton1);
        bouton1.addActionListener(new bouton1Listener());
        panel7.add(bouton2); 
        bouton2.addActionListener(new bouton2Listener());

        this.setContentPane(container);
        this.setVisible(true);
        
    }
    
    
    class bouton1Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (combo1.getSelectedItem().equals("Veuillez choisir...")) { // cette ligne permet de tester l'était du combo1 afin qu'il ne soit pas dans "Veuillez choisir..."
                jop1.showMessageDialog(null, "Veuillez choisir votre sexe !", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                try{
                    Integer vAge = new Integer (jtf1.getText()); // on dois absolument mettre Integer et pas juste int sinon sa marche pas
                    if (vAge >49){
                        jop3.showMessageDialog(null, "Veuillez consulter un médecin avant tout effort !", "Message", JOptionPane.INFORMATION_MESSAGE); 
                    }
                    if (combo1.getSelectedItem().equals("Femme")){
                        if (radio1.isSelected()){
                        variablemin = ((226-vAge) * 60) /100;
                        variablemax = ((226-vAge) * 70) /100;
                        }
                        if (radio2.isSelected()){
                            variablemin = ((226-vAge) * 70) /100;
                            variablemax = ((226-vAge) * 80) /100;
                        }
                        if (radio3.isSelected()){
                            variablemin = ((226-vAge) * 80) /100;
                            variablemax = ((226-vAge) * 90) /100;
                        }
                        jtf2.setText("Entre " + variablemin  + " et " + variablemax + " battement par minute.");
                    }
                    else{
                        if (radio1.isSelected()){
                            variablemin = ((220-vAge) * 60) /100;
                            variablemax = ((220-vAge) * 70) /100;
                        }
                        if (radio2.isSelected()){
                            variablemin = ((220-vAge) * 70) /100;
                            variablemax = ((220-vAge) * 80) /100;
                        }
                        if (radio3.isSelected()){
                            variablemin = ((220-vAge) * 80) /100;
                            variablemax = ((220-vAge) * 90) /100;
                        }
                        jtf2.setText("Entre " + variablemin  + " et " + variablemax + " battement par minute.");
                    }
                    
                }
                catch (NumberFormatException exception){
                    jop2.showMessageDialog(null, "Veuillez saisir correctement votre age !", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    class bouton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            combo1.setSelectedItem("Veuillez choisir...");
            jtf1.setText(null);
            jtf2.setText(null);
            radio1.setSelected(true);
        }
    }
    
}
