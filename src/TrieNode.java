class TrieNode {
    char data;
    boolean isEnd;
    int count;
    LinkedList<TrieNode> childList;

    public TrieNode(char c) {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        data = c;
        count = 0;
    }

    public TrieNode getChild(char c) {
        if (childList != null) {
            for (TrieNode eachChild : childList) {
                if (eachChild.data == c) {
                    return eachChild;
                }
            }
        }

        return null;
    }
}