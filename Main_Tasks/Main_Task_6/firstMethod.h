class firstMethod {
private:
    int *arr;
    int length;
    int max = 100;
    int min = 0;

    /*TASKS*/
    void making5Null() {
        clock_t beginTime = clock(); // начальное время
        for (int i = 4; i < length; i += 5)
            arr[i] = 0;
        beginTime = clock() - beginTime;
        std::cout << "Make 5th zero: " << (double)beginTime / CLOCKS_PER_SEC << std::endl;
    }

    void deleteOdd() {
        clock_t time = clock(); // начальное время
        int curr = 0;//index of new array;
        int newLenght = length;
        auto *newArr = new int[newLenght];

        for (int i = 0; i < length; ++i)
            if (arr[i] % 2 == 0) newArr[curr++] = arr[i];
            else
                newArr = (int *)realloc(newArr, (--newLenght) * sizeof(int));

        delete[]arr;
        arr = newArr;
        length = newLenght;
        time = clock() - time;
        printf("%s%f\n", "Delete odd numbers: ", (double)time / CLOCKS_PER_SEC);
    }

    void sort() {
        clock_t time = clock(); // начальное время
        quickSort(arr, 0, length);
        time = clock() - time;
        printf("%s%f\n", "Sort: ", (double)time / CLOCKS_PER_SEC);
    }

public:
    /*CONSTRUCTOR/DESTRUCTOR*/

    explicit firstMethod(int size) {
        length = size;
        arr = new int[size];
        for (int i = 0; i < size; ++i)
            arr[i] = min + rand() % (max - min);
    }

    virtual ~firstMethod() {
        delete[]arr;
    }

    /*TEST*/
    void go() {
        std::cout << "First -------------------\n";
        making5Null();
        deleteOdd();
        sort();
        std::cout << "First ------------------\n\n";
    }
};

