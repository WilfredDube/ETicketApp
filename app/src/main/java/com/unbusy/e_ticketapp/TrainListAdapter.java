package com.unbusy.e_ticketapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TrainListAdapter extends ArrayAdapter {
    private static final String TAG = "TrainListAdapter";

    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<TrainData> trips;

    public TrainListAdapter(Context context, int resource, List<TrainData> trips) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.trips = trips;
    }

    @Override
    public int getCount() {
        return trips.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){

            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.trainName = convertView.findViewById(R.id.trainName);
            viewHolder.seatsLeft = convertView.findViewById(R.id.seatsLeft);
            viewHolder.compartmentType = convertView.findViewById(R.id.compartmentType);
            viewHolder.trainStops = convertView.findViewById(R.id.trainStops);
            viewHolder.arrivalTime = convertView.findViewById(R.id.arrivalTime);
            viewHolder.departureTime = convertView.findViewById(R.id.departureTime);
            viewHolder.tripCost = convertView.findViewById(R.id.tripCost);
            viewHolder.fromPlace = convertView.findViewById(R.id.fromPlace);
            viewHolder.toPlace = convertView.findViewById(R.id.toPlace);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TrainData currentApp = trips.get(position);

        viewHolder.trainName.setText(currentApp.getTrainName());
        viewHolder.seatsLeft.setText("" + currentApp.getSeatsLeft());
        viewHolder.compartmentType.setText(currentApp.getCompartmentType());
        viewHolder.trainStops.setText("" + currentApp.getTrainStops());
        viewHolder.arrivalTime.setText(currentApp.getArrivalTime());
        viewHolder.departureTime.setText(currentApp.getDepartureTime());
        viewHolder.tripCost.setText(String.format("$%.2f",currentApp.getTripCost()));
        viewHolder.fromPlace.setText(currentApp.getFromPlace());
        viewHolder.toPlace.setText(currentApp.getToPlace());

        return convertView;
    }

    private static class ViewHolder {
        TextView trainName;
        TextView seatsLeft;
        TextView compartmentType;
        TextView trainStops;
        TextView arrivalTime;
        TextView departureTime;
        TextView tripCost;
        TextView fromPlace;
        TextView toPlace;
    }
}
