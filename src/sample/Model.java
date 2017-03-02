package sample;

import javafx.stage.Stage;

import java.io.*;

public class Model {

    private Stage stage;

    public Model(Stage stage) {
        this.stage = stage;
    }


    public Stage getStage() {
        return stage;
    }


    /**
     * Splits the string into seperate words (divided by regular expression).
     * Puts each word in array to get length of that array.
     * @param words - getting by controller
     * @return The result length of the array with words
     */
    public int countWords(String words) {
        String[] splittedWords = words.split("\\S+");
        return splittedWords.length;
    }


    /**
     * Gives the number of characters in string back
     * @param text
     * @return length of string
     */
    public int countChar(String text) {
        return text.length();
    }


    /**
     * Trims string with the method trim.
     * Replaces all spaces and tabs by one space, because it only has to remove redundant spaces
     * thanks to regular expression.
     * @param text
     * @return the trimed text and removed space,tab and space
     */
    public String trim (String text) {
        String trimedText = text.trim();
        return trimedText.replaceAll("\\p{Blank}+", " ");
    }


    /**
     * Writes a new file with (given) string text by FileWriter
     * @param file
     * @param text
     */
    public void saveFile(File file, String text) {

        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(text);
            writer.close();
        } catch (IOException e) {

        }
    }


    /**
     * Opens file and uses StringBuilder to build strings.
     * Reads every line and adds read line/string to the string above.
     * @param file
     */
    public String openFile(File file) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            bufferedReader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            return null;
        }
    }
}
