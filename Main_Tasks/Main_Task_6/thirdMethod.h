int randomNumber() { return (0 + rand() % (100 - 0)); }
bool isOdd(int i) { return ((i % 2) == 1); }
bool compare(int i, int j) { return (i > j); }

class thirdMethod {
private:
    std::vector<int> arr{};

    /*TASKS*/
    void making5Null() {
        clock_t time = clock(); // начальное время
        std::vector<int>::iterator p;
        for (p = arr.begin(); p < arr.end(); p++)
            if ((p - arr.begin()) % 5 == 0) *p = 0;
        time = clock() - time;
        std::cout << "Make 5th zero: " << (double) time / CLOCKS_PER_SEC << std::endl;
    }

    void deleteOdd() {
        clock_t time = clock(); // начальное время
        arr.erase(
                remove_if(arr.begin(), arr.end(), isOdd),
                arr.end());
        time = clock() - time;
        std::cout << "Odd numbers: " << (double) time / CLOCKS_PER_SEC << std::endl;
    }

    void sortV() {
        clock_t time = clock(); // начальное время
        sort(arr.begin(), arr.end(), compare);
        time = clock() - time;
       std::cout << "Sort: " << (double) time / CLOCKS_PER_SEC << std::endl;
    }

public:
    explicit thirdMethod(int size) {
        arr.resize(static_cast<unsigned long>(size));
        generate(arr.begin(), arr.end(), randomNumber);
    }

    virtual ~thirdMethod() {
        arr.clear();
    }

    /*TEST*/
    void go() {
        std::cout << "Third -------------------\n";
        making5Null();
        deleteOdd();
        sortV();
        std::cout << "Third ------------------\n\n";
    }
};
