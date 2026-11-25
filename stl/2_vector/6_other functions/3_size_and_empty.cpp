#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<int> v = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    cout << v.size();
    cout << v.empty();

    v.pop_back();

    cout << endl;

    // v1.swap(v2);

    return 0;
}