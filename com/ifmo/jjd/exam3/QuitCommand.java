package com.ifmo.jjd.exam3;

public class QuitCommand implements Command{

    private String commandName = "Quit";

    @Override
    public String showCommand() {
        return commandName;
    }

    @Override
    public void execute() {
        System.out.println("Thanks for playing");
    }
}
