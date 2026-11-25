#include <iostream>
#include <set>
using namespace std;

int main()
{// sorted everything in a sorted order and has unique elements
    set<int> s;
    s.insert(1);
    s.insert(3);
    s.insert(4);
    s.insert(6);
    s.insert(2);
    s.insert(5);

    // everything is stored in an accending order
    for (auto i : s)
    {
        cout << i << " "; // 1 2 3 4 5 6
    }
    return 0;
}