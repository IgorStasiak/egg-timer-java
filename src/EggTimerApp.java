import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class EggTimerApp extends Application {

    private Label timerLabel;
    private Timeline timeline;
    private int timeLeft;

    @Override
    public void start(Stage primaryStage) {
        timerLabel = new Label("Wybierz stopień ugotowania");
        timerLabel.setStyle("-fx-font-size: 24px;");

        Button softButton = new Button("Jajko na miękko (5 min)");
        Button mediumButton = new Button("Jajko na półmiękko (7 min)");
        Button hardButton = new Button("Jajko na twardo (10 min)");

        softButton.setOnAction(e -> startTimer(300));
        mediumButton.setOnAction(e -> startTimer(420));
        hardButton.setOnAction(e -> startTimer(600));

        VBox root = new VBox(20, timerLabel, softButton, mediumButton, hardButton);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20px;");

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Egg Timer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startTimer(int seconds) {
        timeLeft = seconds;
        if (timeline != null) {
            timeline.stop();
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeLeft--;
            int minutes = timeLeft / 60;
            int secondsLeft = timeLeft % 60;
            timerLabel.setText(String.format("Pozostały czas: %02d:%02d", minutes, secondsLeft));

            if (timeLeft <= 0) {
                timeline.stop();
                timerLabel.setText("Gotowe!");
            }
        }));

        timeline.setCycleCount(seconds);
        timeline.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
