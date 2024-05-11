package com.websecurity.websecurity.treedecision;


import com.websecurity.websecurity.entities.DataWeb;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodeTree {
    private NodeTree rightNode;
    private NodeTree leftNode;
    private DataWeb dataWeb;

    public NodeTree(DataWeb dataWeb) {
        this.dataWeb = dataWeb;
    }
}
