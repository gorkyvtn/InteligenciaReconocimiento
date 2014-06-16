
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gvistin
 */
public class TomaDat {
    
      public DefaultTableModel loadFile(BufferedReader br) {
          DefaultTableModel r=new DefaultTableModel();
          r.setColumnCount(784);
        try {
            String line ;
           while ((line = br.readLine()) != null) {
              // System.out.println(line);
            String[] fields = line.split(";");
            Object[] d = new Object[fields.length];
            for(int i = 0; i < fields.length; i++) {
                    //System.out.println((i+1)+"++ "+fields[i]);
                    d[i]=Double.parseDouble(fields[i]);
                }
                 r.addRow(d);
                //line=br.readLine();
             }
            return r;
        } catch (IOException ex) {
            ex.toString();
        }
        return null;
    }
    
}
