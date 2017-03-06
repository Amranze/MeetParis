package fr.amrane.amranetest.conversation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import fr.amrane.amranetest.R;
import fr.amrane.amranetest.conversation.adapter.ListModel;

/**
 * Created by Amrane Ait Zeouay on 01-Mar-17.
 */

public class ListAdapter extends ArrayAdapter<ListModel> {

    //public ListAdapter(Context context, String[] foods, int[] imgs) {
    public ListAdapter(Context context, List<ListModel> foods) {
        super(context, R.layout.custom_row ,foods);
        //super(context, R.layout.custom_row ,foods);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater infalter = LayoutInflater.from(getContext());
        View customView = infalter.inflate(R.layout.custom_row, parent, false);

        String singleStringItem = getItem(position).getName();
        String singleConversation = getItem(position).getMessage();
        int drawableIcon = getItem(position).getImgDrawable();

        TextView textView = (TextView) customView.findViewById(R.id.textView);
        TextView tv_conversation = (TextView) customView.findViewById(R.id.tv_conversation);
        ImageView imageView = (ImageView) customView.findViewById(R.id.imageView);

        textView.setText(singleStringItem);
        tv_conversation.setText(singleConversation);
        imageView.setImageResource(drawableIcon);
        return customView;
    }
}
