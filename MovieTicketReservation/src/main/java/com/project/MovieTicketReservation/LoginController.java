package com.project.MovieTicketReservation;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

@Component
public class LoginController {
	@FXML
	public Label congratsLabel;
	@FXML
	public Button buttolLabel;
	
	public void congrats(ActionEvent event) {
		this.congratsLabel.setText("Congrats, Lina!");
	}
}
