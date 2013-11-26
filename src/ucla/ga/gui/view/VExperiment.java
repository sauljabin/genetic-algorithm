package ucla.ga.gui.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ucla.ga.gui.controller.CExperiment;
import net.miginfocom.swing.MigLayout;

public class VExperiment extends JFrame {

	private static final long serialVersionUID = 3534945320350243632L;

	private List<JButton> buttons;
	private JPanel pnlCentral;
	private JLabel lblLocale;
	private DefaultComboBoxModel<String> cmbModelSelectLocale;
	private JComboBox<String> cmbSelectLocale;
	private JButton btnRun;

	public VExperiment() {
		setLayout(new BorderLayout());
		setSize(260, 230);
		setResizable(false);
		setLocationRelativeTo(this);
		buttons = new ArrayList<JButton>();

		pnlCentral = new JPanel();
		pnlCentral.setLayout(new MigLayout());
		add(pnlCentral, BorderLayout.CENTER);

		lblLocale = new JLabel();
		pnlCentral.add(lblLocale, "width 120,  height 30");

		cmbModelSelectLocale = new DefaultComboBoxModel<String>();
		cmbSelectLocale = new JComboBox<String>(cmbModelSelectLocale);
		pnlCentral.add(cmbSelectLocale, "width 120,  height 30, wrap");
		
		btnRun = new JButton();
		pnlCentral.add(btnRun, "grow, span 2");
	}

	public void addListener(CExperiment listener) {
		for (JButton button : buttons) {
			button.addActionListener(listener);
		}
		addWindowListener(listener);
		cmbSelectLocale.addItemListener(listener);
	}

	public JLabel getLblLocale() {
		return lblLocale;
	}

	public DefaultComboBoxModel<String> getCmbModelSelectLocale() {
		return cmbModelSelectLocale;
	}

	public JButton getBtnRun() {
		return btnRun;
	}
}
