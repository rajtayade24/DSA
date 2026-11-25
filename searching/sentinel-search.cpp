#include <iostream>
#include <vector>
using namespace std;

int sentinelSearch(vector<int>& arr, int target) {
  int n = arr.size();
  int last = arr[n - 1];  // store last element

  arr[n - 1] = target;  // place sentinel

  int i = 0;
  while (arr[i] != target) {
    i++;
  }

  arr[n - 1] = last;  // restore

  if (i < n - 1 || last == target) return i;

  return -1;
}

int main() {
  vector<int> arr = {5, 6, 3, 7, 3, 0};
  int target = 3;

  int index = sentinelSearch(arr, target);

  if (index != -1)
    cout << "Element found at index " << index;
  else
    cout << "Element not found";

  return 0;
}
