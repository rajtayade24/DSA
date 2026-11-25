#include <iostream>
using namespace std;

#define MAX 100

int main() {
    int arr[MAX];
    int n = 0, choice, pos, value;

    do {
        cout << "\n--- Array Operations Menu ---\n";
        cout << "1. Create Array\n";
        cout << "2. Display Array\n";
        cout << "3. Insert Element\n";
        cout << "4. Delete Element\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Enter number of elements (max " << MAX << "): ";
                cin >> n;
                if (n > MAX || n < 0) {
                    cout << "Invalid size!\n";
                    n = 0;
                    break;
                }
                cout << "Enter " << n << " elements:\n";
                for (int i = 0; i < n; i++) {
                    cin >> arr[i];
                }
                cout << "Array created successfully!\n";
                break;

            case 2:
                if (n == 0)
                    cout << "Array is empty!\n";
                else {
                    cout << "Array elements are: ";
                    for (int i = 0; i < n; i++)
                        cout << arr[i] << " ";
                    cout << endl;
                }
                break;

            case 3:
                if (n == MAX) {
                    cout << "Array is full! Cannot insert.\n";
                    break;
                }
                cout << "Enter position to insert (1 to " << n + 1 << "): ";
                cin >> pos;
                if (pos < 1 || pos > n + 1) {
                    cout << "Invalid position!\n";
                    break;
                }
                cout << "Enter value to insert: ";
                cin >> value;
                for (int i = n; i >= pos; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[pos - 1] = value;
                n++;
                cout << "Element inserted successfully!\n";
                break;

            case 4:
                if (n == 0) {
                    cout << "Array is empty! Cannot delete.\n";
                    break;
                }
                cout << "Enter position to delete (1 to " << n << "): ";
                cin >> pos;
                if (pos < 1 || pos > n) {
                    cout << "Invalid position!\n";
                    break;
                }
                value = arr[pos - 1];
                for (int i = pos - 1; i < n - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                n--;
                cout << "Deleted element: " << value << endl;
                break;

            case 5:
                cout << "Exiting program...\n";
                break;

            default:
                cout << "Invalid choice! Please try again.\n";
        }

    } while (choice != 5);

    return 0;
}
