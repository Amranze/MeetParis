package fr.amrane.amranetest.message.presenter;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.text.format.DateUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import fr.amrane.amranetest.R;
import fr.amrane.amranetest.account.model.Account;
import fr.amrane.amranetest.account.repository.AccountRepository;
import fr.amrane.amranetest.account.repository.AccountRepositoryImpl;
import fr.amrane.amranetest.message.adapter.ChatAdapter;
import fr.amrane.amranetest.message.model.Message;
import fr.amrane.amranetest.message.view.MessageView;

/**
 * Created by aaitzeouay on 28/02/2017.
 */

public class MessagePresenter {
    private ArrayList<Message> messages;
    private ChatAdapter chatAdapter;
    private Account user;
    private Date lastMessageDate;
    private MessageView mView;
    private AccountRepository accountRepository;

    public MessagePresenter(){
        messages = new ArrayList<Message>();
        accountRepository = new AccountRepositoryImpl();
        //chatAdapter = new ChatAdapter();
        //user = new Account();
    }

    public void sendMessages(Message message){
        //user = accountRepository.getCurrentUser();
        if(user != null){
            message.setStatus(Message.STATUS_SENDING);
            messages.add(message);
            //new AsyncTask<Void>();
        }
    }

    public void loadMessages(){

    }


    private class ChatAdapter extends BaseAdapter {

        /* (non-Javadoc)
         * @see android.widget.Adapter#getCount()
         */
        @Override
        public int getCount() {
            return messages.size();
        }

        /* (non-Javadoc)
         * @see android.widget.Adapter#getItem(int)
         */
        @Override
        public Message getItem(int arg0) {
            return messages.get(arg0);
        }

        /* (non-Javadoc)
         * @see android.widget.Adapter#getItemId(int)
         */
        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        /* (non-Javadoc)
         * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
         */
        @SuppressLint("InflateParams")
        @Override
        public View getView(int pos, View v, ViewGroup arg2) {
            Message message = getItem(pos);
            //if (message.isMessageSent())
                //v = getLayoutInflater().inflate(R.layout.chat_item_sent, null);
            //else
                //v = getLayoutInflater().inflate(R.layout.chat_item_rcv, null);

            TextView lbl = (TextView) v.findViewById(R.id.lbl1);
            lbl.setText(DateUtils.getRelativeDateTimeString(mView.getContext(), message.getTimeStamp(), DateUtils.SECOND_IN_MILLIS,
                    DateUtils.DAY_IN_MILLIS, 0));

            lbl = (TextView) v.findViewById(R.id.lbl2);
            lbl.setText(message.getMessage());

            lbl = (TextView) v.findViewById(R.id.lbl3);
            if (message.getStatus() == Message.STATUS_SENT) {
                if (message.getStatus() == Message.STATUS_SENT)
                    lbl.setText(R.string.delivered_text);
                else {
                    if (message.getStatus() == Message.STATUS_SENDING)
                        lbl.setText(R.string.sending_text);
                    else {
                        lbl.setText(R.string.failed_text);
                    }
                }
            } else
                lbl.setText("");

            return v;
        }

    }
}
