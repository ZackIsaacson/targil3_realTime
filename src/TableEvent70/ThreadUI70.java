package TableEvent70;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ThreadUI70 extends JFrame
{
	private JTextArea textArea;  
	private static int num=0;
	public ThreadUI70(String header)
	{
		super(header);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setLocation((num%3)*300+70,(num/3)*220+30);
		num++;
		textArea = new JTextArea(10, 23);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		add (scrollPane);
		pack();
		setVisible(true);
	}

	public void print(Object obj)
	{
		textArea.append(obj.toString());
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	public void println(Object obj)
	{
		textArea.append(obj.toString()+'\n');
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
}
