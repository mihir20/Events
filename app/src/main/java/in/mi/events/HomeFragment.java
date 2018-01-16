package in.mi.events;


import android.os.Bundle;
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

        recyclerView=rootView.findViewById( R.id.evnetsList );
        recyclerView.setHasFixedSize( true );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        events = new ArrayList<>(  );
        events.add( new Event( "Meeting",
                "Mihir",
                "Today is senate meeting under mihir" ));
        events.add( new Event( "Game",
                "Mihir",
                "Today is Final day of India vs South Africa Test Match" ));
        eventAdapter = new EventAdapter( events );

        recyclerView.setAdapter( eventAdapter );

        return rootView;
    }

}
