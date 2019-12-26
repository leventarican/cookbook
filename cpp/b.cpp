#include <SFML/Graphics.hpp>
#include <iostream>

//using namespace sf;

/**
 * SFML: is built on top of OpenGL.
 * 
 * sudo apt install libsfml-dev
 * will install (in my case version SFML 2.5)
 * 
 * compile: g++ -c b.cpp
 * link: g++ b.o -o b -lsfml-graphics -lsfml-window -lsfml-system
 * 
 * g++ -c b.cpp && g++ b.o -o b -lsfml-graphics -lsfml-window -lsfml-system && ./b
 **/
int main()
{
    sf::RenderWindow window(sf::VideoMode(200, 200), "SFML works!");
    sf::CircleShape shape(100.f);
    shape.setFillColor(sf::Color::Green);

    sf::Clock clock;
    sf::Time tm = clock.getElapsedTime();
    std::cout << tm.asSeconds();

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
