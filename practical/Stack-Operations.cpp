#include <iostream>
#include <cstring>
using namespace std;

#define MAX 100

class Stack {
    int top;
    char arr[MAX];

public:
    Stack() {
        top = -1;
    }

    // Push element
    void push(char element) {
        if (top == MAX - 1) {
            cout << "Stack Overflow! Cannot push " << element << endl;
        } else {
            arr[++top] = element;
            cout << element << " pushed onto stack." << endl;
        }
    }

    // Pop element
    char pop() {
        if (top == -1) {
            cout << "Stack Underflow! Cannot pop element.\n";
            return '\0';
        } else {
            cout << arr[top] << " popped from stack.\n";
            return arr[top--];
        }
    }

    // Display stack
    void display() {
        if (top == -1) {
            cout << "Stack is empty.\n";
        } else {
            cout << "Stack elements (top to bottom): ";
            for (int i = top; i >= 0; i--) {
                cout << arr[i] << " ";
            }
            cout << endl;
        }
    }

    // Check palindrome using stack
    void checkPalindrome(string str) {
        Stack tempStack;
        for (char ch : str)
            tempStack.push(ch);

        string rev = "";
        while (!tempStack.isEmpty()) {
            rev += tempStack.pop();
        }

        if (str == rev)
            cout << "'" << str << "' is a Palindrome.\n";
        else
            cout << "'" << str << "' is NOT a Palindrome.\n";
    }

    bool isEmpty() {
        return top == -1;
    }
};

int main() {
    Stack s;
    int choice;
    char element;
    string str;

    do {
        cout << "\n--- Stack Operations Menu ---\n";
        cout << "1. Push Element\n";
        cout << "2. Pop Element\n";
        cout << "3. Check Palindrome\n";
        cout << "4. Display Stack\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Enter element to push: ";
                cin >> element;
                s.push(element);
                break;

            case 2:
                s.pop();
                break;

            case 3:
                cout << "Enter string to check palindrome: ";
                cin >> str;
                s.checkPalindrome(str);
                break;

            case 4:
                s.display();
                break;

            case 5:
                cout << "Exiting program.\n";
                break;

            default:
                cout << "Invalid choice! Try again.\n";
        }

    } while (choice != 5);

    return 0;
}
