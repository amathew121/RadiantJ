package com.ashish;

public class Trienode {
    char c;
    Trienode parent;
    Trienode childs[] = new Trienode[128];
    boolean isRootform ;
    boolean isWord;
    float prf;
    int count;
    
    public Trienode(){
    	c='\u0000';
    	parent=null;
		isRootform=false;
		count = 0;
	}
}