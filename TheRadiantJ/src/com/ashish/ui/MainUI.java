package com.ashish.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JButton;

import com.ashish.FileReader;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JList;

public class MainUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{694, 0};
		gridBagLayout.rowHeights = new int[]{14, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblMorphologicalAnalyzerFor = new JLabel("Morphological Analyzer for Malayalam");
		GridBagConstraints gbc_lblMorphologicalAnalyzerFor = new GridBagConstraints();
		gbc_lblMorphologicalAnalyzerFor.insets = new Insets(0, 0, 5, 0);
		gbc_lblMorphologicalAnalyzerFor.anchor = GridBagConstraints.NORTH;
		gbc_lblMorphologicalAnalyzerFor.gridx = 0;
		gbc_lblMorphologicalAnalyzerFor.gridy = 0;
		frame.getContentPane().add(lblMorphologicalAnalyzerFor, gbc_lblMorphologicalAnalyzerFor);
		
		JLabel lblAshishMathew = new JLabel("Ashish Mathew");
		GridBagConstraints gbc_lblAshishMathew = new GridBagConstraints();
		gbc_lblAshishMathew.insets = new Insets(0, 0, 5, 0);
		gbc_lblAshishMathew.gridx = 0;
		gbc_lblAshishMathew.gridy = 1;
		frame.getContentPane().add(lblAshishMathew, gbc_lblAshishMathew);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		frame.getContentPane().add(panel, gbc_panel);
		
	
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileReader.main(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel.add(btnImport);
		

	}

}
