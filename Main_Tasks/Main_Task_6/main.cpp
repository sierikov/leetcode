#include <algorithm>
#include <ctime>
#include <iostream>
#include <vector>

#include "sort.h"
#include "firstMethod.h"
#include "secondMethod.h"
#include "thirdMethod.h"

int main() {
    int amount = 300000;
    srand(static_cast<unsigned int>(time(nullptr)));
    firstMethod firstArray(amount);
    firstArray.go();
    secondMethod secondArray(amount);
    secondArray.go();
    thirdMethod thirdArray(amount);
    thirdArray.go();
    return 0;
}