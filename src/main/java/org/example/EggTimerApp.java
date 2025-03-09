package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EggTimerApp extends Application {
    private TimerController timerController;
    private Label timeLabel;
    private Label calculatedTimeLabel;
    private ProgressBar progressBar;
    private ComboBox<String> eggTypeBox;
    private ComboBox<String> eggSizeBox;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("🥚Egg Timer🥚");

        timerController = new TimerController(this);

        eggTypeBox = new ComboBox<>();
        eggTypeBox.getItems().addAll("Soft-boiled", "Medium-boiled", "Hard-boiled");
        eggTypeBox.setValue("Soft-boiled");

        eggSizeBox = new ComboBox<>();
        eggSizeBox.getItems().addAll("Small", "Medium", "Large");
        eggSizeBox.setValue("Medium");

        calculatedTimeLabel = new Label("Estimated Time: 4:00");
        eggTypeBox.setOnAction(e -> updateTimeDisplay());
        eggSizeBox.setOnAction(e -> updateTimeDisplay());

        Button startButton = new Button("Start");
        startButton.setOnAction(e -> timerController.startTimer(eggTypeBox.getValue(), eggSizeBox.getValue()));

        Button stopButton = new Button("Stop");
        stopButton.setOnAction(e -> timerController.stopTimer());

        timeLabel = new Label("Time: 00:00");
        progressBar = new ProgressBar(0);

        VBox layout = new VBox(10, eggTypeBox, eggSizeBox, calculatedTimeLabel, startButton, stopButton, timeLabel, progressBar);
        layout.setAlignment(Pos.CENTER);

        primaryStage.setScene(new Scene(layout, 300, 250));
        primaryStage.show();
    }

    private void updateTimeDisplay() {
        int estimatedTime = TimerController.getEstimatedTime(eggTypeBox.getValue(), eggSizeBox.getValue());
        int minutes = estimatedTime / 60;
        int seconds = estimatedTime % 60;
        calculatedTimeLabel.setText(String.format("Estimated Time: %02d:%02d", minutes, seconds));
    }

    public void updateTime(String time, double progress) {
        timeLabel.setText("Time: " + time);
        progressBar.setProgress(progress);
    }

    public static void main(String[] args) {
        launch(args);
    }
}