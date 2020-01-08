package com.unbusy.e_ticketapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class StationListAdapter extends ArrayAdapter {
    private static final String TAG = "StationListAdapter";

    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<Station> stations;
//    private RadioButton selected = null;

    public StationListAdapter(Context context, int resource, List<Station> stations) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.stations = stations;
    }

    @Override
    public int getCount() {
        return stations.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null){

            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.stationRB = convertView.findViewById(R.id.stationName);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Station currentApp = stations.get(position);

        viewHolder.stationRB.setText(currentApp.getStName());

//        //by default last radio button selected
//        if (position == getCount() - 1) {
//            if (selected == null) {
//                viewHolder.stationRB.setChecked(true);
//                selected = viewHolder.stationRB;
//            }
//        }
//
//        viewHolder.stationRB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (selected != null) {
//                    selected.setChecked(false);
//                }
//                viewHolder.stationRB.setChecked(true);
//                selected = viewHolder.stationRB;
//
//                Log.d(TAG, "onClick: " + selected.getText().toString());
//            }
//        });

        return convertView;
    }

    private static class ViewHolder {
        TextView stationRB;
    }
}
