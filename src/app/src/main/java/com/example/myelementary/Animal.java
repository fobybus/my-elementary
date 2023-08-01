//////
//2023 @msf@i@dbu
package com.example.myelementary;

public class Animal {
    private String name;
    private int sound;
    private int image;

    public static Animal[] animals = {new Animal("apple", R.raw.apple_, R.raw.apple),
            new Animal("ball", R.raw.ball_, R.raw.ball),
            new Animal("ear", R.raw.ear_, R.raw.ear),
            new Animal("eye", R.raw.eye_, R.raw.eye),
            new Animal("fish", R.raw.fish_, R.raw.fish),
            new Animal("flower", R.raw.flower_, R.raw.flower),
            new Animal("hand", R.raw.hand_, R.raw.hand),
            new Animal("leg", R.raw.leg_, R.raw.leg),
            new Animal("nose", R.raw.nose_, R.raw.nose),
            new Animal("potato", R.raw.potato_, R.raw.potato),
            new Animal("tomato", R.raw.tomato_, R.raw.tomato),

            new Animal("cat", R.raw.cat_, R.raw.cat),
            new Animal("chicken", R.raw.chicken_, R.raw.chicken),
            new Animal("cow", R.raw.cow_, R.raw.cow),
            new Animal("dog", R.raw.dog_, R.raw.dog),
            new Animal("donkey", R.raw.donkey_, R.raw.donkey),
            new Animal("duck", R.raw.duck_, R.raw.duck),
            new Animal("monkey", R.raw.monkey_, R.raw.monkey),
            new Animal("rabbit", R.raw.rabbit_, R.raw.rabbit),
            new Animal("sheep", R.raw.sheep_, R.raw.sheep),
            new Animal("zebra", R.raw.donkey_, R.raw.zebra),
    };

    public static int getRight(int type) {
        int id;
        if (type == 0)
            id = R.raw.wright;
        else
            id = R.raw.wright_;
        return id;
    }

    public static int getWrong(int type) {
        int id;
        if (type == 0)
            id = R.raw.x;
        else
            id = R.raw.wrong;
        return id;
    }

    public Animal(String name, int sound, int image) {
        this.name = name;
        this.sound = sound;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public int get_sound() {
        return this.sound;
    }

    public int getImage() {
        return this.image;
    }


}///
