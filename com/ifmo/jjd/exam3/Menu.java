package com.ifmo.jjd.exam3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Command> command;

    public Menu() {
        command = new ArrayList<>();
        command.add(new StartGameCommand());
        command.add(new LoadGameCommand());
        command.add(new QuitCommand());
    }

    public void run() {
        this.showMenu();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            int menuNumber = Integer.parseInt(input.readLine());
            this.command.get(menuNumber - 1).execute();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void showMenu() {
        System.out.println("Select command:");
        for (int i = 0; i < command.size(); i++) {
            System.out.println(i + 1 + ". " + command.get(i).showCommand() + ".");
        }
    }
}
