package com.ifmo.jjd.exam3;

import java.io.IOException;

public class StartGameCommand implements Command{

    private String commandName = "Start game";

    @Override
    public String showCommand() {
        return commandName;
    }

    @Override
    public void execute() {
        Game game = new Game();
        try {
            game.start();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
