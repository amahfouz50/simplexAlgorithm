/*
 *   I am Ahmed Reda Mahfouz
 *   Student at the Faculty of Computing and Information Menoufia University 
 *   Department of Computer Science
 *
 *   *       Please Visit us at www.github.com/amahfouz50     *
 *  This Program was Developed by www.github.com/amahfouz50 forums Team
 *  *           Please Don't Remove This Comment       *
 */  

/**
 *
 *   @author Ahmed Mahfouz
 */
package simplex;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sun.applet.Main;


public class simplex {

    /**
     * @param args the command line arguments22
     */
    public static void main(String[] args)  {
              try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       solver solve=new solver();
       solve.setSize(300, 200);
       solve.setTitle("Simplex (Ahmed Mahfouz) ");
       solve.setLocationRelativeTo(null);
       solve.setDefaultCloseOperation(3);
       solve.setVisible(true);
    }
}
