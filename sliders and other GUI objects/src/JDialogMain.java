import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.UIManager;

/**
 *   file: JDialogMain.java
 */

/**
 * @author atmanning - atmanning@dbq.edu
 *
 */
public class JDialogMain extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JSlider sliderH;
	private JTextField textFieldSliderH;
	private JTextField textFieldSliderV;
	private JSlider sliderV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogMain dialog = new JDialogMain();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogMain() {
		setBounds(100, 100, 450, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			sliderH = new JSlider();
			sliderH.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					// this slider has been moved!
					JSlider me = (JSlider)e.getSource(); // object is a slider
					// update the value textbox
					textFieldSliderH.setText("" + me.getValue());
				}
			});
			sliderH.setMajorTickSpacing(20);
			sliderH.setMinorTickSpacing(10);
			sliderH.setPaintTicks(true);
			sliderH.setPaintLabels(true);
			sliderH.setBounds(12, 13, 275, 57);
			contentPanel.add(sliderH);
		}
		{
			sliderV = new JSlider();
			sliderV.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					
					JSlider me = (JSlider)e.getSource();
					
					// update matching textField
					textFieldSliderV.setText("" + me.getValue());
				}
			});
			
			textFieldSliderH = new JTextField();
			textFieldSliderH.setText("50");
			textFieldSliderH.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// get a handle
					JTextField me = (JTextField)e.getSource();
					
					sliderH.setValue(Integer.parseInt(me.getText())); 
				}
			});
			textFieldSliderH.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldSliderH.setBounds(286, 13, 50, 22);
			contentPanel.add(textFieldSliderH);
			textFieldSliderH.setColumns(10);
			sliderV.setMajorTickSpacing(25);
			sliderV.setMinorTickSpacing(10);
			sliderV.setBounds(12, 72, 74, 133);
			sliderV.setBackground(UIManager.getColor("Button.background"));
			sliderV.setToolTipText("slide me!");
			sliderV.setPaintTicks(true);
			sliderV.setPaintLabels(true);
			sliderV.setOrientation(SwingConstants.VERTICAL);
			sliderV.setForeground(Color.BLACK);
			contentPanel.add(sliderV);
		}
		{
			textFieldSliderV = new JTextField();
			textFieldSliderV.setText("50");
			textFieldSliderV.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JTextField me = (JTextField)e.getSource();
					
					// move slider to position
					sliderV.setValue(Integer.parseInt(me.getText()));
					
				}
			});
			textFieldSliderV.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldSliderV.setBounds(12, 212, 59, 22);
			contentPanel.add(textFieldSliderV);
			textFieldSliderV.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(168, 134, 97, 25);
			contentPanel.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(EXIT_ON_CLOSE);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public JTextField getTextFieldSliderV() {
		return textFieldSliderV;
	}
	public JSlider getSliderV() {
		return sliderV;
	}
}
