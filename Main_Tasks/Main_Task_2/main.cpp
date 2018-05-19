#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cstring>

using namespace std;

#define BASE "phone.dat"

struct PhoneItem {
    char firstName[5];
    char secondName[10];
    char phone[10];
    PhoneItem *prev;
    PhoneItem *next;
};

char prompt_menu_item();

int iNumber(char *str, int length, char *info);

int iName(char *str, int length, char *info);

void showList(PhoneItem *head);

void allDelete(PhoneItem *&head);

int addToList(PhoneItem *&head);

void search(PhoneItem *head);

void loadList(PhoneItem *&head);

void saveList(PhoneItem *head);

int deleteItem(PhoneItem *&head);

void sortList(PhoneItem *&head);

void sortFirstName(PhoneItem *&tempHead);

int main(int argc, char *argv[]) {
    PhoneItem *Head = nullptr;
    char variant;
    while (true) {
        variant = prompt_menu_item();
        switch (variant) {
            case '1':
                addToList(Head);
                break;
            case '2':
                deleteItem(Head);
                break;
            case '3':
                search(Head);
                break;
            case '4':
                showList(Head);
                break;
            case '5':
                sortList(Head);
                break;
            case '6':
                saveList(Head);
                break;
            case '7':
                allDelete(Head);
                loadList(Head);
                break;
            case '8':
                allDelete(Head);
                cout << "End of Program" << endl << "Press any button to continue" << endl;
                return 0;
            default:
                break;
        }
    }
}

char prompt_menu_item()//Меню
{
    char variant;
    do {
        cout << endl << endl;
        cout << "Choose option\n" << endl;
        cout << " 1. Add a Line\n"
             << " 2. Delete a Line\n"
             << " 3. Look for a Line\n"
             << " 4. Display full List\n"
             << " 5. Sort List\n"
             << " 6. Save to File\n"
             << " 7. Load from File\n"
             << " 8. Eit\n"
                "Option > ";
        cin >> variant;
    } while (!strchr("12345678", variant));
    return variant;
}

// INPUT NUMBER
int iNumber(char *str, int length, char *info) {
    int i = 0;
    char ch;

    cout << endl << info << endl << "-> ";
    while (i < length) {
        cin >> ch;
        if ((ch == '\r') && (i >= 3)) break;
        if (ch >= '0' && ch <= '9') {
            str[i] = ch;
            i++;
            cout << ch;
        }
    }
    str[i] = '\0';
    return 0;
}

//INPUT
int iName(char *str, int length, char *info) {
    int i = 0;
    char ch;
    cout << endl << info << endl << "-> ";
    while (i <= length) {
        cin >> ch;
        if ((ch == '\r') && (i >= 1)) break;
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch == '-'))
        {
            str[i] = ch;
            i++;
            cout << ch;
        }
    }
    str[i] = '\0';
    return 0;
}

void showList(PhoneItem *head)//Вывод данных из справочника
{
    PhoneItem *tmpItem = head;
    int count = 0;

    cout << "Full List:" << endl;
    while (tmpItem) {
        cout << count + 1 << ". " << tmpItem->firstName << " " << tmpItem->secondName << " " << tmpItem->phone << endl;
        count++;
        tmpItem = tmpItem->next;
    }
    cout << "Total of Lines = " << count << endl;
}

void allDelete(PhoneItem *&head)//Удаление всех данных
{
    PhoneItem *tmpItem;
    while (head) {
        if (head->next) {
            tmpItem = head->next;
            delete head;
            head = tmpItem;
        } else {
            delete head;
            head = nullptr;
        }
    }
}

