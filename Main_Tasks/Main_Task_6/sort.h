void quickSort(int *mas, int first, int last) {
    int mid, count;
    int f = first, l = last;
    mid = mas[(f + l) / 2]; //вычисление опорного элемента
    do {
        while (mas[f] > mid) f++;
        while (mas[l] < mid) l--;
        if (f <= l) { //перестановка элементов
            count = mas[f];
            mas[f] = mas[l];
            mas[l] = count;
            f++;
            l--;
        }
    } while (f < l);
    if (first < l) quickSort(mas, first, l);
    if (f < last) quickSort(mas, f, last);
}
