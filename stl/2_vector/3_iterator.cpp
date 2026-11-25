#include <iostream>
#include <vector>
using namespace std;

int main()
{
    // iterators
    vector<int> v = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    vector<int>::iterator it = v.begin();
    cout << *(it) << " ";

    it++;
    cout << *(it) << " ";

    it = it + 2;
    cout << *(it) << " ";

    return 0;
}