package com.astooltech.advancedview.proteus.design.TreeViewCustome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class getRootNod_from_List {


    public static List<Node> BuildTreeAndGetRoots(List<MyObject> actualObjects) {
        Map<Long, Node> lookup = new HashMap<>();
        List rootNodes = new ArrayList<Node>();

        for (MyObject object : actualObjects) {
            // add us to lookup
            Node ourNode;
            if (lookup.containsKey(object.objectId)) {   // was already found as a parent - register the actual object
                ourNode = lookup.get(object.objectId);
                ourNode.Source = object;
            } else {
                ourNode = new Node();
                ourNode.Source = object;

                lookup.put(object.objectId, ourNode);
            }

            // hook into parent
            if (object.parentObjectId == null || object.parentObjectId.equals(object.objectId)) {   // is a root node
                rootNodes.add(ourNode);
            } else {   // is a child row - so we have a parent
                Node parentNode;
                if (!lookup.containsKey(object.parentObjectId)) {   // unknown parent, construct preliminary parent
                    parentNode = new Node();
                    lookup.put(object.parentObjectId, parentNode);
                } else {
                    parentNode = lookup.get(object.parentObjectId);
                }
                parentNode.Children.add(ourNode);
                ourNode.Parent = parentNode;
            }
        }

        return rootNodes;
    }




}