#include "Date.h"

struct Performance {
    char title[50];
    int day;
    float cost;
    Performance *Next, *Prev;

    void add (){
        do {
            std::cout << "Please Enter the title of the Performance: " << std::endl;
            std::cin.getline(title, 50);
        } while (!validate(title));
    }
};