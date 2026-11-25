#include <iostream>
#include <string>
using namespace std;


string asciiToBinary(string text)
{
    string binary = "";

    for (char ch : text)
    {
        int ascii = (int)ch;

        for (int i = 7; i >= 0; i--)
        {
            binary += ((ascii >> i) & 1) + '0';
        }
    }

    return binary;
}


string crcdivision(string data, string generator)
{
    int n = data.length();
    int g = generator.length();


    for (int i = 0; i <= n - g; i++)
    {
        if (data[i] == '1')
        {
            for (int j = 0; j < g; j++)
            {
                if (data[i + j] == generator[j])
                    data[i + j] = '0';
                else
                    data[i + j] = '1';
            }
        }
    }

    
    return data.substr(n - g + 1, g - 1);
}


int main()
{
    string text, generator;

    
    cout << "enter ASCII text: ";
    cin >> text;

    cout << "enter generator: ";
    cin >> generator;


    
    string data = asciiToBinary(text);

    cout << "\nbinary data: " << data << endl;



    int zeros = generator.length() - 1;

    string appendedData = data;

    for (int i = 0; i < zeros; i++)
    {
        appendedData += '0';
    }

    cout << "data after adding zeros: "
         << appendedData << endl;


    
    string crc = crcdivision(appendedData, generator);
    cout << "CRC: " << crc << endl;


    
    string codeword = data + crc;

    cout << "transmitted codeword: "
         << codeword << endl;


    
    string received;

    cout << "\nenter received codeword: ";
    cin >> received;


    
    string remainder = crcdivision(received, generator);

    cout << "receiver remainder: "
         << remainder << endl;

    if (remainder.find('1') == string::npos)
    {
        cout << "no error detected." << endl;
        cout << "data accepted." << endl;
    }
    else
    {
        cout << "error detected" << endl;
        cout<<"retransmission reqired"<<endl;
        cout<<"retransmission data is:"<<codeword<<endl;

        
    }

    return 0;
}