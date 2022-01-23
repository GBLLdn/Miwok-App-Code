package com.example.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import android.widget.AdapterView;

import java.util.ArrayList;



public class WordAdapter extends ArrayAdapter <Word> {



    /** Resource ID for the background color for this list of words */

    private int mColorResourceId;

    private int mAudioResourceId;

    /*
     * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
     * based on a data source, which is a list of {@link WordAdapter} objects.
     * */

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words   A List of WordAdapter objects to display in a list
     * @param colorResourceId is the resource ID for the background color for this list of words
     */

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {



        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, words);

        mColorResourceId = colorResourceId;

    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.miwok_two_text, parent, false);
        }


        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the miwok_two_text.xml layout with the ID miwok_text_view
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);

        // Get the miwokTranslation from the current Word object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the miwok_two_text.xml layout with the ID default_text_view
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);

        // Get the miwokTranslation from the current Word object and
        // set this text on the name TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the miwok_two_text.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.icon_image);

        if (currentWord.hasImage()) {
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentWord.getImageResourceId());

            iconView.setVisibility(View.VISIBLE);

        }
        else{
            iconView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);

        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);


        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}