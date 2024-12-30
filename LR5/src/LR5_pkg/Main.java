package LR5_pkg;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.*;

public class Main {

	public static void main(String[] args) {	

		JFrame mainFrame = new JFrame();
		mainFrame.setLocation(500, 300);
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new FlowLayout());
	
		mainFrame.add(new JLabel("Введите название файла:"));
		
		
		JTextField fileField;   
		JTextArea resultArea; 		
		JButton resultButton; 
		
		// Создание и добавление компонентов
		fileField = new JTextField(20);
		mainFrame.add(fileField);
		
		resultButton = new JButton("Открыть");
		mainFrame.add(resultButton);
		
		resultArea = new JTextArea(1,10);		
		resultArea.setEditable(false);
		mainFrame.add(resultArea);
		
		
		
		//Обработчик кнопки
		resultButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {					
					String file_name = fileField.getText();
					FileReader reader = new FileReader(file_name);
					int c;
					String data ="";
		            while((c=reader.read())!=-1) {		            	
		                System.out.print((char)c);
			            data=data+(char)c;
		            }
		            
		            resultArea.setText(data);
		            
		            		            
					//resultArea.setText("Содержимое файла выведено в консоль");
					reader.close();					
				} catch (IOException ex) {
					resultArea.setText(ex.getMessage());					
				} 		
			}
		});		

		mainFrame.setVisible(true);
	}
}
