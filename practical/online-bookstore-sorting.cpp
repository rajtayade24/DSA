#include <iostream>
#include <vector>
#include <algorithm> // for sort
using namespace std;

int main() {
    int n;
    cout << "Enter the number of books: ";
    cin >> n;
    cin.ignore(); // Important: remove leftover newline

    vector<string> books(n);
    
    // Input book titles
    for(int i = 0; i < n; i++) {
        cout << "Enter title of book " << i+1 << ": ";
        cin  >> books[i];
        //  getline(cin, books[i]); // Reads full line including spaces
    }

    // Sort book titles alphabetically
    sort(books.begin(), books.end());

    // Display sorted book titles
    cout << "\nBooks sorted alphabetically:\n";
    for(int i = 0; i < n; i++) {
        cout << i+1 << ". " << books[i] << endl;
    }

    return 0;
}
