#include <iostream>
#include <cstring>
#include "Validator.h"

using namespace std;

struct BankData {
    char name[6];
    int nominal, year;
    double kurs;

    void input() {
        cout << "Please enter the information below\n";
        cout << " Name of currency : ";
        while (!validate(name))
           cin.getline(name, 6);
        cout << " Nominal : ";
        while (!validate(nominal))
            cin >> nominal;
        cout << " Year : ";
        while (!validate(year))
            cin >> year;
        cout << " Exchange to UAH : ";
        while (!validate(kurs))
            cin >> kurs;
    }

    void output() {
        cout << name << "\t\t" << nominal << "\t\t" << year << '\t' << kurs << endl;
    }
};