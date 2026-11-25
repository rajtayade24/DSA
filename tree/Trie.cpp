#include <iostream>
using namespace std;

class TrieNode {
 public:
  TrieNode* children[26];
  bool isEndOfWord;

  TrieNode() {
    isEndOfWord = false;
    for (int i = 0; i < 26; i++) children[i] = NULL;
  }
};

class Trie {
 private:
  TrieNode* root;

 public:
  Trie() {
    root = new TrieNode();
  }

  // Insert word
  void insert(string word) {
    TrieNode* temp = root;

    for (int i = 0; i < word.length(); i++) {
      int index = word[i] - 'a';

      if (temp->children[index] == NULL) temp->children[index] = new TrieNode();

      temp = temp->children[index];
    }

    temp->isEndOfWord = true;
  }

  // Search full word
  bool search(string word) {
    TrieNode* temp = root;

    for (int i = 0; i < word.length(); i++) {
      int index = word[i] - 'a';

      if (temp->children[index] == NULL) return false;

      temp = temp->children[index];
    }

    return temp->isEndOfWord;
  }

  // Search prefix
  bool startsWith(string prefix) {
    TrieNode* temp = root;

    for (int i = 0; i < prefix.length(); i++) {
      int index = prefix[i] - 'a';

      if (temp->children[index] == NULL) return false;

      temp = temp->children[index];
    }

    return true;
  }
};

int main() {
  Trie t;

  t.insert("cat");
  t.insert("car");
  t.insert("dog");

  cout << t.search("cat") << endl;     // 1 (true)
  cout << t.search("cap") << endl;     // 0 (false)
  cout << t.startsWith("ca") << endl;  // 1 (true)

  return 0;
}