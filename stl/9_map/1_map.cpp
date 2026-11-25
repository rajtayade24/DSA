#include <iostream>
#include <map>
using namespace std;

// map store unique keys in s sorted order something similar to set data sturcture

int main() {
  map<int, int> m;
  m[1] = 2;
  m.emplace({2, 2});
  m.insert({3, 2});

  for (auto it : m) {
    cout << it.first << " " << it.second << endl;
  }

  auto it = m.find(1);
  cout << it.second << endl;
 
  return 0;
}