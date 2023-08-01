package com.example.myelementary;

public class song {
    private String name;
    private int id;
    song(String name,int id)
    {
        this.name=name;
        this.id=id;
    }

    public String getName()
    {
        return this.name;
    }

    public int getId()
    {
        return this.id;
    }

    public static  song songs[]={
       new song("one potato",R.raw.potatos),
            new song("knees and toes",R.raw.knee),
            new song("abcd",R.raw.abcd),
            new song("apples are yummy",R.raw.apples_yummy),
            new song("baby shark",R.raw.baby_shark),
            new song("five little monkeys",R.raw.fivemonkeys),
            new song("brush your teeth",R.raw.brush_brush),
            new song("if you are happy",R.raw.happy),
            new song("jonny jonny",R.raw.jonny_jonny),
            new song("planting song",R.raw.planting_song),
            new song("twinkle twinkle",R.raw.twinkle),
            new song("iam a little teapot",R.raw.little_pot)
    };
}
