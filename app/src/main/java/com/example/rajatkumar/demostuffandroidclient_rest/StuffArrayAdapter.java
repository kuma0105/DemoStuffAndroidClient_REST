package com.example.rajatkumar.demostuffandroidclient_rest;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
public class StuffArrayAdapter extends ArrayAdapter<Stuff> {
    // class for reusing views as list items scroll off and onto the screen
    private static class ViewHolder {
        TextView stuffIDTextView;
        TextView recordNumberTextView;
        TextView omegaTextView;
        TextView deltaTextView;
        TextView thetaTextView;
    }

    public StuffArrayAdapter(Context context, List<Stuff> stuffs) {
        super(context, -1, stuffs);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        try {
            // get Stuff object for this specified ListView position
            Stuff stuffItem = getItem(position);
            ViewHolder viewHolder;
            // object that reference's list item's views
            // check for reusable ViewHolder from a ListView item that scrolled // offscreen; otherwise, create a new ViewHolder
            if (convertView == null) {
                // no reusable ViewHolder, so create one
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.list_item, parent, false);
                viewHolder.stuffIDTextView = (TextView) convertView.findViewById(R.id.stuffIDTextView);
                viewHolder.recordNumberTextView = (TextView) convertView.findViewById(R.id.recordNumberTextView);
                viewHolder.omegaTextView = (TextView) convertView.findViewById(R.id.omegaTextView);
                viewHolder.deltaTextView = (TextView) convertView.findViewById(R.id.deltaTextView);
                viewHolder.thetaTextView = (TextView) convertView.findViewById(R.id.thetaTextView);
                convertView.setTag(viewHolder);
            }
            else {
                // reuse existing ViewHolder stored as the list item's tag
                viewHolder = (ViewHolder) convertView.getTag();
            }
            // get other data from Stuff object and place into views
            Context context = getContext();
            // for loading String resources
            viewHolder.stuffIDTextView.setText(context.getString( R.string.demoStuff_id, stuffItem.id));
            viewHolder.recordNumberTextView.setText( context.getString(R.string.demoStuff_recordNumber, stuffItem.recordNumber));
            viewHolder.omegaTextView.setText( context.getString(R.string.demoStuff_omega, stuffItem.omega));
            viewHolder.deltaTextView.setText( context.getString(R.string.demoStuff_delta, stuffItem.delta));
            viewHolder.thetaTextView.setText( context.getString(R.string.demoStuff_theta, stuffItem.theta));
        }
        catch(Exception e){
            System.out.println(e.getMessage()); }
        return convertView;
        // return completed list item to display
    }
}

