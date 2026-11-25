#include <iostream>
#include <list>
using namespace std;

int main() {
  list<int> li;
  li.push_back(3);
  li.emplace_back(4);

  // In vector we use insert function which is costly
  // insert function takes time for doinng operation
  li.push_front(1);
  li.emplace_front(1);

  for (auto i : li) cout << i << " ";

  // for (list<int>::iterator i = li.begin(); i < li.end(); i++)
  // {
  //     cout << *i << " ";
  // }


  // Rest functions are same as vector
  // begin, end, rbegin, rend, clear, insert, size, swap   
  return 0;
}