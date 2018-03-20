#include <fstream>

bool initDuoList();

void inputFile() {
    std::ifstream file("theater.dat");
    if (!file.is_open())
        std::cerr << "[ERROR] Please check the name or placement of file\n"
                "[HINT] It must call \'theater.dat\'\n";
        //ask about separation
    else {
        file.close();
        if (initDuoList()) {
            std::cout << "Preparation Done!";
        } else {
            std::cerr << "[ERROR] Invalid syntax of file\n";
        }
    }
}

bool initDuoList() {
    std::ifstream file("theater.dat");

}