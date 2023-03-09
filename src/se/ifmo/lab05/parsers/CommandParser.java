package se.ifmo.lab05.parsers;

import se.ifmo.lab05.utils.IOProvider;
import se.ifmo.lab05.exceptions.ExitException;
import se.ifmo.lab05.exceptions.InvalidArgsException;
import se.ifmo.lab05.interfaces.Printer;
import se.ifmo.lab05.managers.CommandManager;

import java.util.*;

public class CommandParser {
    private final CommandManager commandManager;

    public CommandParser(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public void run(IOProvider IOProvider) {
        Scanner scanner = IOProvider.getScanner();
        Printer printer = IOProvider.getPrinter();

        while (true) {
            try {
                printer.printf(">> ");
                String line = scanner.nextLine();
                String[] splitLine = line.strip().split("\s+");
                String commandName = splitLine[0];
                String[] args = Arrays.copyOfRange(splitLine, 1, splitLine.length);
                if (!commandManager.execute(commandName, args)) {
                    printer.print("Invalid command");
                }
            } catch (ExitException e) {
                printer.print("");
            } catch (InvalidArgsException e) {
                printer.print("Invalid arguments. Use command \"help\" to find them.");
            } catch (NoSuchElementException e) {
                printer.print("\nEOF");
                break;
            } catch (Exception e) {
                printer.print(e.toString());
            }
        }
    }
}
