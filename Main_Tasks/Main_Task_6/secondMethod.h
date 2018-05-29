class secondMethod {
private:
    std::vector<int> arr{};
    int max = 100;
    int min = 0;

    /*TASKS*/
    void making5Null() {
        clock_t time = clock(); // начальное время
        for (int i = 4; i < arr.size(); i += 5) arr[i] = 0;
        time = clock() - time;
        std::cout << "Make 5th zero:" << (double)time / CLOCKS_PER_SEC << std::endl;
    }

    void deleteOdd() {
        clock_t time = clock(); // начальное время
        for (int i = 0; i < arr.size(); i++)
            if (arr[i] % 2 != 0)
                arr.erase(arr.begin() + (i--));
        time = clock() - time;
        std::cout << "Delete odd numbers: " << (double)time / CLOCKS_PER_SEC << std::endl;
    }

    void sort() {
        clock_t time = clock(); // начальное время
        quickSort(&arr[0], 0, static_cast<int>(arr.size()));
        time = clock() - time;
        std::cout <<"Sort: " << (double)time / CLOCKS_PER_SEC << std::endl;
    }

public:
    explicit secondMethod(int size) {
        arr.reserve(static_cast<unsigned long>(size));
        for (int i = 0; i < size; i++)
            arr.push_back(min + rand() % (max - min));
    }

    ~secondMethod() {
        arr.clear();
    }

    /*TEST*/
    void go() {
        std::cout << "Second -------------------\n";
        making5Null();
        deleteOdd();
        sort();
        std::cout << "Second ------------------\n\n";
    }
};