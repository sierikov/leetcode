#include "BankData.h"

void sortDataByName();

int displayMenu() {
    int option;
    std::cout << " === Menu === \n"
            " 01. Sort the Base by Name\n"
            " 02. Put out all data from Year\n"
            " 99. Exit\n"
            "Option >> ";
    do std::cin >> option; while (!validate(option));
    return option;
}

void sortDataByName(int amount, BankData **pointerData) {
    std::cout << "Sorting ..";
    for (int i = 0; i < amount; ++i) {
        for (int j = 0; j < amount - i - 1; ++j) {
            if (strcmp(pointerData[j] -> name,
                       pointerData[j+1] -> name) > 0 ) {
                BankData *temp = pointerData[j];
                pointerData[j] = pointerData[j + 1];
                pointerData[j + 1] = temp;
            }
        }
    }
    std::cout << "Done.\n Want to see new Base [Y/N]: ";
    char temp;
    std::cin >> temp;
    if (temp == 'Y' || temp == 'y')
        for (int i = 0; i < amount; ++i)
            pointerData[i] -> output();
}

