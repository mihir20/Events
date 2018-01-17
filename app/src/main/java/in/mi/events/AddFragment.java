package in.mi.events;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    private static final int RESULT_LOAD_IMAGE = 1;
    TextInputEditText titleText, descriptionText;
    AppCompatButton addButton;
    AppCompatImageView imageView;
    FloatingActionButton fab;
    Uri selectedImage;
    HomeFragment homeFragment = new HomeFragment();

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            selectedImage = data.getData();
            imageView.setImageURI( selectedImage );

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate( R.layout.fragment_add, container, false );

        fab = rootView.findViewById( R.id.sendFAB );
        titleText = rootView.findViewById( R.id.textInputEditTextTitle );
        descriptionText = rootView.findViewById( R.id.textInputEditTextDescription );
        imageView = rootView.findViewById( R.id.addImageIV );
        addButton = rootView.findViewById( R.id.appCompatButtonAddImage );
        addButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        } );

        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle(  );
                b.putString( "TITLE",titleText.getText().toString() );
                b.putString( "DESCRIPTION", descriptionText.getText().toString() );

                if (selectedImage!=null){
                    b.putString( "IMAGE_URI", selectedImage.toString() );
                    homeFragment.setArguments( b );
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace( R.id.frame, homeFragment ).commit();
                }
                else {
                    Toast.makeText( v.getContext(),"Select Image",Toast.LENGTH_SHORT ).show();
                }

            }
        } );



        return rootView;
    }

}
