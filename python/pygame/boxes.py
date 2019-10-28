import pygame
import sys
import random

GRAY = (200, 200, 200)
GREEN = (0, 255, 0)
BLUE = (0, 0, 255)
SCREEN_SIZE = 700
NUMBER_BOX = 4
BOX_SIZE = SCREEN_SIZE / NUMBER_BOX

pygame.init()
surface = pygame.display.set_mode([SCREEN_SIZE, SCREEN_SIZE])

boxes = []
boxes_selected = [-1]*2
boxes_value = {}

# TODO: peristent when found matching boxes

# generate random colors for boxes
def generate_box():
    global boxes_value
    grid = NUMBER_BOX*NUMBER_BOX
    shuffle = [i for i in range(0,grid)]
    random.shuffle(shuffle)
    count = 0
    value = (random.randint(0,255), random.randint(0,255), random.randint(0,255))
    for key in shuffle:
        count += 1
        if count % 2 == 0:
            value = (random.randint(0,255), random.randint(0,255), random.randint(0,255))
        # print(f"{key}:{value}")
        boxes_value[key] = value

def select_box(mousex, mousey):
    global boxes_selected
    for index, box in enumerate(boxes):
        if box.collidepoint(mousex, mousey):
            if boxes_selected[0] == -1:
                boxes_selected[0] = index
            else:
                boxes_selected[1] = index

def main():
    global boxes_selected
    
    mousex = 0
    mousey = 0

    generate_box()

    for x in range(0, NUMBER_BOX):
        for y in range(0, NUMBER_BOX):
            box = pygame.Rect((x*BOX_SIZE, y*BOX_SIZE), (BOX_SIZE-5, BOX_SIZE-5))
            boxes.append(box)

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == pygame.MOUSEBUTTONUP:
                mousex, mousey = event.pos
                if boxes_selected[0] != -1 and boxes_selected[1] != -1:
                    boxes_selected[0] = -1
                    boxes_selected[1] = -1
                select_box(mousex, mousey)

        for index, box in enumerate(boxes):
            if index in boxes_selected:
                pygame.draw.rect(surface, boxes_value.get(index), box)
            else:
                pygame.draw.rect(surface, GRAY, box)

        pygame.display.update()

if __name__ == "__main__":
    main()