#include <iostream>
#include <fstream>
#include <string>
using namespace std;

struct Employee {
    int id;
    char name[50];
    char department[30];
    char address[100];
};

// Function to add employee record
void addEmployee() {
    ofstream outFile("employee.dat", ios::binary | ios::app);
    Employee emp;

    cout << "\nEnter Employee ID: ";
    cin >> emp.id;
    cin.ignore(); // clear input buffer

    cout << "Enter Name: ";
    cin.getline(emp.name, 50);

    cout << "Enter Department: ";
    cin.getline(emp.department, 30);

    cout << "Enter Address: ";
    cin.getline(emp.address, 100);

    outFile.write(reinterpret_cast<char*>(&emp), sizeof(emp));
    outFile.close();
    cout << "Record added successfully!\n";
}

// Function to display employee record by ID
void displayEmployee() {
    ifstream inFile("employee.dat", ios::binary);
    Employee emp;
    int searchId;
    bool found = false;

    cout << "\nEnter Employee ID to display: ";
    cin >> searchId;

    while (inFile.read(reinterpret_cast<char*>(&emp), sizeof(emp))) {
        if (emp.id == searchId) {
            cout << "\nEmployee Details:\n";
            cout << "ID: " << emp.id << "\n";
            cout << "Name: " << emp.name << "\n";
            cout << "Department: " << emp.department << "\n";
            cout << "Address: " << emp.address << "\n";
            found = true;
            break;
        }
    }

    if (!found) {
        cout << "Record not found!\n";
    }

    inFile.close();
}

// Function to delete employee record by ID
void deleteEmployee() {
    ifstream inFile("employee.dat", ios::binary);
    ofstream outFile("temp.dat", ios::binary);
    Employee emp;
    int deleteId;
    bool found = false;

    cout << "\nEnter Employee ID to delete: ";
    cin >> deleteId;

    while (inFile.read(reinterpret_cast<char*>(&emp), sizeof(emp))) {
        if (emp.id == deleteId) {
            found = true;
            continue; // skip the record to delete
        }
        outFile.write(reinterpret_cast<char*>(&emp), sizeof(emp));
    }

    inFile.close();
    outFile.close();

    remove("employee.dat");
    rename("temp.dat", "employee.dat");

    if (found) {
        cout << "Record deleted successfully!\n";
    } else {
        cout << "Record not found!\n";
    }
}

// Main menu
int main() {
    int choice;
    do {
        cout << "\n--- Employee Management System ---\n";
        cout << "1. Add Employee\n";
        cout << "2. Display Employee\n";
        cout << "3. Delete Employee\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch(choice) {
            case 1: addEmployee(); break;
            case 2: displayEmployee(); break;
            case 3: deleteEmployee(); break;
            case 4: cout << "Exiting...\n"; break;
            default: cout << "Invalid choice! Try again.\n";
        }
    } while(choice != 4);

    return 0;
}
