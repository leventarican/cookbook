import pygame
import time

WIDTH = 500
HEIGHT = 500
GREEN = (0, 200, 0)

init = pygame.init()
screen = pygame.display.set_mode([WIDTH, HEIGHT])

box_x = 200
box_y = 100
box = pygame.Rect(box_x, box_y, 20, 20)

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    pygame.draw.rect(screen, GREEN, box)

    pygame.display.update()
    time.sleep(0.1)