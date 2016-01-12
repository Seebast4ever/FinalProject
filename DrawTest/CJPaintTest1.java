import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CJPaintTest1 extends JComponent {
    
    public static class Line{
	private int x1, y1, x2, y2;
	private Color color;

	public Line(int x1, int y1, int x2, int y2, Color color) {
	    this.x1 = x1;
	    this.y1 = y1;
	    this.x2 = x2;
	    this.y2 = y2;
	    this.color = color;
	}
	
    }

    public void callRepaint() {
	repaint();
    }

    public static void main(String[]args) {
	JFrame testFrame = new JFrame();
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	CJPaintTest1 comp = new CJPaintTest1();
	testFrame.getContentPane().add(comp, BorderLayout.WEST);

	//panel for buttons
	JPanel buttonsPanel = new JPanel();
	JButton newLineButton = new JButton("New Line");
	buttonsPanel.add(newLineButton);
	buttonsPanel.add(clearButton);
	testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	newLineButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    
		}
	    }
	
    }
}

