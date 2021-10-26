/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.spigot.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CommandInfo {

    String name() default "";

    String description() default "";

    boolean onlyPlayer() default true;

    String[] aliases() default "";

    String noPermissionMessage() default "§cVous n'avez la permission d'éxécuter cette commande";

    String[] args() default {};

    int permission() default 0;

    long cooldown() default 5;

}
