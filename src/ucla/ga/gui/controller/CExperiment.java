package ucla.ga.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import ucla.ga.app.Config;
import ucla.ga.app.Locale;
import ucla.ga.gui.view.VExperiment;

public class CExperiment implements ActionListener, WindowListener, ItemListener {

	private Locale locale;
	private Config config;
	private VExperiment vExperiment;

	public CExperiment() throws FileNotFoundException, IOException {

		config = new Config("resource/");
		config.load();

		locale = new Locale("resource/locale/");
		locale.load(config.get("LOCALE"));

		vExperiment = new VExperiment();
		initView();
		loadLocale();
		vExperiment.setVisible(true);
	}

	private void initView() {
		for (String string : locale.list()) {
			vExperiment.getCmbModelSelectLocale().addElement(string);
		}
		vExperiment.addListener(this);
	}

	private void loadLocale() {
		vExperiment.getLblLocale().setText(locale.get("lblLocale"));
		vExperiment.getCmbModelSelectLocale().setSelectedItem(config.get("LOCALE"));
		vExperiment.getBtnRun().setText(locale.get("btnRun"));
	}

	public void close() {
		vExperiment.dispose();
		System.exit(0);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		close();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}

	@Override
	public void windowIconified(WindowEvent arg0) {

	}

	@Override
	public void windowOpened(WindowEvent arg0) {

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		try {
			String loc = vExperiment.getCmbModelSelectLocale().getSelectedItem().toString();
			locale.load(loc);
			config.set("LOCALE", loc);
			loadLocale();
			config.save();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
