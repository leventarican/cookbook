import pygame
import time
import sys

WIDTH = 500
HEIGHT = 500
GREEN = (0, 200, 0) # RGB (0-255, 0-255, 0-255)

pygame.init()
surface = pygame.display.set_mode([WIDTH, HEIGHT])  # this returns a surface object
pygame.display.set_caption('form scratch')

box_pos_x = 200
box_pos_y = 100
box = pygame.Rect(box_pos_x, box_pos_y, 20, 20)
shoot = pygame.Rect(box_pos_x+50, box_pos_y, 10, 10)

# game loop
# ---------
# handle events
# update game state
# draw game state to surface
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    pygame.draw.rect(surface, GREEN, box)

    pygame.draw.rect(surface, GREEN, shoot)

    pygame.display.update() # display the surface object
    time.sleep(0.1)