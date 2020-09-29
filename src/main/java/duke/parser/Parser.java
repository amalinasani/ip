package duke.parser;

import duke.command.*;
import duke.exception.InvalidArgumentException;
import duke.exception.InvalidCommandException;
import duke.exception.InvalidIndexException;

public class Parser {

    /**
     * Handles user command
     * Create command object for user command
     */
    public Command parseCommand(String userInput) throws InvalidCommandException, InvalidIndexException, InvalidArgumentException {
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

        case Command.COMMAND_SAVE:
            command = new SaveCommand();
            break;

        case Command.COMMAND_DELETE:
            try {
                int index = Integer.parseInt(splitUserInput[1]);
                command = new DeleteTaskCommand(index);
            } catch(IndexOutOfBoundsException e){
                throw new InvalidIndexException();
            }
            break;

        case Command.COMMAND_DONE:
            try {
                int index = Integer.parseInt(splitUserInput[1]) - 1;
                command = new DoneCommand(index);
            } catch(IndexOutOfBoundsException e){
                throw new InvalidIndexException();
            }
            break;

        case Command.COMMAND_TODO:
            // Fallthrough
        case Command.COMMAND_DEADLINE:
            // Fallthrough
        case Command.COMMAND_EVENT:
            try {
                command = new AddTaskCommand(inputCommand, splitUserInput[1]);
            } catch(IndexOutOfBoundsException e){
                throw new InvalidArgumentException();
            }
            break;

        default:
            throw new InvalidCommandException();
        }
        return command;
    }
}
