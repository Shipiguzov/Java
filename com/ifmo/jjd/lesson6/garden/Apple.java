package com.ifmo.jjd.lesson6.garden;

public class Apple {
    private int ageOfApple;
    private boolean isFresh = true;
    private boolean onTree = true;

    public Apple(int ageOfApple) {
        this.setAgeOfApple(ageOfApple);
    }

    public  void addAppleDay() {
        this.ageOfApple += 1;
        if (this.getAgeOfApple() >= 30) this.setOnTree(false);
        if (this.getAgeOfApple() >= 31) this.setIsFresh(false);
    }

    public int getAgeOfApple() {
        return ageOfApple;
    }

    public void setAgeOfApple(int age) {
        if (age < 0) throw new IllegalArgumentException("age must be 0 or more");
        this.ageOfApple = age;
    }

    public boolean isFresh() {
        return isFresh;
    }

    public void setIsFresh(boolean fresh) {
        isFresh = fresh;
    }

    public boolean isOnTree() {
        return onTree;
    }

    public void setOnTree(boolean onTree) {
        this.onTree = onTree;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "ageOfApple=" + ageOfApple +
                ", isFresh=" + isFresh +
                ", onTree=" + onTree +
                '}';
    }
}
