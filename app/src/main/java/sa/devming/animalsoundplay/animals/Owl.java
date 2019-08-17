package sa.devming.animalsoundplay.animals;

import android.content.Context;
import android.media.SoundPool;

import sa.devming.animalsoundplay.Animal;
import sa.devming.animalsoundplay.R;

public class Owl extends Animal {
    private final int imageResId = R.drawable.owl;
    private final int soundResId = R.raw.owl;

    public Owl(Context context, SoundPool soundPool) {
        super(context, soundPool);
        setResId(imageResId, soundResId);
    }
}
