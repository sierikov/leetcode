#include <cstdlib>

#pragma once

#include <iostream>
#include "Performance.h"

class List {
    Performance *head, *tail;
public:
    List() : head(nullptr), tail(nullptr) {};
    ~List(); //Destruct
    void show();
    void add(float cost, int day);
    void deleteElement();
    void foundElement();

};

List::~List() {
    while (head) {
        //BackUp Next Address
        tail = head->Next;
        //Deleting address 1st element
        delete head;
        //Changing begin to next element
        head = tail;
    }
}

void List::add(float cost, int day) {
    auto *temp = new Performance;
    temp->Next = nullptr;
    temp->cost = cost;
    temp->day = day;

    if (head != nullptr) {
        //Adding address on previous element
        temp->Prev = tail;
        tail->Next = temp;
        //change tail address
        tail = temp;
    } else {
        //List is empty
        temp->Prev = nullptr;
        head = tail = temp;
    }
}

void List::show() {
    //from the tail
    Performance *temp = tail;
    while (temp != nullptr) {
        std::cout << "Cost: "temp->cost << " ";
        //Change address on previous element
        temp = temp->Prev;
    }
    std::cout << "\n";

    //from the head
    temp = head;
    while (temp != nullptr) {
        std::cout << "Cost: "temp->cost << " ";
        //Change address on next element
        temp = temp->Next;
    }
    std::cout << "\n";
}

void List::deleteElement(){
    Performance *temp = tail;

}

void List::foundElement() {
    Performance *temp = head;
    int userDay = 3;
    while (temp != nullptr) {
        if (userDay == temp->day) std::cout << "Item has been found!" << std::endl;
        temp = temp->Next;
    }
}