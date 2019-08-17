package sa.devming.animalsoundplay.animals;

import android.content.Context;
import android.media.SoundPool;

import sa.devming.animalsoundplay.Animal;
import sa.devming.animalsoundplay.R;

public class Cat extends Animal {

    private final int imageResId = R.drawable.cat;
    private final int soundResId = R.raw.cat;


    public Cat(Context context, SoundPool soundPool) {
        super(context, soundPool);
        setResId(imageResId, soundResId);
    }
}
