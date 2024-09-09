package com.astooltech.advancedview.proteus.design.TreeViewCustome;

public class MyObject {
    public Long objectId;
    public String objectName;
    public Long parentObjectId;

    public MyObject(Long objectId, String objectName, Long parentObjectId) {
        this.objectId = objectId;
        this.objectName = objectName;
        this.parentObjectId = parentObjectId;
    }
    
    @Override
	public String toString() {
		return "Name: "+objectName+" Id: "+objectId;
	}
}