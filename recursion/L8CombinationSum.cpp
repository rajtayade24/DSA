#include <iostream>
#include <vector>
using namespace std;

void f(int idx, int target, vector<int>& ds, vector<vector<int>>& ans,
       int arr[], int n) {
  if (idx == n) {
    if (target == 0) {
      ans.push_back(ds);
    }
    return;
  }

  //  pick element
  if (arr[idx] <= target) {
    ds.push_back(arr[idx]);
    f(idx, target - arr[idx], ds, ans, arr, n);
    ds.pop_back();
  }
  f(idx + 1, target, ds, ans, arr, n);
}

int main() {
  int arr[] = {1, 2, 3};
  int n = sizeof(arr) / sizeof(arr[0]);

  vector<int> ds;
  vector<vector<int>> ans;

  f(0, 3, ds, ans, arr, n);

  for (auto v : ans) {
    for (auto x : v) {
      cout << x << " ";
    }
    cout << endl;
  }
}