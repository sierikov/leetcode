#ifndef MAIN_TASK_5_MATRIX_H
#define MAIN_TASK_5_MATRIX_H

#endif

#pragma once

#include <iostream>
#include <cstdio>
#include <cstdlib>

class Matrix {
private:
    int cols;
    int rows;
    int **mass;
public:
    Matrix();

    Matrix(int rows, int cols);

    ~Matrix();

    void input();

    void display();

    void replace();

    int sizeRows();

    int sizeCols();

    friend void findSUm(Matrix &matrix);
};


// ClassArray.cpp

Matrix::Matrix() {};

Matrix::Matrix(int rows, int cols) {
    std::cout << "entered\n";
    this->cols = cols;
    this->rows = rows;
    mass = new int *[rows];
    for (int i = 0; i < rows; i++) mass[i] = new int[cols];
    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            mass[i][j] = rand() % 10;

};

Matrix::~Matrix() { for (int i = 0; i < rows; i++) delete[] mass[i]; };

int Matrix::sizeCols() { return cols; };

int Matrix::sizeRows() { return rows; };

void findSUm(Matrix &matrix) {
    int sum = 0;
    for (int i = 0; i < matrix.sizeCols(); i++)
        for (int j = 0; j < matrix.sizeRows(); j++)
            sum += matrix.mass[i][j];
    std::cout << "The sum is " << sum << std::endl;
};

void Matrix::replace() {
    for (int i = 0; i < sizeCols(); i++)
        for (int j = 0; j < sizeRows(); j++)
            if (mass[i][j] % 2 == 0) mass[i][j] = 0;
            else mass[i][j] = 1;
}

void Matrix::display() {
    std::cout << "Display\n" << "ROW = " << rows << " COL = " << cols << std::endl;
    for (int i = 0; i < rows; i++, std::cout << std::endl)
        for (int j = 0; j < cols; j++)
            std::cout << mass[i][j] << " ";
}

void Matrix::input() {
    for (int i = 0; i < sizeCols(); i++)
        for (int j = 0; j < sizeRows(); j++)
            std::cin >> mass[i][j];
}