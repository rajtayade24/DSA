#include <iostream>
#include <vector>
using namespace std;

// TC = O(n)
int main() {
  vector<int> arr = {5, 6, 3, 7, 3, 0};
  int target = 3;

  bool flag = false;
  int i = 0;

  while (i < arr.size()) {
    if (arr[i] == target) {
      flag = true;
      break;
    }
    i++;
  }

  if (flag)
    cout << "Element is found at index " << i;
  else
    cout << "Element is not found, i = " << i;

  return 0;
}
