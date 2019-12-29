#include <GLFW/glfw3.h>
#include <stdlib.h>
//#include <stdio.h>

/**
 * gcc -Wall `pkg-config --cflags glfw3` -o e e.cpp `pkg-config --static --libs glfw3` -lGL && ./e
 */
typedef struct {
    GLfloat x, y, z; 
    GLfloat r, g, b, a;
} Vertex;

const int WINDOWS_WIDTH = 640*2;
const int WINDOWS_HEIGHT = 480;

void drawPoint(Vertex v1, GLfloat size);
void drawPoints(int width, int height);

void drawPoint(Vertex v1, GLfloat size) {
    glPointSize(size);
    glBegin(GL_POINTS);
    glColor4f(v1.r, v1.g, v1.b, v1.a);
    glVertex3f(v1.x, v1.y, v1.z);
    glEnd();
}   

void drawPoints(int width, int height){
    GLfloat size=5.0f;
    for(GLfloat x = 0.0f; x<=1.0f; x+=0.2f, size+=5) {
        Vertex v1 = {x, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        drawPoint(v1, size);
    }
}

int main(void) {
    GLFWwindow* window;
    if (!glfwInit())
        exit(EXIT_FAILURE);
    window = glfwCreateWindow(640, 480, "GLFW: e", NULL, NULL);
    if (!window) {
        glfwTerminate();
        exit(EXIT_FAILURE);
    }
    glfwMakeContextCurrent(window);
    
    while (!glfwWindowShouldClose(window)) {
        float ratio;
        int width, height;
        glfwGetFramebufferSize(window, &width, &height);
        ratio = (float) width / (float) height;
        glViewport(0, 0, width, height);
        glClear(GL_COLOR_BUFFER_BIT);
        
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(-ratio, ratio, -1.f, 1.f, 1.f, -1.f);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        drawPoints(width, height);
        
        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    glfwDestroyWindow(window);
    glfwTerminate();
    exit(EXIT_SUCCESS);
}