int addToList(PhoneItem *&head)//Добавление
{
    PhoneItem *tmpItem = new PhoneItem, *tmpSearch = head;
    tmpItem->firstName[0] = '\0';
    tmpItem->secondName[0] = '\0';
    tmpItem->phone[0] = '\0';
    tmpItem->prev = nullptr;
    tmpItem->next = nullptr;
    iName(tmpItem->firstName, 5, const_cast<char *>("Enter the First Name"));
    iName(tmpItem->secondName, 10, const_cast<char *>("Enter the Second Name"));
    iNumber(tmpItem->phone, 10, const_cast<char *>("Enter the number"));
    while (tmpSearch) {
        if (strcmp(tmpSearch->phone, tmpItem->phone) == 0) {
            cout << endl << "ERROR: This number already exist in list";
            delete tmpItem;
            return 1;
        }
        if (tmpSearch->next) {
            tmpSearch = tmpSearch->next;
        } else
            tmpSearch = nullptr;
    }

    if (head) {
        tmpItem->next = head;
        head->prev = tmpItem;
        head = tmpItem;
    } else // head==NULL
        head = tmpItem;
    return 0;
}

void search(PhoneItem *head)//Поиск по фамилии или по номеру
{
    int count = 0;
    char tmpstr[21];
    PhoneItem *tmpSearch = head;
    char variant;

    do {
        cout << endl << endl;
        cout << "Options: \n" << endl;
        cout << " 1. Search by surname\n"
             << " 2. Search by number\n" << endl;
        cin >> variant;
    } while (!strchr("12", variant));

    tmpstr[0] = '\0';


    if (variant == 1) {
        iName(tmpstr, 21, const_cast<char *>("Please enter surname"));
        cout << endl << "Searching ..." << endl;

        while (tmpSearch) {
            if (strcmp(tmpSearch->secondName, tmpstr) == 0) {
                cout << count + 1 << ". " << tmpSearch->firstName << " " << tmpSearch->secondName << " " << tmpSearch->phone
                     << endl;
                count++;
            }
            tmpSearch = tmpSearch->next;
        }
    } else { // поиск по номеру телефона
        iNumber(tmpstr, 13, const_cast<char *>("Enter please the number"));
        cout << endl << "Searching ..." << endl;
        while (tmpSearch) {
            if (strcmp(tmpSearch->phone, tmpstr) == 0) {
                cout << count + 1 << ". " << tmpSearch->firstName << " " << tmpSearch->secondName << " " << tmpSearch->phone
                     << endl;
                count++;
            }
            tmpSearch = tmpSearch->next;
        }
    }
    cout << endl << "Found Lines:  " << count << endl;
};

void loadList(PhoneItem *&head)//Загрузка из файла
{
    PhoneItem *tmpItem;
    int count = 0;
    FILE *fin = fopen(BASE, "rt");

    if (fin != nullptr) {
        while (!feof(fin)) {
            tmpItem = new PhoneItem;
            tmpItem->firstName[0] = '\0';
            tmpItem->secondName[0] = '\0';
            tmpItem->phone[0] = '\0';
            tmpItem->prev = nullptr;
            tmpItem->next = nullptr;

            fscanf(fin, "%s %s %s", &tmpItem->firstName, &tmpItem->secondName, &tmpItem->phone);

            if (strlen(tmpItem->firstName) && strlen(tmpItem->secondName) && strlen(tmpItem->phone)) {
                if (head) {
                    head->prev = tmpItem;
                    tmpItem->next = head;
                    head = tmpItem;
                } else {
                    head = tmpItem;
                }
                count++;
            } else {
                delete tmpItem;
            }
        }
        fclose(fin);
        cout << endl << "Lines loaded = " << count << endl;
    } else {
        cout << endl << "ERROR: Unable to open the file " << endl;
    }
};

void saveList(PhoneItem *head)//Сохранить в файл
{
    PhoneItem *tmpItem = head;
    int count = 0;
    FILE *fout = fopen(BASE, "wt");


    if (fout != nullptr) {
        while (tmpItem) {
            fprintf(fout, "%s %s %s\n", tmpItem->firstName, tmpItem->secondName, tmpItem->phone);
            tmpItem = tmpItem->next;
            count++;
        }
        fclose(fout);
        cout << endl << "Amount of written Data: " << count << endl;
    } else {
        cout << endl << "ERROR: Unable to close the file! " << endl;
    }
};

