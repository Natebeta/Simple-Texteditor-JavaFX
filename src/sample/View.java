package sample;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {

    private Button bTrim;
    private Label lWords,lChar;
    private TextArea areaText;
    private MenuItem miOpen, miSave;
    private Scene scene;

    public View(Stage stage) {

        scene = new Scene(new VBox(), 500, 400);

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("Datei");
        miOpen = new MenuItem("Open");
        miSave = new MenuItem("Save");
        menuFile.getItems().addAll(miOpen,miSave);
        menuBar.getMenus().add(menuFile);

        areaText = new TextArea();
        areaText.setPrefSize(1000, 1000);

        HBox leftHbox = new HBox();
        HBox rightHbox = new HBox();
        bTrim = new Button("Trim");
        lWords = new Label("Wörter: ");
        lChar = new Label("Zeichen: ");
        leftHbox.getChildren().add(bTrim);
        rightHbox.setAlignment(Pos.CENTER_RIGHT);
        leftHbox.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(leftHbox, Priority.ALWAYS);
        HBox.setHgrow(rightHbox, Priority.ALWAYS);
        rightHbox.getChildren().addAll(lWords, new Separator(Orientation.VERTICAL), lChar);
        ToolBar toolbar = new ToolBar(leftHbox,rightHbox);



        ((VBox) scene.getRoot()).getChildren().addAll(menuBar, toolbar, areaText);
        stage.setScene(scene);
        stage.setTitle("Java Texteditor by Aman Thind");
        stage.show();
    }

    public Label getlChar() {
        return lChar;
    }

    public Button getbTrim() {
        return bTrim;
    }

    public Label getlWords() {
        return lWords;
    }

    public TextArea getAreaText() {
        return areaText;
    }

    public MenuItem getMiOpen() {
        return miOpen;
    }

    public MenuItem getMiSave() {
        return miSave;
    }

    public Scene getScene() {
        return scene;
    }
}
