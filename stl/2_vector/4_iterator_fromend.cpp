#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<int> v = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    vector<int>::iterator it = v.end(); // end point at the next of last index
    cout << *(it) << " ";

    it--;
    cout << *(it) << " ";

    it = it - 4;
    cout << *(it) << " ";

   
    // vector<int>:;iterator it = v.rend();

    // vector<int>:;iterator it = v.rbegin();
    // cout << endl;

    // for (auto i : v)
    // {
    //     cout << i << " ";
    // }
    // cout << endl;

    // v.erase(v.begin() + 1); //v.erase(index)
    // v.erase(v.begin() + 1, v.end() + 1); //

    // vector<int> v = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    // v.insert(v.begin(), 200);       // 200 1 2 3 4 5 6 7 8 9
    // v.insert(v.begin() + 1, 2, 10); // 200 10 10 1 2 3 4 5 6 7 8 9
    // for (auto i : v)
    // {
    //     cout << i << " ";
    // }
    // cout << endl;

    // vector<int> copy(2, 50);
    // v.insert(v.begin(), copy.begin(), copy.end());
    // for (int i : v)
    // {
    //     cout << i << " ";
    // }
    // cout << endl;

    // cout << v.size();
    // cout << v.empty();

    // v.pop_back();

    // cout << endl;

    // // v1.swap(v2);

    return 0;
}