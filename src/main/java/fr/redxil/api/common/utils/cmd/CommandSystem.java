package fr.redxil.api.common.utils.cmd;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.CommandNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public abstract class CommandSystem<C> {

    final String name;
    BiConsumer<CommandContext<C>, String> executor;
    Predicate<C> require = null;
    CommandSystem<C> then = null;
    List<CommandSystem<C>> argumentCreatorCreatorList = new ArrayList<>();

    protected CommandSystem(String name) {
        this.name = name;
    }

    public void setExecutor(BiConsumer<CommandContext<C>, String> executor) {
        this.executor = executor;
    }

    public CommandSystem<C> setThen(CommandSystem<C> argumentCreator) {
        this.then = argumentCreator;
        return this;
    }

    public ArgumentCreator<C> createArgument(String argName, ArgumentType<?> argumentType, BiConsumer<CommandContext<C>, String> executor) {
        ArgumentCreator<C> arg = new ArgumentCreator<>(argName, argumentType);
        arg.setExecutor(executor);
        addArgument(arg);
        return arg;
    }

    public ArgumentCreator<C> createThen(String argName, ArgumentType<?> argumentType, BiConsumer<CommandContext<C>, String> executor) {
        ArgumentCreator<C> arg = new ArgumentCreator<>(argName, argumentType);
        arg.setExecutor(executor);
        setThen(arg);
        return arg;
    }

    public LiteralArgumentCreator<C> createLiteralThen(String argName, BiConsumer<CommandContext<C>, String> executor) {
        LiteralArgumentCreator<C> arg = new LiteralArgumentCreator<>(argName);
        arg.setExecutor(executor);
        setThen(arg);
        return arg;
    }


    public CommandSystem<C> addArgument(CommandSystem<C> argumentCreator) {
        this.argumentCreatorCreatorList.add(argumentCreator);
        return this;
    }

    public LiteralArgumentCreator<C> createLiteralArgument(String argName, BiConsumer<CommandContext<C>, String> executor) {
        LiteralArgumentCreator<C> arg = new LiteralArgumentCreator<>(argName);
        arg.setExecutor(executor);
        addArgument(arg);
        return arg;
    }


    public CommandSystem<C> setRequire(Predicate<C> check) {
        this.require = check;
        return this;
    }


    protected <T extends ArgumentBuilder<C, T>> void updateBuilder(ArgumentBuilder<C, T> builder) {
        if (then != null)
            builder.then(then.build());
        builder.executes(context -> {
            executor.accept(context, name);
            return 1;
        });
        if (require != null)
            builder.requires(require);
    }

    protected CommandNode<C> updateNode(CommandNode<C> commandNode) {
        argumentCreatorCreatorList.forEach(argCreator -> commandNode.addChild(argCreator.build()));
        return commandNode;
    }

    public abstract CommandNode<C> build();

    public String getName() {
        return this.name;
    }

}
