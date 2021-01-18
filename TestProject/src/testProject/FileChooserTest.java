package testProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FileChooserTest extends JFrame {
	private JTextField fileName = new JTextField(), dir = new JTextField();
	private JButton open = new JButton("Open"), save = new JButton("Save");
	public FileChooserTest() {
		JPanel p =new JPanel();
		open.addActionListener(new OpenL());
		p.add(open);
		save.addActionListener(new SaveL());
		p.add(save);
		add(p,BorderLayout.SOUTH);
		dir.setEditable(false);
		p=new JPanel();
		p.setLayout(new GridLayout(2,1));
		p.add(fileName);
		p.add(dir);
		add(p,BorderLayout.NORTH);
	}
	class OpenL implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser c = new JFileChooser();
			int rVal = c.showOpenDialog(FileChooserTest.this);
			if(rVal == JFileChooser.APPROVE_OPTION) {
				fileName.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().toString());
			}
			if(rVal==JFileChooser.CANCEL_OPTION) {
				fileName.setText("You Pressed cancel");
				dir.setText("");
			}
		}
	}
	class SaveL implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser c = new JFileChooser();
			int rVal = c.showSaveDialog(FileChooserTest.this);
			if(rVal == JFileChooser.APPROVE_OPTION) {
				fileName.setText(c.getSelectedFile().getName());
				dir.setText(c.getCurrentDirectory().toString());
			}
			if(rVal==JFileChooser.CANCEL_OPTION) {
				fileName.setText("You Pressed cancel");
				dir.setText("");
			}
		}
	}
	public static void main(String[] args) {
		FileChooserTest f = new FileChooserTest();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		//		f.setTitle(f.getClass().getSimpleName());
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(1200,700);
				f.setVisible(true);
			}
		});
		
	}
}
