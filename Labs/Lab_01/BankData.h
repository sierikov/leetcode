#include <iostream>
#include <cstring>
#include "Validator.h"

struct BankData {
    char name[6];
    int nominal, year;
    double kurs;

    void input() {
        std::cout << "Please enter the information below\n";
        std::cout << " Name of currency : ";
        while (!validate(name))
            std::cin.getline(name, 6);
        std::cout << " Nominal : ";
        while (!validate(nominal))
            std::cin >> nominal;
        std::cout << " Year : ";
        while (!validate(year))
            std::cin >> year;
        std::cout << " Exchange to UAH : ";
        while (!validate(kurs))
            std::cin >> kurs;
    }

    void output() {
        std::cout << name << "\t\t" << nominal << "\t\t" << year << '\t' << kurs << std::endl;
    }
};



