package duke.storage;

import duke.exception.FileFormatException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;
import duke.ui.Ui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to store taskList in .txt file, and load tasks from .txt file
 *
 * @author Amalina Sani
 */
public class Storage {
    private static final String FILE_DIR = "data";
    private static final String FILE_PATH = "data/duke.txt";

    /**
     * Constructor for Storage class
     * Catches IOException
     *
     * @param filePath The storage file path
     * */
    public Storage(String filePath){
        File fileDir = new File(FILE_DIR);
        if (!fileDir.exists()){
            fileDir.mkdir();
        }

        try {
            checkFileExists(filePath);
        } catch (IOException e){
            Ui.printLoadErrorMessage();
        }
    }

    /**
     * Checks if file exists and creates new file if it does not exist
     *
     * @param filePath The storage file path
     * @return dataFile The file for storing data
     */
    public File checkFileExists(String filePath) throws IOException{
        File dataFile = new File(filePath);
        if (!dataFile.exists()){
            dataFile.createNewFile();
        }
        return dataFile;
    }

    /**
     * Loads data from file
     * Catches FileFormatException and IOException
     *
     * @return The task list ArrayList
     */
    public ArrayList<Task> loadFromFile(){
        ArrayList<Task> taskList = new ArrayList<>();

        try {
            File dataFile = checkFileExists(FILE_PATH);
            Scanner in = new Scanner(dataFile);
            while(in.hasNext()){
                String line = in.nextLine();
                String[] taskDetails = line.split(" \\| ");

                switch(taskDetails[0]){
                case "T":
                    taskList.add(new ToDo(taskDetails[2]));
                    break;
                case "D":
                    taskList.add(new Deadline(taskDetails[2],taskDetails[3]));
                    break;
                case "E":
                    taskList.add(new Event(taskDetails[2], taskDetails[3]));
                default:
                    throw new FileFormatException();
                }
                if (taskDetails[1].equals("1")){
                    int taskIndex = taskList.size()-1;
                    taskList.get(taskIndex).markAsDone();
                }
            }
        } catch(FileFormatException | IOException e){
        }
        return taskList;
    }

    /**
     * Saves task list to file
     *
     * @param taskList The task list array list to be saved
     * @throws IOException
     */
    public void saveToFile(ArrayList<Task> taskList) throws IOException {
        FileWriter fw = new FileWriter(FILE_PATH);
        for (Task task : taskList) {
            int status = (task.getStatus() ? 1 : 0);
            fw.write(task.getTaskType()
                    + " | " + status
                    + " | " + task.getDescription()
                    + " | " + task.getDate()
                    + System.lineSeparator());
        }
        fw.close();
        Ui.printSaveSuccessMessage();
    }

}
