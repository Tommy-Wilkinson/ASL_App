package com.asl_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //generate a reference to the Drop Down Menu object (a spinner here)
    private Spinner dropDownMenu;
    private VideoView videoView;
    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find the Spinner view item from the app layout by id name in activity_main.xml file
        dropDownMenu = findViewById(R.id.dropDownMenu);
        videoView = (VideoView) findViewById(R.id.videoView);

        //counter variable to keep track of number of times video has played



        //generate an array of strings for the options in drop down menu
        // initialized here as an arraylist per android documentation
        //need an adapter to convert between a arraylist and view items
        //to be manipulated on screen.
        ArrayList<String> signs = new ArrayList<>();
            signs.add(0, "Choose a Sign");
            signs.add("Arrive");
            signs.add("Buy");
            signs.add("Communicate");
            signs.add("Create");
            signs.add("Drive");
            signs.add("Fun");
            signs.add("House");
            signs.add("Hope");
            signs.add("Lip");
            signs.add("Man");
            signs.add("Mother");
            signs.add("Mouth");
            signs.add("One");
            signs.add("Perfect");
            signs.add("Pretend");
            signs.add("Read");
            signs.add("Really");
            signs.add("Sister");
            signs.add("Some");
            signs.add("Write");


        //generate the adapter to turn array list into view items for interaction
        ArrayAdapter<String> spinAdapt;
        spinAdapt = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, signs);

        //Set theme of adapter
        spinAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //assign code reference to spinner widget to link program interaction and user interaction
        dropDownMenu.setAdapter(spinAdapt);


        //generate listener function to execute when an item in the list is selected/pressed
        dropDownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //TO DO need to override methog setSelection to make method fire again if
                //the same item is clicked in menu? May not need if shifting to new view
                //Do we want to have the drop down persist to allow easier switch to different signs?


                if(parent.getItemAtPosition(position).equals("Choose a Sign"))
                {
                    //Do Nothing.

                }else{
                    //get the name of item selected and save it as selection
                    String selection = parent.getItemAtPosition(position).toString();

                    counter = 0;
                    //pass selection through a switch statement to decide which video to launch
                    switch(selection)
                    {
                        //if selection matchs case name then execute code and break
                        //Set the path for the video view to find videos saved in Raw folder
                        //Commands to play video come after switch statement breaks
                        case "Arrive":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.arrive));
                        break;
                        case "Buy":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.buy));
                            break;
                        case "Communicate":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.communicate));
                            break;
                        case "Create":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.create));
                            break;
                        case "Drive":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.drive));
                            break;
                        case "Fun":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fun));
                            break;
                        case "Hope":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hope));
                            break;
                        case "House":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.house));
                            break;
                        case "Lip":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lip));
                            break;
                        case "Man":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.man));
                            break;
                        case "Mother":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mother));
                            break;
                        case "Mouth":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mouth));
                            break;
                        case "One":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.one));
                            break;
                        case "Perfect":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.perfect));
                            break;
                        case "Pretend":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pretend));
                            break;
                        case "Read":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.read));
                            break;
                        case "Really":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.really));
                            break;
                        case "Sister":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sister));
                            break;
                        case "Some":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.some));
                            break;
                        case "Write":
                            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.write));
                            break;


                        default:
                            break;


                    }


                    // Requests focus and starts to play video from switch statement if any returned
                    //
                    //TO DO: Need an exception handler for null path return?
                    //Have video repeat: automatically three time or implement a button with onClick listener?
                    //

                    videoView.requestFocus();
                    videoView.start();
                    //This line for testing only, remove later
                    Toast.makeText(parent.getContext(), "Pressed on " + selection,Toast.LENGTH_SHORT).show();
                    //To Do
                    //Add code to load new View? Or continue to use this initial layout
                    //Load a Video resource from file based on ID of selection
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(counter < 2) {
                    counter++;
                    videoView.start();
                }
            }
        });


    }
}
