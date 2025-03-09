# 🥚 Egg Timer ⏳

Egg Timer is a simple JavaFX application that helps you cook eggs perfectly! Choose the desired **doneness** (Soft, Medium, Hard) and **size** (Small, Medium, Large), and the timer will count down while displaying the remaining time.

## 🚀 Features
- Select egg doneness: **Soft, Medium, Hard**
- Select egg size: **Small, Medium, Large**
- Visual countdown timer with progress bar
- **Alarm sound** when the eggs are ready
- Simple, clean **JavaFX UI**
- Supports **Java 17+**

## 📥 Installation
### Prerequisites:
- **Java 17+** (e.g., OpenJDK 17)
- **Maven** (for dependency management)

### Clone the repository:
```sh
git clone https://github.com/YourUsername/egg-timer.git
cd egg-timer
```

### Run the application:
```sh
mvn clean package
java -jar target/egg-timer-1.0-SNAPSHOT.jar
```

## 🛠️ Usage
1.	Select egg doneness (Soft, Medium, Hard).
2.	Select egg size (Small, Medium, Large).
3.	Click Start to begin the countdown.
4.	Watch the progress bar and remaining time.
5.	When time is up, an alarm sound will play!

## 🎵 Sound Issues?
If the alarm sound does not play:
1.	Make sure alarm.wav is in src/main/resources/.
2.	Run:
```sh
mvn clean package
```
3.	Check JavaFX media support.

## 📌 Dependencies
This project uses:
- javafx-controls
- javafx-fxml 
- javafx-media

All dependencies are managed via Maven.

## 🤝 Contributing
Feel free to fork this project and submit pull requests! 🚀

## 📜 License
MIT License. See LICENSE for details.