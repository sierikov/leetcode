#include <iostream>
#include "Abonent.h"
#include "Functions.h"

int main() {
    int amountAbonents, option;
    std::cout << "Welcome to OurTelephone\n"
            "Before we start please enter some information" << std::endl;
    do{
        std::cout << "Enter please amount of users : ";
        std::cin >> amountAbonents;
    } while (!validate(amountAbonents));
    auto Book = new Abonent[amountAbonents];
    fillData(Book, amountAbonents);
    while (true) {
        option = displayMenu();
        if (option == 1) addLine(Book, amountAbonents);
        else if (option == 2) deleteLine(Book, amountAbonents);
        else if (option == 3) findLine(Book, amountAbonents);
        else if (option == 4) showAll(Book, amountAbonents);
        else break;
    }
    return 0;
}