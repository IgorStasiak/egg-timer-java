package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class TimerController {
    private EggTimerApp app;
    private Timeline timeline;
    private int secondsLeft;
    private int totalSeconds;

    public TimerController(EggTimerApp app) {
        this.app = app;
    }

    public void startTimer(String eggType, String eggSize) {
        if (timeline != null) {
            timeline.stop();
        }

        totalSeconds = getEstimatedTime(eggType, eggSize);
        secondsLeft = totalSeconds;

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateTimer()));
        timeline.setCycleCount(secondsLeft);
        timeline.play();
    }

    private void updateTimer() {
        secondsLeft--;
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;
        double progress = 1.0 - ((double) secondsLeft / totalSeconds);

        app.updateTime(String.format("%02d:%02d", minutes, seconds), progress);

        if (secondsLeft <= 0) {
            timeline.stop();
            SoundPlayer.playAlarm();
        }
    }

    public void stopTimer() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    public static int getEstimatedTime(String eggType, String eggSize) {
        int baseTime;
        switch (eggType) {
            case "Soft-boiled":
                baseTime = 240;
                break;
            case "Medium-boiled":
                baseTime = 360;
                break;
            case "Hard-boiled":
                baseTime = 600;
                break;
            default:
                baseTime = 240;
        }

        switch (eggSize) {
            case "Small":
                baseTime *= 0.9;
                break;
            case "Large":
                baseTime *= 1.1;
                break;
        }

        return (int) baseTime;
    }
}