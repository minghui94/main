package seedu.address.logic.commands;

import com.google.common.eventbus.EventBus;
import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.events.ui.ChangeThemeEvent;
import seedu.address.commons.events.ui.SendMessageEvent;
import seedu.address.logic.commands.exceptions.CommandException;

import com.google.common.eventbus.Subscribe;

import java.nio.file.NoSuchFileException;


/**
 * Sends a message to the contact through email
 */

public class ChangeThemeCommand extends Command {

    public static final String COMMAND_WORD = "theme";
    public static final String COMMAND_ALIAS = "t";
    public static final String COMMAND_HELP = "theme THEME_NAME";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Changes theme. \n"
            + COMMAND_WORD + " <THEME_NAME>";


    public static final String MESSAGE_NO_THEME = "No available theme.";
    public static final String MESSAGE_CHANGE_SUCCESS = "Theme changed successfully.";

    private final String themeName;

    /**
     * @param String Name of setting to change
     */
    public ChangeThemeCommand(String themeName) {
        this.themeName = themeName;
    }

    @Override
    public CommandResult execute() throws CommandException {
        EventsCenter.getInstance().post(new ChangeThemeEvent(themeName));
        return new CommandResult(MESSAGE_CHANGE_SUCCESS);
    }


}
