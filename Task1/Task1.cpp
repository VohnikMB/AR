#include <iostream> 
#include <fstream> 
using  namespace std;

int main()
{
    ifstream sfile;
    ofstream efile;
    efile.open("text_copy.txt");
    sfile.open("text.txt");
    char sh;
    while (sfile.get(sh))
    {
        efile << sh;
        if (sh == '\n') efile << '\n';
    }
    sfile.close();
    efile.close();

}