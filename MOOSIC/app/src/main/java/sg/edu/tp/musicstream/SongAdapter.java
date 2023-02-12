package sg.edu.tp.musicstream;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import sg.edu.tp.musicstream.util.AppUtil;

public class SongAdapter extends RecyclerView.Adapter<MyView> {
    public SongAdapter(List<Song> songs) {
        this.songs = songs;
    }

    List<Song> songs;
    Context context;
    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View songView = inflater.inflate(R.layout.item_song,parent,false);
        MyView viewHolder = new MyView(songView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, final int position) {
        Song song = songs.get(position);
        TextView artist = holder.artist;
        artist.setText(song.getArtist());
        TextView title = holder.title;
        title.setText(song.getTitle());
        int imageId = AppUtil.getImageIdFromDrawable(context, song.getCoverArt());
        holder.image.setImageResource(imageId);
        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.favList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }
}
