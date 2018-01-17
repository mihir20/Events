package in.mi.events;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements
         NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView mNavigationView;
    FragmentTransaction fragmentTransaction;
    public static FloatingActionButton fab;
    public static String USER_EMAIL ;
    HomeFragment homeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //setting user
        USER_EMAIL = getIntent().getExtras().getString( "EMAIL" );

        drawerLayout= findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mNavigationView = findViewById(R.id.navigation_view);
        fab = findViewById( R.id.fab );
        homeFragment = new HomeFragment();

        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.frame,new AddFragment() ).commit();
                fab.setVisibility( View.GONE );
            }
        } );


        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);
        }


        //setting default screen
        mNavigationView.setCheckedItem( R.id.home );
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, homeFragment);
        transaction.commit();


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.frame,new HomeFragment() ).commit();
                drawerLayout.closeDrawers();
                return true;
            case R.id.sighOut:
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.frame,new AddFragment() ).commit();
                drawerLayout.closeDrawers();
                return true;
            default:
                return true;
        }


    }


}
