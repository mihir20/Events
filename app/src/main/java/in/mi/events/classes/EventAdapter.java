package in.mi.events.classes;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.mi.events.R;

/**
 * Created by mi on 17/1/18.
 */

public class EventAdapter extends RecyclerView.Adapter<EventHolder> {

    ArrayList<Event> events;

    public EventAdapter(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.event_list_element,parent,false );
        EventHolder eventHolder= new EventHolder( v );

        return eventHolder;
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {

        holder.title.setText( events.get( position ).getTitle() );
        holder.author.setText( events.get( position ).getAuthor() );
        holder.description.setText( events.get( position ).getDescription() );
        holder.srcImage.setImageURI( Uri.parse(events.get(position).getImageUri()) );

    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
