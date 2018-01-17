package in.mi.events;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.mi.events.classes.Event;
import in.mi.events.classes.EventAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private ArrayList<Event> events;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate( R.layout.fragment_home,
                container,
                false );
        MainActivity.fab.setVisibility( View.VISIBLE );

        recyclerView=rootView.findViewById( R.id.evnetsList );
        recyclerView.setHasFixedSize( true );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        events = new ArrayList<>(  );

        //Load new event
        loadNewEvent();



        eventAdapter = new EventAdapter( events );

        recyclerView.setAdapter( eventAdapter );

        return rootView;
    }

    private void loadNewEvent() {
        if(getArguments() != null){
            String title, author, description, imageUri;

            title = getArguments().getString( "TITLE" );
            author = "Mihir";
            description = getArguments().getString( "DESCRIPTION");
            imageUri = getArguments().getString( "IMAGE_URI" );

            Event event = new Event( title, author, description, imageUri) ;
            events.add( event );
        }
    }

}
