package duke.parser;

import duke.command.*;
import duke.exception.InvalidCommandException;

public class Parser {
    public Command parseCommand(String userInput) throws InvalidCommandException {
        String[] splitUserInput = userInput.split(" ", 2);
        String inputCommand = splitUserInput[0].toUpperCase();
        Command command = null;

        switch (inputCommand) {
            case Command.COMMAND_LIST:
                command = new ListCommand();
                break;

            case Command.COMMAND_BYE:
                command = new ByeCommand();
                break;

            case Command.COMMAND_DELETE:
                command = new DeleteTaskCommand(Integer.parseInt(splitUserInput[1]));
                break;

            case Command.COMMAND_SAVE:
                command = new SaveCommand();
                break;

            case Command.COMMAND_DONE:
                try {
                    int taskNumber = Integer.parseInt(splitUserInput[1]) - 1;
                    command = new DoneCommand(taskNumber);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Which task?");
                }
                break;
            case Command.COMMAND_TODO:
                // Fallthrough
            case Command.COMMAND_DEADLINE:
                // Fallthrough
            case Command.COMMAND_EVENT:
                try {
                    command = new AddTaskCommand(inputCommand, splitUserInput[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("You've forgotten to add a description!");
                }
                break;

            default:
                throw new InvalidCommandException();
        }
        return command;
    }
}
