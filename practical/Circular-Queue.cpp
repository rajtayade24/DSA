#include <iostream>
using namespace std;

#define SIZE 5  // maximum size of circular queue

class CircularQueue {
 private:
  char queue[SIZE];
  int front, rear;

 public:
  CircularQueue() {
    front = -1;
    rear = -1;
  }

  // Check if queue is full
  bool isFull() {
    return (front == 0 && rear == SIZE - 1) || (front == rear + 1);
  }

  // Check if queue is empty
  bool isEmpty() {
    return (front == -1);
  }

  // Insert element
  void enqueue(char element) {
    if (isFull()) {
      cout << "\nQueue Overflow! Cannot insert '" << element << "'." << endl;
      return;
    }
    if (front == -1)  // first element insertion
      front = 0;
    rear = (rear + 1) % SIZE;
    queue[rear] = element;
    cout << "\nInserted '" << element << "' into the queue." << endl;
  }

  // Delete element
  void dequeue() {
    if (isEmpty()) {
      cout << "\nQueue Underflow! Nothing to delete." << endl;
      return;
    }

    char element = queue[front];
    if (front == rear) {  // only one element
      front = rear = -1;
    } else {
      front = (front + 1) % SIZE;
    }
    cout << "\nDeleted element: '" << element << "'" << endl;
  }

  // Display queue elements
  void display() {
    if (isEmpty()) {
      cout << "\nQueue is empty." << endl;
      return;
    }

    cout << "\nQueue elements are: ";
    int i = front;
    while (true) {
      cout << queue[i] << " ";
      if (i == rear) break;
      i = (i + 1) % SIZE;
    }
    cout << endl;
  }
};

// ---------------- MAIN FUNCTION ----------------
int main() {
  CircularQueue cq;
  int choice;
  char element;

  cout << "===== Circular Queue Operations (Characters) =====" << endl;

  do {
    cout << "\nMenu:\n";
    cout << "1. Insert an Element\n";
    cout << "2. Delete an Element\n";
    cout << "3. Display Queue\n";
    cout << "4. Exit\n";
    cout << "Enter your choice: ";
    cin >> choice;

    switch (choice) {
      case 1:
        cout << "Enter a character to insert: ";
        cin >> element;
        cq.enqueue(element);
        break;
      case 2:
        cq.dequeue();
        break;
      case 3:
        cq.display();
        break;
      case 4:
        cout << "Exiting program..." << endl;
        break;
      default:
        cout << "Invalid choice! Try again." << endl;
    }

  } while (choice != 4);

  return 0;
}
