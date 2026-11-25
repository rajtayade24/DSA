#include <iostream>
#include <stack>
// last in first out
using namespace std;

int main()
{
    stack<int> st;
    st.push(1); // 1
    st.push(2); // 2, 1
    st.push(3); // 3, 2, 1
    st.push(4); // 4, 3, 2, 1

    // for (auto i : st) {
    //     cout << i << "  ";
    // }
    // LOOPS DOES NOT WORS IN STACK IT IS LAST IN FIRST OUT
    //  MEANS COME AT THE LAST AND GO FIRSTLY
    //
    //  IMPORTANT FUNCTIONS ARE
    cout << st.top();
    
    return 0;
}