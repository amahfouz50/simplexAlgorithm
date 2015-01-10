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
 * @author Ahmed Mahfouz
 */
package simplex;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.smartcardio.Card;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class solver extends JFrame implements ActionListener {

    JButton solve = new JButton("solve");
    JLabel c = new JLabel("number of constrain");
    JLabel c1 = new JLabel("number of variable");
    JTextField s = new JTextField();
    JTextField s1 = new JTextField();
    JPanel x = new JPanel();
    JPanel x1 = new JPanel();

    public solver() {
        x.setLayout(new GridLayout(2, 2, 10, 10));
        x.add(c);
        x.add(s);
        x.add(c1);
        x.add(s1);
        x1.add(solve, BorderLayout.CENTER);
        add(x, BorderLayout.NORTH);
        add(x1, BorderLayout.SOUTH);
        solve.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int flag = 0;
        if (e.getSource() == solve) {
            int numberconstrain = 0;
            int numbervalue = 0;
            try {
                numberconstrain = Integer.parseInt(s.getText());

            } catch (Exception NumberFormatException) {
                flag = 1;
                JOptionPane.showMessageDialog(null, "please enter nuber of constrain");
                setVisible(false);
                solver solve = new solver();
                solve.setSize(300, 200);
                solve.setLocationRelativeTo(null);
                solve.setDefaultCloseOperation(3);
                solve.setVisible(true);
            }
            try {
                numbervalue = Integer.parseInt(s1.getText());
            } catch (Exception NumberFormatException) {
                flag = 1;
                JOptionPane.showMessageDialog(null, "please enter nuber of variable");
                setVisible(false);
                solver solve = new solver();
                solve.setSize(300, 200);
                solve.setLocationRelativeTo(null);
                solve.setDefaultCloseOperation(3);
                solve.setVisible(true);
            }

            if (flag == 0) {

                if (numberconstrain <= 0 || numbervalue <= 1) {
                    if (numberconstrain <= 0) {
                        JOptionPane.showMessageDialog(null, "number of constrain is less than 1");
                    } else if (numbervalue <= 1) {
                        JOptionPane.showMessageDialog(null, "number of variable is less than 1");
                    } else {
                        JOptionPane.showMessageDialog(null, "number of constrain and variable is less than 1");
                    }
                    setVisible(false);
                    solver solve1 = new solver();
                    solve1.setSize(300, 200);
                    solve1.setLocationRelativeTo(null);
                    solve1.setDefaultCloseOperation(3);
                    solve1.setVisible(true);
                } else {
                    setVisible(false);
                    solve solve = new solve(numberconstrain, numbervalue);
                    solve.setSize(500, 500);
                    solve.setTitle("Simplex (Ahmed Mahfouz) ");
                    solve.setLocationRelativeTo(null);
                    solve.setDefaultCloseOperation(3);

                    solve.setVisible(true);
                }
            }
        }
    }

}
