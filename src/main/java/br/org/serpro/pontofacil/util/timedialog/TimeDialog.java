package br.org.serpro.pontofacil.util.timedialog;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class TimeDialog extends JOptionPane {

	public static Date showTimeDialog(Component parentComponent, String message, String title) {

		JOptionPane optionPane = new JOptionPane();
		TimePanel horaPanel = new TimePanel();
		Object msg[] = { message, horaPanel };
		optionPane.setMessage(msg);
		optionPane.setInputValue(horaPanel);
		optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
		optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", new Locale("pt",
				"BR"));

		JDialog dialog = optionPane.createDialog(parentComponent, title);
		dialog.show();
		Object value = optionPane.getValue();

		if (value == null || !(value instanceof Integer)) {

			// Do nothing

		} else {
			int i = ((Integer) value).intValue();
			if (i == JOptionPane.CLOSED_OPTION) {

				// Do nothing

			} else if (i == JOptionPane.OK_OPTION) {
				TimePanel b = (TimePanel) optionPane.getInputValue();
				try {
					return sdf.parse(b.getTxtHora().getText());
				} catch (ParseException e) {
				}

			} else if (i == JOptionPane.CANCEL_OPTION) {

				// Do nothing

			}
		}

		return null;

	}

}
