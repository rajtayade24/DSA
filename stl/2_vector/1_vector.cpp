#include <iostream>
#include <vector>
using namespace std;

int main()
{ /// first syntax for defiininng
    vector<int> v;
    v.push_back(1);
    v.emplace_back(2);

    for (int i : v)
        cout << v[i - 1] << endl;

    // second syntax to define a vector
    vector<int> v1(4, 1000);
    cout << v1[3] << endl;

    // vector<pair<int, int>> vec;
    // vec.push_back({1, 2});
    // vec.emplace_back(2, 3);
    // cout << vec[1].first << endl;

    // vector<int> v2(v1);
    // cout << v2[2] << endl;

    // // iterators
    // vector<int> v = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    // vector<int>::iterator it = v.begin(); // point to the memory location
    // cout << *(it) << " ";

    // it++;
    // cout << *(it) << " ";

    // it = it + 2;
    // cout << *(it) << " ";

    // vector<int>::iterator it = v.end(); //end point at the next of last index

    // vector<int>:;iterator it = v.rend();

    // vector<int>:;iterator it = v.rbegin();
    // cout << endl;

    // vector<int> v = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    // for (vector<int>::iterator i = v.begin(); i < v.end(); i++)
    // {
    //     cout << *(i) << " ";
    // }
    // cout << endl;

    // for (auto i = v.begin(); i < v.end(); i++)
    // {
    //     cout << *(i) << " ";
    // }
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