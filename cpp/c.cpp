//#include <GL/glut.h>
#include <GL/freeglut.h>

/**
 * # C++ and OpenGL with GLUT (freeglut)
 * 
 * g++ c.cpp -lglut -lGL -o c && ./c
 * 
 * you need freeglut3 and freeglut3-dev on linux
 * also OpenGL for sure. check you version with: $ glxinfo | grep OpenGL
 * 
 **/
void draw() {
    glBegin(GL_TRIANGLES);
    glVertex3f(-0.7, 0.7, 0);
    glVertex3f(0.7, 0.7, 0);
    glVertex3f(0, -0.7, 0);
    glEnd();

    glFlush();
}

int main(int argc, char **argv)
{
    glutInit(&argc, argv);
    glutInitWindowSize(500, 500);
    glutCreateWindow("OpenGL");
    glutDisplayFunc(draw);
    glutMainLoop();
    return 0;
}
