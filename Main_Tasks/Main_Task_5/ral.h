#ifndef __RAL__
#define __RAL__

#include <iostream>
#include <algorithm>
#include <streambuf>
#include <vector>
#include <string>

namespace ral
{
    typedef std::vector<std::vector<unsigned char>> keytype;
    enum alg{
        noone, gamm, subst, polisub
    };

    extern std::ostream cout;

    class my_manip {
        alg n;
        keytype key;
        std::ostream&(*f)(std::ostream&, alg, keytype&);
    public:
        my_manip(std::ostream&(*F)(std::ostream&, alg, keytype&), alg N, keytype& KEY) :
                f(F), n(N), key(KEY)
        {}
        friend std::ostream& operator<<(std::ostream& os, my_manip& my)
        {
            return my.f(os, my.n, my.key);
        }
    };

    my_manip encrypt(alg n, keytype& key);
    my_manip encrypt(alg n, std::vector<unsigned char>& key);
    my_manip encrypt(alg n, const char* key);
    my_manip encrypt(alg n);

    class ourbuf : public std::streambuf
    {
    protected:
        virtual int_type overflow(int_type c);
    };

}

#endif


int main()
{
    ral::keytype key;
    std::vector<unsigned char> g;
    g.reserve(16);
    g = { 4, 11, 3, 2, 10, 1, 12, 9, 14, 7, 0, 15, 13, 5, 8, 6 };
    key.push_back(g);
    g = { 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
    key.push_back(g);
    g = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    key.push_back(g);
    std::cout << "Begin" << std::endl;
    std::cout << "Leonid said|" << encrypt(ral::gamm, "gamm") << "This is sparta!!!" << 123 << encrypt(ral::noone) << "|and kicked the Persian ambassador" << endl;
    std::cout << "Leonid said|" << encrypt(ral::subst, key[0]) << "This is sparta!!!" << encrypt(ral::noone) << "|and kicked the Persian ambassador" << endl;
    std::cout << "Leonid said|" << encrypt(ral::polisub, key) << "This is sparta!!!" << encrypt(ral::noone) << "|and kicked the Persian ambassador" << endl;
    std::cout << "End" << std::endl;
    system("pause");
    return 0;
}