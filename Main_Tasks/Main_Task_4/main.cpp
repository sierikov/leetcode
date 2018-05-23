#include <iostream>
#include <cstdio>
#include <cstdlib>
#include "ClassArray.h"
#include "functions.h"

int main() {
    someArray firstArray(10), secondArray;
    for (int i = 0; i < firstArray.size(); i++)
        firstArray[i] = rand() % 10;
    std::cout << "Object: First Array with size: " << firstArray.size() << std::endl;
    std::cout << firstArray << std::endl;
    std::cout << "Object: Second Array with size: " << secondArray.size() << std::endl;
    std::cout << secondArray << std::endl;
    std::cout << "Coping object 1 to object 2 ..." << std::endl;
    secondArray = firstArray;
    std::cout << "Here is object 2 with size of " << secondArray.size() << std::endl;
    std::cout << secondArray << std::endl;

    compareObjects(firstArray, secondArray);

    std::cout << "Enter new values for object 2\n "
                 "Enter please " << secondArray.size() << " elements for object 2" << std::endl;
    std::cin >> secondArray;

    compareObjects(firstArray, secondArray);

    std::cout << "Output:" << std::endl;
    std::cout << "Object 1 element[5] : " << firstArray[5] << std::endl;
    std::cout << "Object 2 element[5] : " << secondArray[5] << std::endl;

    return 0;
}

// ClassArray.h