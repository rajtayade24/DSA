#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

void f(int idx, int sum, vector<int>& ans, vector<int>& arr) {

  if (idx == arr.size()) {
    ans.push_back(sum);
    return;
  }

  // pick element
  f(idx + 1, sum + arr[idx], ans, arr);

  // not pick element
  f(idx + 1, sum, ans, arr);
}

int main() {

  vector<int> arr = {1, 2, 3};
  vector<int> ans;

  f(0, 0, ans, arr);

  sort(ans.begin(), ans.end());

  for (auto it : ans)
    cout << it << " ";

  return 0;
}