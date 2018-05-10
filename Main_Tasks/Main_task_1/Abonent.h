#include "Validator.h"

struct Abonent {
    static const int SIZE_Name = 11,
            SIZE_Surname = 21,
            SIZE_Telephone = 15;
    char name[SIZE_Name],
            surname[SIZE_Surname],
            telephone[SIZE_Telephone];

    void input() {
        do {
            std::cout << "Please enter the telephone number of Abonent :";
            std::cin.getline(telephone, SIZE_Telephone);
        } while (!validate(telephone, SIZE_Telephone));
        do {
            std::cout << "Please enter the name of Abonent :";
            std::cin.getline(name, SIZE_Name);
        } while (!validate(name, SIZE_Name));
        do {
            std::cout << "Please enter the surname of Abonent :";
            std::cin.getline(surname, SIZE_Surname);
        } while (!validate(surname, SIZE_Surname));
    }

    void output() {
        std::cout << telephone << '\t' << surname << '\t' << name << std::endl;
    }
};