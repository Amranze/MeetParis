package fr.amrane.amranetest.message.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

import fr.amrane.amranetest.R;
import fr.amrane.amranetest.message.model.Message;

/**
 * Created by aaitzeouay on 27/02/2017.
 */

public class ChatAdapter extends ArrayAdapter<Message> {
    private long userId;

    public ChatAdapter(Context context, long userId, List<Message> messages) {
        super(context, 0, messages);
        this.userId = userId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.chat_view, parent, false);
            final ViewHolder holder = new ViewHolder();

            holder.imageLeft = (ImageView) convertView.findViewById(R.id.dater_profile);
            holder.imageRight = (ImageView) convertView.findViewById(R.id.user_profile);
            convertView.setTag(holder);
        }
        final Message messge = (Message) getItem(position);
        final ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.imageLeft.setVisibility(View.GONE);
        holder.body.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);

        final ImageView profileView =  holder.imageRight;
        Picasso.with(getContext()).load(getProfileAvatar(messge.getIdSender())).into(profileView);
        return super.getView(position, convertView, parent);
    }

    private static String getProfileAvatar(final long userId){
        String hex ="";
        String userid = String.valueOf(userId);

        try {
            final MessageDigest digest = MessageDigest.getInstance("MD5");
            final byte[] hash = digest.digest(userid.getBytes());
            final BigInteger bigInteger = new BigInteger(hash);
            hex = bigInteger.abs().toString(16);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "http://www.gravatar.com/"+hex+"?d=identicon";
    }

    class ViewHolder {
        public ImageView imageLeft;
        public ImageView imageRight;
        public TextView body;
    }
}
