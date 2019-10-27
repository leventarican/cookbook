import pygame
import sys

GREEN = (0, 255, 0)

def main():
    pygame.init()
    surface = pygame.display.set_mode([500, 500])

    # list fonts with fc-list (not working with this method)
    # freesansbold comes with pygame
    font = pygame.font.Font('freesansbold.ttf', 50)
    text = font.render('game', False, GREEN)
    textRect = text.get_rect()
    textRect.center = (250, 250)

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

        surface.blit(text, textRect)

        pygame.display.update()

if __name__ == "__main__":
    main()