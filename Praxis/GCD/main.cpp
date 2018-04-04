#include <iostream>
#include "Menu.h"
#include "GCD.h"
int main() {
    std::cout << "Hello, Friend! \n Choose an option" << std::endl;
    int option = 99;
    while (true) {
        option = displayMenu();
        if(option == 1) fromRanNumber();
        else if (option == 2) fromMinNumber();
        else if (option == 3) calculateGCD();
        else if (option == 4) EAI();
    }
    return 0;
}