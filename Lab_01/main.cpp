#include "Functions.h"

using namespace std;

int main() {
    int amount = 0, option = 0;
    cout << "Welcome to my BankApp! \n"
            "Before we start, please fill the database\n"
            "Enter amount of currencies : ";
    while (!validate(amount))
        cin >> amount;

    //creating Base
    auto *bankData = new BankData[amount];
    for (int i = 0; i < amount; ++i)
        bankData[i].input();

    //massive of pointers
    auto **pointerData = new BankData *[amount];
    for (int i = 0; i < amount; ++i)
        pointerData[i] = &bankData[i];

    cout << "Base is ready to work!\n"
            "Name\tNominal\tYear\tKurs" << endl;
    for (int i = 0; i < amount; ++i)
        bankData[i].output();

    while (true) {
        option = displayMenu();
        if (option == 1) sortDataByName(amount, pointerData);
        else if (option == 2) outputYearDate(amount, pointerData);
        else break;
    }
    delete[] bankData;
    return 0;
}