#include "Date.h"

struct Performance {
    char title[50];
    int day;
    float cost;
    Performance *Next, *Prev;
};