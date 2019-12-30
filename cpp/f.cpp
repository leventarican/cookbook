#include <GLFW/glfw3.h>
#include <stdlib.h>

/**
 * gcc -Wall `pkg-config --cflags glfw3` -o f f.cpp `pkg-config --static --libs glfw3` -lGL && ./f
 */
typedef struct {
    GLfloat x, y, z; 
    GLfloat r, g, b, a;
} Vertex;

const int WINDOWS_WIDTH = 640*2;
const int WINDOWS_HEIGHT = 480;

void drawLine(Vertex v1, Vertex v2, GLfloat width);
void drawLines();
void drawGrid(GLfloat width, GLfloat height, GLfloat grid_width);

void drawLine(Vertex v1, Vertex v2, GLfloat width) {
    glLineWidth(width);
    glBegin(GL_LINES);
    {
        glColor4f(v1.r, v1.g, v1.b, v1.a);
        glVertex3f(v1.x, v1.y, v1.z);
        
        glColor4f(v2.r, v2.g, v2.b, v2.a);
        glVertex3f(v2.x, v2.y, v2.z);
    }
    glEnd();
}

void drawLines() {
    Vertex v1 = {-5.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.7f};
    Vertex v2 = {5.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.7f};
    Vertex v3 = {0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.7f};
    Vertex v4 = {0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.7f};
    
    drawLine(v1, v2, 10.0f);
    drawLine(v3, v4, 10.0f);
}

void drawGrid(GLfloat width, GLfloat height, GLfloat grid_width){
    //horizontal
    for(float i=-height; i<height; i+=grid_width){
        Vertex v1 = {-width, i, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        Vertex v2 = {width, i, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        drawLine(v1, v2, grid_width);
    }
    
    //vertical
    for(float i=-width; i<width; i+=grid_width){
        Vertex v1 = {i, -height, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        Vertex v2 = {i, height, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        drawLine(v1, v2, grid_width);
    }
}

int main(void) {
    GLFWwindow* window;
    if (!glfwInit())
        exit(EXIT_FAILURE);
    window = glfwCreateWindow(640, 480, "GLFW: f", NULL, NULL);
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

        {
            drawGrid(5.0f, 1.0f, 0.1f);
            drawLines();
        }
        
        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    glfwDestroyWindow(window);
    glfwTerminate();
    exit(EXIT_SUCCESS);
}

