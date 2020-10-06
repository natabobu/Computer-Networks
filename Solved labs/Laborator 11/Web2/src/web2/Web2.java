package web2;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.*;

public class Web2 extends JFrame implements HyperlinkListener {

    JEditorPane jep;
    private JButton b;
    private JTextField t;

    public Web2(String title) {
        Container contentPane = getContentPane();
        JPanel p=new JPanel();
        JPanel p1=new JPanel();
        p.setLayout(new GridLayout(2,1,10,10));
        p1.setLayout(new GridLayout(1,3,10,10));
        JLabel l=new JLabel("URL");
        p1.add(l);
        t=new JTextField(200);
        p1.add(t);
        b=new JButton("ok");
        b.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                bActionPerformed(evt);
            }
        });
        p1.add(b);
        contentPane.add(p);
        jep = new JEditorPane();
        jep.setEditable(false);
        jep.addHyperlinkListener(this);
       
        
        JScrollPane scrollPane = new JScrollPane(jep);
        p.add(scrollPane);
        p.add(p1);
    }
    private void bActionPerformed(java.awt.event.ActionEvent evt) { 
        String url=t.getText();
        try {
            jep.setPage(url);
        } catch (IOException ioe) {
            jep.setContentType("text/html");
            jep.setText("<html>Pagina nu a putut fi incarcata</html>");
        }
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent evt) {
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            try {
                jep.setPage(evt.getURL());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
