#include <iostream>
#include <fstream>
using namespace std;

struct Student {
    int id;
    char name[50];
    int age;
    char course[30];
};

const char* FILENAME = "students.dat";

void addStudent() {
    ofstream file(FILENAME, ios::binary | ios::app);
    Student s;
    cout << "Enter ID: "; cin >> s.id; cin.ignore();
    cout << "Enter Name: "; cin.getline(s.name, 50);
    cout << "Enter Age: "; cin >> s.age; cin.ignore();
    cout << "Enter Course: "; cin.getline(s.course, 30);
    file.write((char*)&s, sizeof(s));
    file.close();
    cout << "Student added.\n";
}

void searchStudent() {
    ifstream file(FILENAME, ios::binary);
    int id; cout << "Enter ID to search: "; cin >> id;
    Student s; bool found = false;
    while (file.read((char*)&s, sizeof(s))) {
        if (s.id == id) {
            cout << "ID: " << s.id << "\nName: " << s.name
                 << "\nAge: " << s.age << "\nCourse: " << s.course << "\n";
            found = true; break;
        }
    }
    if (!found) cout << "Student not found.\n";
    file.close();
}

void updateStudent() {
    fstream file(FILENAME, ios::binary | ios::in | ios::out);
    int id; cout << "Enter ID to update: "; cin >> id; cin.ignore();
    Student s; bool found = false;
    while (file.read((char*)&s, sizeof(s))) {
        if (s.id == id) {
            cout << "Enter new Name: "; cin.getline(s.name, 50);
            cout << "Enter new Age: "; cin >> s.age; cin.ignore();
            cout << "Enter new Course: "; cin.getline(s.course, 30);
            file.seekp(-sizeof(s), ios::cur);
            file.write((char*)&s, sizeof(s));
            cout << "Student updated.\n";
            found = true; break;
        }
    }
    if (!found) cout << "Student not found.\n";
    file.close();
}

void deleteStudent() {
    ifstream file(FILENAME, ios::binary);
    ofstream temp("temp.dat", ios::binary);
    int id; cout << "Enter ID to delete: "; cin >> id;
    Student s; bool found = false;
    while (file.read((char*)&s, sizeof(s))) {
        if (s.id == id) found = true;
        else temp.write((char*)&s, sizeof(s));
    }
    file.close(); temp.close();
    remove(FILENAME); rename("temp.dat", FILENAME);
    if (found) cout << "Student deleted.\n";
    else cout << "Student not found.\n";
}

int main() {
    int choice;
    do {
        cout << "\n1.Add 2.Search 3.Update 4.Delete 5.Exit\nChoice: ";
        cin >> choice; cin.ignore();
        if (choice == 1) addStudent();
        else if (choice == 2) searchStudent();
        else if (choice == 3) updateStudent();
        else if (choice == 4) deleteStudent();
    } while (choice != 5);
    return 0;
}
