import pygame

pygame.init()

screenwidth = 500
screenheight = 500

win = pygame.display.set_mode((screenwidth, screenheight))
pygame.display.set_caption('the game')

width = 40
height = 60
x = 0
y = screenheight - height
vel = 20

isJump = False
jumpCount = 10

# collision, events, ... in main loop
run = True
while run:
    pygame.time.delay(100)  # ms

    for event in pygame.event.get():    # all events in pygame
        if event.type == pygame.QUIT:
            run = False

    # move
    # top left is 0,0 of coordinate system
    keys = pygame.key.get_pressed()    # list of keys
    if keys[pygame.K_LEFT] and x > vel:
        x-= vel
    if keys[pygame.K_RIGHT] and x < screenwidth - width - vel:
        x+= vel
    if not(isJump):
        if keys[pygame.K_UP] and y < vel:
            y -= vel
        if keys[pygame.K_DOWN] and y > screenheight - height - vel:
            y += vel
        if keys[pygame.K_SPACE]:
            isJump = True
    else:
        if jumpCount >= -10:
            neg = 1
            if jumpCount < 0:
                neg = -1
            y -= (jumpCount ** 2) * 0.5 * neg
            jumpCount -= 1
        else:
            isJump = False
            jumpCount = 10

    # kinda clear screen; color black
    win.fill((0, 0, 0))

    # everything in pygame is a surface, also the window
    # color is in RGB
    pygame.draw.rect(win, (0, 255, 0), (x, y, width, height))
    pygame.display.update()

pygame.quit()