int deleteItem(PhoneItem *&head)//Удаление записи
{
    PhoneItem *tmpSearch = head;
    char * tmp_phone = const_cast<char *>("");
    tmp_phone[0] = '\0';
    iNumber(tmp_phone, 13, const_cast<char *>("Please enter the phone number"));
    while (tmpSearch) {
        if (strcmp(tmpSearch->phone, tmp_phone) == 0) {
            if ((tmpSearch->prev) && (tmpSearch->next)) {
                tmpSearch->prev->next = tmpSearch->next;
                tmpSearch->next->prev = tmpSearch->prev;
            } else if ((tmpSearch->prev == nullptr) && (tmpSearch->next)) {
                tmpSearch->next->prev = nullptr;
                head = tmpSearch->next;
            } else if ((tmpSearch->prev) && (tmpSearch->next == nullptr)) {
                tmpSearch->prev->next = nullptr;
            } else if ((tmpSearch->prev == nullptr) && (tmpSearch->next == nullptr)) {
                head = nullptr;
            }
            delete tmpSearch;
            cout << endl << "Line has been deleted" << endl;
            return 0;
        }
        tmpSearch = tmpSearch->next;
    }
    cout << endl << "Number not found in the List" << endl;
    return 0;
};

void sortList(PhoneItem *&head)//Сортировка справочника
{
    PhoneItem *tmpHead = head, *tmpPk1, *tmpPk2, *Prev1, *Next2;
    int n = 0, i, j;

    while (tmpHead != nullptr) {// Считаем количество элементов в списке
        n++;
        tmpHead = tmpHead->next;
    }

    cout << endl << "Searching ..." << endl;


    //Bubble Sort
    for (i = 0; i < (n - 1); i++) {
        tmpHead = head;
        for (j = 0; j < n - 1 - i; j++) {
            tmpPk1 = tmpHead;
            tmpPk2 = tmpHead->next;
            if (strcmp(tmpPk1->secondName, tmpPk2->secondName) > 0) {
                Prev1 = tmpPk1->prev;
                Next2 = tmpPk2->next;

                tmpPk2->next = tmpPk1;
                tmpPk2->prev = Prev1;
                tmpPk1->next = Next2;
                tmpPk1->prev = tmpPk2;
                if (Next2 != nullptr)
                    Next2->prev = tmpPk1;
                if (tmpPk1 != head) {
                    Prev1->next = tmpPk2;
                } else
                    head = tmpPk2;
                tmpHead = tmpPk2;
            }
            tmpHead = tmpHead->next;
        }
        sortFirstName(tmpHead);// Сортировка по имени
    }
    sortFirstName(head);// Сортировка по имени
    cout << endl << "List is Sorted " << endl;
};

void sortFirstName(PhoneItem *&tempHead)//Сортировка по имени
{
    PhoneItem *tmpItem;
    char tmpStr[32];
    // Сортировка по имени
    tmpItem = tempHead;
    while (true) {
        if (tmpItem->next) {
            if (strcmp(tmpItem->secondName, tmpItem->next->secondName) == 0) {// фамилии совпадают
                if (strcmp(tmpItem->firstName, tmpItem->next->firstName) > 0) {
                    strcpy(tmpStr, tmpItem->firstName);
                    strcpy(tmpItem->firstName, tmpItem->next->firstName);
                    strcpy(tmpItem->next->firstName, tmpStr);
                    // surname doesn't need to be copied
                    strcpy(tmpStr, tmpItem->phone);
                    strcpy(tmpItem->phone, tmpItem->next->phone);
                    strcpy(tmpItem->next->phone, tmpStr);
                }
                tmpItem = tmpItem->next;
            } else
                break;
        } else
            break;
    }
};
