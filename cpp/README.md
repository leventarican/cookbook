# ISO C++

## compile and run
```
g++ i.cpp && ./a.out
g++ -std=c++11 i.cpp && ./a.out
```

# OpenGL with GLFW
* install under linux
    * cmake: generate build files
    * make: compiles sourcecode into libraries
    * make install: installs the library header files, static or shared libraries onto your machine.
```
$ wget https://github.com/glfw/glfw/releases/download/3.3/glfw-3.3.zip

$ unzip glfw-3.3.zip

$ cd glfw-3.3

$ mkdir build && cd build

$ cmake

$ make

$ sudo make install

-- Install configuration: ""
-- Installing: /usr/local/include/GLFW
-- Installing: /usr/local/include/GLFW/glfw3.h
-- Installing: /usr/local/include/GLFW/glfw3native.h
-- Installing: /usr/local/lib/cmake/glfw3/glfw3Config.cmake
-- Installing: /usr/local/lib/cmake/glfw3/glfw3ConfigVersion.cmake
-- Installing: /usr/local/lib/cmake/glfw3/glfw3Targets.cmake
-- Installing: /usr/local/lib/cmake/glfw3/glfw3Targets-noconfig.cmake
-- Installing: /usr/local/lib/pkgconfig/glfw3.pc
-- Installing: /usr/local/lib/libglfw3.a
```

## GLFW and OpenGL examples
* sourcecode example: `d.cpp, e.cpp, f.cpp, g.cpp`

# OpenGL with freeglut (GLUT)
* sourcecode example: `c.cpp`
* you need freeglut3 and freeglut3-dev on linux
* also OpenGL for sure. check you version with: `$ glxinfo | grep OpenGL`

# OpenGL with SFML
* sourcecode example: `b.cpp`
* you need SFML libs. Under linux (debian based): `sudo apt install libsfml-dev` 

# code c++ with geany
* the editor based on scintilla (= fast)
* setup c++17: https://github.com/Errichto/youtube/wiki/Linux-setup
* `#include <bits/stdc++.h>` includes entire std library

## cheatsheet
* keybindings > ctrl + alt + p (preferences)
```
alt + 1: editor
alt + 2: terminal
alt + 3: compile
alt + 4: build
alt + 5: run
```
