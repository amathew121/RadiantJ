package com.ashish;

public class Trienode {
    char c;
    Trienode parent;
    Trienode childs[] = new Trienode[128];
    boolean rootform ;
    boolean isWord;
    float prf;
    
    public Trienode(){
    	c='\u0000';
    	parent=null;
		rootform=false;
	}
}