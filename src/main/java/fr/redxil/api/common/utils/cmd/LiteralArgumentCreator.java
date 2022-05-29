package fr.redxil.api.common.utils.cmd;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;

import java.util.function.BiConsumer;

public class LiteralArgumentCreator<C> extends CommandSystem<C> {

    public LiteralArgumentCreator(String name, BiConsumer<CommandContext<C>, String> executor) {
        super(name, executor);
    }

    @Override
    public LiteralCommandNode<C> build() {
        LiteralArgumentBuilder<C> literalArgBuilder = LiteralArgumentBuilder.literal(this.name);
        updateBuilder(literalArgBuilder);

        LiteralCommandNode<C> build = literalArgBuilder.build();
        updateNode(build);

        return build;
    }
}
