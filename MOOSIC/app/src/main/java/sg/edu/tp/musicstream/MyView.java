package sg.edu.tp.musicstream;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sg.edu.tp.musicstream.util.AppUtil;

public class MyView extends RecyclerView.ViewHolder{

    public TextView title;
    public TextView artist;
    public ImageView image;
    public ImageButton removeBtn;

    public MyView(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        artist = itemView.findViewById(R.id.artist);
        image = itemView.findViewById(R.id.image);
        removeBtn = itemView.findViewById(R.id.removeBtn);
    }
}
