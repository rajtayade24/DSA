#include <iostream>
#include <string>
using namespace std;

struct Song {
  string title;
  Song* next;
};

class Playlist {
 private:
  Song* head;

 public:
  Playlist() {
    head = nullptr;
  }

  // Add song at the end
  void addSong(string title) {
    Song* newSong = new Song();
    newSong->title = title;
    newSong->next = nullptr;

    if (head == nullptr) {
      head = newSong;
    } else {
      Song* temp = head;
      while (temp->next != nullptr) temp = temp->next;
      temp->next = newSong;
    }
    cout << "Song added: " << title << endl;
  }

  // +Remove song by title
  void removeSong(string title) {
    if (head == nullptr) {
      cout << "Playlist is empty.\n";
      return;
    }

    Song* temp = head;
    Song* prev = nullptr;

    // If song is at head
    if (temp != nullptr && temp->title == title) {
      head = temp->next;
      delete temp;
      cout << "Song removed: " << title << endl;
      return;
    }

    // Search for the song
    while (temp != nullptr && temp->title != title) {
      prev = temp;
      temp = temp->next;
    }

    // Song not found
    if (temp == nullptr) {
      cout << "Song not found: " << title << endl;
      return;
    }

    prev->next = temp->next;
    delete temp;
    cout << "Song removed: " << title << endl;
  }

  // Display playlist
  void display() {
    if (head == nullptr) {
      cout << "Playlist is empty.\n";
      return;
    }

    cout << "\nYour Playlist:\n";
    Song* temp = head;
    int index = 1;
    while (temp != nullptr) {
      cout << index++ << ". " << temp->title << endl;
      temp = temp->next;
    }
  }

  // Move song up or down in the playlist
  void reorder(int pos, bool moveUp) {
    if (head == nullptr || head->next == nullptr) {
      cout << "Not enough songs to reorder.\n";
      return;
    }

    if (pos <= 1 && moveUp) {
      cout << "Song already at top.\n";
      return;
    }

    // Find the node at given position
    Song* prev = nullptr;
    Song* curr = head;
    for (int i = 1; curr != nullptr && i < pos; i++) {
      prev = curr;
      curr = curr->next;
    }

    if (curr == nullptr) {
      cout << "Invalid position.\n";
      return;
    }

    if (moveUp) {
      // Move up — swap with previous node
      if (pos == 2) {  // Special case: move second node to head
        prev->next = curr->next;
        curr->next = head;
        head = curr;
      } else {
        Song* prePrev = head;
        for (int i = 1; i < pos - 2; i++) prePrev = prePrev->next;

        prePrev->next = curr;
        prev->next = curr->next;
        curr->next = prev;
      }
      cout << "Moved up: " << curr->title << endl;
    } else {
      // Move down — swap with next node
      if (curr->next == nullptr) {
        cout << "Song already at bottom.\n";
        return;
      }

      Song* nextNode = curr->next;
      curr->next = nextNode->next;
      nextNode->next = curr;

      if (prev == nullptr)
        head = nextNode;
      else
        prev->next = nextNode;

      cout << "Moved down: " << nextNode->title << endl;
    }
  }
};

// Main menu
int main() {
  Playlist playlist;
  int choice, pos;
  string title;

  while (true) {
    cout << "\n====== Playlist Manager ======\n";
    cout << "1. Add Song\n";
    cout << "2. Remove Song\n";
    cout << "3. Display Playlist\n";
    cout << "4. Move Song Up\n";
    cout << "5. Move Song Down\n";
    cout << "6. Exit\n";
    cout << "Enter your choice: ";
    cin >> choice;
    cin.ignore();  // To handle newline

    switch (choice) {
      case 1:
        cout << "Enter song title: ";
        getline(cin, title);
        playlist.addSong(title);
        break;
      case 2:
        cout << "Enter song title to remove: ";
        getline(cin, title);
        playlist.removeSong(title);
        break;
      case 3:
        playlist.display();
        break;
      case 4:
        cout << "Enter song position to move up: ";
        cin >> pos;
        playlist.reorder(pos, true);
        break;
      case 5:
        cout << "Enter song position to move down: ";
        cin >> pos;
        playlist.reorder(pos, false);
        break;
      case 6:
        cout << "Exiting Playlist Manager.\n";
        return 0;
      default:
        cout << "Invalid choice! Try again.\n";
    }
  }
}
