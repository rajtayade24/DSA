#include <iostream>
#include <vector>
using namespace std;

void f(vector<int>& arr, vector<int>& ds, vector<vector<int>>& ans,
       bool freq[]) {
  if (ds.size() == arr.size()) {
    ans.push_back(ds);
    return;
  }

  for (int i = 0; i < arr.size(); i++) {
    if (!freq[i]) {
     freq[i] = true;
      ds.push_back(arr[i]); 
      f(arr, ds, ans, freq);
      ds.pop_back();
      freq[i] = false;
    }
  }
}

// Reduce space complexity of map(freq) usage
void optimal(int idx , vector<int>& arr,
             vector<vector<int>>& ans) {
  if (idx == arr.size()) {
    ans.push_back(arr);
    return;
  }

  for (int i = idx; i < arr.size(); i++) {
    swap(arr[idx], arr[i]);
    optimal(idx + 1, arr,  ans);
    swap(arr[idx], arr[i]);
  }
}

int main() {
  vector<int> arr = {1, 2, 3};
  vector<int> ds;
  vector<vector<int>> ans;
  bool freq[3] = {false};

  // f(arr, ds, ans, freq);
  optimal(0, arr, ans);
  for (auto it : ans) {
    for (auto i : it) {
      cout << i << " ";
    }
    cout << endl;
  }

  

  return 0;
}