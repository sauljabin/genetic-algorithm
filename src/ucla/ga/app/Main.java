package ucla.ga.app;

import javax.swing.JOptionPane;

import ucla.ga.gui.controller.CExperiment;

public class Main {

	public static void main(String[] args) {
		try {
			new CExperiment();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}
