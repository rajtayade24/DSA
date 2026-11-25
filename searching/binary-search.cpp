#include <algorithm>  // for sort
#include <iostream>
#include <vector>
using namespace std;

// TC = O(log(n))
int binarySearch(vector<int>& arr, int target) {
  int left = 0;
  int right = arr.size() - 1;

  while (left <= right) {
    int mid = left + (right - left) / 2;

    if (arr[mid] == target)
      return mid;

    else if (arr[mid] < target)
      left = mid + 1;

    else
      right = mid - 1;
  }
  return -1;
}

int main() {
  vector<int> arr = {5, 6, 3, 7, 3, 0};
  int target = 3;

  sort(arr.begin(), arr.end());

  int index = binarySearch(arr, target);

  if (index != -1)
    cout << "Element found at index " << index;
  else
    cout << "Element not found";

  return 0;
}
