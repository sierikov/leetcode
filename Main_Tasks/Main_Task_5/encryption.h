#include <iostream>
#include <algorithm>
#include <streambuf>
#include <vector>
#include <string>

namespace ral
{
    typedef std::vector<std::vector<unsigned char>> keytype;
    enum alg{
        noone, polisub
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
        friend std::ostream& operator<< (std::ostream& os, my_manip& my)
        {
            return (std::ostream &) my.f(os, my.n, my.key);
        }
    };

    my_manip encrypt(alg n, keytype& key);
    my_manip encrypt(alg n);

    class ourbuf : public std::streambuf
    {
    protected:
        virtual int_type overflow(int_type c);
    };

}



int main()
{
    ral::keytype key;
    std::vector<unsigned char> g;
    g.reserve(16);
    g = { 4, 11, 3, 2, 10, 1, 12, 9, 14, 7, 0, 15, 13, 5, 8, 6 };
    key.push_back(g);
    std::cout << "Begin" << std::endl;
    std::cout << "Start|" << encrypt(ral::polisub, key) << "Polisub encrypt" << encrypt(ral::noone) << "None encrypt" << std::endl;
    std::cout << "End" << std::endl;
    system("pause");
    return 0;
}