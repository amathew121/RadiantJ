package com.ashish;

public class Trie {
	private Trienode root;

	public Trie() {
		root = new Trienode();
	}

	public Trienode getRoot() {
		return root;
	}

	public Trienode addString(String str, boolean isRootForm) {
		return addString(str, getRoot(), isRootForm);
	}

	public Trienode searchRF(String str) {
		return searchRF(str, getRoot());
	}

	private Trienode addString(String str, Trienode root, boolean isRootForm) {
		if (str.length() == 0) {
			if (isRootForm) {
				root.prf = 1;
				root.parent.prf = root.parent.prf + root.prf/26;
				root.rootform = true;
			}
			root.isWord = true;
			return root;
		}
		String newstr = str.substring(1, str.length());
		char c = str.charAt(0);
		Trienode newnode;
		if (root.childs[c - 65] == null) {
			newnode = new Trienode();
			newnode.c = c;
			newnode.parent = root;
			root.childs[c - 65] = newnode;
		} else{
			newnode = root.childs[c - 65];
		}
		return addString(newstr, newnode, isRootForm);

	}

	private Trienode searchRF(String str, Trienode root) {
		if (str.length() == 0) {
			return root;
		}

		try{
			String newstr = str.substring(1, str.length());
			char c = str.charAt(0);
			Trienode node = root.childs[c - 65];

				return searchRF(newstr, node);
		}
		catch(NullPointerException ne) {
			if(!root.isWord) { 
				System.out.println("String not found"); 
				System.out.println("Match found till " + root.c);		}
			return root;
		}
		

	}

	public void printAll() {
		Trienode node = getRoot();
		print(new StringBuilder(), node);
	}
	public void print(StringBuilder prefix, Trienode node) {
		prefix.append(node.c);
		if (node.isWord){
			System.out.println(prefix + "\t" + node.prf);
		}
		
		for(int i =0 ; i < 26 ; i ++) {
			if (node.childs[i] != null){
				print(prefix, node.childs[i]);
				prefix.deleteCharAt(prefix.length()-1);
			}
		}
		
	}
	public static void main(String args[]) {
		Trie t = new Trie();
		t.addString("HELLO", true);
		t.addString("WORLD", true);
		t.addString("WORKS", false);
		t.addString("WALK", true);
		t.addString("WALKS", false);
		t.addString("WALKED", false);
		t.addString("WALKING", false);
		t.addString("WALKER", false);
		t.addString("JAVA", true);

		System.out.println(t.searchRF("HELLO").rootform);
		System.out.println(t.searchRF("JAVA").rootform);
		System.out.println(t.searchRF("WALKED").rootform );

		t.printAll();
	}
}