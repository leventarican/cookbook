import pygame
import sys

GREEN = (0, 255, 0)
SCREEN_SIZE = 500
NUMBER_BOX = 10
BOX_SIZE = SCREEN_SIZE / NUMBER_BOX

def main():
    pygame.init()
    surface = pygame.display.set_mode([SCREEN_SIZE, SCREEN_SIZE])

    boxes = []

    for x in range(0, NUMBER_BOX):
        for y in range(0, NUMBER_BOX):
            box = pygame.Rect((x*BOX_SIZE, y*BOX_SIZE), (BOX_SIZE-5, BOX_SIZE-5))
            boxes.append(box)

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

        for box in boxes:
            pygame.draw.rect(surface, GREEN, box)

        pygame.display.update()

if __name__ == "__main__":
    main()