package fr.redxil.api.common.utils.cmd;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.tree.CommandNode;

public class ArgumentCreator<C> extends CommandSystem<C> {

    ArgumentType<?> argumentType;
    SuggestionProvider<C> suggestionProvider = null;

    public ArgumentCreator(String name, ArgumentType<?> argumentType) {
        super(name);
        this.argumentType = argumentType;
    }

    public ArgumentCreator<C> setSuggestion(SuggestionProvider<C> suggestion) {
        this.suggestionProvider = suggestion;
        return this;
    }

    public CommandNode<C> build() {
        RequiredArgumentBuilder<C, ?> argumentBuilder = RequiredArgumentBuilder.argument(this.name, this.argumentType);
        updateBuilder(argumentBuilder);

        if (suggestionProvider != null)
            argumentBuilder.suggests(suggestionProvider);

        return updateNode(argumentBuilder.build());
    }

}
