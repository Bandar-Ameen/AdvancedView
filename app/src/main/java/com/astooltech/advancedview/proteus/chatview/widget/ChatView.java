package com.astooltech.advancedview.proteus.chatview.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.CallSuper;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.OverallItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.SimpleItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.SubItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.SelectableAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.ActionModeHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFlexible;
import com.astooltech.advancedview.proteus.chatview.data.Message;
import com.astooltech.advancedview.proteus.chatview.data.MessageAdapter;
import com.astooltech.advancedview.proteus.chatview.data.OverallItemChatItem;
import com.astooltech.advancedview.proteus.chatview.photoview.ExpandIconView;
import com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
//import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator;

/**
 * Created by shrikanthravi on 20/02/18.
 */

public class ChatView extends RelativeLayout implements FlexibleAdapter.OnItemClickListener, FlexibleAdapter.OnItemLongClickListener, FlexibleAdapter.OnDeleteCompleteListener, FlexibleAdapter.OnItemMoveListener, FlexibleAdapter.OnItemSwipeListener, FlexibleAdapter.OnUpdateListener {

    public static int Personal = 1;
    public static int Group = 2;

    protected Context mContext;
    protected LayoutInflater mLayoutInflater;

    protected int mode=1;
    protected boolean more=false;
    protected RelativeLayout mLayoutRoot;
    protected RecyclerView chatRV;
    protected LinearLayout sendLL;

    public LinearLayout getM_hedaerContiner() {
        return M_hedaerContiner;
    }

    public ActionModeHelpercu getmActionModeHelper() {
        return mActionModeHelper;
    }

    private  ActionModeHelpercu mActionModeHelper;
    private LinearLayout M_hedaerContiner;
    public ImageButton getM_option() {
        return M_option;
    }

    private ImageButton M_option;

    public ImageButton getM_Back() {
        return M_Back;
    }

    public TextView getM_userName() {
        return M_userName;
    }

    public TextView getM_userStatuse() {
        return M_userStatuse;
    }

    public CircleImageView getM_profile() {
        return M_profile;
    }

    private ImageButton M_Back;
    private TextView M_userName;
    private TextView M_userStatuse;
    private de.hdodenhof.circleimageview.CircleImageView M_profile;
    protected MaterialRippleLayout sendMRL;
    protected HorizontalScrollView moreHSV;
    protected MaterialRippleLayout galleryMRL,videoMRL,cameraMRL,audioMRL,micMRL;
    protected ExpandIconView expandIconView;
    protected List<AbstractFlexibleItem> messageList;

    public MessageAdapter getMessageAdapter() {
        return messageAdapter;
    }

    protected MessageAdapter messageAdapter;
    protected boolean showSenderLL=false;
    protected boolean showLeftBubbleIcon=true;
    protected boolean showRightBubbleIcon=true;
    protected boolean showSenderName=true;
    protected EditText messageET;

