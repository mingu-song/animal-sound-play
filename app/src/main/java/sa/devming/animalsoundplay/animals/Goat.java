package sa.devming.animalsoundplay.animals;

import android.content.Context;
import android.media.SoundPool;

import sa.devming.animalsoundplay.Animal;
import sa.devming.animalsoundplay.R;

public class Goat extends Animal {
    private final int imageResId = R.drawable.goat;
    private final int soundResId = R.raw.goat;

    public Goat(Context context, SoundPool soundPool) {
        super(context, soundPool);
        setResId(imageResId, soundResId);
    }
}
