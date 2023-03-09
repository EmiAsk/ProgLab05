package se.ifmo.lab05.commands;

import se.ifmo.lab05.exceptions.InvalidArgsException;
import se.ifmo.lab05.managers.CollectionManager;
import se.ifmo.lab05.utils.IOProvider;

public class ShuffleCommand extends Command {
    public ShuffleCommand(IOProvider IOProvider, CollectionManager collection) {
        super("shuffle", "перемешать элементы коллекции в случайном порядке", IOProvider, collection);
    }

    @Override
    public void execute(String[] args) throws InvalidArgsException {
        validateArgs(args, 0);
        collection.shuffle();
        provider.getPrinter().print("Collection has been shuffled.");
    }
}
