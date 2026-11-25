#include <iostream>
#include <set>
using namespace std;

int main() {
  set<int> s = {1, 3, 4, 5, 6, 7, 8};
  s.insert(9);
  s.emplace(3);

  auto it =
      s.find(3);  // return an iterator that point to the address of integer
  cout << *it;

  auto itr = s.find(2);  // if int is not present the it will point at end
  cout << *it;

  s.erase(it, itr);
  s.erase(itr);

  cout << s.count(1);  // if exist return 1
  // if not exist return 0

  // auto

  return 0;
}