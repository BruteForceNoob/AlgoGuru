package com.algoguru.algoguru;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by faculty_access on 12-Nov-17.
 */

public class ContentFragment extends Fragment {

    public String titleText;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.content_scroll_view, container, false);

        titleText= this.getArguments().getString("titleText");
        TextView textView = rootView.findViewById(R.id.title);
        textView.setText(titleText);
        WebView videoView= rootView.findViewById(R.id.videoView);
        TextView contentView= rootView.findViewById(R.id.contentView);
        videoView.setVisibility(View.GONE);
        contentView.setVisibility(View.GONE);

      // String uriPath = "android.resource://"+MainActivity.PACKAGE_NAME+"/"+R.raw.videoplayback;
        //uriPath="https://www.youtube.com/watch?v=nmhjrI-aW5o";
        //String uriPath ="C://Users//sujeeth//AndroidStudioProjects//AlgoGuru//app//src//main//res//drawable//bubble_sort_example.gif";
       // Uri uri = Uri.parse(uriPath);
        //MediaController mediaController= new MediaController();
        String x="<!DOCTYPE html><html><body><img src=\"https://thumbs.gfycat.com/SilkyBrownHoverfly-max-1mb.gif\" alt=\"Smileyface\" width=\"100%\" height=\"100%\"></body></html>";
        String linearSearchGif="<!DOCTYPE html><html><body><img src=\"https://www.tutorialspoint.com/data_structures_algorithms/images/linear_search.gif\" alt=\"Smileyface\" width=\"100%\" height=\"100%\"></body></html>";
        switch(titleText) {
            case "Bubble Sort Explained":

                videoView.setVisibility(View.VISIBLE);
                videoView.loadData(x, "text/html", "utf-8");
                break;

            case "Bubble Sort Theory":

                contentView.setVisibility(View.VISIBLE);
                contentView.setText("Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.");
                break;

            case "Big O! Theory":

                contentView.setVisibility(View.VISIBLE);
                contentView.setText("Big O notation is used in Computer Science to describe the performance or complexity of an algorithm. Big O specifically describes the worst-case scenario, and can be used to describe the execution time required or the space used (e.g. in memory or on disk) by an algorithm");
                break;

            case "Linear Search Theory":

                contentView.setVisibility(View.VISIBLE);
                contentView.setText("In computer science, linear search or sequential search is a method for finding a target value within a list. It sequentially checks each element of the list for the target value until a match is found or until all the elements have been searched.");
                break;

            case "Linear Search Explained":

                videoView.setVisibility(View.VISIBLE);
                videoView.loadData(linearSearchGif, "text/html", "utf-8");

                break;




        }


        return rootView;
    }
}