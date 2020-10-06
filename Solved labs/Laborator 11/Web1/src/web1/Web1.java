package web1;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.*;

public class Web1 extends JFrame implements HyperlinkListener {

    JEditorPane jep;

    public Web1(String title) {
        Container contentPane = getContentPane();
        jep = new JEditorPane();
        jep.setEditable(false);
        jep.addHyperlinkListener(this);
        try {
            jep.setPage("http://localhost");
        } catch (IOException ioe) {
            jep.setContentType("text/html");
            jep.setText("<html>Pagina nu a putut fi incarcata</html>");
        }
        JScrollPane scrollPane = new JScrollPane(jep);
        contentPane.add(scrollPane);
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
