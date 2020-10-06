package simpleweb;
import javax.management.openmbean.SimpleType;
import javax.swing.*;
import java.io.*;
import java.awt.*;
public class SimpleWeb extends JFrame{
    public SimpleWeb(String title){
        Container contentPane=getContentPane();
        JEditorPane jep=new JEditorPane();
        jep.setEditable(false);
        try{
            jep.setPage("http://localhost");
        }catch(IOException ioe){
            jep.setContentType("text/html");
            jep.setText("<html>Pagina nu a putut fi incarcata</html>");
        }
        JScrollPane scrollPane=new JScrollPane();
        contentPane.add(scrollPane);
    }
    
}
