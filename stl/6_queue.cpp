#include <iostream>
#include <queue>
// last in first out
using namespace std;

int main()
{
    queue<int> q;
    q.push(1); //1
    q.push(2); //1, 2
    q.push(3); //1, 2, 3 
    q.push(4); //1, 2, 3, 4 

    cout  << q.front() << q.back() << endl;

    q.pop();
    
    cout  << q.front() << q.back() << endl;
 
    return 0;
}