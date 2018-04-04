#ifndef GCD_GCD_H
#define GCD_GCD_H

#endif //GCD_GCD_H

long min(long a, long b) {
    return a > b ? b : a;
}


void fromRanNumber () {
    int a,b;
    std::cout << "Enter the values \n "
                 "A = ";
    std::cin >> a;
    std::cout << "B = ";
    std::cin >> b;
    for (int i = a; i > 0; i--) {
        if (a % i == 0 && b % i == 0) {
            std::cout << "GCD is = " << i;
            break;
        }
    }
}

void fromMinNumber () {
    int a,b;
    std::cout << "Enter the values \n "
                 "A = ";
    std::cin >> a;
    std::cout << "B = ";
    std::cin >> b;
    for (long i = min(a, b); i > 0; i--) {
        if (a % i == 0 && b % i == 0) {
            std::cout << "GCD is = " << i;
            break;
        }
    }
}

void calculateGCD() {
    int a,b;
    std::cout << "Enter the values \n "
                 "A = ";
    std::cin >> a;
    std::cout << "B = ";
    std::cin >> b;
    if (a > b) {
        long tmp = a;
        a = b;
        b = static_cast<int>(tmp);
    }
    while (a > 1L && b > 1L) {
        for (long i = 2; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                std::cout << "GCD is = " << i;
                a /= i;
                b /= i;
                break;
            }
            if (a % i == 0) {
                a /= i;
                break;
            }
            if (b % i == 0) {
                b /= i;
                break;
            }
        }
    }
}

void EAI () {
    int a,b;
    std::cout << "Enter the values \n "
                 "A = ";
    std::cin >> a;
    std::cout << "B = ";
    std::cin >> b;
    if (a == b) {
        std::cout << "GCD is = " << a;
    }
    if (a > b) {
        long tmp = a;
        a = b;
        b = static_cast<int>(tmp);
    }
    return EAI(a, b - a);

}
