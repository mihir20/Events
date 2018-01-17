package in.mi.events.classes;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.mi.events.R;

/**
 * Created by mi on 17/1/18.
 */

public class EventHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{

    TextView title,author, description;
    ImageView imageView;
    AppCompatImageView srcImage;

    public EventHolder(View itemView) {
        super( itemView );
        title = itemView.findViewById( R.id.eventTitleID );
        author=itemView.findViewById( R.id.eventAuthorID );
        description = itemView.findViewById( R.id.eventDesccriptionID );
        imageView = itemView.findViewById( R.id.eventLikedImageID );
        imageView.setTag( "NOT_LOVED");
        imageView.setImageResource( R.drawable.ic_favorite_black_24dp );
        srcImage = itemView.findViewById( R.id.eventImageID );
        itemView.setOnLongClickListener( this );
    }


    @Override
    public boolean onLongClick(View v) {

        if (imageView.getTag() == "NOT_LOVED" ){
            imageView.setTag( "LOVED" );
            imageView.setImageResource( R.drawable.loved_ic );}
        else {
            imageView.setTag( "NOT_LOVED" );
            imageView.setImageResource( R.drawable.ic_favorite_black_24dp );
        }
        return true;
    }
}

