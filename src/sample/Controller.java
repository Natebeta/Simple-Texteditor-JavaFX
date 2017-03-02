package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;


public class Controller {

    private Stage stage;
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.stage = model.getStage();
        this.view = new View(stage);

        view.getMiOpen().setOnAction(new OpenEventHandler());
        view.getMiSave().setOnAction(new SaveEventHandler());
        view.getAreaText().textProperty().addListener(new TxtChangeEventHandler());
        view.getbTrim().setOnAction(new TrimEHandler());
    }

    class OpenEventHandler implements EventHandler<ActionEvent> {

        /**
         * Uses FileChooser to open dialog an choose file.
         * Gives the file to model to open it and then to set the content into the text area in View.
         * If-condition to not get an error if choosing the file was chanceled.
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if (file == null) {
                return;
            }
             String stringFile = model.openFile(file);
             view.getAreaText().setText(stringFile);
        }
    }

    class TxtChangeEventHandler implements ChangeListener<String> {

        /**
         * Get the text of view as a string, which is goin to model into methods countChar and countWords to get Integer.
         * After getting the number, the text in labels is setted to the integers.
         * @param observable
         * @param oldValue
         * @param newValue
         */
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            String text = view.getAreaText().getText();
            Integer charInt = model.countChar(text);
            Integer wordsInt = model.countWords(text);
            view.getlChar().setText("Zeichen: " + charInt);
            view.getlWords().setText("Wörter: " + wordsInt);
        }
    }

    class SaveEventHandler implements EventHandler<ActionEvent> {

        /**
         * Uses FileChooser to open the Save-Dialog. When location is choosed, it's going to be saved by the method saveFile
         * in the model class with the text of the text area.
         * If choosing the location got canceld, the process got ended by giving return.
         * ExtensionFilter got added to save the file only in txt.
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(".txt", "*.txt");
            fileChooser.getExtensionFilters().add(extensionFilter);
            File file = fileChooser.showSaveDialog(stage);
            if (file == null) {
                return;
            }
            model.saveFile(file, view.getAreaText().getText());
        }
    }

    class TrimEHandler implements EventHandler<ActionEvent> {

        /**
         * Takes the text of text area in view for the trim method in model class.
         * Text Area got replaced by the trimed text.
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            String text = view.getAreaText().getText();
            view.getAreaText().setText(model.trim(text));
        }
    }
}
