#include <iostream>
#include <vector>
using namespace std;
int main()
{
    vector<int> v1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    vector<int> v2 = {1, 2, 3, 4, 5};

    v1.swap(v2);

    cout << "first vector is : " << endl;
    for (vector<int>::iterator i = v1.begin(); i < v1.end(); i++)
    {
        cout << *i << " ";
    }
    cout << endl;
    cout << "second vector is : " << endl;
    for (vector<int>::iterator i = v2.begin(); i < v2.end(); i++)
    {
        cout << *i << " ";
    }

    return 0;
}