    private int leftBubbleLayoutColor = R.color.colorAccent2;
    private int rightBubbleLayoutColor = R.color.colorAccent1;
    private int leftBubbleTextColor = android.R.color.black;
    private int rightBubbleTextColor = android.R.color.white;
    private int chatViewBackgroundColor = android.R.color.white;
    private int timeTextColor = android.R.color.tab_indicator_text;
    private int senderNameTextColor = android.R.color.tab_indicator_text;
    private int ChatViewBackgroundColor = android.R.color.white;
    private Typeface typeface;
    private OnClickSendButtonListener onClickSendButtonListener;
    private OnClickGalleryButtonListener onClickGalleryButtonListener;
    private OnClickVideoButtonListener onClickVideoButtonListener;
    private OnClickCameraButtonListener onClickCameraButtonListener;
    private OnClickAudioButtonListener onClickAudioButtonListener;
    private OnTouchMicButtonListener onTouchMicButtonListener;

public void refresh(){

    mLayoutRoot.invalidate();
}
    public ChatView(Context context, AttributeSet attrs) {
        super(context, attrs);


        init(context);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ChatView,
                0, 0);
        setAttributes(a);
        a.recycle();

    }
    private void initializeActionModeHelper(@SelectableAdapter.Mode int mode) {
        mActionModeHelper = new ActionModeHelpercu() {
            @Override
            public void updateContextTitle(int count) {
                if (mActionMode != null) {//You can use the internal ActionMode instance
                    mActionMode.setTitle(count == 1 ?
                            getContext().getString(R.string.action_selected_one, Integer.toString(count)) :
                            getContext().getString(R.string.action_selected_many, Integer.toString(count)));
                }
            }
        }.withDefaultMode(mode)
                .disableDragOnActionMode(true)
                .disableSwipeOnActionMode(true);
    }

    @SuppressLint("WrongConstant")
    protected void init(Context context){

        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);

        //load rootview from xml
        View rootView = mLayoutInflater.inflate(R.layout.widget_chatview, this, true);

        //initialize UI
        mLayoutRoot = rootView.findViewById(R.id.rootRL);
        chatRV = rootView.findViewById(R.id.chatRV);
        sendLL = rootView.findViewById(R.id.sendLL);
        sendMRL = rootView.findViewById(R.id.sendMRL);
        M_hedaerContiner=rootView.findViewById(R.id.sendLLfk);
        M_hedaerContiner.setVisibility(View.GONE);
        moreHSV = rootView.findViewById(R.id.moreLL);
        M_option=rootView.findViewById(R.id.M_Option);
        M_Back=rootView.findViewById(R.id.M_back);
        M_profile=rootView.findViewById(R.id.M_profile);
        M_userName=rootView.findViewById(R.id.M_message_userName);
        M_userStatuse=rootView.findViewById(R.id.M_message_userOnline);
        messageET = rootView.findViewById(R.id.messageET);
        galleryMRL = rootView.findViewById(R.id.galleryMRL);
        videoMRL = rootView.findViewById(R.id.videoMRL);
        cameraMRL = rootView.findViewById(R.id.cameraMRL);
        audioMRL = rootView.findViewById(R.id.audioMRL);
        micMRL = rootView.findViewById(R.id.micMRL);
        expandIconView = rootView.findViewById(R.id.expandIconView);
        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList,context,chatRV,context);
       /* WrapContentLinearLayoutManager layoutManager = new WrapContentLinearLayoutManager(context, LinearLayoutManager.VERTICAL,true);
        layoutManager.setStackFromEnd(true);
        chatRV.setLayoutManager(layoutManager);
        chatRV.setItemAnimator(new ScaleInBottomAnimator(new OvershootInterpolator(1f)));
        chatRV.setAdapter(messageAdapter);*/


        expandIconView.setState(1,false);

        expandIconView.setOnClickListener(new OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                if(more){
                    expandIconView.setState(1,true);
                    moreHSV.setVisibility(View.GONE);
                    more=false;
                }
                else{
                    expandIconView.setState(0,true);
                    moreHSV.setVisibility(View.VISIBLE);
                    more=true;
                }
            }
        });

        sendMRL.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sendButtonClicked();
            }
        });

        galleryMRL.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                galleryButtonClicked();
            }
        });

        videoMRL.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                videoButtonClicked();
            }
        });

        cameraMRL.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraButtonClicked();
            }
        });

        audioMRL.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                audioButtonClicked();
            }
        });

        micMRL.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    micButtonTouched();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    micButtonReleased();
                }
                return true;
            }
        });

        if(getmActionModeHelper()==null){
            initializeActionModeHelper(SelectableAdapter.Mode.IDLE);
        }





    }

    protected void setAttributes(TypedArray attrs){

        //set Attributes from xml
        showSenderLayout(attrs.getBoolean(R.styleable.ChatView_showSenderLayout,true));
        showLeftBubbleIcon(attrs.getBoolean(R.styleable.ChatView_showLeftBubbleIcon,showLeftBubbleIcon));
        showRightBubbleIcon(attrs.getBoolean(R.styleable.ChatView_showRightBubbleIcon,showRightBubbleIcon));
        setLeftBubbleLayoutColor(attrs.getColor(R.styleable.ChatView_leftBubbleLayoutColor,getResources().getColor(leftBubbleLayoutColor)));
        setRightBubbleLayoutColor(attrs.getColor(R.styleable.ChatView_rightBubbleLayoutColor,getResources().getColor(rightBubbleLayoutColor)));
        setLeftBubbleTextColor(attrs.getColor(R.styleable.ChatView_leftBubbleTextColor,getResources().getColor(leftBubbleTextColor)));
        setRightBubbleTextColor(attrs.getColor(R.styleable.ChatView_rightBubbleTextColor,getResources().getColor(rightBubbleTextColor)));
        setChatViewBackgroundColor(attrs.getColor(R.styleable.ChatView_chatViewBackgroundColor,mContext.getResources().getColor(chatViewBackgroundColor)));
        setTimeTextColor(attrs.getColor(R.styleable.ChatView_timeTextColor,mContext.getResources().getColor(timeTextColor)));
        setSenderNameTextColor(attrs.getColor(R.styleable.ChatView_senderNameTextColor,getResources().getColor(senderNameTextColor)));
        showSenderName(attrs.getBoolean(R.styleable.ChatView_showSenderName,showSenderName));
        setTextSize(attrs.getDimension(R.styleable.ChatView_textSize,20));
        setChatViewBackgroundColor(attrs.getColor(R.styleable.ChatView_chatViewBackgroundColor,getResources().getColor(chatViewBackgroundColor)));


    }

    @Override
    public void onUpdateEmptyView(int size) {

    }

    @Override
    public void onDeleteConfirmed(int event) {

    }

    @Override
    public boolean onItemClick(View view,final int position) {
        IFlexible flexibleItem = getMessageAdapter().getItem(position);
        if (flexibleItem instanceof OverallItemChatItem) {
            OverallItemChatItem overallItem = (OverallItemChatItem) flexibleItem;
           /* MenuItem menuItem = mNavigationView.getMenu().findItem(overallItem.getId());
            onNavigationItemSelected(menuItem);*/
            return false;
        }

        // Action on elements are allowed if Mode is IDLE, otherwise selection has priority
        if (getMessageAdapter().getMode() != SelectableAdapter.Mode.IDLE && mActionModeHelper != null) {
            boolean activate = mActionModeHelper.onClick(position);
            com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.Log.d("Last activated position %s", mActionModeHelper.getActivatedPosition());
            return activate;
        } else {
            // Notify the active callbacks or implement a custom action onClick
            if (flexibleItem instanceof SimpleItem || flexibleItem instanceof SubItem) {
                chatRV.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.Log.d("scroll to position=%s item=%s", position, getMessageAdapter().getItem(position));
                        int headers = getMessageAdapter().areHeadersSticky() ? 1 : 0;
                        chatRV.smoothScrollToPosition(Math.max(0, position - headers));
                    }
                }, 300L);

