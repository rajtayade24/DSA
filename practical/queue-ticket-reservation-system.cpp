#include <iostream>
#include <string>
using namespace std;

// Structure for a reservation node
struct Reservation {
    int id;
    string name;
    string destination;
    int tickets;
    Reservation* next;
};

// Queue class for reservation system
class ReservationQueue {
private:
    Reservation* front;
    Reservation* rear;
    int nextId;

public:
    ReservationQueue() {
        front = rear = nullptr;
        nextId = 1;
    }

    // Add a new reservation
    void makeReservation(string name, string destination, int tickets) {
        Reservation* newRes = new Reservation();
        newRes->id = nextId++;
        newRes->name = name;
        newRes->destination = destination;
        newRes->tickets = tickets;
        newRes->next = nullptr;

        if (rear == nullptr) {
            front = rear = newRes;
        } else {
            rear->next = newRes;
            rear = newRes;
        }

        cout << "\nReservation successful! Your Reservation ID: " << newRes->id << endl;
    }

    // Cancel the first reservation (FIFO)
    void cancelReservation() {
        if (front == nullptr) {
            cout << "\nNo reservations to cancel!\n";
            return;
        }

        Reservation* temp = front;
        cout << "\nReservation ID " << temp->id << " (" << temp->name << ") has been canceled.\n";
        front = front->next;

        if (front == nullptr)
            rear = nullptr;

        delete temp;
    }

    // Modify reservation by ID
    void modifyReservation(int id) {
        if (front == nullptr) {
            cout << "\nNo reservations available!\n";
            return;
        }

        Reservation* temp = front;
        while (temp != nullptr && temp->id != id)
            temp = temp->next;

        if (temp == nullptr) {
            cout << "\nReservation ID not found!\n";
            return;
        }

        cout << "\nCurrent details for Reservation ID " << id << ":\n";
        cout << "Name: " << temp->name << ", Destination: " << temp->destination 
             << ", Tickets: " << temp->tickets << endl;

        cout << "\nEnter new details:\n";
        cout << "Name: ";
        cin.ignore();
        getline(cin, temp->name);
        cout << "Destination: ";
        getline(cin, temp->destination);
        cout << "Number of Tickets: ";
        cin >> temp->tickets;

        cout << "\nReservation updated successfully!\n";
    }

    // Display all reservations
    void displayReservations() {
        if (front == nullptr) {
            cout << "\nNo reservations in the queue!\n";
            return;
        }

        cout << "\nCurrent Reservations Queue:\n";
        cout << "---------------------------------------------\n";
        cout << "ID\tName\t\tDestination\tTickets\n";
        cout << "---------------------------------------------\n";

        Reservation* temp = front;
        while (temp != nullptr) {
            cout << temp->id << "\t" << temp->name << "\t\t" << temp->destination 
                 << "\t\t" << temp->tickets << endl;
            temp = temp->next;
        }
    }
};

// Main function
int main() {
    ReservationQueue queue;
    int choice;

    do {
        cout << "\n=== Ticket Reservation System ===\n";
        cout << "1. Make Reservation\n";
        cout << "2. Cancel Reservation\n";
        cout << "3. Modify Reservation\n";
        cout << "4. Display All Reservations\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                string name, destination;
                int tickets;
                cout << "\nEnter Name: ";
                cin.ignore();
                getline(cin, name);
                cout << "Enter Destination: ";
                getline(cin, destination);
                cout << "Enter Number of Tickets: ";
                cin >> tickets;
                queue.makeReservation(name, destination, tickets);
                break;
            }

            case 2:
                queue.cancelReservation();
                break;

            case 3: {
                int id;
                cout << "\nEnter Reservation ID to modify: ";
                cin >> id;
                queue.modifyReservation(id);
                break;
            }

            case 4:
                queue.displayReservations();
                break;

            case 5:
                cout << "\nExiting system. Thank you!\n";
                break;

            default:
                cout << "\nInvalid choice! Please try again.\n";
        }
    } while (choice != 5);

    return 0;
}
