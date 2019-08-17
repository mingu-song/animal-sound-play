package sa.devming.animalsoundplay.animals;

import android.content.Context;
import android.media.SoundPool;

import sa.devming.animalsoundplay.Animal;
import sa.devming.animalsoundplay.R;

public class Dog extends Animal {

    private final int imageResId = R.drawable.dog;
    private final int soundResId = R.raw.dog;

    public Dog(Context context, SoundPool soundPool) {
        super(context, soundPool);
        setResId(imageResId, soundResId);
    }
}
