#clean
find src -type f -name "*.class" -delete

#compile main
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml src/screensframework/ScreensFramework.java 

#manually compile controllers
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml src/screensframework/Screen1Controller.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml src/screensframework/Screen2Controller.java
javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml src/screensframework/Screen3Controller.java

#run
java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml src.screensframework.ScreensFramework
