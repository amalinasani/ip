package duke.parser;

import duke.command.*;
import duke.exception.InvalidArgumentException;
import duke.exception.InvalidCommandException;
import duke.exception.InvalidIndexException;

/**
 * Class to handle user input
 *
 * @author Amalina Sani
 */
public class Parser {

    /**
     * Creates command object for user commands (List, Bye, Save, Delete, Done, Find, Todo, Deadline, Event)
     * Throws InvalidCommandException, InvalidIndexException, InvalidArgumentException
     *
     * @param userInput The string of user input
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
        case Command.COMMAND_HELP:
            command = new HelpCommand();
            break;
        case Command.COMMAND_DELETE:
            try {
                int index = Integer.parseInt(splitUserInput[1])-1;
                command = new DeleteTaskCommand(index);
            } catch(IndexOutOfBoundsException | NumberFormatException e){
                throw new InvalidIndexException();
            }
            break;

        case Command.COMMAND_DONE:
            try {
                int index = Integer.parseInt(splitUserInput[1]) - 1;
                command = new DoneCommand(index);
            } catch(IndexOutOfBoundsException | NumberFormatException e){
                throw new InvalidIndexException();
            }
            break;

        case Command.COMMAND_FIND:
            try {
                String word = splitUserInput[1].toUpperCase();
                command = new FindCommand(word);
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
