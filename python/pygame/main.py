import pygame
import sys

SCREEN_WIDTH = 500
SCREEN_HEIGHT = 500

class Main(object):
    def __init__(self, id):
        self.id = id
        pygame.init()
        self.surface = pygame.display.set_mode([SCREEN_WIDTH, SCREEN_HEIGHT])
        print('init done.')

    def run(self):
        while True:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    sys.exit()

    def whoami(self):
        print(f"main id: {self.id}")

    def change_background(color):
        self.surface.fill(color)

if __name__ == "__main__":
    main = Main(0)
    main.whoami()
    main.run()