//                //TODO FOR YOU: call your custom Action on item click
//                String title = extractTitleFrom(flexibleItem);
//                EditItemDialog.newInstance(title, position).show(getFragmentManager(), EditItemDialog.TAG);
            }
            return false;
        }
    }

    @Override
    public void onItemLongClick(int position) {
       getmActionModeHelper().onLongClick((AppCompatActivity) getContext(), position);
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

    public interface OnClickSendButtonListener{
        public void onSendButtonClick(String body);
    }
    public interface OnClickGalleryButtonListener{
        public void onGalleryButtonClick();
    }

    public interface OnClickVideoButtonListener{
        public void onVideoButtonClick();
    }

    public interface OnClickCameraButtonListener{
        public void onCameraButtonClicked();
    }

    public interface OnClickAudioButtonListener{
        public void onAudioButtonClicked();
    }

    public interface OnTouchMicButtonListener{
        public void onMicButtonTouched();
        public void onMicButtonReleased();
    }

    public void setOnClickSendButtonListener(OnClickSendButtonListener onClickSendButtonListener){
        this.onClickSendButtonListener = onClickSendButtonListener;
    }

    public void setOnClickGalleryButtonListener(OnClickGalleryButtonListener onClickGalleryButtonListener){
        this.onClickGalleryButtonListener = onClickGalleryButtonListener;
    }
    public void setOnClickVideoButtonListener(OnClickVideoButtonListener onClickVideoButtonListener){
        this.onClickVideoButtonListener = onClickVideoButtonListener;
    }

    public void setOnClickCameraButtonListener(OnClickCameraButtonListener onClickCameraButtonListener){
        this.onClickCameraButtonListener = onClickCameraButtonListener;
    }

    public void setOnClickAudioButtonListener(OnClickAudioButtonListener onClickAudioButtonListener){
        this.onClickAudioButtonListener = onClickAudioButtonListener;
    }

    public void setOnTouchMicButtonListener(OnTouchMicButtonListener onTouchMicButtonListener){
        this.onTouchMicButtonListener = onTouchMicButtonListener;
    }

    public void sendButtonClicked(){
        if(onClickSendButtonListener!=null){

            onClickSendButtonListener.onSendButtonClick(messageET.getText().toString());
            messageET.setText("");
        }
    }

    public void galleryButtonClicked(){
        if(onClickGalleryButtonListener!=null){
            onClickGalleryButtonListener.onGalleryButtonClick();
        }
    }

    public void videoButtonClicked(){
        if(onClickVideoButtonListener!=null){
            onClickVideoButtonListener.onVideoButtonClick();
        }
    }

    public void cameraButtonClicked(){
        if(onClickCameraButtonListener!=null){
            onClickCameraButtonListener.onCameraButtonClicked();
        }
    }

    public void audioButtonClicked(){
        if(onClickAudioButtonListener!=null){
            onClickAudioButtonListener.onAudioButtonClicked();
        }
    }

    public void micButtonTouched(){
        if(onTouchMicButtonListener!=null){
            onTouchMicButtonListener.onMicButtonTouched();
        }
    }

    public void micButtonReleased(){
        if(onTouchMicButtonListener!=null){
            onTouchMicButtonListener.onMicButtonReleased();
        }
    }

    public List<AbstractFlexibleItem> getMessageList(){
        return this.messageList;
    }

    //Use this method to add a message to chatview
    public void addMessage(AbstractFlexibleItem message){

        messageList.add(0,message);
        messageAdapter.notifyItemInserted(0);
        chatRV.smoothScrollToPosition(0);
        mLayoutRoot.invalidate();
    }

    //Use this method to remove a message from chatview
    public void removeMessage(Message message){
        messageList.remove(message);
        messageAdapter.notifyDataSetChanged();
    }

    //Use this method to clear all messages
    public void clearMessages(){
        messageList.clear();
        messageAdapter.notifyDataSetChanged();
    }


    //For hiding or showing sender layout which contains an edittext ,send button and many others features
    public void showSenderLayout(boolean b){
        this.showSenderLL=b;
        if(b){
            sendLL.setVisibility(VISIBLE);
        }
        else{
            sendLL.setVisibility(GONE);
        }
    }

    //For groups (showing or hiding sender name which appears on top of the message)
    public void showSenderName(boolean b){
        messageAdapter.showSenderName(b);
    }

    //For showing or hiding sender icon in left
    public void showLeftBubbleIcon(boolean b){
        messageAdapter.showLeftBubbleIcon(b);
    }

    //For showing or hiding receiver icon in right
    public void showRightBubbleIcon(boolean b){
        messageAdapter.showRightBubbleIcon(b);
    }


    //For changing left bubble layout color
    public void setLeftBubbleLayoutColor(int color){
        messageAdapter.setLeftBubbleLayoutColor(color);
    }

    //for changing right bubble layout color
    public void setRightBubbleLayoutColor(int color){
        messageAdapter.setRightBubbleLayoutColor(color);
    }

    //For changing left bubble text color
    public void setLeftBubbleTextColor(int color){
        messageAdapter.setLeftBubbleTextColor(color);
    }

    //For changing right bubble text color
    public void setRightBubbleTextColor(int color){
        messageAdapter.setRightBubbleTextColor(color);
    }

    //For changing chatview background color
    public void setChatViewBackgroundColor(int color){
        mLayoutRoot.setBackgroundColor(color);
    }

    //For changing time text color which is displayed (expands) when message is clicked
    public void setTimeTextColor(int color){
        messageAdapter.setTimeTextColor(color);
    }

    //For changing typeface of text inside
    public void setTypeface(Typeface typeface){
        messageAdapter.setTypeface(typeface);
    }

    public void setSenderNameTextColor(int color){
        messageAdapter.setSenderNameTextColor(color);
    }

    public void setTextSize(float size){
       // LisnerRecyclerview sd=new LisnerRecyclerview();

        messageAdapter.setTextSize(size);
    }
    public class ActionModeHelpercu implements ActionMode.Callback {

        @SelectableAdapter.Mode
        private int defaultMode = SelectableAdapter.Mode.IDLE;

        private boolean disableSwipe, disableDrag,
                longPressDragDisabledByHelper, handleDragDisabledByHelper, swipeDisabledByHelper;
        private FlexibleAdapter mAdapter;
        private ActionMode.Callback mCallback;
        protected ActionMode mActionMode;

        public ActionModeHelpercu(){
            mAdapter=getMessageAdapter();
        }




        public ActionModeHelpercu(@NonNull FlexibleAdapter adapter, @MenuRes int cabMenu,
                                @Nullable ActionMode.Callback callback) {

            this.mCallback = callback;
        }

        /**
         * Changes the default mode to apply when the ActionMode is destroyed and normal selection is
         * again active.
         * <p>Default value is {@link SelectableAdapter.Mode#IDLE}.</p>
         *
         * @param defaultMode the new default mode when ActionMode is off, accepted values:
         *                    {@code IDLE, SINGLE}
         * @return this object, so it can be chained
         * @since 1.0.0-b1
         */
        public final ActionModeHelpercu withDefaultMode(@SelectableAdapter.Mode int defaultMode) {
            if (defaultMode == SelectableAdapter.Mode.IDLE || defaultMode == SelectableAdapter.Mode.SINGLE)
                this.defaultMode = defaultMode;
            return this;
        }

        /**
         * Automatically disables LongPress drag and Handle drag capability when ActionMode is
         * activated and enable it again when ActionMode is destroyed.
         *
         * @param disableDrag true to disable the drag, false to maintain the drag during ActionMode
         * @return this object, so it can be chained
         * @since 1.0.0-b1
         */
        public final ActionModeHelpercu disableDragOnActionMode(boolean disableDrag) {
            this.disableDrag = disableDrag;
            return this;
        }

        /**
         * Automatically disables Swipe capability when ActionMode is activated and enable it again
         * when ActionMode is destroyed.
         *
         * @param disableSwipe true to disable the swipe, false to maintain the swipe during ActionMode
         * @return this object, so it can be chained
         * @since 1.0.0-b1
         */
        public final ActionModeHelpercu disableSwipeOnActionMode(boolean disableSwipe) {
            this.disableSwipe = disableSwipe;
            return this;
        }

        /**
         * @return the current instance of the ActionMode, {@code null} if ActionMode is off.
         * @since 1.0.0-b1
         */
        public ActionMode getActionMode() {
            return mActionMode;
        }

        /**
         * Gets the activated position only when mode is {@code SINGLE}.
         *
         * @return the activated position when {@code SINGLE}. -1 if no item is selected
         * @since 1.0.0-b1
         */
        public int getActivatedPosition() {
            List<Integer> selectedPositions = mAdapter.getSelectedPositions();
            if (mAdapter.getMode() == SelectableAdapter.Mode.SINGLE && selectedPositions.size() == 1) {
                return selectedPositions.get(0);
            }
            return RecyclerView.NO_POSITION;
        }

        /**
         * Implements the basic behavior of a CAB and multi select behavior.
         *
         * @param position the current item position
         * @return true if selection is changed, false if the click event should ignore the ActionMode
         * and continue
         * @since 1.0.0-b1
         */
        public boolean onClick(int position) {
            if (position != RecyclerView.NO_POSITION) {
                toggleSelection(position);
                return true;
            }
            return false;
        }

        /**
         * Implements the basic behavior of a CAB and multi select behavior onLongClick.
         *
         * @param activity the current Activity
         * @param position the position of the clicked item
         * @return the initialized ActionMode or null if nothing was done
         * @since 1.0.0-b1
         */
        @NonNull
        public ActionMode onLongClick(AppCompatActivity activity, int position) {
            // Activate ActionMode
            if (mActionMode == null) {
                mActionMode = activity.startSupportActionMode(this);
            }
            // We have to select this on our own as we will consume the event
            toggleSelection(position);
            return mActionMode;
        }

        /**
         * Toggle the selection state of an item.
         * <p>If the item was the last one in the selection and is unselected, the selection is stopped.
         * Note that the selection must already be started (actionMode must not be null).</p>
         *
         * @param position position of the item to toggle the selection state
         * @since 1.0.0-b1
         */
        public void toggleSelection(int position) {
            if (position >= 0 && (
                    (mAdapter.getMode() == SelectableAdapter.Mode.SINGLE && !mAdapter.isSelected(position)) ||
                            mAdapter.getMode() == SelectableAdapter.Mode.MULTI)) {
                mAdapter.toggleSelection(position);
            }
            // If SINGLE is active then ActionMode can be null
            if (mActionMode == null) return;

            int count = mAdapter.getSelectedItemCount();
            if (count == 0) {
                mActionMode.finish();
            } else {
                updateContextTitle(count);
            }
        }

        /**
         * Updates the title of the Context Menu.
         * <p>Override to customize the title and subtitle.</p>
         *
         * @param count the current number of selected items
         * @since 1.0.0-b1
         */
        public void updateContextTitle(int count) {
            if (mActionMode != null) {
                mActionMode.setTitle(String.valueOf(count));
            }
        }

        /**
         * Helper method to restart the action mode after a restoration of deleted items and after
         * screen rotation. The ActionMode will be activated only if
         * {@link FlexibleAdapter#getSelectedItemCount()} has selections.
         * <p>To be called in the {@code onUndo} method after the restoration is done or at the end
         * of {@code onRestoreInstanceState}.</p>
         *
         * @param activity the current Activity
         * @since 1.0.0-b1
         */
        public void restoreSelection(AppCompatActivity activity) {
            if ((defaultMode == SelectableAdapter.Mode.IDLE && mAdapter.getSelectedItemCount() > 0) ||
                    (defaultMode == SelectableAdapter.Mode.SINGLE && mAdapter.getSelectedItemCount() > 1)) {
                onLongClick(activity, -1);
            }
        }

        @CallSuper
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            // Inflate the Context Menu
            actionMode.getMenuInflater().inflate(R.menu.menu_selection_modes, menu);
            com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.Log.d("ActionMode is active!");
            // Activate the ActionMode Multi
            mAdapter.setMode(SelectableAdapter.Mode.MULTI);
            // Disable Swipe and Drag capabilities as per settings
            disableSwipeDragCapabilities();
            // Notify the provided callback
            return mCallback == null || mCallback.onCreateActionMode(actionMode, menu);
        }

        @CallSuper
        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return mCallback != null && mCallback.onPrepareActionMode(actionMode, menu);
        }

        @CallSuper
        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem item) {
            boolean consumed = false;
            if (mCallback != null) {
                consumed = mCallback.onActionItemClicked(actionMode, item);
            }
            if (!consumed) {
                // Finish the actionMode
                actionMode.finish();
            }
            return consumed;
        }

        /**
         * {@inheritDoc}
         * With FlexibleAdapter v5.0.0 the default mode is {@link SelectableAdapter.Mode#IDLE}, if
         * you want single selection enabled change default mode with {@link #withDefaultMode(int)}.
         */
        @CallSuper
        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.Log.d("ActionMode is about to be destroyed!");
            // Change mode and deselect everything
            mAdapter.setMode(defaultMode);
            mAdapter.clearSelection();
            mActionMode = null;
            // Re-enable Swipe and Drag capabilities if they were disabled by this helper
            enableSwipeDragCapabilities();
            // Notify the provided callback
            if (mCallback != null) {
                mCallback.onDestroyActionMode(actionMode);
            }
        }

        /**
         * Utility method to be called from Activity in many occasions such as: <i>onBackPressed</i>,
         * <i>onRefresh</i> for SwipeRefreshLayout, after <i>deleting</i> all selected items.
         *
         * @return true if ActionMode was active (in case it is also terminated), false otherwise
         * @since 1.0.0-b1
         */
        public boolean destroyActionModeIfCan() {
            if (mActionMode != null) {
                mActionMode.finish();
                return true;
            }
            return false;
        }

        private void enableSwipeDragCapabilities() {
            if (longPressDragDisabledByHelper) {
                longPressDragDisabledByHelper = false;
                mAdapter.setLongPressDragEnabled(true);
            }
            if (handleDragDisabledByHelper) {
                handleDragDisabledByHelper = false;
                mAdapter.setHandleDragEnabled(true);
            }
            if (swipeDisabledByHelper) {
                swipeDisabledByHelper = false;
                mAdapter.setSwipeEnabled(true);
            }
        }

        private void disableSwipeDragCapabilities() {
            if (disableDrag && mAdapter.isLongPressDragEnabled()) {
                longPressDragDisabledByHelper = true;
                mAdapter.setLongPressDragEnabled(false);
            }
            if (disableDrag && mAdapter.isHandleDragEnabled()) {
                handleDragDisabledByHelper = true;
                mAdapter.setHandleDragEnabled(false);
            }
            if (disableSwipe && mAdapter.isSwipeEnabled()) {
                swipeDisabledByHelper = true;
                mAdapter.setSwipeEnabled(false);
            }
        }

    }
    private class WrapContentLinearLayoutManager extends LinearLayoutManager {
        public WrapContentLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }

        @Override
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e) {
                Log.e("probe", "meet a IOOBE in RecyclerView");
            }
        }
    }
}
