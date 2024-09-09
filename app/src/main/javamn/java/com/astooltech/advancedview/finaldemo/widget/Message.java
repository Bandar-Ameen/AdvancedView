package com.astooltech.advancedview.finaldemo.widget;


import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.astooltech.advancedview.proteus.value.Value;

import java.util.List;

/**
 * Created by shrikanthravi on 16/02/18.
 */


public class Message {


    protected String LeftSimpleMessage = "LEFT";
    protected String RightSimpleMessage = "RIGHT";
    protected String LeftSingleImage = "LeftImage";
    protected String RightSingleImage = "RightImage";

    //Can hold upto 11 images.
    protected String LeftMultipleImages = "LeftImages";
    protected String RightMultipleImages = "RightImages";

    //Single Video
    protected String LeftVideo = "LeftVideo";
    protected String RightVideo = "RightVideo";

    protected String LeftAudio = "LeftAudio";
    protected String RightAudio = "RightAudio";

    protected long id;
    protected MessageType messageType;
    protected String type;
    protected String body;
    protected String time;
    protected String status;
    protected List<Uri> imageList;
    protected String userName;
    protected Uri userIcon;
    protected Uri videoUri;
    protected Uri audioUri;

    public Drawable getSenderProfile() {
        return SenderProfile;
    }

    public void setSenderProfile(Drawable senderProfile) {
        SenderProfile = senderProfile;
    }

    public Drawable getReceverprofile() {
        return Receverprofile;
    }

    public void setReceverprofile(Drawable receverprofile) {
        Receverprofile = receverprofile;
    }

    private Drawable SenderProfile;
private Drawable Receverprofile;
    public String getUrlWeb() {
        return UrlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        UrlWeb = urlWeb;
    }

    public Value getSomeValue() {
        return SomeValue;
    }

    public void setSomeValue(Value someValue) {
        SomeValue = someValue;
    }

    protected String UrlWeb;
    protected Value SomeValue;
    protected int indexPosition;

    public enum MessageType{
        LeftSimpleMessage,
        RightSimpleImage,
        LeftSingleImage,
        RightSingleImage,
        LeftMultipleImages,
        RightMultipleImages,
        LeftVideo,
        RightVideo,
        LeftAudio,
        RightAudio,
        WebLeft,
        WebRight
    }

    public Message(){

    }
private boolean SenderOrRecever;

    public boolean isSenderOrRecever() {
        return SenderOrRecever;
    }

    public void setSenderOrRecever(boolean senderOrRecever) {
        SenderOrRecever = senderOrRecever;
    }

    public String getReceverName() {
        return ReceverName;
    }

    public void setReceverName(String receverName) {
        ReceverName = receverName;
    }

    public String getSenderName() {
        return SenderName;
    }

    public void setSenderName(String senderName) {
        SenderName = senderName;
    }

    public String getReverProfileBase64() {
        return ReverProfileBase64;
    }

    public void setReverProfileBase64(String reverProfileBase64) {
        ReverProfileBase64 = reverProfileBase64;
    }

    public String getsEnderProfileBase64() {
        return enderProfileBase64;
    }

    public void setsEnderProfileBase64(String enderProfileBase64) {
        this.enderProfileBase64 = enderProfileBase64;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getSenderID() {
        return SenderID;
    }

    public void setSenderID(String senderID) {
        SenderID = senderID;
    }

    public String getReceverId() {
        return ReceverId;
    }

    public void setReceverId(String receverId) {
        ReceverId = receverId;
    }

    private String ReceverName;
    private String SenderName;
    private String ReverProfileBase64;
    private String enderProfileBase64;
    private String fileType;
    private String SenderID;
    private String ReceverId;

    public Uri getAudioUri() {
        return audioUri;
    }

    public void setAudioUri(Uri audioUri) {
        this.audioUri = audioUri;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public int getIndexPosition() {
        return indexPosition;
    }

    public void setIndexPosition(int indexPosition) {
        this.indexPosition = indexPosition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Uri> getImageList() {
        return imageList;
    }

    public void setImageList(List<Uri> imageList) {
        this.imageList = imageList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Uri getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(Uri userIcon) {
        this.userIcon = userIcon;
    }

    public Uri getVideoUri() {
        return videoUri;
    }

    public void setVideoUri(Uri videoUri) {
        this.videoUri = videoUri;
    }
}


