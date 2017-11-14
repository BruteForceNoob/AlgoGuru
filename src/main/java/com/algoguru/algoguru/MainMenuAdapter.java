package com.algoguru.algoguru;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by faculty_access on 12-Nov-17.
 */

public class MainMenuAdapter extends BaseExpandableListAdapter {

    Context context;
    List<String> labels;
    Map<String,List<String>> itemMap;

    public MainMenuAdapter(Context context, List<String> labels, Map<String, List<String>> itemMap) {
        this.context = context;
        this.labels = labels;
        this.itemMap = itemMap;
    }

    @Override
    public int getGroupCount() {
        return labels.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return itemMap.get(labels.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return labels.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return itemMap.get(labels.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String label= (String)getGroup(i);
        if(view == null)
        {
            LayoutInflater layoutInflater= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view= layoutInflater.inflate(R.layout.list_parent,null);

        }
        TextView textLabelView = (TextView) view.findViewById(R.id.labelView);

        textLabelView.setText(label);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String item = (String) getChild(i,i1);

        if(view == null)
        {
            LayoutInflater layoutInflater= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view= layoutInflater.inflate(R.layout.list_items,null);

        }
        TextView textItemView = (TextView) view.findViewById(R.id.itemView);

        textItemView.setText(item);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
