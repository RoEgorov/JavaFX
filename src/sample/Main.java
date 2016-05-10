package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 300, Color.BEIGE);
        primaryStage.setScene(scene);
        primaryStage.show();

        MenuBar menuBar = new MenuBar();
        menuBar.setLayoutX(10);
        menuBar.setLayoutY(10);
        menuBar.setBlendMode(BlendMode.HARD_LIGHT);
        menuBar.setCursor(Cursor.CLOSED_HAND);
        DropShadow effect=new DropShadow();
        effect.setOffsetX(5);
        effect.setOffsetY(5);
        menuBar.setEffect(effect);
        menuBar.setStyle("-fx-base:skyblue;-fx-border-width:4pt;-fx-border-color:navy;-fx-font:bold 16pt Georgia;");
        menuBar.setPrefSize(550, 50);

        Menu menuF = new Menu("Новая игра");
        MenuItem menuItemP = new MenuItem("Выберете сложность");

        SeparatorMenuItem sep=new SeparatorMenuItem();
        RadioMenuItem radioItemY = new RadioMenuItem("Легкий уровень");
        radioItemY.setStyle("-fx-text-fill:navy;-fx-font:bold italic 12pt Georgia;");
        ToggleGroup tgroup=new ToggleGroup();
        radioItemY.setToggleGroup(tgroup);
        radioItemY.setSelected(true);
        RadioMenuItem radioItemN = new RadioMenuItem("Слоный уровень");
        radioItemN.setStyle("-fx-text-fill:navy;-fx-font:bold italic 12pt Georgia;");
        radioItemN.setToggleGroup(tgroup);
        menuF.getItems().addAll(menuItemP, radioItemY, radioItemN);

        Menu menuE = new Menu("Результаты");
        MenuItem menuItemCut = new MenuItem("Топ-10");
        menuItemCut.setStyle("-fx-text-fill:navy;-fx-font:bold italic 14pt Georgia;");
        MenuItem menuItemCopy = new MenuItem("Ваш последний");
        menuItemCopy.setStyle("-fx-text-fill:navy;-fx-font:bold italic 14pt Georgia;");
        menuE.getItems().addAll(menuItemCut, menuItemCopy);

        Menu menuV = new Menu("Выход");
        MenuItem menuItemS = new MenuItem("Выход");
        menuItemS.setStyle("-fx-text-fill:navy;-fx-font:bold italic 14pt Georgia;");
        menuItemS.setAccelerator(KeyCombination.keyCombination("ESC"));

        menuItemS.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Platform.exit();
            } });

        menuV.getItems().addAll(menuItemS);

        menuBar.getMenus().addAll(menuF, menuE, menuV);
        root.getChildren().add(menuBar);
    }
}
