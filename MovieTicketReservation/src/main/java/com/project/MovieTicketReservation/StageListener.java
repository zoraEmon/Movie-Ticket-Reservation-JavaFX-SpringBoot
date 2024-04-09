package com.project.MovieTicketReservation;

import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

@Component
public class StageListener implements ApplicationListener<StageReadyEvent> {
	private final String applicationTitle;
	private final Resource fxml;
	private final ApplicationContext ac;
	
	StageListener(
			@Value("${spring.application.ui.title}") String applicationTitle,
			@Value("classpath:/login.fxml") Resource resource, ApplicationContext ac ) {
		
		this.applicationTitle = applicationTitle;
		this.fxml = resource;
		this.ac = ac;
	}
	@Override
	public void onApplicationEvent(StageReadyEvent stageReadyEvent) {
		try {
			Stage stage = stageReadyEvent.getStage();
			URL url = this.fxml.getURL();
			FXMLLoader fxmlLoader = new FXMLLoader(url);
			fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
				
				@Override
				public Object call(Class<?> aClass) {
					return ac.getBean(aClass);
				}
			});
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root, 600, 600);
			stage.setScene(scene);
			stage.setTitle(this.applicationTitle);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
