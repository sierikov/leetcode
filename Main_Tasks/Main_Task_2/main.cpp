#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cstring>

using namespace std;

#define F_NAME "phone.dat"

struct PhoneItem {
    char fname[11];
    char sname[21];
    char phone[13];
    PhoneItem *prev;
    PhoneItem *next;
};

char prompt_menu_item();

int input_number(char *str, int strlen, char *info);

int input_name(char *str, int strlen, char *info);

void print_phonelist(PhoneItem *head);

void delete_all_items(PhoneItem *&head);

int add_to_phonelist(PhoneItem *&head);

void search_in_phonelist(PhoneItem *head);

void load_phonelist(PhoneItem *&head);

void save_phonelist(PhoneItem *head);

int delete_phoneitem(PhoneItem *&head);

void sort_phonelist(PhoneItem *&head);

void sort_by_fname(PhoneItem *&tmphead);

int main(int argc, char *argv[]) {
    PhoneItem *Head = nullptr;
    char variant;
    while (true) {
        variant = prompt_menu_item();
        switch (variant) {
            case '1':
                add_to_phonelist(Head);
                break;
            case '2':
                delete_phoneitem(Head);
                break;
            case '3':
                search_in_phonelist(Head);
                break;
            case '4':
                print_phonelist(Head);
                break;
            case '5':
                sort_phonelist(Head);
                break;
            case '6':
                save_phonelist(Head);
                break;
            case '7':
                delete_all_items(Head);
                load_phonelist(Head);
                break;
            case '8':
                delete_all_items(Head);
                cout << "Завершение работы программы." << endl << "Нажмите любую клавишу." << endl;
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
        cout << "Выберите вариант\n" << endl;
        cout << " 1. Добавить запись\n"
             << " 2. Удалить запись\n"
             << " 3. Найти запись\n"
             << " 4. Показать все записи\n"
             << " 5. Сортировать записи\n"
             << " 6. Сохранить в файл\n"
             << " 7. Загрузить из файла\n"
             << " 8. Выйти из программы\n"
                "Ваш выбор = ";
        cin >> variant;
    } while (!strchr("12345678", variant));
    return variant;
}

// INPUT NUMBER
int input_number(char *str, int strlen, char *info) {
    int i = 0;
    char ch;

    cout << endl << info << endl << "-> ";
    while (i < strlen) {
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
int input_name(char *str, int strlen, char *info) {
    int i = 0;
    char ch;

    cout << endl << info << endl << "-> ";
    while (i <= strlen) {
        cin >> ch;
        if ((ch == '\r') && (i >= 1)) break;
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch == '-') || (ch >= 'А' && ch <= 'Я') ||
            (ch >= 'а' && ch <= 'я')) {
            str[i] = ch;
            i++;
            cout << ch;
        }
    }
    str[i] = '\0';
    return 0;
}

void print_phonelist(PhoneItem *head)//Вывод данных из справочника
{
    PhoneItem *tmpItem = head;
    int count = 0;

    cout << "Телефонный справочник:" << endl;
    while (tmpItem) {
        cout << count + 1 << ". " << tmpItem->fname << " " << tmpItem->sname << " " << tmpItem->phone << endl;
        count++;
        tmpItem = tmpItem->next;
    }
    cout << "Всего записей " << count << endl;
}

void delete_all_items(PhoneItem *&head)//Удаление всех данных
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

int add_to_phonelist(PhoneItem *&head)//Добавление
{
    PhoneItem *tmpItem = new PhoneItem, *tmpSearch = head;
    tmpItem->fname[0] = '\0';
    tmpItem->sname[0] = '\0';
    tmpItem->phone[0] = '\0';
    tmpItem->prev = nullptr;
    tmpItem->next = nullptr;
    input_name(tmpItem->fname, 11, const_cast<char *>("Введите имя"));
    cout << endl;
    input_name(tmpItem->sname, 21, const_cast<char *>("Введите фамилию"));
    cout << endl;

    input_number(tmpItem->phone, 13, const_cast<char *>("Введите номер телефона"));
    while (tmpSearch) {
        if (strcmp(tmpSearch->phone, tmpItem->phone) == 0) {
            cout << endl << "Запись с таким номером телефона уже существует.";
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

void search_in_phonelist(PhoneItem *head)//Поиск по фамилии или по номеру
{
    int count = 0;
    char tmpstr[21];
    PhoneItem *tmpSearch = head;
    char variant;

    do {
        cout << endl << endl;
        cout << "Выберите вариант поиска\n" << endl;
        cout << " 1. Искать по фамилии\n"
             << " 2. Искать по номеру телефона\n" << endl;
        cin >> variant;
    } while (!strchr("12", variant));

    tmpstr[0] = '\0';


    if (variant == 1) {
        input_name(tmpstr, 21, const_cast<char *>("Введите фамилию для поиска"));
        cout << endl << "Идет поиск ..." << endl;

        while (tmpSearch) {
            if (strcmp(tmpSearch->sname, tmpstr) == 0) {
                cout << count + 1 << ". " << tmpSearch->fname << " " << tmpSearch->sname << " " << tmpSearch->phone
                     << endl;
                count++;
            }
            tmpSearch = tmpSearch->next;
        }
    } else { // поиск по номеру телефона
        input_number(tmpstr, 13, const_cast<char *>("Введите номер телефона для поиска"));
        cout << endl << "Идет поиск ..." << endl;
        while (tmpSearch) {
            if (strcmp(tmpSearch->phone, tmpstr) == 0) {
                cout << count + 1 << ". " << tmpSearch->fname << " " << tmpSearch->sname << " " << tmpSearch->phone
                     << endl;
                count++;
            }
            tmpSearch = tmpSearch->next;
        }
    }
    cout << endl << "Найдено записей " << count << endl;
};

void load_phonelist(PhoneItem *&head)//Загрузка из файла
{
    PhoneItem *tmpItem;
    int count = 0;
    FILE *fin = fopen(F_NAME, "rt");

    if (fin != nullptr) {
        while (!feof(fin)) {
            tmpItem = new PhoneItem;
            tmpItem->fname[0] = '\0';
            tmpItem->sname[0] = '\0';
            tmpItem->phone[0] = '\0';
            tmpItem->prev = nullptr;
            tmpItem->next = nullptr;

            fscanf(fin, "%p %p %p", &tmpItem->fname, &tmpItem->sname, &tmpItem->phone);

            if (strlen(tmpItem->fname) && strlen(tmpItem->sname) && strlen(tmpItem->phone)) {
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

void save_phonelist(PhoneItem *head)//Сохранить в файл
{
    PhoneItem *tmpItem = head;
    int count = 0;
    FILE *fout = fopen(F_NAME, "wt");


    if (fout != nullptr) {
        while (tmpItem) {
            fprintf(fout, "%s %s %s\n", tmpItem->fname, tmpItem->sname, tmpItem->phone);
            tmpItem = tmpItem->next;
            count++;
        }
        fclose(fout);
        cout << endl << "Записано записей " << count << endl;
    } else {
        cout << endl << "Ошибка! Невозможно открыть файл " << endl;
    }
};

int delete_phoneitem(PhoneItem *&head)//Удаление записи
{
    PhoneItem *tmpSearch = head;
    char tmp_phone[13];
    tmp_phone[0] = '\0';
    input_number(tmp_phone, 13, const_cast<char *>("Чтобы удалить запись, введите номер телефона"));
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
            cout << endl << "Запись удалена" << endl;
            return 0;
        }
        tmpSearch = tmpSearch->next;
    }
    cout << endl << "Телефон не найден" << endl;
    return 0;
};

void sort_phonelist(PhoneItem *&head)//Сортировка справочника
{
    PhoneItem *tmpHead = head, *tmpPk1, *tmpPk2, *Prev1, *Next2;
    int n = 0, i, j;

    while (tmpHead != nullptr) {// Считаем количество элементов в списке
        n++;
        tmpHead = tmpHead->next;
    }

    cout << endl << "Идет сортировка ..." << endl;


    //Bubble Sort
    for (i = 0; i < (n - 1); i++) {
        tmpHead = head;
        for (j = 0; j < n - 1 - i; j++) {
            tmpPk1 = tmpHead;
            tmpPk2 = tmpHead->next;
            if (strcmp(tmpPk1->sname, tmpPk2->sname) > 0) {
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
        sort_by_fname(tmpHead);// Сортировка по имени
    }
    sort_by_fname(head);// Сортировка по имени
    cout << endl << "Сортировка завершена " << endl;
};

void sort_by_fname(PhoneItem *&tmphead)//Сортировка по имени
{
    PhoneItem *tmpItem;
    char tmpStr[32];
    // Сортировка по имени
    tmpItem = tmphead;
    while (true) {
        if (tmpItem->next) {
            if (strcmp(tmpItem->sname, tmpItem->next->sname) == 0) {// фамилии совпадают
                if (strcmp(tmpItem->fname, tmpItem->next->fname) > 0) {
                    strcpy(tmpStr, tmpItem->fname);
                    strcpy(tmpItem->fname, tmpItem->next->fname);
                    strcpy(tmpItem->next->fname, tmpStr);
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
