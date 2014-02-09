package com.ashish;

public class Generator {

	private Trie t;

	public Generator(Trie t) {
		this.t = t;
	}

	public Trie generateSuffixRules() {
		Trie suffixTrie = new Trie();
		suffixSearch(new StringBuilder(), t.getRoot(), suffixTrie);
		return suffixTrie;

	}

	public void suffixSearch(StringBuilder prefix, Trienode node,
			Trie suffixTrie) {
		Trienode rf = null;
		prefix.append(node.c);
		if (node.isRootform) {
			// System.out.println(prefix + "\t" + node.prf );
			rf = node;
		}

		for (int i = 0; i < 128; i++) {
			if (node.childs[i] != null) {
				suffixSearch(prefix, node.childs[i], suffixTrie);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		}
		if (rf != null) {
			addSuffix(rf, suffixTrie.getRoot());
		}

	}

	private void addSuffix(Trienode rf, Trienode suffix) {
		Trienode newnode = null;
		if (rf != null) {
			for (int i = 0; i < 128; i++) {
				if (rf.childs[i] != null) {
					if ((newnode = suffix.childs[i]) == null) {
						newnode = new Trienode();
						if (rf.childs[i].isWord) {
							newnode.isWord = true;
						}
						newnode.c = rf.childs[i].c;
						newnode.parent = suffix;
						newnode.count++;
						suffix.childs[i] = newnode;
						addSuffix(rf.childs[i], newnode);
					} else {

						newnode = suffix.childs[i];
						newnode.count++;
						addSuffix(rf.childs[i], newnode);

					}
				}

			}
		}
		System.out.println("Added suffix");
	}

}
