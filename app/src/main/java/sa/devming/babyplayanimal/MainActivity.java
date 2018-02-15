package sa.devming.babyplayanimal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private SoundPool soundPool;
    private int catSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listview);
        recyclerView.setHasFixedSize(true);

        ArrayList items = new ArrayList();
        items.add(R.drawable.cat);
        items.add(R.drawable.dog);
        items.add(R.drawable.duck);
        items.add(R.drawable.elephant);
        items.add(R.drawable.frog);
        items.add(R.drawable.pig);

        layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        //layoutManager = new LinearLayoutManager(this);
        //layoutManager = new GridLayoutManager(this,3);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new AnimalAdapter(items, this, new OnItemClickListener() {
            @Override
            public void onItemClick(Object o) {
                if (o instanceof Integer) {
                    showImage();
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void showImage() {
        new AnimalDialog(this, R.drawable.cat_click).show();
        soundPool.play(catSound, 1f, 1f, 0, 0, 1f);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(8).build();
        }
        else {
            soundPool = new SoundPool(8, AudioManager.STREAM_NOTIFICATION, 0);
        }

        catSound = soundPool.load(this, R.raw.cat_sound, 1);
    }

    @Override
    protected void onStop() {
        super.onStop();

        soundPool.release();
        soundPool = null;
    }
}
