#include <cstdlib>

#pragma once

#include <iostream>
#include "Performance.h"

class List {
    Performance *Head, *Tail;
public:
    List() : Head(nullptr), Tail(nullptr) {};
    ~List(); //Destruct
    void Show();
    void Add(float cost, int day);
};

List::~List() {
    while (Head) {
        //BackUp Next Address
        Tail = Head->Next;
        //Deleting address 1st element
        delete Head;
        //Changing begin to next element
        Head = Tail;
    }
}

void List::Add(float cost, int day) {
    auto *temp = new Performance;
    temp->Next = nullptr;
    temp->cost = cost;
    temp->day = day;

    if (Head != nullptr) {
        //Adding address on previous element
        temp->Prev = Tail;
        Tail->Next = temp;
        //change Tail address
        Tail = temp;
    } else {
        //List is empty
        temp->Prev = nullptr;
        Head = Tail = temp;
    }
}

void List::Show() {
    //from the Tail
    Performance *temp = Tail;
    while (temp != nullptr) {
        std::cout << "Cost: "temp->cost << " ";
        //Change address on previous element
        temp = temp->Prev;
    }
    std::cout << "\n";

    //from the Head
    temp = Head;
    while (temp != nullptr) {
        std::cout << "Cost: "temp->cost << " ";
        //Change address on next element
        temp = temp->Next;
    }
    std::cout << "\n";
}
