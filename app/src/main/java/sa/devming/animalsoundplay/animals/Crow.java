package sa.devming.animalsoundplay.animals;

import android.content.Context;
import android.media.SoundPool;

import sa.devming.animalsoundplay.Animal;
import sa.devming.animalsoundplay.R;

public class Crow extends Animal {

    private final int imageResId = R.drawable.crow;
    private final int soundResId = R.raw.crow;


    public Crow(Context context, SoundPool soundPool) {
        super(context, soundPool);
        setResId(imageResId, soundResId);
    }
}
