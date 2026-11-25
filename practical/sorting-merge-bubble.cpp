#include <iostream>
#include <vector>
using namespace std;

// Function to display top 5 scores
void displayTopFive(const vector<float>& arr) {
  int n = arr.size();
  cout << "\nTop Five Scores:\n";
  for (int i = n - 1; i >= max(0, n - 5); i--) {
    cout << arr[i] << "% ";
  }
  cout << endl;
}

// ------------------ Bubble Sort ------------------
void bubbleSort(vector<float>& arr) {
  int n = arr.size();
  for (int i = 0; i < n - 1; i++) {
    // bool swapped = false;
    for (int j = 0; j < n - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        swap(arr[j], arr[j + 1]);
        // swapped = true;
      }
    }
    // if (!swapped)
    // break; // Optimization: stop if already sorted
  }
}

// ------------------ Merge Sort ------------------
void merge(vector<float>& arr, int low, int mid, int high) {
  int n = high - low + 1;
  vector<float> temp(n);  

  int left = low, right = mid + 1, k = 0;

  while (left <= mid && right <= high) {
    if (arr[left] <= arr[right]) {
      temp[k++] = arr[left++];
      cout << "1" << endl;
    } else {
      temp[k++] = arr[right++];
      cout << "\t1" << endl;
    }
  }

  while (left <= mid) {
    temp[k++] = arr[left++];
    cout << "\t\t2" << endl;
  }
  while (right <= high) {
    temp[k++] = arr[right++];
    cout << "\t\t\t3" << endl;
  }

  for (int i = 0; i < n; i++) arr[low + i] = temp[i];  // copy back
}

void mergeSort(vector<float>& arr, int left, int right) {
  if (left < right) {
    int mid = (left + right) / 2;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
  }
}

// ------------------ Main Program ------------------
int main() {
  int n, choice;
  cout << "Enter number of students: ";
  cin >> n;

  vector<float> percent(n);
  cout << "Enter percentage of " << n << " students:\n";
  for (int i = 0; i < n; i++) {
    cout << "Student " << i + 1 << ": ";
    cin >> percent[i];
  }

  cout << "\nChoose sorting method:\n";
  cout << "1. Bubble Sort\n2. Merge Sort\nEnter choice: ";
  cin >> choice;

  switch (choice) {
    case 1:
      bubbleSort(percent);
      cout << "\nSorted using Bubble Sort:\n";
      break;
    case 2:
      mergeSort(percent, 0, n - 1);
      cout << "\nSorted using Merge Sort:\n";
      break;
    default:
      cout << "Invalid choice!" << endl;
      return 0;
  }

  for (float p : percent) cout << p << "% ";
  cout << endl;

  displayTopFive(percent);

  return 0;
}
