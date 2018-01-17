package in.mi.events.classes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.mi.events.R;

/**
 * Created by mi on 17/1/18.
 */

public class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView title,author, description;
    ImageView imageView,srcImage;

    public EventHolder(View itemView) {
        super( itemView );
        title = itemView.findViewById( R.id.eventTitleID );
        author=itemView.findViewById( R.id.eventAuthorID );
        description = itemView.findViewById( R.id.eventDesccriptionID );
        imageView = itemView.findViewById( R.id.eventLikedImageID );
        imageView.setTag( R.drawable.ic_favorite_black_24dp);
        imageView.setImageResource( R.drawable.ic_favorite_black_24dp );
        srcImage = itemView.findViewById( R.id.eventImageID );
        itemView.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {

    }
}
