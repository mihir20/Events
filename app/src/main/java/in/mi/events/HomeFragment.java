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
import in.mi.events.databases.EventsDatabaseHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private ArrayList<Event> events;
    private EventsDatabaseHelper databaseHelper;

    private String user;

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
        user = MainActivity.USER_EMAIL;

        databaseHelper = new EventsDatabaseHelper( this.getContext() );
        recyclerView=rootView.findViewById( R.id.evnetsList );
        recyclerView.setHasFixedSize( true );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        events = new ArrayList<>(  );

        //save new event
        saveNewEventToDatabse();

        //load events from database
        loadEventsFromDatabase();


        eventAdapter = new EventAdapter( events );

        recyclerView.setAdapter( eventAdapter );

        return rootView;
    }

    private void loadEventsFromDatabase() {
        events = databaseHelper.getAllEvents();
    }

    private void saveNewEventToDatabse() {
        if(getArguments() != null){
            String title, author, description, imageUri;

            title = getArguments().getString( "TITLE" );
            author = user;
            description = getArguments().getString( "DESCRIPTION");
            imageUri = getArguments().getString( "IMAGE_URI" );

            Event event = new Event( title, author, description, imageUri) ;
            databaseHelper.addEvent( event );
        }
    }

}
