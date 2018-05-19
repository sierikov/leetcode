#pragma once
#include <iostream>
#include <cstdio>
#include <cstdlib>

class someArray {
private:
    int sizeMass;
    int * mass;
public:
    someArray();
    someArray(int razm);
    ~someArray();
    int size();
    int& operator[] (int x);
    someArray& operator= (someArray &arr2);
    friend bool operator== (someArray &arr1, someArray &arr2);
    friend bool operator!= (someArray &arr1, someArray &arr2);
    friend std::ostream& operator<< (std::ostream &stream, someArray &arr1);
    friend std::istream& operator>> (std::istream &stream, someArray &arr1);
};


// ClassArray.cpp

someArray::someArray(){ sizeMass = 0; mass = nullptr; };

someArray::someArray(int razm)
{
    if(razm > 0 && razm < 20000){
        sizeMass = razm;
        mass = new int[sizeMass];
    } else { // Недопустимый размер массива
        sizeMass = 0; mass = nullptr;
    }
};

someArray::~someArray()
{
    delete[] mass;
};

int someArray::size()
{
    return this->sizeMass;
};

int& someArray::operator[] (int x)
{
    return mass[x];
};

someArray& someArray::operator= (someArray &arr2)
{
    if(this == &arr2) return *this;
    delete[] this->mass;
    this->sizeMass = arr2.size();
    this->mass = new int[this->sizeMass];
    for(int i = 0; i < this->sizeMass; i++)
        this->mass[i] = arr2[i];
    return *this;
};

bool operator== (someArray &arr1, someArray &arr2)
{
    if(arr1.size() != arr1.size())
        return false;
    else
        for(int i = 0; i < arr1.size(); i++)
            if(arr1[i] != arr2[i])
                return false;
    return true;
};

bool operator!= (someArray &arr1, someArray &arr2)
{
    if(arr1.size() != arr1.size())
        return true;
    else
        for(int i = 0; i < arr1.size(); i++)
            if(arr1[i] != arr2[i])
                return true;
    return false;
};

std::ostream& operator<< (std::ostream &stream, someArray &arr1)
{
    for(int i=0; i < arr1.size(); i++)
        stream << arr1[i] << " ";
    stream<<std::endl;
    return stream;
};

std::istream& operator>> (std::istream &stream, someArray &arr1)
{
    for(int i=0; i < arr1.size(); i++)
        stream >> arr1[i];
    return stream;
};