import pygame
import sys
import time

SCREEN_WIDTH = 500
SCREEN_HEIGHT = 500

RED = (255, 0, 0)
GREEN = (0, 255, 0)
BLUE = (0, 0, 255)

class Main(object):
    def __init__(self, id):
        self.id = id
        pygame.init()
        self.surface = pygame.display.set_mode([SCREEN_WIDTH, SCREEN_HEIGHT])
        print('init done.')

    def whoami(self):
        print(f"main id: {self.id}")

    def change_background(self, color):
        self.surface.fill(color)

    # box_pos: a tuble with x and y (left and top position of the rectangle)
    def create_box(self, box_pos):
        # box_pos = (200, 200)
        box_size = (20, 20)
        return pygame.Rect(box_pos, box_size)

    def draw_rectangle(self):
        box_0 = self.create_box((200, 100))
        box_1 = self.create_box((200, 200))
        box_2 = self.create_box((200, 300))

        pygame.draw.rect(self.surface, RED, box_0)
        pygame.draw.rect(self.surface, GREEN, box_1)
        pygame.draw.rect(self.surface, BLUE, (200, 300, 20, 20))

    def draw_line(self):
        # (x, y) startpoint, (x, y) endpoint, width
        pygame.draw.line(self.surface, RED, (10, 10), (490, 10), 5)
        pygame.draw.line(self.surface, GREEN, (10, 490), (490, 490), 1)

    def draw_circle(self):
        # (x,y), radius, width [0 = fill; > 0 width]
        pygame.draw.circle(self.surface, BLUE, (300,50), 10, 0)
        pygame.draw.circle(self.surface, GREEN, (300,50), 20, 2)

    def draw_ellipse(self):
        # (x, y, width, height)
        pygame.draw.ellipse(self.surface, GREEN, (10, 300, 10, 70), 1)

    def draw_pixels(self):
        pixels = pygame.PixelArray(self.surface)
        for i in range(220,250):
            # [pos x][pos y]
            pixels[400+(220-i)][i] = GREEN
        del pixels

    def draw_polygon(self):
        pygame.draw.polygon(self.surface, GREEN, ((200, 400), (300, 400), (250, 300)))

    def draw_primitives(self):
        self.draw_rectangle()
        self.draw_line()
        self.draw_circle()
        self.draw_ellipse()
        self.draw_pixels()
        self.draw_polygon()

    def run(self):
        self.draw_primitives()

        while True:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    sys.exit()

            pygame.display.update()
            time.sleep(0.1)

if __name__ == "__main__":
    main = Main(0)
    main.whoami()
    main.run()