import pygame
import sys

def main():
    SCREEN_WIDTH = 500
    SCREEN_HEIGHT = 500
    FPS = 30
    WHITE = (255, 255, 255)

    clock = pygame.time.Clock()
    surface = pygame.display.set_mode([SCREEN_WIDTH, SCREEN_HEIGHT])

    sprite0 = pygame.image.load('sprite0.png')
    sprite0_x = 10
    sprite0_y = 10
    sprite0_direction = 'right'

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

        surface.fill(WHITE)

        if sprite0_direction == 'right':
            sprite0_x += 5
            if sprite0_x == 450:
                sprite0_direction = 'down'
        if sprite0_direction == 'down':
            sprite0_y += 10
            if sprite0_y == 450:
                sprite0_direction = 'left'
        if sprite0_direction == 'left':
            sprite0_x -= 5
            if sprite0_x == 0:
                sprite0_direction = 'top'
        if sprite0_direction == 'top':
            sprite0_y -= 5
            if sprite0_y == 0:
                sprite0_direction = 'right'

        # copy image to surface
        surface.blit(sprite0, (sprite0_x, sprite0_y))

        pygame.display.update()

        # ensure that loop doesnt run to fast (= CPU clock)
        clock.tick(FPS)

if __name__ == "__main__":
    main()