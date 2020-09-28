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

public class Storage {
    private static final String FILE_DIR = "data";
    private static final String FILE_PATH = "data/data.txt";

    public Storage(String filePath){
        File fileDir = new File(FILE_DIR);
        if (!fileDir.exists()){
            fileDir.mkdir();
        }

        try {
            File dataFile = checkFileExists(filePath);
        } catch (IOException e){
            System.out.println(Ui.ERROR_MESSAGE_IOEXCEPTION);
        }
    }

    /**
     * Check if file exists
     */
    private File checkFileExists(String filePath) throws IOException{
        File dataFile = new File(filePath);
        if (!dataFile.exists()){
            dataFile.createNewFile();
        }
        return dataFile;
    }

    /**
     * Load data from file
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
        } catch(IOException | FileFormatException e){
            System.out.println(Ui.ERROR_MESSAGE_IOEXCEPTION);
        }
        return taskList;
    }

    /**
     * Save task list to file
     */
    public void saveToFile(ArrayList<Task> taskList) throws IOException {
        FileWriter fw = new FileWriter(FILE_PATH);
        for (Task task : taskList) {
            fw.write(task.getTaskType() + " | " + task.getStatus() + " | "
                    + task.getDescription() + " | " + task.getDate() + System.lineSeparator());
        }
        fw.close();
        System.out.println(Ui.MESSAGE_SUCCESSFUL_SAVE);
    }
}
