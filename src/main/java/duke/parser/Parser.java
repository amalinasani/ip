package duke.parser;

import duke.command.ByeCommand;
import duke.command.Command;
import duke.command.DeleteTaskCommand;
import duke.command.ListCommand;
import duke.exception.InvalidCommandException;

public class Parser {
    public Command parseCommand(String userInput) throws InvalidCommandException {
        String[] splitUserInput = userInput.split(" ", 2);
        String inputCommand = splitUserInput[0].toUpperCase();
        Command command;

        switch (inputCommand) {
            case Command.COMMAND_LIST:
                command = new ListCommand();
                break;

            case Command.COMMAND_BYE:
                command = new ByeCommand();
                break;

            case Command.COMMAND_DELETE:
                command = new DeleteTaskCommand(splitUserInput[1]);

                break;

            case "SAVE":
                saveToFile();
                break;

            case "DONE":
                try {
                    int taskNumber = Integer.parseInt(splitUserInput[1]) - 1;
                    markTaskAsDone(taskNumber);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Which task?");
                }
                break;
            case "TODO":
                // Fallthrough
            case "DEADLINE":
                // Fallthrough
            case "EVENT":
                try {
                    addTask(inputCommand.toUpperCase(), splitUserInput[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("You've forgotten to add a description!");
                }
                break;

            default:
                throw new InvalidCommandException();

        }
    }

    public Command createDeleteTaskCommand(String[] taskDetails){
        
    }
}
