package sa.devming.babyplayanimal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    private Context context;
    private final ArrayList items;
    private final OnItemClickListener listener;

    private int lastPosition = -1;

    public AnimalAdapter(ArrayList items, Context context, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
        this.items = items;
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 새로운 뷰를 만든다
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item, parent, false);
        return new AnimalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        holder.imageView.setImageResource((int)items.get(position));
        holder.bind((int)items.get(position), listener);
        setAnimation(holder.imageView, position);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    private void setAnimation(View viewToAnimate, int position) {
        // 새로 보여지는 뷰라면 애니메이션을 해줍니다
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    class AnimalViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        private AnimalViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.animal);
        }

        private void bind(final int animal, final OnItemClickListener listener) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(animal);
                }
            });
        }
    }
}
