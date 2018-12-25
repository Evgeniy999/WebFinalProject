package by.epam.interpol.command;

import java.util.Optional;

public class CommandFactory {
    public static Optional<ActionCommand> chooseCommand(String commandName)
    {
        CommandType commandType = CommandType.valueOf(commandName);
        return (Optional.of(commandType.getCommand()));
    }

}
