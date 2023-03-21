package com.accenture.Scrappy;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;

import social.bigbone.api.exception.BigBoneRequestException;

@Command(name = "scrappywisdom", subcommands = {CommandLine.HelpCommand.class},
        description = "Post wisdom on mastodon")
public class ScrappyWisdom implements Runnable {
    @Spec
    CommandSpec spec;

    App app = null;

    private ScrappyWisdom() {
        app = new App(System.getenv("TOKEN"));
    }

    @Override
    public void run() {
        throw new ParameterException(spec.commandLine(), "Specify a subcommand");
    }

    @Command(name = "post", description = "Post more wisdom")
    void post() {
        app.run();
    }

    @Command(name = "stats", description = "Show stats of previous posts")
    void stats() {
        System.out.println("To be implemented.");
    }

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new ScrappyWisdom());
        if (args.length == 0) {
            cmd.usage(System.out);
        } else {
            cmd.execute(args);
        }
    }


}