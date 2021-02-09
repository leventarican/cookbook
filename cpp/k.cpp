#include <iostream>

using namespace std;

// static members

class developer {
    public:
        static int objectCount;
        developer(int id = 100) {
            objectCount++;
            this->id = id;
            cout <<"constructor called. object count: " << objectCount << endl;
        }
        int getId() {
            return id;
        }
        static int getCount() {
            return objectCount;
        }
        static developer* get_instance() {
            if (!m_instance)
                m_instance = new developer();
            return m_instance;
        }
    private:
        static developer* m_instance;
        int id;
};

// init static members
int developer::objectCount = 0;
// developer* developer::m_instance;
developer* developer::m_instance = nullptr;

int main(void) {
    cout << "init count: " << developer::getCount() << endl;

    developer a(1);
    developer b(2);
    developer::get_instance();
    developer* c = developer::get_instance();

    cout << "instances: " << a.getId() << "; " << b.getId() << "; " << c->getId() << "; " << endl;

    cout << "final count: " << developer::getCount() << endl;
   return 0;
}
