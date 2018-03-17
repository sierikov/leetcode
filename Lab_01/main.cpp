#include "BankData.h"
using namespace std;

int main() {
    int amount = 0;
    cout << "Welcome to my BankApp! \n"
            "Before we start, please fill the database\n"
            "Enter amount of currencies : ";
    while (!validate(amount))
        cin >> amount;
    auto *bankData = new BankData[amount];
    for (int i = 0; i < amount; ++i)
        bankData[i].input();
     cout << "Name\tNominal\tYear\tKurs" << endl;
    for (int i = 0; i < amount; ++i)
        bankData[i].output();
    delete [] bankData;
    return 0;
}