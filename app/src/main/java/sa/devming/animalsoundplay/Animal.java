package sa.devming.animalsoundplay;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.SoundPool;

public class Animal {

    private int imageResId;
    private int soundResId;
    private SoundPool soundPool;
    private Context context;
    private static ProgressDialog progressDialog;

    public Animal(Context context, SoundPool soundPool) {
        this.context = context;
        this.soundPool = soundPool;
        if (this.progressDialog == null) {
            this.progressDialog = new ProgressDialog(context);
            this.progressDialog.setMessage("Icon made by Freepik from www.flaticon.com");
            this.progressDialog.setCancelable(true);
            this.progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Horizontal);
        }
    }

    public void setResId(int imageResId, int soundResId) {
        this.soundResId = soundResId;
        this.imageResId = imageResId;
    }

    public void playSound() {
        progressDialog.show();
        final int sound = soundPool.load(context, soundResId, 1);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                soundPool.play(sound, 1f, 1f, 0, 0, 1.0f);
                progressDialog.dismiss();
            }
        });
    }

    public int getImageResId() {
        return imageResId;
    }
}
