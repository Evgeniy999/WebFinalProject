package by.epam.interpol.command;

import java.util.Optional;

/**
 * The type Command factory.
 */
public class CommandFactory {
    /**
     * Choose command optional.
     *
     * @param commandName the command name
     * @return the optional
     */
    public static Optional<ActionCommand> chooseCommand(String commandName) {
        CommandType commandType = CommandType.valueOf(commandName);
        return (Optional.of(commandType.getCommand()));
    }

}
