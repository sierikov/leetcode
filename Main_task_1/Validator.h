#include <cstring>
#include <iostream>

bool validate(char *str, int amount) {
    bool result = false;
    if (strlen(str) > 1 && strlen(str) < amount) {
        result = true;
    } else {
        std::cerr << "Invalid format. Try again.\n";
    }
    return result;
}

bool validate(int number) {
    bool result = false;
    if (number > 0) {
        result = true;
    } else {
        std::cerr << "Number must be above zero. Try again.\n";
    }
    return result;
}