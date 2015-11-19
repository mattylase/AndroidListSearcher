package software.sweven.ListSearcher;

/**
 * Created by mlaser on 11/19/15.
 */
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mattylase on 11/18/15.
 */
public class StringListAdapter extends BaseAdapter{
    final StringSearchUtility mStringSearchUtility;
    final ArrayList<String> mControlList;
    final ArrayList<String> listOfNames;
    final LayoutInflater mInflater;

    StringListAdapter(ArrayList<String> names, LayoutInflater inflater, StringSearchUtility util) {
        mControlList = new ArrayList<String>(names);
        listOfNames = new ArrayList<String>(names);
        mStringSearchUtility = util;
        mInflater = inflater;
    }

    @Override
    public int getCount() {
        return listOfNames.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addNameCharacter(Character c) {
        if (Character.isAlphabetic(c)) {
            List<Integer> indices = mStringSearchUtility.checkIndicesForCharacter(c);

            List<String> namesToKeep = new ArrayList<String>();
            for (Integer i : indices) {
                namesToKeep.add(mControlList.get(i));
            }

            listOfNames.clear();
            listOfNames.addAll(namesToKeep);
            this.notifyDataSetChanged();
        }
    }

    public void resetList() {
        mStringSearchUtility.clearNames();
        listOfNames.clear();
        listOfNames.addAll(mControlList);
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view;
        if (convertView == null) {
            view = (TextView) mInflater.inflate(android.R.layout.simple_list_item_1, null);
            view.setText(listOfNames.get(position));
        } else {
            view = (TextView) convertView;
            view.setText(listOfNames.get(position));
        }
        return view;
    }
}


