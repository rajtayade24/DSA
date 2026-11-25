#include <iostream>
#include <string>
#include <vector>
using namespace std;

int bruteForcePatternMatch(string T, string P) {
  int n = T.length();
  int m = P.length();

  for (int i = 0; i <= n - m; i++) {
    int j = 0;
    while (j < m && T[i + j] == P[j]) {
      j++;
    }
    if (j == m) return i;  // Pattern found at position i
  }
  return -1;  // Pattern not found
}

vector<int> computeLPS(string pattern) {
  int m = pattern.size();
  vector<int> lps(m, 0);
  
  int len = 0;  // length of previous longest prefix suffix
  int i = 1;
  
  while (i < m) {
    if (pattern[i] == pattern[len]) {
      len++;
      lps[i] = len;
      i++;
    } else {
      if (len != 0) {
        len = lps[len - 1];
      } else {
        lps[i] = 0;
        i++;
      }
    }
  }
  return lps;
}

// KMP search
void KMP(string text, string pattern) {
  vector<int> lps = computeLPS(pattern);

  int i = 0;  // text index
  int j = 0;  // pattern index

  while (i < text.size()) {
    if (text[i] == pattern[j]) {
      i++;
      j++;
    }

    if (j == pattern.size()) {
      cout << "Pattern found at index " << i - j << endl;
      j = lps[j - 1];
    } else if (i < text.size() && text[i] != pattern[j]) {
      if (j != 0) {
        j = lps[j - 1];
      } else {
        i++;
      }
    }
  }
}

int main() {
  string T = "CTCACTGCCTGCCTAG";
  string P = "CTGCCTAG";

  int result = bruteForcePatternMatch(T, P);

  if (result != -1)
    cout << "Pattern found at index: " << result;
  else
    cout << "Pattern not found";

  return 0;
}