#include <iostream>
#include <vector>
using namespace std;

// void f(int idx, vector<int>& ds, int arr[], int n, int target) {
//   if (idx == n) {
//     int sum = 0;
//     for (auto it : ds) {
//       sum += it;
//     }
//     if (sum == target) {
//       for (auto it : ds) {
//         cout << it << " ";
//       }
//       cout << endl;
//     }
//     return;
//   }
//   f(idx + 1, ds, arr, n, target);
//   ds.push_back(arr[idx]);
//   f(idx + 1, ds, arr, n, target);
//   ds.pop_back();
// }

// optimized for printing only one subsequence
bool f(int idx, vector<int>& ds, int arr[], int n, int sum, int target) {
  if (idx == n) {
    if (sum == target) {
      for (auto it : ds) cout << it << " ";
      cout << endl;
      return true;
    }
    // consition is satisfied
    else
      return false;
  }
  ds.push_back(arr[idx]);
  sum += arr[idx];

  if (f(idx + 1, ds, arr, n, sum, target)) {
    return true;
  }

  sum -= arr[idx];
  ds.pop_back();

  if (f(idx + 1, ds, arr, n, sum, target)) {
    return true;
  }
  return false;
}

int main() {
  int arr[] = {1, 2, 3};
  vector<int> ds;
  f(0, ds, arr, sizeof(arr) / sizeof(arr[9]), 0, 2);
  return 0;
}