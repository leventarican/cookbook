#include <SFML/Graphics.hpp>

//using namespace sf;

/**
 * SFML
 * 
 * sudo apt install libsfml-dev
 * will install (in my case version SFML 2.5)
 * 
 * compile: g++ -c b.cpp
 * link: g++ b.o -o b -lsfml-graphics -lsfml-window -lsfml-system
 **/
int main()
{
    sf::RenderWindow window(sf::VideoMode(200, 200), "SFML works!");
    sf::CircleShape shape(100.f);
    shape.setFillColor(sf::Color::Green);

    while (window.isOpen())
    {
        sf::Event event;
        while (window.pollEvent(event))
        {
            if (event.type == sf::Event::Closed)
                window.close();
        }

        window.clear();
        window.draw(shape);
        window.display();
    }

    return 0;
}
