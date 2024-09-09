package com.astooltech.advancedview.proteus.chat.dialogs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.chat.commons.data.fixtures.MessagesFixtures;
import com.astooltech.advancedview.proteus.chat.commons.data.model.Message;
import com.astooltech.advancedview.proteus.chat.commons.models.IMessage;
import com.astooltech.advancedview.proteus.chat.messages.MessageInput;
import com.astooltech.advancedview.proteus.chat.messages.MessagesList;
import com.astooltech.advancedview.proteus.chat.messages.MessagesListAdapter;
import com.astooltech.advancedview.proteus.chat.utils.AppUtils;
import com.astooltech.advancedview.proteus.demo.MyReceiver;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;

import java.lang.reflect.Type;

public class DefaultMessagesActivity extends DemoMessagesActivity
        implements MessageInput.InputListener,
        MessageInput.AttachmentsListener,
        MessageInput.TypingListener, MessagesListAdapter.OnMessageLongClickListener, MyReceiver.ConnectivityReceiverListener{

    public static void open(Context context) {
        context.startActivity(new Intent(context, DefaultMessagesActivity.class));
    }

    private MessagesList messagesList;
    //;
    @Override
    public void onNetworkConnectionChanged(boolean isConnected, int typ, String Dataa) {
       // proteusManager.sendsend("WebView",Dataa);
    }
    @Override
    public void onbackpress(String a1, String a2) {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_messages);

        Bundle bundle=getIntent().getExtras();
        String typActivity="0";
        if (bundle != null) {
            typActivity= bundle.getString("data");
            //  Apigetdata = bundle.getString("api");

        }
mdat=typActivity.split("@");//new String[]{"card1","tt","card2","card5","card1","card5"};
        this.messagesList = findViewById(R.id.messagesList);
        initAdapter();

        MessageInput input = findViewById(R.id.input);
        input.setInputListener(this);
        input.setTypingListener(this);
        input.setAttachmentsListener(this);

    }
public  Value typad(String mess){

    ProteusTypeAdapterFactory  adapter = new ProteusTypeAdapterFactory(this);
    Gson   gsonn  = new GsonBuilder()
            .registerTypeAdapterFactory(adapter)
            .create();
        //String messagee="\"";
        String mes="{\"message\":\""+mess+"\"}";
    String k="{s1:"+mes+"}";

    Type type = new TypeToken<Value>() {

    }.getType();
    Value tempp = gsonn.fromJson(mes, type);

    return  tempp;
}
    @Override
    public boolean onSubmit(CharSequence input) {

    ObjectValue re=  typad(input.toString()).getAsObject();
      Gson tt=new Gson();
        Log.i("ghghgh",tt.toJson(re));
        super.messagesAdapter.addToStart(
                MessagesFixtures.getTextMessage(input.toString(),re), true,layoutInflaterr,mdat);

        return true;
    }

    @Override
    public void onAddAttachments() {
        super.messagesAdapter.addToStart(
                MessagesFixtures.getImageMessage(), true,layoutInflaterr,mdat);
    }

    private void initAdapter() {
        super.messagesAdapter = new MessagesListAdapter<>(super.senderId, super.imageLoader);
        super.messagesAdapter.enableSelectionMode(this);
        super.messagesAdapter.setOnMessageLongClickListener(this);
        super.messagesAdapter.setLoadMoreListener(this);
        super.messagesAdapter.registerViewClickListener(R.id.messageUserAvatar,
                new MessagesListAdapter.OnMessageViewClickListener<Message>() {
                    @Override
                    public void onMessageViewClick(View view, Message message) {
                        AppUtils.showToast(DefaultMessagesActivity.this,
                                message.getUser().getName() + " avatar click",
                                false);
                    }
                });
        this.messagesList.setAdapter(super.messagesAdapter);
    }

    @Override
    public void onStartTyping() {
        Log.v("Typing listener", "Stop");
    }

    @Override
    public void onStopTyping() {
        Log.v("Typing listener", "notdddd");
    }

    @Override
    public void onMessageLongClick(IMessage message) {
        Log.v("Typing listener", "notsssssssssssssdddd"+message.getText());
    }


    @Override
    public void onFastScrollerStateChange(boolean scrolling) {

    }

    @Override
    public void onItemLongClick(int position) {

    }

    @Override
    public void onActionStateChanged(RecyclerView.ViewHolder viewHolder, int actionState) {

    }

    @Override
    public boolean shouldMoveItem(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {

    }

    @Override
    public void onItemSwipe(int position, int direction) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return onQueryTextChange(query);
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        /*if (mAdapter.hasNewFilter(newText)) {
            com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.Log.d("onQueryTextChange newText: " + newText);
            mAdapter.setFilter(newText);

            // Fill and Filter mItems with your custom list and automatically animate the changes
            // - Option A: Use the internal list as original list
            mAdapter.filterItems(DatabaseConfiguration.delay);

            // - Option B: Provide any new list to filter
            //mAdapter.filterItems(DatabaseService.getInstance().getDatabaseList(), DatabaseConfiguration.delay);
        }
        // Disable SwipeRefresh if search is active!!
        mSwipeRefreshLayout.setEnabled(!mAdapter.hasFilter());*/
        return true;
    }
}
