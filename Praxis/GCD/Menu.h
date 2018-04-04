#ifndef GCD_MENU_H
#define GCD_MENU_H

#endif //GCD_MENU_H

int displayMenu (){
    int option;
    std::cout << "1. From ran number\n"
            "2. From min number \n"
            "3. GCD \n"
            "4. Evklid's algorithm (recursion)\n"
            "5. Evklid's algorithm (iteration) \n"
            "6. BAR (recursion) \n"
            "7. BAR (iteration) \n"
            "8. BAR (iteration with swidg) \n "
            "Option >> ";
    std::cin >> option;
    return option;
}
