package sa.devming.babyplayanimal;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class AnimalDialog extends Dialog {
    private Context context;
    private int imageRes;

    public AnimalDialog(Context context, int imageRes) {
        super(context);
        this.context = context;
        this.imageRes = imageRes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.animal_dialog);
        ImageView imageView = findViewById(R.id.dialog_img);
        imageView.setImageResource(imageRes);
    }
}
