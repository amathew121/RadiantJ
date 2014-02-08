package com.ashish;

import java.util.StringTokenizer;

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
				root.parent.prf = root.parent.prf + root.prf / 128;
				root.rootform = true;
			}
			root.isWord = true;
			return root;
		}
		String newstr = str.substring(1, str.length());
		char c = str.charAt(0);
		Trienode newnode;
		int index = c - '\u0D00';
		if (index < 128 && index >= 0) {
			if (root.childs[index] == null) {
				newnode = new Trienode();
				newnode.c = c;
				newnode.parent = root;
				root.childs[index] = newnode;
			} else {
				newnode = root.childs[index];
			}
			return addString(newstr, newnode, isRootForm);
		} else {
			return addString(newstr, root, isRootForm);

		}
	}

	private Trienode searchRF(String str, Trienode root) {
		if (str.length() == 0) {
			return root;
		}

		try {
			String newstr = str.substring(1, str.length());
			char c = str.charAt(0);
			int index = c - '\u0D00';
			if (index < 128 && index >= 0) {
				Trienode node = root.childs[c - '\u0D00'];

				return searchRF(newstr, node);
			} else
				return searchRF(newstr, root);
		} catch (NullPointerException ne) {
			if (!root.isWord) {
				System.out.println("String not found");
				System.out.println("Match found till " + root.c);
			}
			return root;
		}

	}

	public void printAll() {
		Trienode node = getRoot();
		print(new StringBuilder(), node);
	}

	public void print(StringBuilder prefix, Trienode node) {
		prefix.append(node.c);
		if (node.isWord) {
			System.out.println(prefix + "\t" + node.prf);
		}

		for (int i = 0; i < 128; i++) {
			if (node.childs[i] != null) {
				print(prefix, node.childs[i]);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		}

	}

	public static void main(String args[]) {
		Trie t = new Trie();

		String s = "ഉത്തരാഫ്രിക്കയിൽ നിന്നുള്ള ലത്തീൻ ക്രിസ്തീയചിന്തകനും, ദൈവശാസ്ത്രജ്ഞനും മെത്രാനുമായിരുന്നു ഹിപ്പോയിലെ അഗസ്തീനോസ്. വിശുദ്ധ അഗസ്റ്റിൻ (സെയ്ന്റ് അഗസ്റ്റിൻ), വിശുദ്ധ ഓസ്റ്റിൻ, ഔറേലിയുസ് അഗസ്തീനോസ് എന്നീ പേരുകളിലും അദ്ദേഹം അറിയപ്പെടുന്നു. റോമൻ കത്തോലിക്കാ സഭയും ആംഗ്ലിക്കൻ കൂട്ടായ്മയും അഗസ്തീനോസിനെ വിശുദ്ധനും വേദപാരംഗതന്മാരിൽ മുമ്പനും ആയി മാനിക്കുന്നു. പ്രൊട്ടസ്റ്റന്റ് നവീകരണത്തെ ഏറ്റവുമേറെ സ്വാധീനിച്ച സഭാപിതാവ് അദ്ദേഹമാണ്. അഗസ്തീനോസിന്റെ ചിന്തയും, തത്ത്വചിന്തയിലും ദൈവശാസ്ത്രത്തിലും അദ്ദേഹം രൂപപ്പെടുത്തിയ നിലപാടുകളും മദ്ധ്യകാല ലോകവീക്ഷണത്തെ അടിസ്ഥാനപരമായി സ്വാധീനിച്ചു. മനുഷ്യസ്വാതന്ത്ര്യത്തിന്‌ ദൈവത്തിന്റെ കൃപ ഒഴിച്ചുകൂടാത്തതാണെന്ന് അദ്ദേഹം വിശ്വസിച്ചു. തുടങ്ങിയ മത, രാഷ്ട്രീയ സങ്കല്പങ്ങൾ ക്രൈസ്തവലോകത്തിന്‌ സമ്മാനിച്ചത് അഗസ്തീനോസാണ്‌";
		StringTokenizer st = new StringTokenizer(s);

		while (st.hasMoreTokens()) {
			String tkn = st.nextToken();
			System.out.println(tkn);
			t.addString(tkn, false);
		}
		/*
		 * t.addString("HELLO", true); t.addString("WORLD", true);
		 * t.addString("WORKS", false); t.addString("WALK", true);
		 * t.addString("WALKS", false); t.addString("WALKED", false);
		 * t.addString("WALKING", false); t.addString("WALKER", false);
		 * t.addString("JAVA", true);
		 */

		// System.out.println(t.searchRF("HELLO").rootform);
		// System.out.println(t.searchRF("JAVA").rootform);
		// System.out.println(t.searchRF("WALKED").rootform );
		System.out.println("PRINTING ALL IN TRIE");
		t.printAll();
	}
}