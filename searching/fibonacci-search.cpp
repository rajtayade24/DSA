#include <iostream>
#include <vector>
using namespace std;

int fibonacciSearch(vector<int>& arr, int target) {
  int n = arr.size();

  // Generate Fibonacci numbers
  int fib2 = 0;           // (m-2)
  int fib1 = 1;           // (m-1)
  int fib = fib1 + fib2;  // m-th Fibonacci

  while (fib < n) {
    fib2 = fib1;
    fib1 = fib;
    fib = fib1 + fib2;
  }

  int offset = -1;

  while (fib > 1) {
    int i = min(offset + fib2, n - 1);

    if (arr[i] < target) {
      fib = fib1;
      fib1 = fib2;
      fib2 = fib - fib1;
      offset = i;
    } else if (arr[i] > target) {
      fib = fib2;
      fib1 = fib1 - fib2;
      fib2 = fib - fib1;
    } else {
      return i;  // found
    }
  }

  // Compare the last element
  if (fib1 && offset + 1 < n && arr[offset + 1] == target) return offset + 1;

  return -1;  // not found
}

int main() {
  vector<int> arr = {0, 1, 2, 3, 5, 8, 13, 21};
  int target = 5;

  int index = fibonacciSearch(arr, target);

  if (index != -1)
    cout << "Element found at index " << index;
  else
    cout << "Element not found";

  return 0;
}
