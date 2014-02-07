package com.ashish;

public class Trienode {
    char c;
    Trienode parent;
    Trienode childs[] = new Trienode[26];
    boolean rootform ;
    boolean isWord;
    float prf;
    
    public Trienode(){
    	c='$';
		parent=null;
		rootform=false;
	}
}