#include <iostream>
#include <string>

struct Date {
    int day,
    month,
    year;
    const char * DAYS[7] = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };
};
