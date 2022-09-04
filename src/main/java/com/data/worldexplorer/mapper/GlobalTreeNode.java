package com.data.worldexplorer.mapper;

import java.util.ArrayList;
import java.util.List;

public class GlobalTreeNode<T> {
    private List<GlobalTreeNode<T>> children = new ArrayList<GlobalTreeNode<T>>();
    private GlobalTreeNode<T> parent = null;
    private T data = null;

    public GlobalTreeNode(T data) {
        setData(data);
    }

    public List<GlobalTreeNode<T>> getChildren() {
        return this.children;
    }

    public void setChildren(List<GlobalTreeNode<T>> children) {
        for(GlobalTreeNode<T> child : children) {
            child.parent = this;
        }

        this.children = children;
    }

    public void removeChildren() {
        this.children = new ArrayList<GlobalTreeNode<T>>();
    }

    public GlobalTreeNode<T> getParent() {
        return parent;
    }
    public void setParent(GlobalTreeNode<T> parent) {
        this.parent = parent;
    }

    public void removeParent() {
        this.parent = null;
    }

    public void addChild(T data) {
        GlobalTreeNode<T> child = new GlobalTreeNode<T>(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(GlobalTreeNode<T> child) {
        child.parent = this;
        children.add(child);
    }

    public GlobalTreeNode<T> getChild(T data){
        for(GlobalTreeNode<T> child: getChildren()){
            if (child.data.equals(data)){
                return child;
            }
        }
        return null;
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }

    public boolean hasChild(T data){
        for(GlobalTreeNode<T> child: getChildren()){
            if (child.data.equals(data)){
                    return true;
            }
        }
        return false;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public String toString() {
        return getData().toString();
    }


}
