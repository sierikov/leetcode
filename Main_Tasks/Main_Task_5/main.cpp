#include <iostream>
#include "Matrix.h"

int main() {
    Matrix firstArray(7, 7);
    std::cout<<"---------- init --------\n";
    firstArray.display();
    std::cout<<"---------- sum ---------\n";
    findSUm(firstArray);
    std::cout<<"---------- replace -----\n";
    firstArray.replace();
    firstArray.display();
    return 0;
}