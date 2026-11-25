#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    bool lthread; // true if left is thread
    bool rthread; // true if right is thread

    Node(int val) {
        data = val;
        left = right = nullptr;
        lthread = rthread = true;
    }
};

class ThreadedBST {
private:
    Node* root;

public:
    ThreadedBST() {
        root = nullptr;
    }

    // Insert a node
    void insert(int key) {
        Node* ptr = root;
        Node* parent = nullptr;

        while (ptr != nullptr) {
            if (key == ptr->data) {
                cout << "Duplicate key not allowed.\n";
                return;
            }

            parent = ptr;

            if (key < ptr->data) {
                if (!ptr->lthread)
                    ptr = ptr->left;
                else
                    break;
            } else {
                if (!ptr->rthread)
                    ptr = ptr->right;
                else
                    break;
            }
        }

        Node* tmp = new Node(key);

        if (parent == nullptr) {
            root = tmp;
        } else if (key < parent->data) {
            tmp->left = parent->left;
            tmp->right = parent;
            parent->lthread = false;
            parent->left = tmp;
        } else {
            tmp->left = parent;
            tmp->right = parent->right;
            parent->rthread = false;
            parent->right = tmp;
        }

        cout << "Inserted: " << key << endl;
    }

    // Inorder traversal
    void inorder() {
        Node* ptr = root;
        if (ptr == nullptr) {
            cout << "Tree is empty.\n";
            return;
        }

        // Go to leftmost node
        while (!ptr->lthread)
            ptr = ptr->left;

        while (ptr != nullptr) {
            cout << ptr->data << " ";

            if (ptr->rthread)
                ptr = ptr->right;
            else {
                ptr = ptr->right;
                while (!ptr->lthread)
                    ptr = ptr->left;
            }
        }
        cout << endl;
    }

    // Search a node
    Node* search(int key) {
        Node* ptr = root;

        while (ptr != nullptr) {
            if (key == ptr->data)
                return ptr;
            else if (key < ptr->data) {
                if (!ptr->lthread)
                    ptr = ptr->left;
                else
                    break;
            } else {
                if (!ptr->rthread)
                    ptr = ptr->right;
                else
                    break;
            }
        }

        return nullptr;
    }

    // Find inorder successor
    Node* inorderSuccessor(Node* ptr) {
        if (ptr->rthread)
            return ptr->right;

        ptr = ptr->right;
        while (!ptr->lthread)
            ptr = ptr->left;
        return ptr;
    }

    // Delete a node (basic approach, handles leaf nodes)
    void deleteNode(int key) {
        Node* parent = nullptr;
        Node* ptr = root;

        bool found = false;

        while (ptr != nullptr) {
            if (key == ptr->data) {
                found = true;
                break;
            }

            parent = ptr;

            if (key < ptr->data) {
                if (!ptr->lthread)
                    ptr = ptr->left;
                else
                    break;
            } else {
                if (!ptr->rthread)
                    ptr = ptr->right;
                else
                    break;
            }
        }

        if (!found) {
            cout << "Key not found.\n";
            return;
        }

        // For simplicity, handle leaf nodes only
        if (!ptr->lthread && !ptr->rthread) {
            cout << "Deletion of internal nodes not implemented in this demo.\n";
            return;
        }

        if (ptr->lthread && ptr->rthread) { // Leaf node
            if (parent == nullptr) {
                root = nullptr;
            } else if (parent->left == ptr) {
                parent->lthread = true;
                parent->left = ptr->left;
            } else {
                parent->rthread = true;
                parent->right = ptr->right;
            }
            delete ptr;
        }

        cout << "Deleted: " << key << endl;
    }

    // Display (inorder traversal)
    void display() {
        cout << "Tree (Inorder): ";
        inorder();
    }
};

int main() {
    ThreadedBST tbt;
    int choice, val;

    do {
        cout << "\n--- Threaded Binary Tree Menu ---\n";
        cout << "1. Insert\n2. Inorder Traversal\n3. Search\n4. Delete (leaf only)\n5. Display\n0. Exit\n";
        cout << "Enter choice: ";
        cin >> choice;

        switch (choice) {
        case 1:
            cout << "Enter value to insert: ";
            cin >> val;
            tbt.insert(val);
            break;

        case 2:
            tbt.inorder();
            break;

        case 3:
            cout << "Enter value to search: ";
            cin >> val;
            if (tbt.search(val) != nullptr)
                cout << val << " found in tree.\n";
            else
                cout << val << " not found.\n";
            break;

        case 4:
            cout << "Enter value to delete (leaf only): ";
            cin >> val;
            tbt.deleteNode(val);
            break;

        case 5:
            tbt.display();
            break;

        case 0:
            cout << "Exiting...\n";
            break;

        default:
            cout << "Invalid choice!\n";
        }

    } while (choice != 0);

    return 0;
}