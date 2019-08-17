package sa.devming.animalsoundplay;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

import sa.devming.animalsoundplay.animals.*;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private SoundPool soundPool;
    private List<Animal> animalList = new ArrayList<>();

    private void setAnimals() {
        animalList.add(new Cat(this, soundPool));
        animalList.add(new Cow(this, soundPool));
        animalList.add(new Crow(this, soundPool));
        animalList.add(new Dog(this, soundPool));
        animalList.add(new Duck(this, soundPool));
        animalList.add(new Elephant(this, soundPool));
        animalList.add(new Frog(this, soundPool));
        animalList.add(new Goat(this, soundPool));
        animalList.add(new Gorilla(this, soundPool));
        animalList.add(new Hen(this, soundPool));
        animalList.add(new Horse(this, soundPool));
        animalList.add(new Leopard(this, soundPool));
        animalList.add(new Owl(this, soundPool));
        animalList.add(new Pig(this, soundPool));
        animalList.add(new Sheep(this, soundPool));
        animalList.add(new Tiger(this, soundPool));
        animalList.add(new Wolf(this, soundPool));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adMob();

        recyclerView = findViewById(R.id.listview);
        recyclerView.setHasFixedSize(true);

        setSoundPool();

        setAnimals();

        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AnimalAdapter(animalList, this, new OnItemClickListener() {
            @Override
            public void onItemClick(Object o) {
                ((Animal)o).playSound();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void setSoundPool() {
        if (soundPool == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                AudioAttributes audioAttributes = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build();
                soundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(8).build();
            }
            else {
                soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
            }
        }
    }

    private void releaseSoundPool() {
        soundPool.release();
        soundPool = null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        setSoundPool();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseSoundPool();
    }

    private void adMob(){
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        AdView mAdView = findViewById(R.id.adView);
        Bundle extras = new Bundle();
        extras.putString("max_ad_content_rating", "G");
        AdRequest adRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                .build();
        mAdView.loadAd(adRequest);
    }
}
