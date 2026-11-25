#include <cstring>
#include <iostream>
using namespace std;

#define d 256

void rabinKarp(string text, string pattern, int q) {
  int M = pattern.length();
  int N = text.length();
  int hash_p = 0, hash_t = 0;
  int h = 1;

  // Compute h = (d^(M-1)) % q
  for (int i = 0; i < M - 1; i++) h = (h * d) % q;

  // Calculate initial hash values
  for (int i = 0; i < M; i++) {
    hash_p = (d * hash_p + pattern[i]) % q;
    hash_t = (d * hash_t + text[i]) % q;
  }

  // Slide pattern over text
  for (int i = 0; i <= N - M; i++) {
    if (hash_p == hash_t) {
      int j;
      for (j = 0; j < M; j++) {
        if (text[i + j] != pattern[j]) break;
      }

      if (j == M) cout << "Pattern found at index " << i << endl;
    }

    if (i < N - M) {
      hash_t = (d * (hash_t - text[i] * h) + text[i + M]) % q;

      if (hash_t < 0) hash_t += q;
    }
  }
}

int main() {
  string text = "ABABDABACDABABCABAB";
  string pattern = "ABABCABAB";
  int q = 101;

  rabinKarp(text, pattern, q);
  return 0;
}
