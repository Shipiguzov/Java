package com.ifmo.jjd.exam3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Game implements Serializable {

    private List<GameNode> nodeTextArray = new ArrayList<>();
    private GameNode saveGame = null;
    private transient final int COUNT = 13;
    private final static long serialVersionUID = 1L;

    public Game() {
        for (int i = 0; i < COUNT; i++) {
            nodeTextArray.add(new GameNode(i));
        }
        nodeTextArray.get(0).setRightAnswer(nodeTextArray.get(5));
        nodeTextArray.get(0).setWrongAnswer(nodeTextArray.get(1));
        nodeTextArray.get(1).setRightAnswer(nodeTextArray.get(3));
        nodeTextArray.get(1).setWrongAnswer(nodeTextArray.get(2));
        nodeTextArray.get(2).setRightAnswer(null);
        nodeTextArray.get(2).setWrongAnswer(null);
        nodeTextArray.get(3).setRightAnswer(nodeTextArray.get(4));
        nodeTextArray.get(3).setWrongAnswer(nodeTextArray.get(7));
        nodeTextArray.get(4).setRightAnswer(nodeTextArray.get(5));
        nodeTextArray.get(4).setWrongAnswer(nodeTextArray.get(2));
        nodeTextArray.get(5).setRightAnswer(null);
        nodeTextArray.get(5).setWrongAnswer(null);
        nodeTextArray.get(6).setRightAnswer(nodeTextArray.get(8));
        nodeTextArray.get(6).setWrongAnswer(nodeTextArray.get(2));
        nodeTextArray.get(7).setRightAnswer(nodeTextArray.get(6));
        nodeTextArray.get(7).setWrongAnswer(nodeTextArray.get(2));
        nodeTextArray.get(8).setRightAnswer(nodeTextArray.get(11));
        nodeTextArray.get(8).setWrongAnswer(nodeTextArray.get(9));
        nodeTextArray.get(9).setRightAnswer(null);
        nodeTextArray.get(9).setWrongAnswer(null);
        nodeTextArray.get(10).setRightAnswer(nodeTextArray.get(5));
        nodeTextArray.get(10).setWrongAnswer(nodeTextArray.get(2));
        nodeTextArray.get(11).setRightAnswer(nodeTextArray.get(10));
        nodeTextArray.get(11).setWrongAnswer(nodeTextArray.get(12));
        nodeTextArray.get(12).setRightAnswer(null);
        nodeTextArray.get(12).setWrongAnswer(null);
    }

    public void start() throws IOException {
        GameNode gameNode;
        if (Objects.isNull(this.saveGame)) {
            gameNode = nodeTextArray.get(0);
        } else gameNode = this.saveGame;
        String usersChoice = "";
        while (Objects.nonNull(gameNode.getRightAnswer())) {
            System.out.println(Objects.nonNull(gameNode.getRightAnswer()));
            usersChoice = userInput(gameNode);
            if (usersChoice.startsWith("1") || usersChoice.startsWith("2")) {
                gameNode = makeChoice(usersChoice, gameNode);
            } else if (usersChoice.contains("save")) {
                this.saveGame = gameNode;
                saveGame();
                System.out.println("Game saved");
                usersChoice = "SaveGame";
                break;
            } else {
                System.out.println("Enter 1 or 2 or save!");
                continue;
            }
        }
        if (!usersChoice.equalsIgnoreCase("SaveGame"))
            System.out.println(gameNode.nodeText.getText());
    }

    private void saveGame() throws IOException {
        System.out.println("Enter name of file");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        File fileName = new File(input.readLine());
        try (FileOutputStream stream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream)) {
            objectOutputStream.writeObject(this);
        }
    }

    private String userInput(GameNode gameNode) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(gameNode.nodeText.getText());
        System.out.println("Choose you action:");
        Random random = new Random();
        String flag;
        if (random.nextBoolean()) {
            System.out.println("1. " + gameNode.nodeText.getRightAnswer());
            System.out.println("2. " + gameNode.nodeText.getWrongAnswer());
            flag = "+";
        } else {
            System.out.println("1. " + gameNode.nodeText.getWrongAnswer());
            System.out.println("2. " + gameNode.nodeText.getRightAnswer());
            flag = "-";
        }
        System.out.println("Enter you choose (1 or 2) or type save for save game: ");
        return input.readLine() + flag;
    }

    private GameNode makeChoice(String userChoice, GameNode gameNode) {
        if (userChoice.endsWith("+")) {
            if (userChoice.startsWith("1")) return gameNode.rightAnswer;
            else return gameNode.wrongAnswer;
        } else {
            if (userChoice.startsWith("1")) return gameNode.wrongAnswer;
            else return gameNode.rightAnswer;
        }
    }

    private class GameNode implements Serializable {
        private int id;
        private NodeText nodeText;
        private GameNode rightAnswer;
        private GameNode wrongAnswer;

        public GameNode(int id) {
            StringBuilder node = new StringBuilder();
            node.append("NODE").append(id);
            this.nodeText = NodeText.valueOf(node.toString());
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public GameNode getRightAnswer() {
            return rightAnswer;
        }

        public void setRightAnswer(GameNode rightAnswer) {
            this.rightAnswer = rightAnswer;
        }

        public GameNode getWrongAnswer() {
            return wrongAnswer;
        }

        public void setWrongAnswer(GameNode wrongAnswer) {
            this.wrongAnswer = wrongAnswer;
        }
    }
}
