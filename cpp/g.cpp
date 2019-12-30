#include <GLFW/glfw3.h>
#include <stdlib.h>
#include <math.h>   // using cosf

/**
 * gcc -Wall `pkg-config --cflags glfw3` -o g g.cpp `pkg-config --static --libs glfw3` -lGL && ./g
 */

const int WINDOWS_WIDTH = 640*2;
const int WINDOWS_HEIGHT = 480;

typedef struct {
    GLfloat x, y, z; 
    GLfloat r, g, b, a;
} Vertex;

typedef struct {
    GLfloat x, y, z;
} Data;

void drawLine(Vertex v1, Vertex v2, GLfloat width);
void drawLines();
void drawGrid(GLfloat width, GLfloat height, GLfloat grid_width);

void drawPoint(Vertex v1, GLfloat size) {
    glPointSize(size);
    glBegin(GL_POINTS);
    glColor4f(v1.r, v1.g, v1.b, v1.a);
    glVertex3f(v1.x, v1.y, v1.z);
    glEnd();
}

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

void draw2Dplot(const Data *data, int num_points) {
    Vertex v1 = {-10.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    Vertex v2 = {10.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    drawLine(v1, v2, 2.0f);
    v1.x = 0.0f;
    v2.x = 0.0f;
    v1.y = -1.0f;
    v2.y = 1.0f;
    drawLine(v1, v2, 2.0f);
    for(int i=0; i<num_points; i++){
        GLfloat x=data[i].x;
        GLfloat y=data[i].y;
        Vertex v={x, y, 0.0f, 1.0f, 1.0f, 1.0f, 0.5f};
        drawPoint(v, 8.0f);
    }
}

void draw2Dlines(const Data *data, int num_points) {
    for(int i=0; i<num_points-1; i++){
        GLfloat x1=data[i].x;
        GLfloat y1=data[i].y;
        GLfloat x2=data[i+1].x;
        GLfloat y2=data[i+1].y;
        Vertex v1={x1, y1, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f};
        Vertex v2={x2, y2, 0.0f, 0.0f, 1.0f, 0.0f, 0.5f};
        drawLine(v1, v2, 4.0f);
    }
}

void drawLinePlot(float phase_shift){
    drawGrid(5.0f, 1.0f, 0.1f);
    GLfloat range = 10.0f;
    const int num_points = 200;
    Data *data=(Data*)malloc(sizeof(Data)*num_points);
    for(int i=0; i<num_points; i++) {
        data[i].x=((GLfloat)i/num_points)*range-range/2.0f;
        data[i].y= 0.8f*cosf(data[i].x*3.14f+phase_shift);
    }
    draw2Dplot(data, num_points);
    draw2Dlines(data, num_points);
    free(data);
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
    
    float phase_shift=0.0f;
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
            phase_shift+=0.02f;
            drawLinePlot(phase_shift);
            
            //finished all demo calls
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
        
        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    glfwDestroyWindow(window);
    glfwTerminate();
    exit(EXIT_SUCCESS);
}

