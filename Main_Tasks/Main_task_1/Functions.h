void fillData(Abonent *user, int amount) {
    std::cin.ignore();
    for (int i = 0; i < amount; i++) user[i].input();
}

int displayMenu() {
    int option;
    std::cout << " === Menu === \n"
            "1. Add line\n"
            "2. Delete line\n"
            "3. Find line\n"
            "4. Show all table\n"
            "5. Exit" << std::endl;
    do {
        std::cout << "Enter the option >> ";
        std::cin >> option;
    } while (!validate(option));
    return option;
}

void addLine(Abonent *user, int &amount) {
    amount++;
    std::cin.ignore();
    user[amount - 1].input();
    std::cout << "Done ";
}

void deleteLine(Abonent *user, int &amount) {
    char telephone[user->SIZE_Telephone];
    bool isInBook = false;
    std::cout << "\nPlease enter the number of Abonent: ";
    std::cin.ignore();
    std::cin.getline(telephone, user->SIZE_Telephone);
    for (int abonent = 0; abonent < amount; ++abonent) {
        if (!strcmp(telephone, user[abonent].telephone)) isInBook = true;
        if (isInBook) {
            for (int i = abonent + 1; i < amount; ++i) user[i] = user[i + 1];
            amount--;
            std::cout << "Deleted. \n\n";
            isInBook = false;
        }
    }
}

void findLine(Abonent *user, int amount) {
    char surname[user->SIZE_Surname];
    do {
        std::cout << "\nEnter please the surname of abonent: ";
        std::cin.ignore();
        std::cin.getline(surname, user->SIZE_Surname);
    } while (!validate(surname, user->SIZE_Surname));
    for (int i = 0; i < amount; i++)
        if (!strcmp(user[i].surname, surname)) {
            user[i].output();
        }
}

void showAll(Abonent *user, int amount) {
    for (int i = 0; i < amount; i++)
        user[i].output();
}